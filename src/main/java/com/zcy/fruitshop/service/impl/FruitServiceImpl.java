package com.zcy.fruitshop.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zcy.fruitshop.bean.Fruit;
import com.zcy.fruitshop.dao.FruitDao;
import com.zcy.fruitshop.exception.FSDBException;
import com.zcy.fruitshop.service.FruitService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class FruitServiceImpl implements FruitService {

    @Autowired
    private FruitDao fruitDao;

    @Override
    public List<Fruit> queryFruitByName(String name) {
        return fruitDao.queryFruitByName(name);
    }

    @Override
    public Long addFruit(Fruit fruit) throws FSDBException {
        try {
            return fruitDao.addFruit(fruit);
        }catch (Exception e){
            log.error("*********添加水果失败", e);
            throw new FSDBException("添加水果到数据库失败");
        }
    }

    @Override
    public int updateFruit(Fruit fruit) throws FSDBException{
        try {
            fruitDao.updateFruit(fruit);
            return 0;
        }catch (Exception e){
            log.error("********* 更新水果信息失败", e);
            throw new FSDBException("更新水果信息到数据库失败");
        }
    }

    @Override
    public int deleteFruitById(Long id) {
        fruitDao.deleteFruitById(id);
        return 0;
    }

    @Override
    public List<Fruit> queryFruitsByCategory(String category) {
        return fruitDao.queryFruitsByCategory(category);
    }

    @Override
    public List<Fruit> loadAllFruits() {
        return fruitDao.loadAllFruits();
    }

    @Override
    public PageInfo<Fruit> getFruitsByShopId(Long id,Integer page) {
        PageHelper.startPage(page,8);
        List<Fruit> fruitsByShopId = fruitDao.getFruitsByShopId(id);
        PageInfo<Fruit> pageInfo = new PageInfo<>(fruitsByShopId);
        return pageInfo;
    }

    @Override
    public List<Fruit> getCartFruits(Long uid,Long sid) {
        return fruitDao.getCartFruits(uid,sid);
    }

    @Override
    public int addToCart(Long sid, Long fid, Long uid) {
        return fruitDao.addToCart(sid,fid,uid);
    }
}
