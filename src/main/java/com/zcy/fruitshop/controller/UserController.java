package com.zcy.fruitshop.controller;

import com.zcy.fruitshop.bean.Result;
import com.zcy.fruitshop.bean.User;
import com.zcy.fruitshop.exception.FSException;
import com.zcy.fruitshop.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@Slf4j
@Api(tags = "用户业务功能")
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/loginPage")
    @ApiOperation("登陆页面")
    public String login(){
        return "loginPage";
    }

    @GetMapping("/reg")
    @ApiOperation("注册页面")
    public String register(){
        return "reg";
    }

    @PostMapping("/login")
    @ApiOperation("用户登录")
    @ResponseBody
    public Result<User> login(@RequestBody User user, Model model,  HttpSession session){

        Result<User> result = userService.login(user.getAccountNumber(), user.getPassword());
        String accessCode = (String) session.getAttribute("accessCode");
        result.setSuccess(true);
        if (accessCode.equalsIgnoreCase(user.getAccessCode())){
            model.addAttribute("user", result.getData());
            result.setMessage("验证码错误！");
            result.setSuccess(false);
        }
        return result;
    }

    @PostMapping("/register")
    @ApiOperation("用户注册")
    @ResponseBody
    public String register(@RequestBody User user, Model model) throws FSException {

        try {
            Long uid = userService.register(user);
            user.setAccountNumber(uid);
            model.addAttribute("msg", "注册成功! 您的账号是 "+uid);
            return "loginPage";
        }catch (FSException e){
            model.addAttribute("msg", "注册失败，请重新尝试！");
            return "reg";
        }
    }

}
