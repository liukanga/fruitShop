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
@Api(tags = "水果模块RestAPI")
@RestController
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
    public Result<Fruit> addFruit(@RequestParam("name")String name,
                                      @RequestParam("category")String category,
                                      @RequestParam("location")String location,
                                      @RequestParam("dateOfManufacture")String dateOfManufacture,
                                      @RequestParam("qualityGuaranteePeriod")String qualityGuaranteePeriod,
                                      @RequestParam("price")double price,
                                      @RequestParam("stock")Integer stock,
                                      @RequestParam("sugar")String sugar,
                                      @RequestParam("organicAcid")String organicAcid,
                                      @RequestParam("sugarAcidRatio")String sugarAcidRatio,
                                      @RequestParam("vitamins")String vitamins,
                                      @RequestParam("meatQuality")String meatQuality,
                                      @RequestParam("moisture")String moisture,
                                      @RequestParam("shopId")String shopId){

        Result<Fruit> result = new Result<>();
        Fruit fruit = new Fruit(name,category,location,dateOfManufacture,qualityGuaranteePeriod,price,stock,sugar,organicAcid,sugarAcidRatio,vitamins,meatQuality,moisture,shopId);
        try {
            fruitService.addFruit(fruit);
            result.setSuccess(true);
            result.setData(fruit);
            result.setMessage("添加水果成功");
            result.setCode(200);
        }catch (FSDBException e){
            log.error("********* 添加水果失败", e);
            result.setSuccess(false);
            result.setMessage("添加水果失败");
        }
        return result;
    }

    @ApiOperation("修改水果信息")
    @PostMapping("/updateFruit/{id}")
    public Result<Fruit> updateFruit(@PathVariable("id")Long id,
                                     @RequestParam(value = "name", required = false)String name,
                                     @RequestParam(value = "category", required = false)String category,
                                     @RequestParam(value = "location", required = false)String location,
                                     @RequestParam(value = "dateOfManufacture", required = false)String dateOfManufacture,
                                     @RequestParam(value = "qualityGuaranteePeriod", required = false)String qualityGuaranteePeriod,
                                     @RequestParam("price")double price,
                                     @RequestParam("stock")Integer stock,
                                     @RequestParam(value = "sugar", required = false)String sugar,
                                     @RequestParam(value = "organicAcid", required = false)String organicAcid,
                                     @RequestParam(value = "sugarAcidRatio", required = false)String sugarAcidRatio,
                                     @RequestParam(value = "vitamins", required = false)String vitamins,
                                     @RequestParam(value = "meatQuality", required = false)String meatQuality,
                                     @RequestParam(value = "moisture", required = false)String moisture,
                                     @RequestParam(value = "shopId", required = false)String shopId){
        Result<Fruit> result = new Result<>();
        Fruit fruit = new Fruit(name,category,location,dateOfManufacture,qualityGuaranteePeriod,price,stock,sugar,organicAcid,sugarAcidRatio,vitamins,meatQuality,moisture,shopId);
        fruit.setId(id);
        try {
            fruitService.updateFruit(fruit);
            result.setSuccess(true);
            result.setData(fruit);
            result.setMessage("更新水果成功");
            result.setCode(200);
        }catch (FSDBException e){
            log.error("********* 更新水果失败", e);
            result.setSuccess(false);
            result.setMessage("更新水果失败");
        }
        return result;
    }

    @ApiOperation("根据id删除水果")
    @GetMapping("/deleteFruit")
    public Result<String> deleteFruit(@RequestParam("id")Long id){
        Result<String> result = new Result<>();
        fruitService.deleteFruitById(id);

        result.setSuccess(true);
        result.setMessage("删除水果成功");

        return result;
    }

    @PostMapping("/allFruit")
    public List<Fruit> allFruits(){

        return fruitService.loadAllFruits();
    }
}
