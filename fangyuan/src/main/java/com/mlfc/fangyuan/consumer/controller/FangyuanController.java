package com.mlfc.fangyuan.consumer.controller;

import com.mlfc.api.apiservice.FangyuanService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mlfc.api.common.Rest;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.*;
import com.mlfc.api.pojo.Property;
import java.util.List;

@RequestMapping("/fangyuan")
@RestController
@Slf4j
public class FangyuanController {

    @DubboReference
    private FangyuanService fangyuanService;

    @GetMapping("/{id}")
    public Rest<Property> QueryFYById(@RequestBody Long id) {
        log.info("查询房源:{}", id);
        Property property = fangyuanService.getById(id);
        // 检查结果是否为空，如果为空则返回404
        if (property == null) {
            return Rest.error("啥都没有");
        }

        // 如果找到了资源，返回200状态码和资源
        return Rest.success(property);
    }

    @GetMapping("/all")
    public List<Property> QueryFY() {
        return fangyuanService.list();
    }


    @DeleteMapping
    public Rest<String> deleteByIds(@RequestBody List<Integer> ids) {
        log.info("批量删除房源:{}", ids);
        fangyuanService.removeByIds(ids);
        // 如果找到了资源，返回200状态码和资源
        return Rest.success("删除成功");
    }


    @PostMapping("/add")
    public Rest<String> addHouseResource(@RequestBody Property property) {
        try {
            boolean saved = fangyuanService.save(property);
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

    @GetMapping("/list")
    public Rest<Page<Property>> list(
            @RequestParam(value = "pageNo", defaultValue = "1") int pageNo,
            @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {

        // 创建分页对象，MyBatis-Plus中分页的页码是从1开始的
        Page<Property> page = new Page<>(pageNo, pageSize);

        QueryWrapper<Property> wrapper = new QueryWrapper<>();

        wrapper.select("title", "rent", "rent_method", "use_area", "decoration", "facilities", "pic");
        // 调用服务层方法，进行分页查询
        Page<Property> resultPage = fangyuanService.selectPage(page, wrapper);

        // 返回包含分页数据的响应
        return Rest.success(resultPage);
    }


    @GetMapping("/test")
    public String test() {
        return "test";
    }
}



