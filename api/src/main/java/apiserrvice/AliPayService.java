package apiserrvice;

import com.alipay.api.AlipayApiException;
import pojo.Orders;

public interface AliPayService {
    String aliPay(Orders orders) throws AlipayApiException;
}
