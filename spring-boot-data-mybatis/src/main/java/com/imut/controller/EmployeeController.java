package com.imut.controller;

import com.imut.mapper.EmployeeMapper;
import com.imut.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/5/15 11:04
 */
@RestController
public class EmployeeController {
    @Autowired
    EmployeeMapper employeeMapper;

    @GetMapping("/empFindById/{id}")
    public Employee findById(@PathVariable("id") Integer id){
        Employee empId = employeeMapper.getEmpId(id);
        return empId;
    }

    @GetMapping("/empInsert")
    public Employee insert(Employee employee){
        employeeMapper.insert(employee);
        return employee;
    }


}
