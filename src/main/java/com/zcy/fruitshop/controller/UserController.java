package com.zcy.fruitshop.controller;

import com.github.pagehelper.PageInfo;
import com.zcy.fruitshop.bean.Fruit;
import com.zcy.fruitshop.bean.Result;
import com.zcy.fruitshop.bean.Shop;
import com.zcy.fruitshop.bean.User;
import com.zcy.fruitshop.exception.FSException;
import com.zcy.fruitshop.service.FruitService;
import com.zcy.fruitshop.service.ShopService;
import com.zcy.fruitshop.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@Slf4j
@Api(tags = "用户业务功能")
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private FruitService fruitService;

    @Autowired
    private ShopService shopService;

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
    public String toMyCart(@RequestParam("sid") Long sid, Model model,HttpSession session){

        User user = (User)session.getAttribute("user");
        List<Fruit> fruits = fruitService.getCartFruits(user.getAccountNumber(),sid);

        model.addAttribute("fruitList", fruits);
        model.addAttribute("user", user);

        return "shopping-cart";

    }
    @ResponseBody
    @GetMapping("/addToCart")
    public int addToCart(@RequestParam("sid") Long sid,@RequestParam("fid") Long fid,HttpSession session){
        User user = (User)session.getAttribute("user");
        return fruitService.addToCart(sid, fid, user.getAccountNumber());

    }


    @GetMapping("/{accountNumber}/fruitList")
    public String toFruitList(@PathVariable("accountNumber")Long accountNumber, Model model, HttpServletRequest request){

        User user = userService.queryUserById(accountNumber);

        PageInfo<Shop> pageInfo = shopService.queryAllShop(null,1);
        List<Shop> shopList = pageInfo.getList();

        List<Shop> shops = shopList.stream().filter(shop -> shop.getUserId().equals(user.getAccountNumber())).collect(Collectors.toList());

        if (CollectionUtils.isEmpty(shops)){
            return "error";
        }

        HttpSession session = request.getSession();
        User currentUser = (User) session.getAttribute("user");

        model.addAttribute("targetUrl", "http://localhost:8028/allFruit/"+shops.get(0).getId());
        model.addAttribute("currentUser", currentUser);

        return "fruitList";
    }




}
