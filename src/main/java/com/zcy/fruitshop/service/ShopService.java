package com.zcy.fruitshop.service;

import com.zcy.fruitshop.bean.Shop;
import com.zcy.fruitshop.exception.FSDBException;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShopService {

    /**
     * 根据id查询商店
     * @param id
     * @return
     */
    Shop queryShopById(@Param("id")Long id);

    /**
     * 添加商店信息
     * @param shop
     * @return
     */
    Long addShop(Shop shop) throws FSDBException;

    /**
     * 更新商店信息
     * @param shop
     * @return
     */
    int updateShop(Shop shop) throws FSDBException;

    /**
     * 根据id删除商店
     * @param id
     * @return
     */
    int deleteShopById(@Param("id")Long id);

    /**
     * 根据userId查询商店
     * @param userId
     * @return
     */
    List<Shop> queryShopByUserId(@Param("userId") Long userId);

    /**
     * 根据店名查询商店
     * @param name
     * @return
     */
    List<Shop> queryShopByName(@Param("name")String name);

}
