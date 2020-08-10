package com.imut.entities;

import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/4/28 12:02
 */
public class UserLog {
    private Integer id;
    private Integer logUserId;
    private Timestamp logUserDate;
    private String logUserDescribe;
    private Customer customer;
    private  String logUserTelephone;

    public String getLogUserTelephone() {
        return logUserTelephone;
    }

    public void setLogUserTelephone(String logUserTelephone) {
        this.logUserTelephone = logUserTelephone;
    }

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

    public Integer getLogUserId() {
        return logUserId;
    }

    public void setLogUserId(Integer logUserId) {
        this.logUserId = logUserId;
    }

    public Timestamp getLogUserDate() {
        return logUserDate;
    }

    public void setLogUserDate(Timestamp logUserDate) {
        this.logUserDate = logUserDate;
    }

    public String getLogUserDescribe() {
        return logUserDescribe;
    }

    public void setLogUserDescribe(String logUserDescribe) {
        this.logUserDescribe = logUserDescribe;
    }

    @Override
    public String toString() {
        return "UserLog{" +
                "id=" + id +
                ", logUserId=" + logUserId +
                ", logUserDate=" + logUserDate +
                ", logUserDescribe='" + logUserDescribe + '\'' +
                ", customer=" + customer +
                ", logUserTelephone='" + logUserTelephone + '\'' +
                '}';
    }
}
