package com.zcy.fruitshop.service.impl;

import com.zcy.fruitshop.bean.Fruit;
import com.zcy.fruitshop.dao.FruitDao;
import com.zcy.fruitshop.service.FruitService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class FruitServiceImpl implements FruitService {

    @Autowired
    private FruitDao fruitDao;

    @Override
    public List<Fruit> queryFruitByName(String name) {
        return null;
    }

    @Override
    public Long addFruit(Fruit fruit) {
        return null;
    }

    @Override
    public int updateFruitById(Long id) {
        return 0;
    }

    @Override
    public int deleteFruitById(Long id) {
        return 0;
    }

    @Override
    public List<Fruit> queryFruitsByVariety(String variety) {
        return null;
    }
}
