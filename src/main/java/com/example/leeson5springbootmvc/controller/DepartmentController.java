package com.example.leeson5springbootmvc.controller;

import com.example.leeson5springbootmvc.dto.DepartmentDTO;
import com.example.leeson5springbootmvc.entity.Company;
import com.example.leeson5springbootmvc.entity.Department;
import com.example.leeson5springbootmvc.repository.CompanyRepository;
import com.example.leeson5springbootmvc.repository.DepartmentRepository;
import com.example.leeson5springbootmvc.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    CompanyRepository companyRepository;

    // zaproslarni tutib iwlatiw
//    @RequestMapping (method = RequestMethod.GET)

    @GetMapping
    public String getDepartmentPage(Model model) {
        model.addAttribute("list", departmentRepository.findAll());
       // listni yuborish
        return "department/department";
    }


    @GetMapping( "/add")
//    @RequestMapping(path = "/add", method = RequestMethod.GET)
    public String getSaveDepartment(Model model) {
        model.addAttribute("companyList", companyRepository.findAll());

        return "department/department-add";
    }


    @PostMapping("/add")
    public String saveDepartment(Model model, @ModelAttribute DepartmentDTO dto) {
        departmentService.add(dto);
        return "redirect:/department";
    }

    @GetMapping("/delete/{id}") // 1  45   24  90
    public String delete(@PathVariable Integer id){
        departmentRepository.deleteById(id);
        return "redirect:/department";
    }


    @GetMapping("/edit/{id}")
    public String editPage(Model model, @PathVariable(value = "id") Integer id){
        Optional<Department> byId = departmentRepository.findById(id);
        Department department = byId.get();
        model.addAttribute("department", department);
        return ("department/department-edit");
    }
    @PostMapping("/edit/{id}")
    public String update(@PathVariable(value = "id") Integer id, @ModelAttribute Department department){
        Optional<Department> optionalDepartment = departmentRepository.findById(id);
        Department department1 = optionalDepartment.get();
        department1.setId(department.getId());
        department1.setName(department.getName());
        departmentRepository.save(department1);
        return "redirect:/department";
    }


}

