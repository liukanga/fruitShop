package com.zcy.fruitshop.service.impl;

import com.zcy.fruitshop.bean.Fruit;
import com.zcy.fruitshop.dao.FruitDao;
import com.zcy.fruitshop.exception.FSException;
import com.zcy.fruitshop.exception.ValidationException;
import com.zcy.fruitshop.service.FruitService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

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
    public Long addFruit(Fruit fruit) throws FSException {
        if (StringUtils.isEmptyOrWhitespace(fruit.getVariety())){
            log.error("*********水果的种类不能为空！");
            throw new ValidationException("水果种类为空");
        }
        if (StringUtils.isEmptyOrWhitespace(fruit.getName())){
            log.error("*********水果名不能为空");
            throw new ValidationException("水果名为空");
        }
        return fruitDao.addFruit(fruit);
    }

    @Override
    public int updateFruit(Fruit fruit) {
        return fruitDao.updateFruit(fruit);
    }

    @Override
    public int deleteFruitById(Long id) {
        return deleteFruitById(id);
    }

    @Override
    public List<Fruit> queryFruitsByVariety(String variety) {
        return fruitDao.queryFruitsByVariety(variety);
    }
}
