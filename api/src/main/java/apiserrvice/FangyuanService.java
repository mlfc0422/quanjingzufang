package apiserrvice;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import pojo.HouseResources;

import java.util.List;

public interface FangyuanService extends IService<HouseResources> {

    boolean isRentable(long houseResourcesId);

    Page<HouseResources> selectPage(Page<HouseResources> page, QueryWrapper<HouseResources> wrapper);
}
