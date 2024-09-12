package pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class HouseResources implements Serializable {

    private Long id;                   // 房源ID
    private String title;              // 房源标题
    private Long estateId;             // 楼盘ID
    private String buildingNum;        // 楼号（栋）
    private String buildingUnit;       // 单元号
    private String buildingFloorNum;   // 门牌号
    private Integer rent;              // 租金
    private Boolean rentMethod;        // 租赁方式，0-整租，1-合租
    private Integer paymentMethod;      // 支付方式，1-付一押一，2-付三押一，3-付六押一，4-年付押一，5-其它
    private String houseType;          // 户型，如：2室 1厅 1卫
    private String coveredArea;        // 建筑面积
    private String useArea;            // 使用面积
    private String floor;              // 楼层，如：8/26
    private String orientation;         // 朝向：东、南、西、北
    private Integer decoration;        // 装修，1-精装，2-简装，3-毛坯
    private String facilities;          // 配套设施， 如：1,2,3
    private String pic;                // 图片，最多5张
    private String houseDesc;          // 描述
    private String contact;             // 联系人
    private String mobile;             // 手机号
    private Integer time;              // 看房时间，1-上午，2-中午，3-下午，4-晚上，5-全天
    private String propertyCost;       // 物业费
    private Date created;              // 创建时间
    private Date updated;               // 更新时间
    private Boolean statusCode;             // 状态，1-已租，0-未租

}
