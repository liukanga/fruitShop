package com.zcy.fruitshop.service.impl;

import com.zcy.fruitshop.enumrate.MessageEnum;
import com.zcy.fruitshop.bean.Result;
import com.zcy.fruitshop.bean.User;
import com.zcy.fruitshop.dao.UserDao;
import com.zcy.fruitshop.exception.FSDBException;
import com.zcy.fruitshop.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User queryUserById(Long id) {
        return userDao.queryUserById(id);
    }

    @Override
    public Long register(User user) throws FSDBException {
        try {
            return userDao.addUser(user);
        }catch (Exception e){
            log.error("*********注册用户失败");
            throw new FSDBException("添加用户到数据库失败");
        }
    }

    @Override
    public int updateUser(User user) throws FSDBException{
        try {
            return userDao.updateUser(user);
        }catch (Exception e){
            log.error("*********更新用户失败");
            throw new FSDBException("更新用户数据失败");
        }
    }

    @Override
    public int deleteUserById(Long id) {
        userDao.deleteUserById(id);
        return 0;
    }

    @Override
    public Result<User> login(Long accountNumber, String password) {
        Result<User> result = new Result<>();
        User user = userDao.queryUserById(accountNumber);
        if (password.equals(user.getPassword())){
            result.setCode(MessageEnum.VERIFY_SUCCESS.getCode());
            result.setMessage(MessageEnum.VERIFY_SUCCESS.getStatus());
            result.setSuccess(true);
            result.setData(user);
        }else {
            result.setCode(MessageEnum.VERIFY_FAILURE.getCode());
            result.setMessage(MessageEnum.VERIFY_FAILURE.getStatus());
            result.setSuccess(false);
            result.setData(user);
        }
        return result;
    }

    @Override
    public List<User> loadUser(String username, String level) {

        Map<String, String> param = new HashMap<>();
        param.put("username", username);
        param.put("level", level);
        return userDao.queryUser(param);
    }

    @Override
    public List<User> loadAllUser() {

        return userDao.queryAllUser();
    }

}
