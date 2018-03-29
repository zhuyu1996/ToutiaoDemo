package com.nowcoder.controller;

import com.nowcoder.service.ToutiaoService;
import com.sun.xml.internal.bind.v2.model.core.EnumConstant;
import org.apache.catalina.connector.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;


/**
 * great by zhuyu
 */
@Controller
public class MypageController {
    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
    @Autowired
    ToutiaoService toutiaoService;

    @RequestMapping("/hi")
    @ResponseBody
    public String GetSomething() {
        return "say hi";
    }

    @RequestMapping(value = "/My/{groupId}/{userId}")
    @ResponseBody
    public String GetSomValus(@PathVariable("groupId") String groupId,
                              @PathVariable("userId") int userId,
                              @RequestParam(name = "type", defaultValue = "old") String type,
                              @RequestParam(name = "kind", defaultValue = "hahhah") String kind
    ) {
        return String.format("{%s},{%d},{%s},{%s}", groupId, userId, type, kind);
    }

    @RequestMapping("/MYRequest")
    @ResponseBody
    public String Re(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        StringBuffer sb = new StringBuffer();
        Enumeration<String> headname = request.getHeaderNames();
        while (headname.hasMoreElements()) {
            String name = headname.nextElement();
            sb.append(name + ":" + request.getHeader(name) + "<br>");
        }
        for (Cookie cookie : request.getCookies()) {
            sb.append("Cookie:");
            sb.append(cookie.getName());
            sb.append(":");
            sb.append(cookie.getValue() + "<br>");
        }
        sb.append("etLocalPort:" + request.getLocalPort() + "<br>");
        sb.append("getMethod:" + request.getMethod() + "<br>");
        sb.append("getQueryString:" + request.getQueryString() + "<br>");
        sb.append("getRequestURI:" + request.getRequestURI() + "<br>");
        return sb.toString();

    }

    @RequestMapping(path = {"/myresponse"})
    @ResponseBody
    public String Myresponse(@RequestParam(name = "kind", defaultValue = "hhaha") String kind,
                             @RequestParam(name = "type", defaultValue = "hhahh") String type,
                             @CookieValue(value = "myid", defaultValue = "123") String myid,
                             HttpSession httpSession,
                             HttpServletResponse response) {
        response.addCookie(new Cookie(kind, type));
        response.addHeader("kkkkHH", type);

        return "welcomto mypage" + myid + "MYSESSION" + httpSession.getAttribute("msg");
    }


    @RequestMapping("/RE/{code}")
    public String redirectView(@PathVariable(value = "code") int code, HttpSession HttpSession) {

      /*  RedirectView red=new RedirectView("/myresponse",true);//SpringMvc
        if (code==301){
            red.setStatusCode(HttpStatus.MOVED_PERMANENTLY);}*/
        HttpSession.setAttribute("msg", "对面瓜马匹");
        return "redirect:/myresponse";
    }

    @RequestMapping("/myadmin")
    @ResponseBody
    public String admin(@RequestParam(value = "key") String key) {
        logger.info("Visit Index");
        if (!key.equals("admin")) {
            throw new IllegalArgumentException("key: 错误");
        } else {
            return "hello my king" + toutiaoService.say();
        }
    }

    @ExceptionHandler
    @ResponseBody
    public String myerror(Exception e) {
        return "error" + e.getMessage();
    }

    @RequestMapping(path = {"/my"})
    public String myindex(HttpSession HttpSession){
        return "home";
    }
}
