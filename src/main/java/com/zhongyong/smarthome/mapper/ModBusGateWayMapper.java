package com.zhongyong.smarthome.mapper;

import com.zhongyong.smarthome.base.BaseMapper;
import com.zhongyong.smarthome.model.ModBusGateWay;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ModBusGateWayMapper extends BaseMapper<ModBusGateWay> {
    List<ModBusGateWay> selectById(@Param("userId") String userId, @Param("sceneId") String sceneId);
}
