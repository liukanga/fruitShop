package com.zcy.fruitshop.controller;

import com.zcy.fruitshop.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @GetMapping("/fruitList")
    public String toADFruitList(){
        return "admin-fruitList";
    }

    @GetMapping("/userList")
    public String toADUserList(){
        return "userList";
    }

    @GetMapping("/shopList")
    public String toADShopList(){
        return "admin-shopList";
    }

    @GetMapping("/commentList")
    public String toADCommentList(){
        return "commentList";
    }


}
