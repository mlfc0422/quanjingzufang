package apiserrvice;

import com.baomidou.mybatisplus.extension.service.IService;
import pojo.HouseResources;

import java.time.LocalDateTime;
import java.util.List;

public interface FangyuanService  extends IService<HouseResources> {

    void deleteByIds(List<Integer> ids);
}
