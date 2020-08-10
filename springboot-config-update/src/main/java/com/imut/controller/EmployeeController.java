package com.imut.controller;

import com.imut.dao.CustomerDao;
import com.imut.dao.UserDao;
import com.imut.dao.UserLogDao;
import com.imut.dao.YjqOperationLogDao;
import com.imut.entities.*;


import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/4/19 11:03
 */
@Controller
public class EmployeeController {

    @Autowired
    private UserDao userDao;
    @Autowired
    private UserLogDao userLogDao;
    @Autowired
    private CustomerDao customerDao;
    @Autowired
    private YjqOperationLogDao yjqOperationLogDao;

    //查询所有员工返回列表页面 （管理员）ok
    @GetMapping("/findAll1")
    public String list(Model model){
        Collection<User> all = userDao.findAll();
        System.out.println(all);
        //放在请求域
        model.addAttribute("emps",all);
        return "list";
    }

    //查询所有员工返回列表页面（管理员）ok
    @GetMapping("/findAll2")
    public String list2(Model model){
        Collection<UserLog> all = userLogDao.findAll();
        System.out.println(all);
        //放在请求域
        model.addAttribute("emps",all);
        return "list2";
    }
    //用户业务 ok
    @GetMapping("/customerServices")
    public String listCustom(Model model, String loginUser){
        Collection<User> services = userDao.findCustomer(loginUser);
       // System.out.println(services);
        model.addAttribute("emps",services);
        return "listCustomer01";
    }

    //用户日志 ok
    @GetMapping("/customerLog")
    public String listCustomLog(Model model,String loginUser){
        //获取编号
        ArrayList<User> customer = userDao.findCustomer(loginUser);
        Collection<UserLog> userLog = new ArrayList<>();
        Iterator<User> iterator = customer.iterator();
        while(iterator.hasNext()){
            User next = iterator.next();
            Integer id = next.getId();
            userLog.addAll(userLogDao.findUserLog(id));
        }
        model.addAttribute("emps",userLog);
        return "listCustomer02";

    }

    //跳转添加页面 （注册会员）ok
    @GetMapping("/add")
    public String toAddPage(){
        return "add";
    }

    //跳转添加页面（添加业务） ok
    @GetMapping("/addUserService")
    public String toAddUserService(){
        return "addUserService";
    }

    //跳转添加页面（添加业务） ok
    @GetMapping("/addUserLog")
    public String toAddUserLog(){
        return "addUserLog";
    }

    //管理员登录按钮
    @GetMapping("/adminLogin")
    public String adminLogin(){
        return "adminLogin";
    }

    //会员登录按钮
    @GetMapping("/userLogin")
    public String userLogin(){
        return "index";
    }


    //跳转个人信息页面
    @GetMapping("/myBlog")
    public String myBlog(Model model,String loginUser){
        Customer user = customerDao.findByTelephone(loginUser);
        ArrayList<User> customerServiceCount = userDao.findCustomer(loginUser);
        Collection<UserLog> userLog = userLogDao.findByTelephone(loginUser);
        ResultCustomer resultCustomer = new ResultCustomer();
        resultCustomer.setCustomerAddress(user.getCustomerAddress());
        resultCustomer.setCustomerName(user.getCustomerName());
        resultCustomer.setCustomerTelephone(user.getCustomerTelephone());
        resultCustomer.setId(user.getId());
        resultCustomer.setCustomerServiceCount(customerServiceCount.size());
        resultCustomer.setCustomerLogCount(userLog.size());
        model.addAttribute("customer",resultCustomer);
        return "listCustomer03";
    }



    //删除用户日志 ok
    @RequestMapping(value ="/delete/{id}",method = RequestMethod.GET)
    public String deleteEmp(@PathVariable("id") Integer id){
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat();
        String format = sdf.format(d);
        Timestamp timestamp = Timestamp.valueOf(format);
        YjqOperationLog y = new YjqOperationLog();

            userLogDao.deleteUserLog(id);
            return "redirect:/customerLog";
    }

    //删除用户业务(用户本人) ok
    @RequestMapping(value ="/deleteService/{id}",method = RequestMethod.GET)
    public String deleteUserService(@PathVariable("id") Integer id){
        User byId = userDao.findById(id);
        List<UserLog> byTelephone = userLogDao.findByTelephone(byId.getUserTelephone());
        dbUserLog(id,byTelephone.size());
        userLogDao.deleteTelephone(byId.getUserTelephone());//删除日志
        userDao.deleteUserService(id);//删除业务
        return "redirect:/customerServices";
    }

    //操作日志用户删除业务
    private  void dbUserLog(Integer id,Integer size){
        User byId = userDao.findById(id);
        YjqOperationLog y = new YjqOperationLog();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf.format(new Date());
        y.setYjqDate(Timestamp.valueOf(format));
        y.setYjqDescribe("用户:" + byId.getUserTelephone() + "删除" + id+"号业务并删除该业务号下的"+ size + "条日志记录");
        yjqOperationLogDao.addLog(y);
    }
}
