package pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserDataObject implements Serializable {
    private Long userId;                   // 用户ID
    private String userName;               // 用户名
    private String password;               // 密码
    private String realName;               // 真实姓名
    private Integer age;                   // 年龄
    private String gender;                // 性别，1-男性，2-女性
    private String phoneNamber;            // 电话号码
    private String idNumber;               // 身份证号
    private String emailAddress;           // 邮件地址
    private String ipAddress;              // 物理地址
    private String nextPassword;           //二次确认密码
}
