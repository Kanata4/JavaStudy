package com.geekaca.web.pojo;

public class User {
    private Integer id;
    private String username;
    private String password;
    private Integer userType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", userType=" + userType +
                '}';
    }
}
