package com.mlfc.fangyuan.consumer.controller;

import apiserrvice.FangyuanService;
import common.Rest;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.*;
import pojo.HouseResources;

import java.util.Collections;
import java.util.List;

@RequestMapping("fangyuan")
@RestController
@Slf4j
public class FangyuanController {

    @DubboReference
    private FangyuanService fangyuanService;


    @DeleteMapping("/{id}")
    public Rest<HouseResources> QueryFYById(@RequestBody Long id) {
        HouseResources houseResources = fangyuanService.getById(id);
        // 检查结果是否为空，如果为空则返回404
        if (houseResources == null) {
            return Rest.error("无无无");
        }

        // 如果找到了资源，返回200状态码和资源
        return Rest.success(houseResources);
    }

    @GetMapping("/all")
    public List<HouseResources> QueryFY() {
        return fangyuanService.list();
    }

    @PostMapping("/delete/{id}")
    public Rest<String> deleteByIds(@RequestBody Long params) {

        fangyuanService.removeByIds(Collections.singleton(params.longValue()));

        // 如果找到了资源，返回200状态码和资源
        return Rest.success("删除成功");
    }


    @PostMapping("/add")
    public Rest<String> addHouseResource(@RequestBody HouseResources houseResources) {
        try {
            boolean saved = fangyuanService.save(houseResources);
            if (saved) {
                return Rest.success("房源信息添加成功。");
            } else {
                return Rest.error("房源信息添加失败。");
            }
        } catch (Exception e) {
            // 记录异常日志
            return Rest.error("服务器错误，房源信息添加失败。");
        }
    }
}

