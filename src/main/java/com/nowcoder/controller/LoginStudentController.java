package com.nowcoder.controller;


import com.nowcoder.service.StudentService;
import com.nowcoder.util.ToutiaoUtil;
import com.sun.deploy.net.HttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.sql.Time;
import java.util.Map;

@Controller
public class LoginStudentController {
    private static final Logger mylogger = LoggerFactory.getLogger(LoginStudentController.class);
    @Autowired
    StudentService studentService;

    @RequestMapping(value = "/regstudent", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String myreg(@RequestParam(value = "studentname") String studentname,
                        @RequestParam(value = "studentpassword") String studentpassword,
                        @RequestParam(value = "rememberme" ,defaultValue ="0") int rememberme,
                        HttpServletResponse Response) {


        Map<String, Object> map = studentService.Sregiset(studentname, studentpassword);
        if (map.containsKey("ticket")) {
            Cookie cookie = new Cookie("ticket", map.get("ticket").toString());
            cookie.setPath("/");
            if (rememberme>0){
            cookie.setMaxAge(3600*24*5);
            }
            Response.addCookie(cookie);
            return ToutiaoUtil.getJSONString(0,map);
        }
else
        return ToutiaoUtil.getJSONString(1, map);
    }

    @RequestMapping(value = "/Slogin", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String mylogin(@RequestParam(value = "studentname") String studentname,
                          @RequestParam(value = "studentpassword") String studentpassword) {
        Map<String, Object> map = studentService.login(studentname, studentpassword);
        if (map != null) {
            return ToutiaoUtil.getJSONString(1, map);
        }
        return ToutiaoUtil.getJSONString(0, map);

    }
}