package com.zhongyong.smarthome.service;

import com.zhongyong.smarthome.mapper.ModBusGateWayMapper;
import com.zhongyong.smarthome.model.ModBusGateWay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModBusGateWayService {
    @Autowired
    private ModBusGateWayMapper mModBusGateWayMapper;

    //添加
    public int add(ModBusGateWay model) {
        return mModBusGateWayMapper.insert(model);
    }

    //删除
    public int delete(int id) {
        return mModBusGateWayMapper.deleteByPrimaryKey(id);
    }

    //查询
    public List<ModBusGateWay> getAll(ModBusGateWay model) {
        return mModBusGateWayMapper.selectById(model.getUserId(), model.getSceneId());
    }

}
