package apiservice;

import com.alipay.api.AlipayApiException;
import com.baomidou.mybatisplus.extension.service.IService;
import pojo.Order;
import pojo.Orders;

public interface OrderService extends IService<Order> {
    boolean createOrder(Order order);

    String aliPay(Orders orders) throws AlipayApiException;

    void aliReturn(Orders orders);
}
