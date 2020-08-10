package com.godjob.entity;

/**
 * @author nmtl_ygw
 * @Description  用户收藏
 * @date 2020/6/8 16:44
 */
public class UserCollect {
    private Integer id;
    private String userId;
    private String helperId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getHelperId() {
        return helperId;
    }

    public void setHelperId(String helperId) {
        this.helperId = helperId;
    }

    @Override
    public String toString() {
        return "UserCollect{" +
                "id=" + id +
                ", userId=" + userId +
                ", helperId=" + helperId +
                '}';
    }
}
