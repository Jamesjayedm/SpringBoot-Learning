package com.james.springbootdata.controller;

import com.james.springbootdata.bean.Department;
import com.james.springbootdata.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeptController {

    @Autowired
    DepartmentMapper departmentMapper;

    @RequestMapping("/dept/{id}")
    public Department getDepartment(Integer id) {
        return departmentMapper.getDeptById(id);
    }
}
