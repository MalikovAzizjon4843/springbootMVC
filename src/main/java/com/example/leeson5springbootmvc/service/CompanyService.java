package com.example.leeson5springbootmvc.service;

import com.example.leeson5springbootmvc.dto.ApiResponce;
import com.example.leeson5springbootmvc.entity.Company;
import com.example.leeson5springbootmvc.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {
    @Autowired
    CompanyRepository companyRepository;

    public ApiResponce add(Company company) {
        Company save = companyRepository.save(company);
        return new ApiResponce("saved", true, save);
    }


    public ApiResponce edit(Company company, Integer id){
        return new ApiResponce("edited" , true);
    }
}
