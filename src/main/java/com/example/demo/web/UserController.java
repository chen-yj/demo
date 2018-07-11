package com.example.demo.web;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @ApiOperation(value = "用户查询", notes = "根据名称查询用户") //Swagger2配置
    @GetMapping("/{username}")
    public User getUser(@PathVariable("username") String username) {
        return userService.findUserByName(username);
    }

    @ApiIgnore //使用该注解忽略这个API //Swagger2配置
    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    public String jsonTest() {
        return " hi you!";
    }
}
