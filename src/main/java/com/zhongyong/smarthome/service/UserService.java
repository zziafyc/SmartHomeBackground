package com.zhongyong.smarthome.service;

import com.zhongyong.smarthome.mapper.UserMapper;
import com.zhongyong.smarthome.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public List<User> getAllUser() {
        return userMapper.selectAll();
    }

    //注册
    public int register(User user) {
        User exist = userMapper.selectOne(user);
        if (exist != null) {
            return -1;
        }
        String userId = UUID.randomUUID().toString();
        user.setUserId(userId);
        return userMapper.insert(user);
    }

    //登录，根据账号进行密码登录
    public User login(User user) {
        String telephone = user.getTelephone();
        String qq = user.getQq();
        String weChat = user.getWeChat();
        String password = user.getPassword();
        String userName = user.getUserName();
        if (null != telephone) {
            user = userMapper.selectOne(new User(user.getTelephone()));
            if (user == null) {
                return null;
            } else {
                if (user.getPassword().equals(password)) {
                    return user;
                }
            }
        } else if (null != qq) {
            user = userMapper.selectOne(new User(user.getQq()));
            if (user != null) {
                return user;
            }
        } else if (null != weChat) {
            user = userMapper.selectOne(new User(user.getWeChat()));
            if (user != null) {
                return user;
            }
        } else if (null != userName && null != password) {
            user = userMapper.selectByNameAndPass(userName, password);
            if (user != null) {
                return user;
            } else {
                //如果没有查找到，则需要重新注册一下
                user = new User();
                user.setUserName(userName);
                user.setPassword(password);
                String userId = UUID.randomUUID().toString();
                user.setUserId(userId);
                if (userMapper.insert(user) > 0) {
                    return user;
                }
            }
        }
        return null;
    }

    //登录专门对接绿能平台
    public User loginToNiagara(User user) {

        return null;

    }

}
