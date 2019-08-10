package com.neuedu.interceptors;

import com.neuedu.consts.Const;
import com.neuedu.pojo.UserInfo;
import com.neuedu.service.impl.UserServiceImpl;
import com.neuedu.utils.MD5Utils;
import org.omg.CORBA.*;
import org.omg.PortableInterceptor.Interceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.Object;

public class Authorityinterceptor implements HandlerInterceptor {
    @Autowired
    UserServiceImpl userService;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
                 UserInfo userInfo = (UserInfo) session.getAttribute(Const.CURRENT_USER);
                 //判断session中是否有用户数据，如果有，则返回true，继续向下执行
                 if (userInfo != null) {
                         return true;
                     }
        Cookie[]cookies=request.getCookies();
        String username=null;
        String password=null;
        if (cookies!=null&cookies.length>0)
        {
            for (Cookie c:cookies
            ) {
                if(c.getName().equals("username"))
                {
                    username=c.getValue();
                }
                if (c.getName().equals("password"))
                {
                    password=c.getValue();
                }
            }
        }
        if(username!=null&&password!=null)
        {

            UserInfo userInfo1=new UserInfo();

            String s=password;
            System.out.println(username);
            System.out.println(password);
            userInfo1.setPassword(password);
            userInfo1.setUsername(username);
            UserInfo userinfo=userService.login(userInfo1);
            if (userinfo!=null)
            {
                session.setAttribute(Const.CURRENT_USER,userinfo);
                System.out.println("======cookie======");
                System.out.println(username);
                System.out.println(password);
                return true;
            }
        }
                 //不符合条件的给出提示信息，并转发到登录页面
                 request.setAttribute("msg", "您还没有登录，请先登录！");
                 response.sendRedirect("/user/login");
                 return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
