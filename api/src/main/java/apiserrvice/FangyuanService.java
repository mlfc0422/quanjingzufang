package apiserrvice;

import com.baomidou.mybatisplus.extension.service.IService;
import pojo.HouseResources;

public interface FangyuanService  extends IService<HouseResources> {
    boolean isRentable(long houseResourcesId);
}
