package com.atguigu.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

@Controller
public class HelloController {

//    @RequestMapping( {"/","index.html"})
//    public String index(){
//        return "index";
//    }
    @ResponseBody
    @RequestMapping("/hello")
    public String helloWorld() {
        return "hello world";
    }

    @RequestMapping("success")
    public String success(Map<String,Object> map){
        map.put("hello","<h1>你好</h1>");
        map.put("users", Arrays.asList("张三","李四","王五"));
        map.put("user", new Object(){
           public  String id="111";
           public String getName(){
               return "张三";
           }
        });
//        thymeleaf 默认路径为 classpath:/templates
        return "success";
    }
}
