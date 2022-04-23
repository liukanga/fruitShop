package com.zcy.fruitshop.dao;

import com.zcy.fruitshop.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserDao {

    User queryUserById(@Param("accountNumber") Long id);

    Long addUser(User user);

    int updateUser(User user);

    int deleteUserById(@Param("accountNumber")Long id);

    List<User> queryUserByUsername(@Param("username")String username);

}
