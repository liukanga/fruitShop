package com.zcy.fruitshop.service;

import com.zcy.fruitshop.bean.Fruit;
import com.zcy.fruitshop.exception.FSDBException;

import java.util.List;

public interface FruitService {

    List<Fruit> queryFruitByName(String name);

    Long addFruit(Fruit fruit) throws FSDBException;

    int updateFruit(Fruit fruit) throws FSDBException;

    int deleteFruitById(Long id);

    List<Fruit> queryFruitsByCategory(String category);

    List<Fruit> loadAllFruits();

}
