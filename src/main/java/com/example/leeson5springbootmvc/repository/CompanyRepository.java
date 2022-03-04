package com.example.leeson5springbootmvc.repository;

import com.example.leeson5springbootmvc.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Integer> {

}
