package com.godjob.entity;

import java.util.Arrays;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/6/8 16:39
 */
public class HelperImage {
    private String imageId;
    private byte[] image01;
    private byte[] image02;
    private byte[] image03;
    private byte[] image04;
    private byte[] image05;
    //转换后的
    private String imageBase01;
    private String imageBase02;
    private String imageBase03;
    private String imageBase04;
    private String imageBase05;


    public String getImageBase01() {
        return imageBase01;
    }

    public void setImageBase01(String imageBase01) {
        this.imageBase01 = imageBase01;
    }

    public String getImageBase02() {
        return imageBase02;
    }

    public void setImageBase02(String imageBase02) {
        this.imageBase02 = imageBase02;
    }

    public String getImageBase03() {
        return imageBase03;
    }

    public void setImageBase03(String imageBase03) {
        this.imageBase03 = imageBase03;
    }

    public String getImageBase04() {
        return imageBase04;
    }

    public void setImageBase04(String imageBase04) {
        this.imageBase04 = imageBase04;
    }

    public String getImageBase05() {
        return imageBase05;
    }

    public void setImageBase05(String imageBase05) {
        this.imageBase05 = imageBase05;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public byte[] getImage01() {
        return image01;
    }

    public void setImage01(byte[] image01) {
        this.image01 = image01;
    }

    public byte[] getImage02() {
        return image02;
    }

    public void setImage02(byte[] image02) {
        this.image02 = image02;
    }

    public byte[] getImage03() {
        return image03;
    }

    public void setImage03(byte[] image03) {
        this.image03 = image03;
    }

    public byte[] getImage04() {
        return image04;
    }

    public void setImage04(byte[] image04) {
        this.image04 = image04;
    }

    public byte[] getImage05() {
        return image05;
    }

    public void setImage05(byte[] image05) {
        this.image05 = image05;
    }

    @Override
    public String toString() {
        return "HelperImage{" +
                "imageId=" + imageId +
                ", image01=" + image01 +
                ", image02=" + image02 +
                ", image03=" + image03 +
                ", image04=" + image04 +
                ", image05=" + image05 +
                '}';
    }
}
