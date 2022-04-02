package com.zcy.fruitshop.dao;

import com.zcy.fruitshop.bean.Fruit;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FruitDao {

    List<Fruit> queryFruitByName(String name);

    Long addFruit(Fruit fruit);

    int updateFruit(Fruit fruit);

    int deleteFruitById(Long id);

    List<Fruit> queryFruitsByVariety(String variety);

}
