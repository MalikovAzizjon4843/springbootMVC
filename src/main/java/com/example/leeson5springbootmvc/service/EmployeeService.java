package com.example.leeson5springbootmvc.service;

import com.example.leeson5springbootmvc.dto.ApiResponce;
import com.example.leeson5springbootmvc.dto.DepartmentDTO;
import com.example.leeson5springbootmvc.dto.EmployeeDto;
import com.example.leeson5springbootmvc.entity.Company;
import com.example.leeson5springbootmvc.entity.Department;
import com.example.leeson5springbootmvc.entity.Employee;
import com.example.leeson5springbootmvc.repository.CompanyRepository;
import com.example.leeson5springbootmvc.repository.DepartmentRepositary;
import com.example.leeson5springbootmvc.repository.EmployeeRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class EmployeeService {

    @Autowired
    EmployeeRepositary employeeRepositary;

    @Autowired
    DepartmentRepositary departmentRepositary;



    public ApiResponce add(EmployeeDto employeeDto) {
        Optional<Department> optionalDepartment = departmentRepositary.findById(employeeDto.getDepartmentId());

        if (optionalDepartment.isEmpty()) return new ApiResponce("Bunaqa id yoq", false);
        Department department = optionalDepartment.get();

        Employee employee = new Employee();
        employee.setName(employeeDto.getName());
        employee.setDepartment(department);

        Employee save = employeeRepositary.save(employee);
        return new ApiResponce("saved", true, save);
    }

    public ApiResponce edit(EmployeeDto dto, Integer id) {
        Optional<Department> departmentId = departmentRepositary.findById(dto.getDepartmentId());
        Department department = new Department();
        if (departmentId.isEmpty()) {
            return new ApiResponce("Bunday Id yo'q!!!", false);
        }
        department = departmentId.get();
        Employee employee = new Employee();
        employee.setName(dto.getName());
        employee.setId(id);
        employee.setDepartment(department);
        Employee save = employeeRepositary.save(employee);
        return new ApiResponce("Saved", true, save);

    }
}
