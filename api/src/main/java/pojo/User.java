package pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
    private Long id;                        // 用户ID
    private String account;                 //账号
    private String userName;               // 用户名
    private String password;               // 密码
    private String realName;               // 真实姓名
    private Integer age;                   // 年龄
    private String gender;                // 性别，1-男性，2-女性
    private String phoneNamber;            // 电话号码
    private String idNumber;               // 身份证号
    private String emailAddress;           // 邮件地址
    private String address;              // 物理地址
    private String token;                   // 令牌

}
