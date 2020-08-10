package com.godjob.entity;

import java.sql.Timestamp;

/**
 * @author nmtl_ygw
 * @Description  捐款记录
 * @date 2020/6/8 16:45
 */
public class DonationInfo {
    private String donationId;
    private String userId;
    private Integer donationMoney;
    private long donationOrder;
    private Timestamp donationDate;

    public String getDonationId() {
        return donationId;
    }

    public void setDonationId(String donationId) {
        this.donationId = donationId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getDonationMoney() {
        return donationMoney;
    }

    public void setDonationMoney(Integer donationMoney) {
        this.donationMoney = donationMoney;
    }

    public long getDonationOrder() {
        return donationOrder;
    }

    public void setDonationOrder(long donationOrder) {
        this.donationOrder = donationOrder;
    }

    public Timestamp getDonationDate() {
        return donationDate;
    }

    public void setDonationDate(Timestamp donationDate) {
        this.donationDate = donationDate;
    }

    @Override
    public String toString() {
        return "DonationInfo{" +
                "donationId=" + donationId +
                ", userId=" + userId +
                ", donationMoney=" + donationMoney +
                ", donationOrder=" + donationOrder +
                ", donationDate=" + donationDate +
                '}';
    }
}
