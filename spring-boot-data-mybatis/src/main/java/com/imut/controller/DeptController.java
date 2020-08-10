package com.imut.controller;

import com.imut.mapper.DeparmentMapper;
import com.imut.pojo.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/5/15 10:08
 */
@RestController
public class DeptController {
    @Autowired
     DeparmentMapper deparmentMapper;

    @GetMapping("/findById/{id}")
    public Department findById(@PathVariable("id") Integer id){
        return deparmentMapper.findById(id);
    }

    @GetMapping("/insert")
    public String insert(Department department){
        deparmentMapper.insertDept(department);
        return "success";
    }

}
