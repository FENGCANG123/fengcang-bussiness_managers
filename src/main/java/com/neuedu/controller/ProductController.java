package com.neuedu.controller;

import com.neuedu.pojo.Category;
import com.neuedu.pojo.Product;
import com.neuedu.service.impl.CategoryServiceImpl;
import com.neuedu.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.Multipart;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/user/product/")
public class ProductController {
    @Autowired
    CategoryServiceImpl categoryService;
    @Autowired
    ProductServiceImpl productService;
    @RequestMapping(value = "find")
    public String findAll(HttpSession session)
    {
        List<Product> productList=productService.selectAll();
        session.setAttribute("productlist",productList);
        return "product/list";
    }
    @RequestMapping(value = "update/{id}",method = RequestMethod.GET)
public String update(@PathVariable("id") Integer productId, HttpServletRequest request)
{HttpSession session=request.getSession();
    List<Category> categoryList=categoryService.findAll();
    request.getSession().setAttribute("categorylist",categoryList);
    List<Product> productList=(List<Product>) session.getAttribute("productlist");
    for (int i = 0; i <productList.size() ; i++) {
        int j=productList.get(i).getId();
        String newSubImages=new String();
        if (j==productId)
        {
            session.setAttribute("updateProduct",productList.get(i));
            newSubImages=productList.get(i).getSubImages().substring(5);
            System.out.println(newSubImages);
            List<String> newSubImageslist= productService.subImages(newSubImages);

            request.getSession().setAttribute("newSubImageslist",newSubImageslist);
            return "product/index";
        }

    }

 return "productupdate";
}
    @RequestMapping(value = "update/{id}",method = RequestMethod.POST)
    public String update(Product updateProduct ,@RequestParam("mainpicture")MultipartFile mainpicture, @RequestParam("picture1")MultipartFile[] files,HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException
    {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        System.out.println(updateProduct.getId());
        System.out.println(updateProduct.getName());




        if (mainpicture!=null&&!mainpicture.isEmpty())
        {
            String uuid= UUID.randomUUID().toString();
            String fileName=mainpicture.getOriginalFilename();
            String fileextendname=fileName.substring(fileName.lastIndexOf("."));
            String newFileName=uuid+fileextendname;
            File file=new File("D:\\upload");
            File newFile=new File(file,newFileName);
            try {
                mainpicture.transferTo(newFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
            updateProduct.setMainImage(newFileName);

        }





        List<String> strs =(List<String>) request.getSession().getAttribute("newSubImageslist");
        String str="00000";
        for (int i = 0; i <strs.size() ; i++) {
            if (!strs.get(i).equals("")&&strs.get(i)!=null) {
                str = str + strs.get(i);
                str = str + ",";
            }
        }
        System.out.println(files.length);
        if (files!=null&&!files[0].isEmpty())
        {
            for(MultipartFile uploadFile:files)
            {
                String uuid= UUID.randomUUID().toString();
                String fileName=uploadFile.getOriginalFilename();
                String fileextendname=fileName.substring(fileName.lastIndexOf("."));
                String newFileName=uuid+fileextendname;
                File file=new File("D:\\upload");
                File newFile=new File(file,newFileName);
                try {
                    uploadFile.transferTo(newFile);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                str=str+newFileName+",";
            }
//            System.out.println("11111");
//            String uuid= UUID.randomUUID().toString();
//            String fileName=uploadFile.getOriginalFilename();
//            String fileextendname=fileName.substring(fileName.lastIndexOf("."));
//            String newFileName=uuid+fileextendname;
//
//            File file=new File("D:\\upload");
//            File newFile=new File(file,newFileName);
//            try {
//                uploadFile.transferTo(newFile);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
        }
        updateProduct.setSubImages(str.substring(0,str.length()-1));
        int result=productService.updateByPrimaryKey(updateProduct);
        if(result>0){
            //修改成功
            request.getSession().removeAttribute("updateProduct");
            request.getSession().removeAttribute("newSubImageslist");
            return "redirect:/user/product/find";
        }

        return "productupdate";

    }
    @RequestMapping(value = "delete/{id}")
    private String delet(@PathVariable("id") Integer productId)
    {
        int result = productService.deleteByPrimaryKey(productId);
        return "redirect:/user/product/find";
    }
    @RequestMapping(value = "insert",method = RequestMethod.GET)
    public String insert(HttpServletRequest request)
    {
        List<Category> categoryList=categoryService.findAll();
        request.getSession().setAttribute("categorylist",categoryList);
        request.getSession().removeAttribute("updateProduct");
        request.getSession().removeAttribute("newSubImageslist");
        return "product/index";
    }
    @RequestMapping(value = "insert",method = RequestMethod.POST)
    public String insert(Product product, @RequestParam("mainpicture")MultipartFile mainpicture, @RequestParam("picture1")MultipartFile[] files, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        if (mainpicture != null && !mainpicture.isEmpty()) {
            String uuid = UUID.randomUUID().toString();
            String fileName = mainpicture.getOriginalFilename();
            String fileextendname = fileName.substring(fileName.lastIndexOf("."));
            String newFileName = uuid + fileextendname;
            File file = new File("D:\\upload");
            File newFile = new File(file, newFileName);
            try {
                mainpicture.transferTo(newFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
            product.setMainImage(newFileName);

        }

        String str = "00000";

        System.out.println(files.length);
        if (files != null && !files[0].isEmpty()) {
            for (MultipartFile uploadFile : files) {
                String uuid = UUID.randomUUID().toString();
                String fileName = uploadFile.getOriginalFilename();
                String fileextendname = fileName.substring(fileName.lastIndexOf("."));
                String newFileName = uuid + fileextendname;
                File file = new File("D:\\upload");
                File newFile = new File(file, newFileName);
                try {
                    uploadFile.transferTo(newFile);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                str = str + newFileName + ",";
            }
        }
        product.setSubImages(str.substring(0,str.length()-1));
            int result = productService.insert(product);
            if (result > 0) {
                return "redirect:/user/product/find";
            }
            System.out.println("注册失败");
            return "redirect:/user/product/find";

    }
    @RequestMapping(value = "sub/{id}",method = RequestMethod.GET)
    public String subimagesupload(@PathVariable("id") Integer productId,HttpServletRequest request)
    {List<Product> productList=(List<Product>) request.getSession().getAttribute("productlist");
    String newSubImages=null;
        for (int i = 0; i <productList.size() ; i++) {
            int j=productList.get(i).getId();
            if (j==productId)
            {request.getSession().setAttribute("updateProduct",productList.get(i));
                request.getSession().setAttribute("newSubImages",productList.get(i).getSubImages());
                newSubImages=productList.get(i).getSubImages().substring(5);
                break;
            }
        }
        System.out.println(newSubImages);
       List<String> newSubImageslist= productService.subImages(newSubImages);

        request.getSession().setAttribute("newSubImageslist",newSubImageslist);
        return "redirect:/user/product/addimage";
}

   @RequestMapping(value = "deleteimage/{subimage}")
    public String deleteimage(@PathVariable("subimage") String image,HttpServletRequest request)
    {
       List<String> images=(List<String>) request.getSession().getAttribute("newSubImageslist");
       Product product=(Product) request.getSession().getAttribute("updateProduct");

        for (int i = 0; i <images.size() ; i++) {

            String a=images.get(i);
            int j=a.indexOf(".");
            a=a.substring(0,j);
            System.out.println(a);
            if (a.equals(image))
            {
                System.out.println("=========delete=======");
                images.remove(images.get(i));
                break;
            }

        }
        System.out.println(image);
        String str="00000";
        for (int i = 0; i <images.size() ; i++) {
            if (!images.get(i).equals("")&&images.get(i)!=null) {
                str = str + images.get(i);
                str = str + ",";
            }
        }
        product.setSubImages(str.substring(0,str.length()-1));
        productService.updateByPrimaryKey(product);
       request.getSession().setAttribute("newSubImageslist",images);
       String strd="redirect:/user/product/update/"+product.getId();
       return strd;
    }
@RequestMapping(value = "addimage",method = RequestMethod.GET)
    public String addimage()
    {
        return "uploadsubimages";
    }
    @RequestMapping(value = "addimage",method = RequestMethod.POST)
    public String addimage(HttpServletRequest request)
    {
       Product product=(Product) request.getSession().getAttribute("updateProduct");
        System.out.println(product.getId());
        List<String> strs=(List<String>) request.getSession().getAttribute("newSubImageslist");
        String str="00000";
        for (int i = 0; i <strs.size() ; i++) {
            if (i==strs.size()-1)
            {   if (!strs.get(i).equals("")&&strs.get(i)!=null) {
                str = str + strs.get(i);
                break;
            }
            }
            if (!strs.get(i).equals("")&&strs.get(i)!=null) {
                str = str + strs.get(i);
                str = str + ",";
            }
        }
        product.setSubImages(str);
        productService.updateByPrimaryKey(product);
        return "redirect:/user/product/find";

    }
    @RequestMapping(value = "setimage",method = RequestMethod.GET)
    public String setImage()
    {
        return "upload";
    }
    @RequestMapping(value = "setimage",method = RequestMethod.POST)
    public  String  setImage(@RequestParam("pic")MultipartFile uploadFile,HttpServletRequest request){
       List<String>newSubImageslist=(List<String>) request.getSession().getAttribute("newSubImageslist");
        if (uploadFile!=null&&!uploadFile.getOriginalFilename().equals("")&&uploadFile.getOriginalFilename()!=null)
        {
            String uuid= UUID.randomUUID().toString();
            String fileName=uploadFile.getOriginalFilename();
            String fileextendname=fileName.substring(fileName.lastIndexOf("."));
            String newFileName=uuid+fileextendname;
            File file=new File("D:\\upload");
            File newFile=new File(file,newFileName);
            try {
                uploadFile.transferTo(newFile);
                newSubImageslist.add(newFileName);
                request.getSession().setAttribute("newSubImageslist",newSubImageslist);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return "redirect:/user/product/addimage";
    }
    @RequestMapping(value = "onSale/{id}")
    public String onSale(@PathVariable("id") int productId ,HttpServletRequest request){
        List<Product> productList=(List<Product>) request.getSession().getAttribute("productlist");
        for (int i = 0; i <productList.size() ; i++) {
            int j=productList.get(i).getId();
            if (j==productId)
            {Product product=productList.get(i);
            if (product.getStatus()==null)
            {
                product.setStatus(0);
            }
                if (product.getStatus()==0)
                {
                    product.setStatus(1);
                    productService.updateByPrimaryKey(product);
                }
                else
                {
                    product.setStatus(0);
                    productService.updateByPrimaryKey(product);
                }
                return "redirect:/user/product/find";
            }
        }

        return "redirect:/user/product/find";
    }


}
