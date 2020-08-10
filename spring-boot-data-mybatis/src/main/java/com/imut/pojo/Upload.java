package com.imut.pojo;

import java.sql.Timestamp;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/5/16 20:40
 */
public class Upload  {
    private Integer id;
    private byte[] image;
    private Timestamp date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }
}
