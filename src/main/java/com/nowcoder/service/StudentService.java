package com.nowcoder.service;

import com.nowcoder.dao.LoginTicketDAO;
import com.nowcoder.dao.studentDAO;
import com.nowcoder.model.LoginTicket;
import com.nowcoder.model.Student;
import com.nowcoder.util.ToutiaoUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import java.util.UUID;
@Service
public class StudentService {
    @Autowired
    private studentDAO studentdao;
    @Autowired
    private LoginTicketDAO loginTicketdao;

    public Map<String, Object> Sregiset(String name, String password) {
        Map<String, Object> map = new HashMap<>();
        if (StringUtils.isBlank(name)&&StringUtils.isBlank(password)){
            map.put("msgname","name is null");
            map.put("msgpassword","password is null");
            return map;
        }
    if (StringUtils.isBlank(name)){
        map.put("msgname","name is null");
        return map;
    }
   if  (StringUtils.isBlank(password)){
        map.put("msgpassword","password is null");
        return map;
    }

   Student a= studentdao.selectByStudentName(name);
    if (a!=null){
        map.put("msgname","name has registed");
        return map;
    }
    Student student=new Student();
    student.setStudentName(name);
    String salt= UUID.randomUUID().toString().substring(2,6);
    student.setSalt(salt);
    student.setStudentPasswrod(ToutiaoUtil.MD5(salt+password));
    studentdao.addStudent(student);
    map.put("sucssec","chenggong");
    return map;
    }
    public Map<String,Object>login(String name,String password){
        Map<String,Object> map=new HashMap<>();
        if (StringUtils.isBlank(name)){
            map.put("msgname","name is null");
            return map;
        }
        if  (StringUtils.isBlank(password)){
            map.put("msgpassword","password is null");
            return map;
        }
        studentdao.selectByStudentName(name);
        if (name==null){
            map.put("msgname","your name is not in list");
            return map;
        }
        Student student=studentdao.selectByStudentName(name);
      if(!student.getStudentPasswrod().equals(ToutiaoUtil.MD5(student.getSalt()+password))){
            map.put("msgpass","your password is not right");
            return map;
        }
        String ticket=addLoginTicket(student.getStudentId());
        map.put("ticket", ticket);
        return map;
    }
    public  String addLoginTicket(int studentid){
        LoginTicket Ticket=new LoginTicket();
        Ticket.setUserId(studentid);
        Date date=new Date();
        date.setTime(date.getTime()+1000*3600*48);
        Ticket.setExpired(date);
        Ticket.setStatus(0);
        Ticket.setTicket(UUID.randomUUID().toString().replaceAll("-",""));
        loginTicketdao.addTicket(Ticket);

       return Ticket.getTicket();
    }
}
