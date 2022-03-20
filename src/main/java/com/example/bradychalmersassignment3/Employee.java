package com.example.bradychalmersassignment3;

import java.util.Date;

public class Employee {
    private int id;
    private String userName;
    private String password;
    private String  firstName;
    private String lastName;
    private String email;
    private String hireDate;

    public Employee(){}

    public Employee(String userName, String password, String firstName, String lastName, String email, String hireDate){
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.hireDate = hireDate;
    }

    public void setUserName (String userName) {this.userName = userName;}
    public String getUserName() {return this.userName;}

    public void setPassword(String password) {this.password = password;}
    public String getPassword() {return this.password;}

    public void setFirstName(String firstName) {this.firstName = firstName;}
    public String getFirstName(){return this.firstName;}

    public void setLastName(String lastName) {this.lastName = lastName;}
    public String getLastName(){return this.lastName;}

    public void setEmail(String email) {this.email = email;}
    public String getEmail(){return this.email;}

    public void setHireDate(String hireDate) {this.hireDate = hireDate;}
    public String getHireDate(){return this.hireDate;}

}
