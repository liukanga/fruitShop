package com.zcy.fruitshop.controller;

import com.zcy.fruitshop.bean.Fruit;
import com.zcy.fruitshop.bean.Result;
import com.zcy.fruitshop.bean.User;
import com.zcy.fruitshop.exception.FSException;
import com.zcy.fruitshop.service.FruitService;
import com.zcy.fruitshop.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@Slf4j
@Api(tags = "用户业务功能")
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private FruitService fruitService;

    @PostMapping("/login")
    @ApiOperation("用户登录")
    @ResponseBody
    public Result<User> login(@RequestBody User user, HttpServletRequest request){

        Result<User> result = userService.login(user.getAccountNumber(), user.getPassword());
        result.setSuccess(true);
        HttpSession session = request.getSession();
        session.setAttribute("user", userService.queryUserById(user.getAccountNumber()));
        return result;
    }

    @PostMapping("/register")
    @ApiOperation("用户注册")
    @ResponseBody
    public Result<User> register(@RequestBody User user){

        Result<User> result = new Result<>();
        try {
            userService.register(user);
            result.setSuccess(true);
            result.setMessage("注册成功! 您的账号是 "+ user.getAccountNumber());
            result.setCode(200);
            result.setData(user);
        }catch (FSException e){
            log.error("********* 注册失败，请重新尝试！");
            result.setSuccess(false);
            result.setMessage("注册失败，请重新尝试！");
        }
        return result;
    }

    @GetMapping("/toMyCart")
    public String toMyCart(@RequestParam("uid") Long uid, Model model){

        User user = userService.queryUserById(uid);
        List<Fruit> fruits = fruitService.loadAllFruits();

        model.addAttribute("fruitList", fruits);
        model.addAttribute("user", user);

        return "shopping-cart";

    }

}
