package com.zcy.fruitshop.service;

import com.zcy.fruitshop.bean.Fruit;

import java.util.List;

public interface FruitService {

    List<Fruit> queryFruitByName(String name);

    Long addFruit(Fruit fruit);

    int updateFruitById(Long id);

    int deleteFruitById(Long id);

    List<Fruit> queryFruitsByVariety(String variety);

}
