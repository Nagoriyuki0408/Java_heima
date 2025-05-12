package com.shiokou.HM.bean;

public class User {
    private String username; // 用户名
    private String password; // 密码
    private String email;    // 邮箱
    private String phone;    // 电话号码
    private String role;     // 角色 (例如：管理员、普通用户)

    // 构造方法
    public User(String s1,String s2) {
        // 默认构造方法
        this.setUsername(s1);
        this.setPassword(s2);
    }

    public User(String username, String password, String email, String phone, String role) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.role = role;
    }

    // Getter 和 Setter 方法
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    // toString 方法 (可选，用于调试)
    @Override
    public String toString() {
        return "user{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}