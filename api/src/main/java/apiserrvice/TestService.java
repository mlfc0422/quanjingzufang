package apiserrvice;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import pojo.Test;
import java.util.List;

public interface TestService extends IService<Test> {
    List<Test> test();
    Page<Test> getUserPage(int pageNum, int pageSize);

}
