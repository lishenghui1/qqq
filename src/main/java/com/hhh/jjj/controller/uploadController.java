package com.hhh.jjj.controller;

import com.hhh.jjj.po.User;
import com.hhh.jjj.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

;import java.io.File;
import java.io.IOException;

@Controller

public class uploadController {



    @RequestMapping("/upload")

    public String getuser() {
        return "upload";
    }

    @RequestMapping("/uploads")
    public  String upload(MultipartFile file, HttpServletRequest request, Model model) throws IOException {
        System.out.println(file.getOriginalFilename()); //获取原生的上传文件名
        //   file.transferTo();  复制文件到指定地点
        // 1 server服务器tomcat
        // 2 文件服务器 文件存储系统 FastDFS
        // 3 对象存储   OOS  云对象存储
        String realPath = request.getSession().getServletContext().getRealPath("/uploadFile");
        File  destDir=new File(realPath);

        if(!destDir.exists()){
            destDir.mkdir();
        }
        File  dest=new File(realPath+"\\"+file.getOriginalFilename());
        System.out.println(dest);
        file.transferTo(dest);
        model.addAttribute("msg","uploadFile/"+file.getOriginalFilename());
        return  "upload";  //操作完成跳转主页面
    }

}