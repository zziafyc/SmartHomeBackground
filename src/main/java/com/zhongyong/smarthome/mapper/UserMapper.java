package com.zhongyong.smarthome.mapper;

import com.zhongyong.smarthome.base.BaseMapper;
import com.zhongyong.smarthome.model.User;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface UserMapper extends BaseMapper<User> {
    User selectByNameAndPass(@Param("userName") String userName, @Param("password") String password);

}
