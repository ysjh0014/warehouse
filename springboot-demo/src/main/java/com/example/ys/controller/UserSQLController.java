package com.example.ys.controller;

import com.example.ys.Service.UserService;
import com.example.ys.Model.user;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@Api(description = "MySQL数据库测试连接 流转日志接口")
public class UserSQLController {
    @Autowired
    private UserService userService;

    @ApiOperation(value="查询流转日志列表", notes="查询流转日志列表")
    @GetMapping(value = "getUser")
    public List <user> getUser(){
        List<user> ysUser = userService.getUser();
        return ysUser;
    }

}
