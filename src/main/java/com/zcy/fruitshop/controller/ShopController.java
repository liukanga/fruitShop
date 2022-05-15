package com.zcy.fruitshop.controller;


import com.zcy.fruitshop.bean.*;
import com.zcy.fruitshop.service.CommentService;
import com.zcy.fruitshop.service.FruitService;
import com.zcy.fruitshop.service.ShopService;
import com.zcy.fruitshop.service.UserService;
import com.zcy.fruitshop.util.CommonUtils;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
@Api(tags = "商店业务功能")
@RequestMapping(value = "/shop")
public class ShopController {

    @Autowired
    private ShopService shopService;

    @Autowired
    private UserService userService;

    @Autowired
    private FruitService fruitService;

    @Autowired
    private CommentService commentService;

    @GetMapping("/shopList")
    public String toShopList(Model model, HttpServletRequest request){

        List<Shop> shopList = shopService.queryAllShop();
        List<Shop> shopList1 = new ArrayList<>();
        List<Shop> shopList2 = new ArrayList<>();
        List<Shop> shopList3 = new ArrayList<>();
        for (int i=1;i<=shopList.size();i++){
            if (i%3==0){
                shopList1.add(shopList.get(i-1));
            }else if (i%3==1){
                shopList2.add(shopList.get(i-1));
            }else {
                shopList3.add(shopList.get(i-1));
            }
        }
        HttpSession session = request.getSession();
        User currentUser = (User) session.getAttribute("user");

        model.addAttribute("shopList1", shopList1);
        model.addAttribute("shopList2", shopList2);
        model.addAttribute("shopList3", shopList3);
        model.addAttribute("currentUser", currentUser);
        model.addAttribute("type", 1);

        return "shopList";
    }

    @GetMapping("/toShop")
    public String toShop(@RequestParam("id")Long id, Model model, HttpServletRequest request){

        HttpSession session = request.getSession();
        User currentUser = (User) session.getAttribute("user");

        Shop shop = shopService.queryShopById(id);
        User user = userService.queryUserById(shop.getUserId());
        ShopUser shopUser = CommonUtils.toShopUser(shop, user);

        List<Fruit> fruits = fruitService.loadAllFruits();

        List<Comment> comments = commentService.loadAllComment();
        List<CommentUser> commentUserList = new ArrayList<>();
        for (Comment comment : comments){
            User commentator = userService.queryUserById(comment.getUserId());
            CommentUser commentUser = new CommentUser(comment.getContent(), comment.getGmtCreated(), commentator.getUsername());
            commentUserList.add(commentUser);
        }

        model.addAttribute("shopUser", shopUser);
        model.addAttribute("fruitList", fruits);
        model.addAttribute("commentList", commentUserList);
        model.addAttribute("user", currentUser);


        return "shopDetail";

    }

    @GetMapping("queryShop")
    public String loadShopByName(@RequestParam("name")String name, HttpServletRequest request, Model model){

        List<Shop> shops = shopService.queryShopByName(name);
        HttpSession session = request.getSession();
        User currentUser = (User) session.getAttribute("user");

        model.addAttribute("shops", shops);
        model.addAttribute("currentUser", currentUser);
        model.addAttribute("type", 1);

    }


}
