package com.example.demo.repositories;

import com.example.demo.models.Department;
import com.example.demo.models.Employee;
import com.example.demo.utility.DatabaseConnectionManager;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements IRepository<Employee>{



    @Override
    public List<Employee> getAllEntities() {
        Connection conn = DatabaseConnectionManager.getConnection();
        List<Employee> allEmployees = new ArrayList<>();
        try {
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM employees");
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                Employee temp = new Employee(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getDate(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getInt(8)
                );
                allEmployees.add(temp);
            }

        }catch(SQLException e){
            System.out.println("Something wrong in statement");
            e.printStackTrace();
        }
        return allEmployees;
    }

    @Override
    public Employee getSingleById(int id) {
        Connection conn = DatabaseConnectionManager.getConnection();
        return null;
    }

    @Override
    public boolean create(Employee entity) {
        Connection conn = DatabaseConnectionManager.getConnection();
        try {
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO employees(`employee_name`, `job`, `manager`, " +
                    "`hiredate`, `salary`, `commission`, `department_number`)" + " VALUES (?,?,?,?,?,?,?)");

            pstmt.setString(1, entity.getEmployeeName().toUpperCase());
            pstmt.setString(2, entity.getJob().toUpperCase());
            pstmt.setInt(3, entity.getManager());
            pstmt.setDate(4, Date.valueOf(LocalDate.now()));
            pstmt.setInt(5, entity.getSalary());
            pstmt.setInt(6, entity.getCommission());
            pstmt.setInt(7, entity.getDepartmentNumber());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("something is wrong");
            e.printStackTrace();



        }
        return true;
    }
}
