package com.zcy.fruitshop.service;

import com.zcy.fruitshop.bean.Result;
import com.zcy.fruitshop.bean.User;

public interface UserService {

    User queryUserById(Long id);

    Long register(User user);

    int updateUser(User user);

    int deleteUserById(Long id);

    Result<User> login(String username, String password);

}
