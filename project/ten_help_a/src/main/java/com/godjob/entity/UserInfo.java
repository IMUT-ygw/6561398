package com.godjob.entity;

import java.sql.Timestamp;
import java.util.Arrays;

/**
 * @author nmtl_ygw
 * @Description  用户信息实体类
 * @date 2020/6/8 16:16
 */
public class UserInfo {
    private String userId;
    private String userName;
    private String userWxName;
    private Integer userGender;
    private String userHeader;
    private Timestamp userFirstDate;
    private String userAddress;
    private String userCardId;
    private Integer userAge;
    private byte[] userPhoto;
    private String city;
    private String province;
    private String country;
    //转换后的照片格式
    private String basePhoto;

    public String getBasePhoto() {
        return basePhoto;
    }

    public void setBasePhoto(String basePhoto) {
        this.basePhoto = basePhoto;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserWxName() {
        return userWxName;
    }

    public void setUserWxName(String userWxName) {
        this.userWxName = userWxName;
    }

    public Integer getUserGender() {
        return userGender;
    }

    public void setUserGender(Integer userGender) {
        this.userGender = userGender;
    }


    public Timestamp getUserFirstDate() {
        return userFirstDate;
    }

    public void setUserFirstDate(Timestamp userFirstDate) {
        this.userFirstDate = userFirstDate;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserCardId() {
        return userCardId;
    }

    public void setUserCardId(String userCardId) {
        this.userCardId = userCardId;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    public String getUserHeader() {
        return userHeader;
    }

    public void setUserHeader(String userHeader) {
        this.userHeader = userHeader;
    }

    public byte[] getUserPhoto() {
        return userPhoto;
    }

    public void setUserPhoto(byte[] userPhoto) {
        this.userPhoto = userPhoto;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", userWxName='" + userWxName + '\'' +
                ", userGender=" + userGender +
                ", userHeader='" + userHeader + '\'' +
                ", userFirstDate=" + userFirstDate +
                ", userAddress='" + userAddress + '\'' +
                ", userCardId='" + userCardId + '\'' +
                ", userAge=" + userAge +
                ", userPhoto=" + Arrays.toString(userPhoto) +
                ", city='" + city + '\'' +
                ", province='" + province + '\'' +
                ", country='" + country + '\'' +
                ", basePhoto='" + basePhoto + '\'' +
                '}';
    }
}
