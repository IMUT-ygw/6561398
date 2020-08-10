package com.imut.controller;

import com.imut.dao.DepartmentDao;
import com.imut.dao.EmployeeDao;
import com.imut.entities.Department;
import com.imut.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;

import java.util.Collection;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/4/19 11:03
 */
@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;

    //查询所有员工返回列表页面
    @GetMapping("/emps")
    public String list(Model model){
        Collection<Employee> all = employeeDao.getAll();
        //放在请求域
        model.addAttribute("emps",all);
        return "list";
    }
    //跳转添加页面
    @GetMapping("/emp")
    public String toAddPage(Model model){
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "add";
    }

    //员工添加
    //SpringMvc将请求参数和入参对象进行一一绑定，要求请求参数名与入参名一致
    @PostMapping("/emp")
    public String addUser(Employee employee){
        System.out.println(employee);
        employeeDao.save(employee);
        //redirect 表示重定向
        //forward 表示转发到一个地址
        return "redirect:/emps";
    }


    //点击‘编辑’ 跳转到此页面 修改员工信息
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id ,Model model){
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp",employee);
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "add";
    }

    //员工修改
    @PutMapping("/emp")
    public String updateEmp(Employee employee){
        System.out.println(employee);
        //save方法 要判断是否有id  有id 是修改方法  没id 是添加方法
        employeeDao.save(employee);
        //添加/编辑功能完成后，跳转到list页面 进行重新获取全部数据 显示
        return "redirect:/emps";
    }

    @RequestMapping(value ="/delete/{id}",method = RequestMethod.GET)
    public String deleteEmp(@PathVariable("id") Integer id){
            employeeDao.delete(id);
            return "redirect:/emps";
    }
}
