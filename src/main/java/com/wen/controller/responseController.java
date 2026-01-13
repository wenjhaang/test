package com.wen.controller;

import com.wen.pojo.Adderss;
import com.wen.pojo.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class responseController {
    @RequestMapping("/hello2")
    public Result hello2(){
        System.out.println("hello");
        return Result.success("hello");
    }
    @RequestMapping("/getAddr")
    public Result getAddr(){
        Adderss addr=new Adderss();
        addr.setProvince("广东");
        addr.setCity("深圳");
        return Result.success(addr);
    }
    @RequestMapping("/listAddr")
    public Result listAddr(){
        List<Adderss> list=new ArrayList<>();
        Adderss addr=new Adderss();
        addr.setProvince("湖南");
        addr.setCity("长沙");

        Adderss addr2=new Adderss();
        addr2.setProvince("北京");
        addr2.setCity("北京");
        list.add(addr);
        list.add(addr2);
        return Result.success(list);
    }
}
