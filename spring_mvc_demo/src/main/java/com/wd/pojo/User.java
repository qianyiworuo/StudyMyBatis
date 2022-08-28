package com.wd.pojo;

public class User {
    private Integer uId;
    private String username;
    private String password;

    public User() {
    }

    public User(Integer uId, String username, String password) {
        this.uId = uId;
        this.username = username;
        this.password = password;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
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

    @Override
    public String toString() {
        return "User{" +
                "uId=" + uId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
