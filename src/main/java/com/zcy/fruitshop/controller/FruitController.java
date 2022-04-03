package com.zcy.fruitshop.controller;

import com.zcy.fruitshop.bean.Fruit;
import com.zcy.fruitshop.bean.Result;
import com.zcy.fruitshop.bean.User;
import com.zcy.fruitshop.exception.FSException;
import com.zcy.fruitshop.service.FruitService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping(value = "/fruit")
public class FruitController {

    @Autowired
    private FruitService fruitService;

    @PostMapping("/addFruit")
    public String addFruit(@RequestBody Fruit fruit) throws FSException {

        fruitService.addFruit(fruit);
        
        return "/addFruit";
    }


}
