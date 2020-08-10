package com.godjob.entity;

import java.sql.Timestamp;

/**
 * @author nmtl_ygw
 * @Description  管理员审核信息
 * @date 2020/6/19 18:04
 */
public class AdminAuditInfo {
    private UserInfo userInfo;
    private HelperImage helperImage;
    private String  helperDetailAddress;
    private String  helperLog;
    private String  status;

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public HelperImage getHelperImage() {
        return helperImage;
    }

    public void setHelperImage(HelperImage helperImage) {
        this.helperImage = helperImage;
    }

    public String getHelperDetailAddress() {
        return helperDetailAddress;
    }

    public void setHelperDetailAddress(String helperDetailAddress) {
        this.helperDetailAddress = helperDetailAddress;
    }

    public String getHelperLog() {
        return helperLog;
    }

    public void setHelperLog(String helperLog) {
        this.helperLog = helperLog;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
