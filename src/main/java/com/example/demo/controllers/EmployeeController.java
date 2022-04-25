package com.example.demo.controllers;

import com.example.demo.models.Employee;
import com.example.demo.repositories.EmployeeRepository;
import com.example.demo.repositories.IRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import java.sql.Date;

@Controller
public class EmployeeController {

    private final IRepository<Employee> employeeIRepository = new EmployeeRepository();


    @GetMapping("/employees")
    public String allEmployees(Model model){
        model.addAttribute("employees", employeeIRepository.getAllEntities());
        return "employees";
    }

    @GetMapping("/createEmployee")
    public String wishList(){
        return "createEmployee";
    }

    @PostMapping("/createEmployee")
    public String wishListCreation(WebRequest dataFromForm){

        int id = -1;

        String name = dataFromForm.getParameter("name");
        String job = dataFromForm.getParameter("job");
        int commission = Integer.parseInt(dataFromForm.getParameter("commission"));
        int departmentNr = Integer.parseInt(dataFromForm.getParameter("departmentNr"));
        int manager = Integer.parseInt(dataFromForm.getParameter("manager"));
        int salary = Integer.parseInt(dataFromForm.getParameter("salary"));
        Date date = Date.valueOf(dataFromForm.getParameter("date"));


        Employee employee = new Employee(id, name, job, manager, date, salary, commission, departmentNr);

        employeeIRepository.create(employee);

        return "redirect:/createEmployee";
    }

}
