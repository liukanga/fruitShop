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
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Api(tags = "用户模块RestAPI")
@RestController
public class RestUserController {

    @Autowired
    private UserService userService;

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

    /*@ApiOperation("根据用户名查询")
    @GetMapping(value = "/userList")
    public Result<List<User>> loadUserByUsername(@RequestParam(value = "username")String username){

        Result<List<User>> result = new Result<>();
        List<User> users = userService.loadUser(username, null);
        result.setData(users);
        result.setCode(200);
        result.setSuccess(true);
        result.setMessage(CollectionUtils.isEmpty(users) ? FSConstant.NO_DATA_FOUND : FSConstant.SUCCESS);

        return result;
    }*/

    @PostMapping("/allUser")
    public List<User> toUserList(){

        return userService.loadAllUser();
    }

    @ApiOperation("删除用户")
    @GetMapping("/delete")
    public Result<String> deleteUser(@RequestParam("accountNumber")Long accountNumber, Model model){

        Result<String> result = new Result<>();

        userService.deleteUserById(accountNumber);

        result.setSuccess(true);

        return result;
    }


    @ApiOperation("添加用户")
    @PostMapping("/addUser")
    public Result<String> addUser(@RequestParam(value = "username")String username,
                                  @RequestParam(value = "password")String password,
                                  @RequestParam(value = "level")String level,
                                  @RequestParam(value = "address")String address,
                                  @RequestParam(value = "contract")String contract,
                                  @RequestParam(value = "description")String description, Model model){

        Result<String> result = new Result<>();

        User user = new User(username, password, address, level, description, contract);
        try {
            userService.register(user);
            result.setSuccess(true);
            result.setMessage("注册成功，您的账号为：" + user.getAccountNumber() + " 请牢记！");
        }catch (FSDBException e){
            result.setSuccess(false);
            result.setMessage("添加用户失败");
        }
        return result;
    }

    @PostMapping("/updateUser/{accountNumber}")
    @ApiOperation("更新用户")
    public Result<String> updateUser(@PathVariable("accountNumber") Long accountNumber,
                                     @RequestParam(value = "username")String username,
                                     @RequestParam(value = "password")String password,
                                     @RequestParam(value = "level")String level,
                                     @RequestParam(value = "address")String address,
                                     @RequestParam(value = "contract")String contract,
                                     @RequestParam(value = "description")String description, Model model){

        Result<String> result = new Result<>();

        User user = new User(username, password, address, level, description, contract);
        user.setAccountNumber(accountNumber);
        try {
            userService.updateUser(user);
            result.setSuccess(true);
            result.setMessage("更新用户信息成功");
        }catch (FSDBException e){
            result.setSuccess(false);
            result.setMessage("更新用户失败");
        }
        return result;
    }

}
