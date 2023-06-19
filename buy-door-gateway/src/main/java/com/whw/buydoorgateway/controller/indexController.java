package com.whw.buydoorgateway.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;


@Controller
public class indexController {

//    @RequestMapping("/index")
//    public String showIndex(){
//        return "index.html";
//    }

    @PostMapping("fileUploadController")
    public String uploadFile(MultipartFile file) throws IOException {
        System.out.println("hahaha");
        file.transferTo(new File("w:/" + file.getOriginalFilename()));
        return "ok";
    }

    @GetMapping("/show")
    public String showPage(Model model){
        model.addAttribute("msg","hello");
        return "index";
    }
}
