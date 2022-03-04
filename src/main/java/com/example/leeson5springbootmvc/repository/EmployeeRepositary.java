package com.example.leeson5springbootmvc.repository;

import com.example.leeson5springbootmvc.entity.Department;
import com.example.leeson5springbootmvc.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepositary extends JpaRepository<Employee, Integer> {
}
