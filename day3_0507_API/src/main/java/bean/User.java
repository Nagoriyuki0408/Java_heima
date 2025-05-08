package bean;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

//用户信息包含用户名，密码，登录名
public class User {
    @Data
    @NoArgsConstructor
    @AlllArgsConstructor

    private String username;
    private String password;
    private String loginName;
}
