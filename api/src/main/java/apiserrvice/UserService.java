package apiserrvice;

import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;
import pojo.User;


public interface UserService extends IService<User> {

    String selectId(@Param("username") String username, @Param("password") String password);
}
