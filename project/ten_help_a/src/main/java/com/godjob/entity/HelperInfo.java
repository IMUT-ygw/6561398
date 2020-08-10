package com.godjob.entity;

/**
 * @author nmtl_ygw
 * @Description 贫困用户
 * @date 2020/6/8 16:28
 */
public class HelperInfo {
    private String helperId;
    private String userId;
    private String  helperDetailAddress;
    private String  helperLog;
    private String  status;
    private String imageId;

    public String getHelperId() {
        return helperId;
    }

    public void setHelperId(String helperId) {
        this.helperId = helperId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    @Override
    public String toString() {
        return "HelperInfo{" +
                "helperId=" + helperId +
                ", userId=" + userId +
                ", helperDetailAddress='" + helperDetailAddress + '\'' +
                ", helperLog='" + helperLog + '\'' +
                ", status='" + status + '\'' +
                ", imageId=" + imageId +
                '}';
    }
}
