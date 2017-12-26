package com.boot.example.controller;

import com.boot.example.pojo.User;
import com.boot.example.service.UserService;
import com.boot.example.utils.Commons;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping(value = "/user")
@Api(value = "用户模块")
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/getUserList",method = RequestMethod.GET)
    @ApiOperation(value = "获取用户列表")
    public Map<String, Object> getUserList(){
        Map<String, Object> hash_rtn = new HashMap<>();

        List<User> userList = new ArrayList<>();
        try{
            userList = userService.getUserList();
            hash_rtn.put(Commons.JSON_RES, Commons.JSON_OK);
            hash_rtn.put(Commons.JSON_VAL, userList);
        }catch (Exception e){
            e.printStackTrace();
            hash_rtn.put(Commons.JSON_RES, Commons.JSON_NO);
            hash_rtn.put(Commons.JSON_ERROR, e.getMessage());
        }
        return hash_rtn;
    }


    @RequestMapping(value = "/getUser",method = RequestMethod.GET)
    @ApiOperation(value = "获取用户")
    @ApiImplicitParams({@ApiImplicitParam(name = "userName",value = "用户名",required = true, paramType = "query",dataType = "String")})
    public Map<String, Object> getUser(@RequestParam(value = "userName") String userName){
        Map<String, Object> hash_rtn = new HashMap<>();

        User user = new User();
        try{
            user = userService.getUserByUserName(userName);
            hash_rtn.put(Commons.JSON_RES, Commons.JSON_OK);
            hash_rtn.put(Commons.JSON_VAL, user);
        }catch (Exception e){
            e.printStackTrace();
            hash_rtn.put(Commons.JSON_RES, Commons.JSON_NO);
            hash_rtn.put(Commons.JSON_ERROR, e.getMessage());
        }
        return hash_rtn;
    }

}
