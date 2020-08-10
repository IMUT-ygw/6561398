package com.godjob.entity;

import java.sql.Timestamp;

/**
 * @author nmtl_ygw
 * @Description  足迹
 * @date 2020/6/19 10:00
 */
public class FootPrint {
    private Integer id;
    private String userId;
    private String helperId;
    private Timestamp date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getHelperId() {
        return helperId;
    }

    public void setHelperId(String helperId) {
        this.helperId = helperId;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }
}
