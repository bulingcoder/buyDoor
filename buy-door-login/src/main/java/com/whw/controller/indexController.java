package com.whw.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.whw.entity.User;
import com.whw.entity.response.Response;
import com.whw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;


@Controller
public class indexController {

    @Autowired
    private UserService userervice;

    @PostMapping("fileUploadController")
    public String uploadFile(MultipartFile file) throws IOException {
        file.transferTo(new File("w:/" + file.getOriginalFilename()));
        return "ok";
    }

    @GetMapping("/show")
    public String showPage(Model model){
        model.addAttribute("msg","hello");
        return "b2_index";
    }

    @GetMapping("/login.html")
    public String loginPage( Model model){
        model.addAttribute("user",new User());
        return "login";
    }


    @GetMapping("/login")
    public String login(@Validated  User user, Model model){
        System.out.println(user);
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("phone",user.getPhone());
        queryWrapper.eq("password",user.getPassword());
        User result = userervice.getOne(queryWrapper);
        System.out.println(result);

        if(null != result){
            model.addAttribute("userName",": "+result.getName());
            return "b2_index";
        }else {
            return "error";
        }
    }


    @GetMapping("/addUser.html")
    public String addUserPage( Model model){
        return "addUser";
    }


    /**
     * 添加用户
     */
    @PostMapping("/addUser")
    public String addUser(@Validated User user, Model model){
        try {
            userervice.save(user);
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }
        model.addAttribute("userName",": "+user.getName());
        return "b2_index";
    }
}
