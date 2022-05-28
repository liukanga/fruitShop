package com.zcy.fruitshop.dao;

import com.zcy.fruitshop.bean.Shop;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ShopDao {

    Shop queryShopById(@Param("id")Long id);

    Long addShop(Shop shop);

    void updateShop(Shop shop);

    void deleteShopById(@Param("id")Long id);

    List<Shop> queryShopByUserId(@Param("userId") Long userId);

    List<Shop> queryShopByName(@Param("name")String name);

    List<Shop> queryAllShop(@Param("name")String name);

}