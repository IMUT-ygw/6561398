package com.imut.pojo;

/**
 * @author nmtl_ygw
 * @Description   用户基本信息及登录信息
 * @date 2020/5/19 10:17
 */
public class UserInfo {
    private Integer id;
    private String userName;
    private String userCardId;
    private String userPassword;
    private String userTelephone;
    private Integer userGender;
    private Integer userAge;
    private byte[] userHeader;

    public byte[] getUserHeader() {
        return userHeader;
    }

    public void setUserHeader(byte[] userHeader) {
        this.userHeader = userHeader;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserCardId() {
        return userCardId;
    }

    public void setUserCardId(String userCardId) {
        this.userCardId = userCardId;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserTelephone() {
        return userTelephone;
    }

    public void setUserTelephone(String userTelephone) {
        this.userTelephone = userTelephone;
    }

    public Integer getUserGender() {
        return userGender;
    }

    public void setUserGender(Integer userGender) {
        this.userGender = userGender;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userCardId='" + userCardId + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userTelephone='" + userTelephone + '\'' +
                ", userGender=" + userGender +
                ", userAge=" + userAge +
                '}';
    }
}
