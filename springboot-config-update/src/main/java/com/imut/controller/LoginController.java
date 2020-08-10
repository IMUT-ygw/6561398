package com.imut.controller;

import com.imut.dao.*;
import com.imut.entities.Customer;
import com.imut.entities.YjqOperationLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/4/18 16:42
 */
@Controller
public class LoginController {
    @Autowired
    private LoginDao loginDao;
    @Autowired
    CustomerDao customerDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserLogDao userLogDao;
    @Autowired
    private YjqOperationLogDao yjqOperationLogDao;

    /**
     * 用户登录
     *
     * @param username
     * @param password
     * @param map
     * @param httpSession
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String, Object> map,
                        HttpSession httpSession) {
        Customer login = loginDao.login(username, password);
        String error = "用户账号或密码错误!";
        if (login == null) {
            map.put("msg", error);
            return "index";
        } else {
            httpSession.setAttribute("loginUser", username);
            dbUserLog(username, password);
            return "listCustomer01";
        }
    }

    //添加操作日志（用户登陆）
    private void dbUserLog(String username, String password) {
        YjqOperationLog y = new YjqOperationLog();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf.format(new Date());
        y.setYjqDate(Timestamp.valueOf(format));
        y.setYjqDescribe("用户：" + username + "登录");
        yjqOperationLogDao.addLog(y);
    }

    /**
     * 管理员登录   账号：admin  密码：123456
     *
     * @param username
     * @param password
     * @param map
     * @param httpSession
     * @return
     */
    @RequestMapping(value = "/loginAdmin", method = RequestMethod.POST)
    public String loginAdmin(@RequestParam("username") String username,
                             @RequestParam("password") String password,
                             Map<String, Object> map,
                             HttpSession httpSession) {
        if ("admin".equals(username) && "123456".equals(password)) {
            httpSession.setAttribute("loginUser", "管理员");
            dbUserLog();
            return "list";
        } else {
            String error = "管理员账号或密码错误!";
            map.put("msg", error);
            return "adminLogin";
        }
    }

    //添加操作日志（管理员登陆）
    private void dbUserLog() {
        YjqOperationLog y = new YjqOperationLog();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf.format(new Date());
        y.setYjqDate(Timestamp.valueOf(format));
        y.setYjqDescribe("管理员登陆");
        yjqOperationLogDao.addLog(y);
    }

    //添加会员用户
    @PostMapping("/addCustomer")
    public String addCustomer(Customer customer, Map<String, Object> map) {
        Customer byTelephone = customerDao.findByTelephone(customer.getCustomerTelephone());
        if (byTelephone == null) {
            customerDao.addCustomer(customer);
            dbUserLog(customer);
            return "redirect:/allCustomer";
        } else {
            map.put("msg", "手机号已被注册，请重新输入！");
            return "add";
        }
    }

    //添加操作日志（管理员添加会员）
    private void dbUserLog(Customer customer) {
        YjqOperationLog y = new YjqOperationLog();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf.format(new Date());
        y.setYjqDate(Timestamp.valueOf(format));
        y.setYjqDescribe("管理员注册会员：" + customer.getCustomerTelephone());
        yjqOperationLogDao.addLog(y);
    }


    //删除会员涉及业务及流水（用户注销）
    @GetMapping("/deleteCustomer")
    public String deleteCustomer(String telephone) {
        customerDao.deleteCustomer(telephone);
        userDao.deleteByTelephone(telephone);
        userLogDao.deleteTelephone(telephone);
        dbUserLog(telephone);
        return "index";
    }

    //操作日志（用户注销账户）
    private void dbUserLog(String telephone) {
        YjqOperationLog y = new YjqOperationLog();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf.format(new Date());
        y.setYjqDate(Timestamp.valueOf(format));
        y.setYjqDescribe("用户：" + telephone + "注销了账户并将改手机号下的所有会员业务及流水删除");
        yjqOperationLogDao.addLog(y);
    }

    @GetMapping("/exitUser")
    public String exitUser(String username) {
        YjqOperationLog y = new YjqOperationLog();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf.format(new Date());
        y.setYjqDate(Timestamp.valueOf(format));
        y.setYjqDescribe("用户：" + username + "退出登录");
        yjqOperationLogDao.addLog(y);
        return "index";


    }
}



