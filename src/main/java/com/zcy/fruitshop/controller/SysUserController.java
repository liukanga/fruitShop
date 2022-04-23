package com.zcy.fruitshop.controller;

import com.zcy.fruitshop.bean.Result;
import com.zcy.fruitshop.bean.User;
import com.zcy.fruitshop.enumrate.MessageEnum;
import com.zcy.fruitshop.exception.FSDBException;
import com.zcy.fruitshop.exception.FSException;
import com.zcy.fruitshop.service.UserService;
import com.zcy.fruitshop.util.FSConstant;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Api(tags = "用户模块API")
@RestController(value = "/sys/user/")
public class SysUserController {

    @Autowired
    private UserService userService;

    @ApiOperation("添加用户接口")
    @PostMapping(value = "/addUser")
    public Result<User> addUser(@RequestBody User user) throws FSException{
        Result<User> result = new Result<>();
        try {
            userService.register(user);
            result.setData(user);
            result.setMessage("注册用户成功");
            result.setCode(200);
            result.setSuccess(true);
            return result;
        }catch (FSDBException e){
            log.error("****** 注册用户失败", e);
            throw new FSException("注册用户失败");
        }
    }

    @ApiOperation("根据ID查询用户")
    @GetMapping(value = "/findUser")
    public Result<User> find(@RequestParam(value = "id") Long id) {
        Result<User> result = new Result<>();
        User user = userService.queryUserById(id);
        result.setData(user);
        result.setMessage("查询用户成功");
        result.setCode(200);
        result.setSuccess(true);
        return result;
    }

    @ApiOperation("更新用户")
    @PutMapping(value = "/updateUser")
    public Result<User> updateUser(@RequestBody User user) throws FSException{
        Result<User> result = new Result<>();
        try {
            userService.updateUser(user);
            result.setData(user);
            result.setMessage("更新用户成功");
            result.setCode(200);
            result.setSuccess(true);
        }catch (FSDBException e){
            log.error("****** 更新用户失败", e);
            throw new FSException("更新用户失败");
        }
        return result;
    }

    @ApiOperation("删除用户")
    @DeleteMapping(value = "/deleteUser")
    public Integer deleteUserById(@RequestParam(value = "id") Long id) {
        return userService.deleteUserById(id);
    }

    @ApiOperation("根据用户名查询")
    @GetMapping(value = "/userList")
    public Result<List<User>> loadUserByUsername(@RequestParam(value = "username")String username){

        Result<List<User>> result = new Result<>();
        List<User> users = userService.loadUserByUsername(username);
        result.setData(users);
        result.setCode(200);
        result.setSuccess(true);
        result.setMessage(CollectionUtils.isEmpty(users) ? FSConstant.NO_DATA_FOUND : FSConstant.SUCCESS);

        return result;
    }


}
