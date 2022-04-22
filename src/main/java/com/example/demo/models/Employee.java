package com.example.demo.models;

import java.sql.Date;

public class Employee {

    private int id;
    private String employeeName;
    private String job;
    private int manager;
    private Date hireDate;
    private int salary;
    private int commission;
    private int departmentNumber;

    public Employee(int id, String employeeName, String job, int manager, Date hireDate, int salary, int commission, int departmentNumber) {
        this.id = id;
        this.employeeName = employeeName;
        this.job = job;
        this.manager = manager;
        this.hireDate = hireDate;
        this.salary = salary;
        this.commission = commission;
        this.departmentNumber = departmentNumber;
    }

    public int getId() {
        return id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getJob() {
        return job;
    }

    public int getManager() {
        return manager;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public int getSalary() {
        return salary;
    }

    public int getCommission() {
        return commission;
    }

    public int getDepartmentNumber() {
        return departmentNumber;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", employeeName='" + employeeName + '\'' +
                ", job='" + job + '\'' +
                ", manager=" + manager +
                ", hireDate=" + hireDate +
                ", salary=" + salary +
                ", commission=" + commission +
                ", departmentNumber=" + departmentNumber +
                '}';
    }
}
