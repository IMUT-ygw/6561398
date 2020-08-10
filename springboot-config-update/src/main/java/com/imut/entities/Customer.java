package com.imut.entities;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/4/29 8:43
 */
public class Customer {
    private Integer id;
    private String customerName;
    private String customerTelephone;
    private String customerPassword;
    private Integer customerGender;
    private String customerAddress;

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

    public String getCustomerPassword() {
        return customerPassword;
    }

    public void setCustomerPassword(String customerPassword) {
        this.customerPassword = customerPassword;
    }

    public Integer getCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(Integer customerGender) {
        this.customerGender = customerGender;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", customerName='" + customerName + '\'' +
                ", customerTelephone='" + customerTelephone + '\'' +
                ", customerPassword='" + customerPassword + '\'' +
                ", customerGender=" + customerGender +
                ", customerAddress='" + customerAddress + '\'' +
                '}';
    }
}
