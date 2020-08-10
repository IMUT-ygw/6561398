package com.godjob.entity;

/**
 * @author nmtl_ygw
 * @Description  普通用户表
 * @date 2020/6/8 16:42
 */
public class NormalInfo {
    private String normalId;
    private String userId;

    public NormalInfo(String normalId, String userId) {
        this.normalId = normalId;
        this.userId = userId;
    }

    public String getNormalId() {
        return normalId;
    }

    public void setNormalId(String normalId) {
        this.normalId = normalId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "NormalInfo{" +
                "normalId=" + normalId +
                ", userId=" + userId +
                '}';
    }
}
