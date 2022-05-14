package com.zcy.fruitshop.controller;

import com.zcy.fruitshop.bean.Result;
import com.zcy.fruitshop.bean.Shop;
import com.zcy.fruitshop.exception.FSDBException;
import com.zcy.fruitshop.exception.FSException;
import com.zcy.fruitshop.service.ShopService;
import com.zcy.fruitshop.util.FSConstant;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Api(tags = "商店模块RestAPI")
@RestController
public class SycShopController {

    @Autowired
    private ShopService shopService;

    @ApiOperation("添加商店")
    @PostMapping(value = "/addShop")
    public Result<Shop> addShop(@RequestParam("name")String name,
                                @RequestParam("address")String address,
                                @RequestParam("userId")Long userId,
                                @RequestParam("permit")String permit,
                                @RequestParam("description")String description,
                                @RequestParam("bhours")String bHours){
        Result<Shop> result = new Result<>();
        Shop shop = new Shop(name, address, userId, permit, description, bHours);
        try {
            shopService.addShop(shop);
            result.setData(shop);
            result.setSuccess(true);
            result.setCode(200);
            result.setMessage("添加商店成功");
        }catch (FSDBException e){
            log.error("********* 添加商店失败", e);
            result.setSuccess(false);
            result.setMessage("添加商店失败");
        }
        return result;
    }

    @ApiOperation("根据ID查询商店")
    @GetMapping(value = "/findShop")
    public Result<Shop> loadShopById(@RequestParam(value = "id") Long id){
        Result<Shop> result = new Result<>();
        Shop shop = shopService.queryShopById(id);
        result.setData(shop);
        result.setMessage("查询成功");
        result.setCode(200);
        result.setSuccess(true);

        return result;
    }

    @ApiOperation("更新商店")
    @PostMapping(value = "/updateShop/{id}")
    public Result<Shop> updateShop(@RequestParam("name")String name,
                                   @PathVariable("id")Long id,
                                   @RequestParam("address")String address,
                                   @RequestParam("userId")Long userId,
                                   @RequestParam("permit")String permit,
                                   @RequestParam("description")String description,
                                   @RequestParam("bhours")String bHours){
        Result<Shop> result = new Result<>();
        Shop shop = new Shop(name, address, userId, permit, description, bHours);
        shop.setId(id);
        try {
            shopService.updateShop(shop);
            result.setData(shop);
            result.setMessage("更新商店成功");
            result.setCode(200);
            result.setSuccess(true);
        }catch (FSDBException e){
            log.error("********* 更新商店失败", e);
            result.setSuccess(false);
            result.setMessage("更新商店失败");
        }
        return result;
    }

    @ApiOperation("删除商店")
    @GetMapping("/deleteShop")
    public Result<String> deleteShop(@RequestParam("id")Long id){

        Result<String> result = new Result<>();
        shopService.deleteShopById(id);

        result.setSuccess(true);
        return result;
    }

    @ApiOperation("根据店名查询")
    @GetMapping(value = "/shopList")
    public Result<List<Shop>> loadShopByName(@RequestParam(value = "name")String name){

        Result<List<Shop>> result = new Result<>();
        List<Shop> shopList = shopService.queryShopByName(name);
        result.setData(shopList);
        result.setCode(200);
        result.setSuccess(true);
        result.setMessage(CollectionUtils.isEmpty(shopList) ? FSConstant.NO_DATA_FOUND : FSConstant.SUCCESS);

        return result;
    }


    @PostMapping("/allShop")
    public List<Shop> allShops(){

        return shopService.queryAllShop();
    }

}
