package com.wen.controller;

import com.wen.pojo.Emp;
import com.wen.pojo.Result;
import com.wen.service.EmpService;
import com.wen.service.impl.EmpServiceA;
import com.wen.utils.XmlParserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class empController {
    @Autowired
    private EmpService empService;
    @RequestMapping("/listEmp")
    public Result list(){
        List<Emp> empList =  empService.listEmp();
        return Result.success(empList);
    }
}

//    public Result list() {
//        String file = this.getClass().getClassLoader().getResource("emp.xml").getFile();
//        System.out.println(file);
//        List<Emp> empList= XmlParserUtils.parse(file, Emp.class);
//        empList.stream().forEach(emp -> {
//            String gender = emp.getGender();
//            if("1".equals(gender)){
//                emp.setGender("男");
//            }else if("2".equals(gender)){
//                emp.setGender("女");
//            }
//            String job = emp.getJob();
//            if("1".equals(job)){
//                emp.setJob("讲师");
//            }else if("2".equals(job)){
//                emp.setJob("班主任");
//            }else if("3".equals(job)){
//                emp.setJob("就业指导");
//            }
//        });
//
//        return Result.success(empList);
//    }
//
//}
