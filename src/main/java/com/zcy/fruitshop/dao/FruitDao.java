package com.zcy.fruitshop.dao;

import com.zcy.fruitshop.bean.Fruit;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface FruitDao {

    List<Fruit> queryFruitByName(String name);

    Long addFruit(Fruit fruit);

    void updateFruit(Fruit fruit);

    void deleteFruitById(Long id);

    List<Fruit> queryFruitsByCategory(String variety);

    List<Fruit> loadAllFruits();

    List<Fruit> getFruitsByShopId(Long id);

    List<Fruit> getCartFruits(@Param("uid") Long uid, @Param("sid") Long sid);

    int addToCart(@Param("sid")Long sid,@Param("fid") Long fid,@Param("uid") Long uid);
}
