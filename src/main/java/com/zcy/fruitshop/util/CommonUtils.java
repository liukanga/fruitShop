package com.zcy.fruitshop.util;

import com.zcy.fruitshop.bean.Shop;
import com.zcy.fruitshop.bean.ShopUser;
import com.zcy.fruitshop.bean.User;

public class CommonUtils {


    public static ShopUser toShopUser(Shop shop, User user){

        ShopUser shopUser = new ShopUser(shop.getId(), shop.getName(), shop.getAddress(), shop.getUserId(), shop.getImageUrls(), shop.getPermit(), shop.getDescription(), shop.getBHours(), shop.getGmtCreated(), shop.getGmtModified());

        shopUser.setUsername(user.getUsername());
        shopUser.setContract(user.getContract());

        return shopUser;
    }


}
