package com.zcy.fruitshop.dao;

import com.zcy.fruitshop.bean.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {

    User queryUserById(Long id);

    Long addUser(User user);

    int updateUser(User user);

    int deleteUserById(Long id);

    User queryUserByUsername(String username);

}
