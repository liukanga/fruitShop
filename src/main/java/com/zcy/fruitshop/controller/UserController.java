package com.zcy.fruitshop.controller;

import com.zcy.fruitshop.bean.Result;
import com.zcy.fruitshop.bean.User;
import com.zcy.fruitshop.exception.FSException;
import com.zcy.fruitshop.service.UserService;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/loginPage")
    public String login(){
        return "loginPage";
    }

    @GetMapping("/reg")
    public String register(){
        return "reg";
    }

    @GetMapping("/login")
    @ResponseBody
    public Result<User> login(@NonNull @RequestParam(name = "username")String username,
                              @NonNull @RequestParam(name = "password")String password, Model model){

        Result<User> result = userService.login(username, password);
        model.addAttribute("user", result.getData());
        return result;
    }

    @PostMapping("/register")
    @ResponseBody
    public String register(@RequestBody User user, Model model) throws FSException {

        try {
            Long uid = userService.register(user);
            user.setId(uid);
            model.addAttribute("msg", "注册成功! 您的账号是 "+uid);
            return "loginPage";
        }catch (FSException e){
            model.addAttribute("msg", "注册失败，请重新尝试！");
            return "reg";
        }
    }

}
