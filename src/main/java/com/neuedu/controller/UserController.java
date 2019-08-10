package com.neuedu.controller;

import com.neuedu.consts.Const;
import com.neuedu.exception.MyException;
import com.neuedu.pojo.Category;
import com.neuedu.pojo.PageContext;
import com.neuedu.pojo.UserInfo;
import com.neuedu.service.impl.UserServiceImpl;
import com.neuedu.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.List;

@Controller
@RequestMapping("/user/")
public class UserController {
    @Autowired
    UserServiceImpl userService;
    @RequestMapping(value = "login",method = RequestMethod.GET)
    public  String login()
    {
        return "login";
    }
    @RequestMapping(value = "login",method = RequestMethod.POST)
    public  String login(UserInfo userInfo, HttpServletResponse response, HttpServletRequest request)
    {   String s=userInfo.getPassword();
        userInfo.setPassword(MD5Utils.getMD5Code(s));
        UserInfo loginuserInfo=userService.login(userInfo);

       HttpSession session= request.getSession();

       if (loginuserInfo!=null) {

           session.setAttribute(Const.CURRENT_USER,loginuserInfo);
           Cookie username_cookie=new Cookie("username",userInfo.getUsername());
           Cookie password_cookie=new Cookie("password",userInfo.getPassword());
           username_cookie.setMaxAge(60*60*24*7);
           password_cookie.setMaxAge(60*60*7*24);
           response.addCookie(username_cookie);
           response.addCookie(password_cookie);
           return "redirect:home";
       }
       return "login";
    }
    @RequestMapping(value = "home",method = RequestMethod.GET)
    public String home()
    {
        return "home/home";
    }





    @RequestMapping(value = "find/{page}")
    public  String  findAll(@PathVariable("page")int currentPage, HttpSession session){


        List<UserInfo> userInfoList=userService.findAll();
        PageContext pageContext=new PageContext(2,currentPage,userInfoList);


        userInfoList=pageContext.getCurrentlistBySum();
        session.setAttribute("pageContext",pageContext);
        session.setAttribute("userInfoList",userInfoList);
        session.setAttribute("currentPage",currentPage);
        return "userinfo/list";
    }
    @RequestMapping(value = "update/{id}",method = RequestMethod.GET)
    public  String  update(@PathVariable("id") Integer userId, HttpServletRequest request){


      List<UserInfo> list=(List<UserInfo>) request.getSession().getAttribute("userInfoList");
        for (int i = 0; i <list.size() ; i++) {

            if (list.get(i).getId()==userId)
            {
                request.setAttribute("updateuserinfo",list.get(i));
                return "userinfo/index";
            }
        }
        return "userinfo/index";
    }
    @RequestMapping(value = "update/{id}",method = RequestMethod.POST)
    public String update(UserInfo userinfo ,HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException
    {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        System.out.println(userinfo.getAnswer());
        System.out.println(userinfo.getRole());
        int page=(int)request.getSession().getAttribute("currentPage");
        String url="redirect:/user/find/"+page;
        int result=userService.updateByPrimaryKey(userinfo);
        if(result>0){
            //修改成功
            request.getSession().removeAttribute("updateuserinfo");

            return url;
        }


        return url;

    }
    @RequestMapping(value = "delete/{id}")
    private String delet(@PathVariable("id") Integer categoryId)
    {
        int result = userService.deleteByPrimaryKey(categoryId);
        return "redirect:/user/find/0";
    }
    @RequestMapping(value = "insert",method = RequestMethod.GET)
    public String insert()
    {
        return "userinfo/index";
    }
    @RequestMapping(value = "insert",method = RequestMethod.POST)
    public String insert(UserInfo userInfo,HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        int page=(int)request.getSession().getAttribute("currentPage");
        String url="redirect:/user/find/"+page;

        int result=userService.insert(userInfo);
        if (result>0) {

            return url;
        }
        System.out.println("注册失败");
        return url;
    }
    @RequestMapping(value = "logout")
    public String logout(HttpServletRequest request,HttpServletResponse response)
    {
        Enumeration em = request.getSession().getAttributeNames();
        while(em.hasMoreElements()) {
            request.getSession().removeAttribute(em.nextElement().toString());
        }
        Cookie[]cookies=request.getCookies();

        if (cookies!=null&cookies.length>0)
    {
        for (Cookie c:cookies
        ) {
            if(c.getName().equals("username"))
            {
                c.setMaxAge(0);

                response.addCookie(c);
            }
            if (c.getName().equals("password"))
            {
                c.setMaxAge(0);

                response.addCookie(c);
                System.out.println("======password");
            }
        }
    }
//        Cookie newCookie=new Cookie("username",null);
//        newCookie.setMaxAge(0);
//        newCookie.setPath("/");
//        response.addCookie(newCookie);
//        Cookie newCookie1=new Cookie("password",null);
//        newCookie1.setMaxAge(0);
//        newCookie1.setPath("/");
//        response.addCookie(newCookie1);


        return "redirect:/user/login";
    }

}
