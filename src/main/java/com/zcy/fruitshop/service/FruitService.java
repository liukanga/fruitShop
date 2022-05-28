package com.zcy.fruitshop.service;

import com.github.pagehelper.PageInfo;
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

    PageInfo<Fruit> getFruitsByShopId(Long id,Integer page);

    List<Fruit> getCartFruits(Long uid,Long sid);

    int addToCart(Long sid, Long fid, Long accountNumber);
}
