package com.imut.entities;

import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/5/7 9:33
 */
public class YjqOperationLog {
    private Integer id;
    @DateTimeFormat(pattern = "yyyy-mm-dd HH:MM:ss")
    private Timestamp yjqDate;
    private String yjqDescribe;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Timestamp getYjqDate() {
        return yjqDate;
    }

    public void setYjqDate(Timestamp yjqDate) {
        this.yjqDate = yjqDate;
    }

    public String getYjqDescribe() {
        return yjqDescribe;
    }

    public void setYjqDescribe(String yjqDescribe) {
        this.yjqDescribe = yjqDescribe;
    }

    @Override
    public String toString() {
        return "YjqOperationLog{" +
                "id=" + id +
                ", yjqDate=" + yjqDate +
                ", yjqDescribe='" + yjqDescribe + '\'' +
                '}';
    }
}
