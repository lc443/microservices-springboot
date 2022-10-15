package com.leron.department.service;

import com.leron.department.model.Department;
import com.leron.department.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;


    public Department save(Department department) {
        log.info("Inside saveDepartment of DepartmentService");
        return departmentRepository.save(department);
    }

    public Department findDepartmentById(Long departmentId) {
        log.info("Inside findDepartment of DepartmentService");
        return departmentRepository.findByDepartmentId(departmentId);
    }

    public List<Department> findAllDepartments() {
        return departmentRepository.findAll();
    }
}
