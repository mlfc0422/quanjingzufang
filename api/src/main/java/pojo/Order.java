package pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order implements Serializable {
    private long id;
    private long userId;
    private long HouseResourcesId;
    private LocalDate startTime;
    private LocalDate endTime;
    private BigDecimal totalPrice;
    private String status;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

}
