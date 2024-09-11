package pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order implements Serializable {
    private long id;
    private long HouseResourcesId;
    private long userId;
    private byte statusCode;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

}
