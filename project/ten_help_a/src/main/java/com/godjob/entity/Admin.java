package com.godjob.entity;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/6/9 11:34
 */
public class Admin {

    private Integer adminId;
    private String openId;
    private String adminWxName;

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getAdminWxName() {
        return adminWxName;
    }

    public void setAdminWxName(String adminWxName) {
        this.adminWxName = adminWxName;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminId=" + adminId +
                ", openId='" + openId + '\'' +
                ", adminWxName='" + adminWxName + '\'' +
                '}';
    }
}
