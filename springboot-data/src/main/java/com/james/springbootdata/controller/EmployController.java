package com.james.springbootdata.controller;

import com.james.springbootdata.bean.Employee;
import com.james.springbootdata.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployController {

    @Autowired
    EmployeeMapper employeeMapper;

    @ResponseBody
    @RequestMapping("/emp/{id}")
    public Employee getEmp(@PathVariable("id") Integer id) {
        return employeeMapper.getEmpById(id);
    }
}
