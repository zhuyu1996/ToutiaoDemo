package com.nowcoder.interceptor;

import com.nowcoder.model.LoginTicket;
import com.sun.xml.internal.ws.handler.HandlerException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class MyInterceptor  implements HandlerInterceptor{
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String ticket=null;//申明一个字符串ticket
        if(httpServletRequest.getCookies()!=null)
        {
            for (Cookie cookie:httpServletRequest.getCookies()){
                if(cookie.getName().equals("ticket")){
                  ticket=  cookie.getValue();
                }

            }
        }
        if (ticket!=null){

        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }

}
