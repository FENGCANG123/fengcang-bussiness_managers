package com.neuedu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
public class TestController {


    @RequestMapping(value = "upload",method = RequestMethod.GET)
    public  String  login(){

        return "upload";
    }
    @RequestMapping(value = "upload",method = RequestMethod.POST)
    public  String  login(@RequestParam("pic")MultipartFile uploadFile){
if (uploadFile!=null)
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


}
        return "upload";
    }
}

