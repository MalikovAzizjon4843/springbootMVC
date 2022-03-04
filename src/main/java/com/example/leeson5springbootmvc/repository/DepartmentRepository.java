package com.example.leeson5springbootmvc.repository;

import com.example.leeson5springbootmvc.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository  extends JpaRepository<Department, Integer> {
}
