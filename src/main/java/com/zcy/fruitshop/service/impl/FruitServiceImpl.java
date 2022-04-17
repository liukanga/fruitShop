package com.zcy.fruitshop.service.impl;

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
            log.error("*********添加水果失败");
            throw new FSDBException("添加水果到数据库失败");
        }
    }

    @Override
    @Transactional(rollbackFor = FSDBException.class)
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
}
