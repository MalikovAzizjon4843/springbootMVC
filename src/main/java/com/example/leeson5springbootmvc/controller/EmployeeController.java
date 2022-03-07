package com.example.leeson5springbootmvc.controller;

import com.example.leeson5springbootmvc.dto.DepartmentDTO;
import com.example.leeson5springbootmvc.dto.EmployeeDto;
import com.example.leeson5springbootmvc.entity.Company;
import com.example.leeson5springbootmvc.entity.Department;
import com.example.leeson5springbootmvc.entity.Employee;
import com.example.leeson5springbootmvc.repository.CompanyRepository;
import com.example.leeson5springbootmvc.repository.DepartmentRepository;
import com.example.leeson5springbootmvc.repository.EmployeeRepositary;
import com.example.leeson5springbootmvc.service.DepartmentService;
import com.example.leeson5springbootmvc.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    DepartmentService departmentService;

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    EmployeeRepositary employeeRepositary;

    @Autowired
    EmployeeService employeeService;

    // zaproslarni tutib iwlatiw
//    @RequestMapping (method = RequestMethod.GET)

    @GetMapping
    public String getEmployeePage(Model model) {
        model.addAttribute("list", employeeRepositary.findAll());
        // listni yuborish
        return "employee/employee";
    }


    @GetMapping( "/add")
//    @RequestMapping(path = "/add", method = RequestMethod.GET)
    public String getSaveEmployee(Model model) {
        model.addAttribute("departmentList", departmentRepository.findAll());

        return "employee/employee-add";
    }


    @PostMapping("/add")
    public String saveEmployee(Model model, @ModelAttribute EmployeeDto dto) {
        employeeService.add(dto);
        return "redirect:/employee";
    }

    @GetMapping("/delete/{id}") // 1  45   24  90
    public String delete(@PathVariable Integer id){
        employeeRepositary.deleteById(id);
        return "redirect:/employee";
    }


    @GetMapping("/edit/{id}")
    public String editPage(Model model, @PathVariable(value = "id") Integer id){
        Optional<Employee> byId = employeeRepositary.findById(id);
        Employee employee = byId.get();
        model.addAttribute("employee", employee);
        return ("employee/employee-edit");
    }
    @PostMapping("/edit/{id}")
    public String update(@PathVariable(value = "id") Integer id, @ModelAttribute Department department){
        Optional<Employee> optionalEmployee = employeeRepositary.findById(id);
        Employee employee1 = optionalEmployee.get();
        employee1.setId(department.getId());
        employee1.setName(department.getName());
        employeeRepositary.save(employee1);
        return "redirect:/employee";
    }
}

