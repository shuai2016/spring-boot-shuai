package com.shuai.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @Value("${person.last-name}")
    private String name;

    @ResponseBody
    @RequestMapping("hello")
    public String hello(){
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
}
