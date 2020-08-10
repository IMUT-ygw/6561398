package com.imutdata.springbootdata.controller;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/4/24 11:36
 */
@Controller
@RequestMapping("controller")
public class MyController {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @ResponseBody
    @RequestMapping("/hello")
    public Map<String , Object> helle(){
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from account");
        return maps.get(0);
    }

}
