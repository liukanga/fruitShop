package com.zcy.fruitshop.dao;

import com.zcy.fruitshop.bean.Fruit;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FruitDao {

    List<Fruit> queryFruitByName(String name);

    Long addFruit(Fruit fruit);

    void updateFruit(Fruit fruit);

    void deleteFruitById(Long id);

    List<Fruit> queryFruitsByCategory(String variety);

    List<Fruit> loadAllFruits();

}
