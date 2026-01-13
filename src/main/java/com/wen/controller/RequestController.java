package com.wen.controller;

import com.wen.pojo.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class RequestController {
    @RequestMapping("/simpleParam")
    public String simpleParam(String name, Integer age){
        System.out.println(name+":"+age);
        return "success";
    }
    @RequestMapping("/simplePojo")
    public String simplePojo(User user){
        System.out.println(user);
        return "success";
    }
    @RequestMapping("/dateParam")
    public String dateParam(@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime updateTime){
        System.out.println(updateTime);
        return "success";
    }
    @RequestMapping("/jsonParam")
    public String jsonParam(@RequestBody User user){
        System.out.println(user);
        return "success";
    }
    @RequestMapping("/path/{id}/{name}")
    public String path(@PathVariable Integer id, @PathVariable String name){
        System.out.println(id+":"+name);
        return "success";
    }
}
