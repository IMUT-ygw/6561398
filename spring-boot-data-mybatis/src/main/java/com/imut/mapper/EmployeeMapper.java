package com.imut.mapper;

import com.imut.pojo.Employee;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/5/15 10:44
 */
public interface EmployeeMapper {


    public Employee getEmpId(Integer id);

    public void insert(Employee employee);
}
