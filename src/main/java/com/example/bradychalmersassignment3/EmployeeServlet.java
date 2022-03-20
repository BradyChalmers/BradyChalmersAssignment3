package com.example.bradychalmersassignment3;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import com.example.bradychalmersassignment3.DBUtil;
import com.example.bradychalmersassignment3.Employee;


@WebServlet(name = "EmployeeServlet", value = "/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
    private DBUtil dbhelper;

    public void init(){
        dbhelper = new DBUtil();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
        if(dbhelper.selectUser(request.getParameter("txtUsername"), request.getParameter("txtPassword")))
        {
            RequestDispatcher dispatcher = request.getRequestDispatcher("good-login.jsp");
            dispatcher.forward(request, response);
        }
        else{
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
        if(request.getParameter("checkVar") == "create"){
            String userNameInput = request.getParameter("userNameInput");
            String passwordInput = request.getParameter("passwordInput");
            String firstNameInput = request.getParameter("txtFirstNameEdit");
            String lastNameInput = request.getParameter("lastNameInput");
            String emailInput = request.getParameter("emailInput");
            String dateInput = request.getParameter("dateInput");
            Employee employee = new Employee(userNameInput, passwordInput, firstNameInput, lastNameInput, emailInput, dateInput);
            try {
                dbhelper.insertUser(employee);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else{
            RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
            dispatcher.forward(request, response);
        }
    }


    private void loginUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(dbhelper.selectUser(request.getParameter("txtUsername"), request.getParameter("txtPassword")))
        {
            RequestDispatcher dispatcher = request.getRequestDispatcher("good-login.jsp");
            dispatcher.forward(request, response);
        }
        else{
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);
        }
    }
}
