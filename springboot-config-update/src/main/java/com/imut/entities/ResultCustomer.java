package com.imut.entities;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/5/6 20:52
 */
public class ResultCustomer {
    private Integer id;
    private String customerName;
    private String customerTelephone;
    private String customerAddress;
    private Integer customerServiceCount;
    private Integer customerLogCount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerTelephone() {
        return customerTelephone;
    }

    public void setCustomerTelephone(String customerTelephone) {
        this.customerTelephone = customerTelephone;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public Integer getCustomerServiceCount() {
        return customerServiceCount;
    }

    public void setCustomerServiceCount(Integer customerServiceCount) {
        this.customerServiceCount = customerServiceCount;
    }

    public Integer getCustomerLogCount() {
        return customerLogCount;
    }

    public void setCustomerLogCount(Integer customerLogCount) {
        this.customerLogCount = customerLogCount;
    }

    @Override
    public String toString() {
        return "ResultCustomer{" +
                "id=" + id +
                ", customerName='" + customerName + '\'' +
                ", customerTelephone='" + customerTelephone + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", customerServiceCount=" + customerServiceCount +
                ", customerLogCount=" + customerLogCount +
                '}';
    }
}
