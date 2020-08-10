package com.imut.controller;

import com.imut.dao.CustomerDao;
import com.imut.dao.UserDao;
import com.imut.dao.UserLogDao;
import com.imut.dao.YjqOperationLogDao;
import com.imut.entities.Customer;
import com.imut.entities.User;
import com.imut.entities.UserLog;
import com.imut.entities.YjqOperationLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/4/29 10:09
 */
@Controller
public class CustomerController {
    @Autowired
   private CustomerDao customerDao;
    @Autowired
    private  UserDao userDao;
    @Autowired
   private UserLogDao userLogDao;
    @Autowired
    private YjqOperationLogDao yjqOperationLogDao;


    //会员表
    @GetMapping("/allCustomer")
    public String allCustomer(Model model){
        Collection<Customer> all = customerDao.findAll();
        model.addAttribute("emps",all);
        return "list3";
    }

    //会员添加业务
    @PostMapping("/userServiceAdd")
    public String addUserService(String userTelephone, String userService, String userDescribe, HashMap<String, Object> map){
        Customer byTelephone = customerDao.findByTelephone(userTelephone);
        if(byTelephone == null){
            map.put("msg","该手机号未注册！");
            return "addUserService";
        }
        User user = new User();
        user.setUserTelephone(userTelephone);
        user.setUserService(userService);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf.format(new Date());
        Timestamp time = Timestamp.valueOf(format);
        user.setUserDate(time);
        user.setUserDescribe(userDescribe);
        System.out.println("业务信息" + user);
        userDao.insertUser(user);
        dbUserLog(userTelephone,userService);
        return "redirect:/findAll1";
    }
    //操作日志（会员添加业务）
    private  void dbUserLog(String telephone,String describe){
        YjqOperationLog y = new YjqOperationLog();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf.format(new Date());
        y.setYjqDate(Timestamp.valueOf(format));
        y.setYjqDescribe("管理员为用户" + telephone + "添加业务：" +  describe);
        yjqOperationLogDao.addLog(y);
    }


    //用户添加日志
    @PostMapping("/addUserLog")
    public String addUserLog(Integer logUserId,String logUserDescribe,String logUserTelephone,HashMap<String,Object> map){
       //验证业务是否存在
        User byId = userDao.findById(logUserId);
        if(byId == null){
            map.put("msg","业务编号不存在");
            return "addUserLog";
        }
        //验证是不是本人的业务
        ArrayList<User> customer = userDao.findCustomer(logUserTelephone);
        Iterator<User> iterator = customer.iterator();
        while(iterator.hasNext()) {
            User user = iterator.next();
            if (user.getId().equals(logUserId)) {
                UserLog userLog = new UserLog();
                userLog.setLogUserId(logUserId);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String format = sdf.format(new Date());
                Timestamp timestamp = Timestamp.valueOf(format);
                userLog.setLogUserDate(timestamp);
                userLog.setLogUserDescribe(logUserDescribe);
                userLog.setLogUserTelephone(logUserTelephone);
                userLogDao.insertUserLog(userLog);
                dbUserLog(logUserTelephone,logUserId,logUserDescribe);//调用日志
                return "redirect:/customerLog";
            } else {
                if (user == customer.get(customer.size() - 1)) {
                    map.put("msg", "请查询本人正确的编号进行输入！");
                    return "addUserLog";
                }
            }
        }
        map.put("msg","您未办理业务！无法添加日志！");
        return "addUserLog";
    }

    //操作日志记录
    private  void dbUserLog(String telephone,Integer id,String describe){
        YjqOperationLog y = new YjqOperationLog();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf.format(new Date());
        y.setYjqDate(Timestamp.valueOf(format));
        y.setYjqDescribe("用户:" + telephone + "为" + id+"业务添加日志信息内容为：" + describe);
        yjqOperationLogDao.addLog(y);
    }

}
