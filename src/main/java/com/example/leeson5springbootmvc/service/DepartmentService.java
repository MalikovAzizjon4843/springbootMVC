package com.example.leeson5springbootmvc.service;

import com.example.leeson5springbootmvc.dto.ApiResponce;
import com.example.leeson5springbootmvc.dto.DepartmentDTO;
import com.example.leeson5springbootmvc.entity.Company;
import com.example.leeson5springbootmvc.entity.Department;
import com.example.leeson5springbootmvc.repository.CompanyRepository;
import com.example.leeson5springbootmvc.repository.DepartmentRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DepartmentService {
    @Autowired
    DepartmentRepositary departmentRepositary;

    @Autowired
    CompanyRepository companyRepository;

    public ApiResponce add(DepartmentDTO departmentDTO) {
        Optional<Company> optionalCompany = companyRepository.findById(departmentDTO.getCompanyId());
        if (optionalCompany.isPresent()) return new ApiResponce("Bunaqa id yoq", false);
        Company company = optionalCompany.get();

        Department department = new Department();
        department.setName(departmentDTO.getName());
        department.setCompany(company);

        Department save = departmentRepositary.save(department);
        return new ApiResponce("saved", true, save);
    }

    public ApiResponce edit(DepartmentDTO dto , Integer id){
        Optional<Company> companyId = companyRepository.findById(dto.getCompanyId());
        Company company = new Company();
        if (companyId.isPresent()) {
            return new ApiResponce("Bunday Id yo'q!!!", false);
        }
        company=companyId.get();
        Department department = new Department();
        department.setName(dto.getName());
        department.setId(id);
        department.setCompany(company);
        Department save = departmentRepositary.save(department);
        return new ApiResponce("Saved", true, save);

    }






}
