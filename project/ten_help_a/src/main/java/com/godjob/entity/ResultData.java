package com.godjob.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

/**
 * @author nmtl_ygw
 * @Description  获取返回时的数据  贫困用户点击前模块
 * @date 2020/6/17 16:16
 */

@Component
@PropertySource("classpath:application")
public class ResultData {
    //贫困简述页面
    private byte[] userPhoto; //用户头像
    private String userHelpAppleLog; //用户贫困说明
    @Value("${user.dafultMoney}")
    private Integer userNeedMoney; //需要筹钱数
    private String  basePhoto;
    private String helperId;
    private String userId;
    private Timestamp date;

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
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

    public String getBasePhoto() {
        return basePhoto;
    }

    public void setBasePhoto(String basePhoto) {
        this.basePhoto = basePhoto;
    }

    public byte[] getUserPhoto() {
        return userPhoto;
    }

    public void setUserPhoto(byte[] userPhoto) {

        this.userPhoto = userPhoto;
    }

    public String getUserHelpAppleLog() {
        return userHelpAppleLog;
    }

    public void setUserHelpAppleLog(String userHelpAppleLog) {
        this.userHelpAppleLog = userHelpAppleLog;
    }

    public Integer getUserNeedMoney() {
        return userNeedMoney;
    }

    public void setUserNeedMoney(Integer userNeedMoney) {
        this.userNeedMoney = userNeedMoney;
    }

}
