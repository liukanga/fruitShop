package com.zcy.fruitshop.service.impl;

import com.zcy.fruitshop.bean.MessageEnum;
import com.zcy.fruitshop.bean.Result;
import com.zcy.fruitshop.bean.User;
import com.zcy.fruitshop.dao.UserDao;
import com.zcy.fruitshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User queryUserById(Long id) {
        return userDao.queryUserById(id);
    }

    @Override
    public Long register(User user) {
        return userDao.addUser(user);
    }

    @Override
    public int updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public int deleteUserById(Long id) {
        return deleteUserById(id);
    }

    @Override
    public Result<User> login(String username, String password) {
        Result<User> result = new Result<>();
        User user = userDao.queryUserByUsername(username);
        if (password.equals(user.getPassword())){
            result.setCode(600);
            result.setMessage("success");
            result.setData(user);
            return result;
        }
        return null;
    }

}
