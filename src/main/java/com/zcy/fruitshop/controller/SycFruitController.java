package com.zcy.fruitshop.controller;


import com.zcy.fruitshop.bean.Fruit;
import com.zcy.fruitshop.bean.Result;
import com.zcy.fruitshop.exception.FSDBException;
import com.zcy.fruitshop.exception.FSException;
import com.zcy.fruitshop.service.FruitService;
import com.zcy.fruitshop.util.FSConstant;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Api(tags = "水果模块API")
@RestController(value = "/sys/fruit/")
public class SycFruitController {

    @Autowired
    private FruitService fruitService;

    @ApiOperation("查询水果")
    @GetMapping("/findFruit")
    public Result<List<Fruit>> findFruit(@RequestParam(value = "name", required = false)String name,
                                         @RequestParam(value = "category", required = false)String category){

        Result<List<Fruit>> result = new Result<>();
        List<Fruit> fruits = new ArrayList<>();
        if (StringUtils.hasText(name)){
            fruits = fruitService.queryFruitByName(name);
        }
        if (StringUtils.hasText(category)){
            fruits = fruitService.queryFruitsByCategory(category);
        }
        result.setData(fruits);
        result.setCode(200);
        result.setSuccess(true);
        result.setMessage(CollectionUtils.isEmpty(fruits) ? FSConstant.NO_DATA_FOUND : FSConstant.SUCCESS);

        return result;
    }

    @ApiOperation("添加水果")
    @PostMapping("/addFruit")
    public Result<Fruit> addFruit(@RequestBody Fruit fruit) throws FSException{
        Result<Fruit> result = new Result<>();
        try {
            fruitService.addFruit(fruit);
            result.setSuccess(true);
            result.setData(fruit);
            result.setMessage("添加水果成功");
            result.setCode(200);
            return result;
        }catch (FSDBException e){
            log.error("********* 添加水果失败", e);
            throw new FSException("添加水果失败");
        }
    }

    @ApiOperation("修改水果信息")
    @PutMapping("/updateFruit")
    public Result<Fruit> updateFruit(@RequestBody Fruit fruit) throws FSException{
        Result<Fruit> result = new Result<>();
        try {
            fruitService.updateFruit(fruit);
            result.setSuccess(true);
            result.setData(fruit);
            result.setMessage("更新水果信息成功");
            result.setCode(200);
            return result;
        }catch (FSDBException e){
            log.error("********* 更新水果信息失败", e);
            throw new FSException("更新水果信息失败");
        }
    }

    @ApiOperation("根据id删除水果")
    @DeleteMapping("/deleteFruit")
    public Integer deleteFruit(@RequestParam("id")Long id){
        return fruitService.deleteFruitById(id);
    }

}
