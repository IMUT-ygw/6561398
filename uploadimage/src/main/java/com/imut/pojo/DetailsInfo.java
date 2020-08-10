package com.imut.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Arrays;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/5/19 10:19
 */

public class DetailsInfo {
    private Integer id;
    @JsonInclude(JsonInclude.Include.NON_NULL )
    private String dtUserTelephone;
    private String dtUserAddress;
    private String dtUserIllness;
    private byte[] dtUserImage01;
    private byte[] dtUserImage02;
    private byte[] dtUserImage03;
    private byte[] dtUserImage04;
    private byte[] dtUserImage05;

    public DetailsInfo(String dtUserTelephone, String dtUserAddress,
                       String dtUserIllness, byte[] dtUserImage01,
                       byte[] dtUserImage02, byte[] dtUserImage03,
                       byte[] dtUserImage04, byte[] dtUserImage05) {
        this.dtUserTelephone = dtUserTelephone;
        this.dtUserAddress = dtUserAddress;
        this.dtUserIllness = dtUserIllness;
        this.dtUserImage01 = dtUserImage01;
        this.dtUserImage02 = dtUserImage02;
        this.dtUserImage03 = dtUserImage03;
        this.dtUserImage04 = dtUserImage04;
        this.dtUserImage05 = dtUserImage05;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDtUserTelephone() {
        return dtUserTelephone;
    }

    public void setDtUserTelephone(String dtUserTelephone) {
        this.dtUserTelephone = dtUserTelephone;
    }

    public String getDtUserAddress() {
        return dtUserAddress;
    }

    public void setDtUserAddress(String dtUserAddress) {
        this.dtUserAddress = dtUserAddress;
    }

    public String getDtUserIllness() {
        return dtUserIllness;
    }

    public void setDtUserIllness(String dtUserIllness) {
        this.dtUserIllness = dtUserIllness;
    }

    public byte[] getDtUserImage01() {
        return dtUserImage01;
    }

    public void setDtUserImage01(byte[] dtUserImage01) {
        this.dtUserImage01 = dtUserImage01;
    }

    public byte[] getDtUserImage02() {
        return dtUserImage02;
    }

    public void setDtUserImage02(byte[] dtUserImage02) {
        this.dtUserImage02 = dtUserImage02;
    }

    public byte[] getDtUserImage03() {
        return dtUserImage03;
    }

    public void setDtUserImage03(byte[] dtUserImage03) {
        this.dtUserImage03 = dtUserImage03;
    }

    public byte[] getDtUserImage04() {
        return dtUserImage04;
    }

    public void setDtUserImage04(byte[] dtUserImage04) {
        this.dtUserImage04 = dtUserImage04;
    }

    public byte[] getDtUserImage05() {
        return dtUserImage05;
    }

    public void setDtUserImage05(byte[] dtUserImage05) {
        this.dtUserImage05 = dtUserImage05;
    }

    @Override
    public String toString() {
        return "DetailsInfo{" +
                "id=" + id +
                ", dtUserTelephone='" + dtUserTelephone + '\'' +
                ", dtUserAddress='" + dtUserAddress + '\'' +
                ", dtUserIllness='" + dtUserIllness + '\'' +
                ", dtUserImage01=" + Arrays.toString(dtUserImage01) +
                ", dtUserImage02=" + Arrays.toString(dtUserImage02) +
                ", dtUserImage03=" + Arrays.toString(dtUserImage03) +
                ", dtUserImage04=" + Arrays.toString(dtUserImage04) +
                ", dtUserImage05=" + Arrays.toString(dtUserImage05) +
                '}';
    }
}
