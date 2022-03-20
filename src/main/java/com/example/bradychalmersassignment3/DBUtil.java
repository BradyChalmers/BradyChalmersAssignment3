package com.example.bradychalmersassignment3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.sql.DataSource;

public class DBUtil {
    private String jdbcURL = "jdbc:mysql://localhost:3306/hrmanager";
    private String jdbcUsername = "root";
    private String jdbcPassword = "";

    private static final String INSERT_USERS_SQL = "INSERT INTO employee" + "  (userName, password, firstName, lastName, email, hireDate) VALUES " +
            " (?, ?, ?, ?, ?, ?, ?);";

    private static final String SELECT_USER_VALIDATION = "select idemployee from employee where userName =? and password = ?;";

    public DBUtil() {}

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }
    public boolean selectUser(String userNameInput, String passwordInput) {
        int checkID = -1;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_VALIDATION)) {
            preparedStatement.setString(1, userNameInput);
            preparedStatement.setString(2, passwordInput);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    if (rs.getInt(1) == 1) {
                        return true;
                    }
                }
            }
            return false;
        } catch (SQLException e) {
            return false;
        }
    }

    public void insertUser(Employee employee) throws SQLException {
        System.out.println(INSERT_USERS_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setString(1, employee.getUserName());
            preparedStatement.setString(2, employee.getPassword());
            preparedStatement.setString(3, employee.getFirstName());
            preparedStatement.setString(4, employee.getLastName());
            preparedStatement.setString(5, employee.getEmail());
            preparedStatement.setString(6, employee.getHireDate());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
