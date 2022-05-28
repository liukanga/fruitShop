package com.zcy.fruitshop.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zcy.fruitshop.bean.Shop;
import com.zcy.fruitshop.dao.ShopDao;
import com.zcy.fruitshop.exception.FSDBException;
import com.zcy.fruitshop.service.ShopService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopDao shopDao;

    @Override
    public Shop queryShopById(Long id) {
        return shopDao.queryShopById(id);
    }

    @Override
    @Transactional(rollbackFor = FSDBException.class)
    public Long addShop(Shop shop) throws FSDBException {
        try {
            return shopDao.addShop(shop);
        }catch (Exception e){
            log.error("********* 添加商店信息到数据库失败", e);
            throw new FSDBException("添加商店信息失败");
        }
    }

    @Override
    @Transactional(rollbackFor = FSDBException.class)
    public int updateShop(Shop shop) throws FSDBException {
        try {
            shopDao.updateShop(shop);
            return 0;
        }catch (Exception e){
            log.error("********* 更新商店信息失败", e);
            throw new FSDBException("更新商店信息失败");
        }
    }

    @Override
    public int deleteShopById(Long id) {
        shopDao.deleteShopById(id);
        return 0;
    }

    @Override
    public List<Shop> queryShopByUserId(Long userId) {
        return shopDao.queryShopByUserId(userId);
    }

    @Override
    public List<Shop> queryShopByName(String name) {

        return shopDao.queryShopByName(name);
    }

    @Override
    public PageInfo<Shop> queryAllShop(String name,Integer page) {
        PageHelper.startPage(page,9);
        List<Shop> shops = shopDao.queryAllShop(name);
        PageInfo<Shop> pageInfo = new PageInfo<>(shops);
        return pageInfo;
    }
}
