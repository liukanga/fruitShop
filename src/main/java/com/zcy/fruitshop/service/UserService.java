package com.zcy.fruitshop.service;

import com.zcy.fruitshop.bean.Result;
import com.zcy.fruitshop.bean.User;
import com.zcy.fruitshop.exception.FSDBException;

import java.util.List;

public interface UserService {

    User queryUserById(Long id);

    Long register(User user) throws FSDBException;

    int updateUser(User user) throws FSDBException;

    int deleteUserById(Long id);

    Result<User> login(Long accountNumber, String password);

    List<User> loadUserByUsername(String username);

}
