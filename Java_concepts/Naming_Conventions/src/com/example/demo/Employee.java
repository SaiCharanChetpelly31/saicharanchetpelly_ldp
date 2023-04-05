package com.example.demo;

public class Employee {
    private int employeeId;
    private String employeeName;
    private double employeeSalary;

    public Employee(int id, String name, double salary) {
        this.employeeId = id;
        this.employeeName = name;
        this.employeeSalary = salary;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public double getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeName(String name) {
        this.employeeName = name;
    }

    public void setEmployeeSalary(double salary) {
        this.employeeSalary = salary;
    }

    public static void main(String[] args) {
        Employee emp = new Employee(101, "Sai Charan Chetpelly", 18000.00);
        System.out.println("Employee ID: " + emp.getEmployeeId());
        System.out.println("Employee Name: " + emp.getEmployeeName());
        System.out.println("Employee Salary: " + emp.getEmployeeSalary());
        emp.setEmployeeName("Raju");
        emp.setEmployeeSalary(20000.00);
        System.out.println("Updated Employee Name: " + emp.getEmployeeName());
        System.out.println("Updated Employee Salary: " + emp.getEmployeeSalary());
    }
}