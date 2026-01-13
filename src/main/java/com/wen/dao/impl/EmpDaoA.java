package com.wen.dao.impl;

import com.wen.dao.EmpDao;
import com.wen.pojo.Emp;
import com.wen.utils.XmlParserUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class EmpDaoA implements EmpDao {
    @Override
    public List<Emp> ListEmp() {
        String file = this.getClass().getClassLoader().getResource("emp.xml").getFile();
        System.out.println(file);
        List<Emp> empList = XmlParserUtils.parse(file,Emp.class);
        return empList;
    }
}
