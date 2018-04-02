package com.zhongyong.smarthome.controller;

import com.zhongyong.smarthome.base.HttpResult;
import com.zhongyong.smarthome.model.ModBusGateWay;
import com.zhongyong.smarthome.service.ModBusGateWayService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("modBusGateWay")
@RestController
public class ModBusGateWayController {
    @Autowired
    private ModBusGateWayService mModBusGateWayService;

    //添加
    @PostMapping("/addModBus")
    public HttpResult<Void> addModBus(@RequestBody ModBusGateWay model) {
        if (mModBusGateWayService.add(model) > 0) {
            return new HttpResult<>(200, "操作成功", null);
        } else {
            return new HttpResult<>(500, "操作失败", null);
        }

    }

    //删除
    @PostMapping("/deleteModBus")
    public HttpResult<Integer> deleteModBus(int id) {
        if (mModBusGateWayService.delete(id) > 0) {
            return new HttpResult<>(200, "操作成功", null);
        } else {
            return new HttpResult<>(500, "操作失败", null);
        }

    }

    //查询
    @PostMapping("/getModBusList")
    public HttpResult<List<ModBusGateWay>> getModBusList(@RequestBody ModBusGateWay model) {
        List<ModBusGateWay> list = mModBusGateWayService.getAll(model);
        if (null != list && list.size() > 0) {
            return new HttpResult<>(200, "操作成功", list);
        } else {
            return new HttpResult<>(400, "没有查询到相关结果", null);
        }
    }
}
