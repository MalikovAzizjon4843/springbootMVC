package com.example.leeson5springbootmvc.controller;

import com.example.leeson5springbootmvc.entity.Company;
import com.example.leeson5springbootmvc.repository.CompanyRepository;
import com.example.leeson5springbootmvc.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @Autowired
    CompanyRepository companyRepository;



//    @RequestMapping(method = RequestM
//    //zaproslarni  tutib  ishlatishethod.GET)

    @GetMapping
    public String getCompanyPage(Model model) {
        model.addAttribute("list", companyRepository.findAll());
        // listni yuborish
        return "company/company";
    }


    @GetMapping(path = "/add")
//    @RequestMapping(path = "/add", method = RequestMethod.GET)
    public String getSaveCompany() {
        return "company/company-add";
    }


    @PostMapping("/add")
    public String saveCompany(Model model, @ModelAttribute Company company) {
        companyService.add(company);
        return "redirect:/company";
    }

    @GetMapping("/delete/{id}") // 1  45   24  90
    public String delete(@PathVariable Integer id){
        companyRepository.deleteById(id);
        return "redirect:/company";
    }


    @GetMapping("/edit/{id}")
    public String editPage(Model model, @PathVariable(value = "id") Integer id) {
        Optional<Company> byId = companyRepository.findById(id);
        Company company = byId.get();
        model.addAttribute("company", company);
        return "company/company-edit";
    }

    @PostMapping("/edit/{id}")
    public String update(@PathVariable(value = "id") Integer id, @ModelAttribute Company company) {
        Optional<Company> optionalCompany = companyRepository.findById(id);
        Company company1 = optionalCompany.get();
        company1.setId(company.getId());
        company1.setName(company.getName());
        companyRepository.save(company1);
        return "redirect:/company";
    }


}

