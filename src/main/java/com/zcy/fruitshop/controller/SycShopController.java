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
@Api(tags = "商店模块API")
@RestController(value = "/sys/shop/")
public class SycShopController {

    @Autowired
    private ShopService shopService;

    @ApiOperation("添加商店")
    @PostMapping(value = "/addShop")
    public Result<Shop> addShop(@RequestBody Shop shop) throws FSException {
        Result<Shop> result = new Result<>();
        try {
            shopService.addShop(shop);
            result.setData(shop);
            result.setSuccess(true);
            result.setCode(200);
            result.setMessage("添加商店成功");
            return result;
        }catch (FSDBException e){
            log.error("********* 添加商店失败", e);
            throw new  FSException("添加商店失败");
        }
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
    @PutMapping(value = "/updateShop")
    public Result<Shop> updateShop(@RequestBody Shop shop) throws FSException{
        Result<Shop> result = new Result<>();
        try {
            shopService.updateShop(shop);
            result.setData(shopService.queryShopById(shop.getId()));
            result.setMessage("更新商店成功");
            result.setCode(200);
            result.setSuccess(true);
            return result;
        }catch (FSDBException e){
            log.error("********* 更新商店失败", e);
            throw new FSException("更新商店失败");
        }
    }

    @ApiOperation("删除商店")
    @DeleteMapping(value = "/deleteShop")
    public Integer deleteShopById(@RequestParam(value = "id") Long id) {
        return shopService.deleteShopById(id);
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

}
