package com.imut.entities;


import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/4/28 12:01
 */
public class User {
    private Integer id ;
    private String userTelephone;
    private Timestamp userDate;
    private String userService;
    private String userDescribe;
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    public String getUserTelephone() {
        return userTelephone;
    }

    public void setUserTelephone(String userTelephone) {
        this.userTelephone = userTelephone;
    }

    public Timestamp getUserDate() {
        return userDate;
    }

    public void setUserDate(Timestamp userDate) {
        this.userDate = userDate;
    }

    public String getUserService() {
        return userService;
    }

    public void setUserService(String userService) {
        this.userService = userService;
    }

    public String getUserDescribe() {
        return userDescribe;
    }

    public void setUserDescribe(String userDescribe) {
        this.userDescribe = userDescribe;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userTelephone='" + userTelephone + '\'' +
                ", userDate=" + userDate +
                ", userService='" + userService + '\'' +
                ", userDescribe='" + userDescribe + '\'' +
                ", customer=" + customer +
                '}';
    }
}
