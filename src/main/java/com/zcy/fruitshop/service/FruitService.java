package com.zcy.fruitshop.service;

import com.zcy.fruitshop.bean.Fruit;
import com.zcy.fruitshop.exception.FSException;

import java.util.List;

public interface FruitService {

    List<Fruit> queryFruitByName(String name);

    Long addFruit(Fruit fruit) throws FSException;

    int updateFruit(Fruit fruit);

    int deleteFruitById(Long id);

    List<Fruit> queryFruitsByVariety(String variety);

}
