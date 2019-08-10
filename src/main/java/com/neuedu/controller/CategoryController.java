package com.neuedu.controller;

import com.neuedu.pojo.Category;
import com.neuedu.pojo.PageContext;
import com.neuedu.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.List;


@Controller
@RequestMapping("/user/category/")
public class CategoryController {

    @Autowired
    ICategoryService categoryService;

    @RequestMapping(value = "find/{page}")
    public  String  findAll(@PathVariable("page")int currentPage,HttpServletRequest request){



        List<Category> categoryList=categoryService.findAll();
        PageContext pageContext=new PageContext(2,currentPage,categoryList);
        pageContext.getCurrentlistBySum();
        request.getSession().setAttribute("pageContext",pageContext);
        request.getSession().setAttribute("categorylist",categoryList);
        request.getSession().setAttribute("currentPage",currentPage);
        return "category/list";
    }


    @RequestMapping(value = "update/{id}",method = RequestMethod.GET)
    public  String  update(@PathVariable("id") Integer categoryId, HttpServletRequest request){


        Category category=categoryService.findCategoryById(categoryId);

        request.setAttribute("updatecategory",category);

        return "category/index";
    }

    @RequestMapping(value = "update/{id}",method = RequestMethod.POST ,produces="text/html;charset=UTF-8;")
    public  String  update(Category category, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        System.out.println(category.getName());

       //
       int count= categoryService.updateCategory(category);

       if(count>0){
           //修改成功
           System.out.println("修改成功");
           System.out.println(category.getName());
           request.removeAttribute("updatecategory");
           int page=(int)request.getSession().getAttribute("currentPage");
           String url="redirect:/user/category/find/"+page;
           return url;
       }

        return "categoryupdate";
    }
    @RequestMapping(value = "delete/{id}")
    public String delet(@PathVariable("id") Integer categoryId)
    {
        int result = categoryService.deleteByPrimaryKey(categoryId);
        return "redirect:/user/category/find/0";
    }
    @RequestMapping(value = "insert",method = RequestMethod.GET)
    public String insert(HttpServletRequest request)
    { List<Category> categoryList=(List<Category>) request.getSession().getAttribute("categorylist");
        System.out.println(categoryList.size());
        request.removeAttribute("updatecategory");
        return "category/index";
    }
    @RequestMapping(value = "insert",method = RequestMethod.POST)
    public String insert(Category category,HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        System.out.println(category.getName());
        categoryService.insert(category);
        int page=(int)request.getSession().getAttribute("currentPage");
        String url="redirect:/user/category/find/"+page;
        return url;
    }


}
