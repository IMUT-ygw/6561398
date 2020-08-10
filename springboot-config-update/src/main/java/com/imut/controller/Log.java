package com.imut.controller;

import com.imut.dao.YjqOperationLogDao;
import com.imut.entities.YjqOperationLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/5/7 9:44
 */
@Controller
public class Log {
    @Autowired
    YjqOperationLogDao yjqOperationLogDao;

    //显示所有操作日志
    @GetMapping("/allLog")
    public String allLog(Model model){
        List<YjqOperationLog> all = yjqOperationLogDao.findAll();
        model.addAttribute("allLog",all);
        return "list4";
    }

    //清空操作日志表
    @GetMapping("/deleteAllLog")
    public String deleteLog(){
        yjqOperationLogDao.deleteLog();
        return "list4";
    }

    //测试插入操作日志 ok
    @PostMapping("/insertLog")
    @ResponseBody
    public String Insert(String date,String describe){
        YjqOperationLog y = new YjqOperationLog();
        Timestamp timestamp = Timestamp.valueOf(date);
      y.setYjqDate(timestamp);
      y.setYjqDescribe(describe);
        yjqOperationLogDao.addLog(y);
        return "success";
    }
}
