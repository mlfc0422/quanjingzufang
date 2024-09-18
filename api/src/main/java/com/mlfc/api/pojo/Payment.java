package com.mlfc.api.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    private Long id;            // 支付ID
    private Long orderId;        // 订单ID
    private BigDecimal amount;   // 支付金额
    private String paymentMethod; // 支付方式（如支付宝、微信支付等）
    private String paymentStatus; // 支付状态
    private LocalDateTime createdAt; // 支付时间
}
