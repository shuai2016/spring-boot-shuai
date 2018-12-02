package com.shuai.controller;

import com.shuai.exception.UserNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * HelloController
 *
 * @author shuai
 * @date 2018/11/30
 */
@Controller
public class HelloController {

    @Value("${person.last-name}")
    private String name;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @ResponseBody
    @RequestMapping("hello")
    public String hello(@RequestParam("user") String user){
        if ("aaa".equals(user)){
            throw new UserNotExistException();
        }
        return "Hello World!";
    }

    @ResponseBody
    @RequestMapping("sayHello")
    public String sayHello(){
        return "hello,"+ name;
    }

    @RequestMapping("success")
    public String success(ModelMap modelMap){
        modelMap.put("hello","你好");
        return "success";
    }

    @ResponseBody
    @GetMapping("/query")
    public Map<String,Object> map(){
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from phone");
        return maps.get(0);
    }
}
