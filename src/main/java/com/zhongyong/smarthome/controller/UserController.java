package com.zhongyong.smarthome.controller;

import com.zhongyong.smarthome.base.HttpResult;
import com.zhongyong.smarthome.model.User;
import com.zhongyong.smarthome.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("user")
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/getAllUser")
    public List<User> getAllUser() {
        return userService.getAllUser();
    }

    @PostMapping("/register")
    public HttpResult<User> register(@RequestBody User user) {
        int result = userService.register(user);
        if (result > 0) {
            return new HttpResult<>(200, "注册成功", user);
        } else if (result == -1) {
            return new HttpResult<>(400, "该用户已注册", null);
        } else {
            return new HttpResult<>(500, "服务器正忙", null);
        }
    }

    @PostMapping("/login")
    public HttpResult<User> login(@RequestBody User user) {
        User user2 = userService.login(user);
        if (user2 == null) {
            return new HttpResult<>(400, "登录失败，账号或密码错误", null);
        } else {
            return new HttpResult<>(200, "登录成功", user2);
        }

    }

}
