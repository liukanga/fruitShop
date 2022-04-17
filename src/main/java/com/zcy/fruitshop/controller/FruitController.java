package com.zcy.fruitshop.controller;

import com.zcy.fruitshop.bean.Fruit;
import com.zcy.fruitshop.exception.FSException;
import com.zcy.fruitshop.service.FruitService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@Api(tags = "水果业务功能")
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
