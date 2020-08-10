package com.imut.pojo;

import java.io.Serializable;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/6/22 15:55
 */
public class User implements Serializable {
    private Integer userId;
    private String userName;
    private Integer userAge;


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userAge=" + userAge +
                '}';
    }
}
