package com.imut.pojo;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/5/21 16:48
 */
public class LoginAttribute {
    private String telephone;
    private String password;
    private String adminId;
    private String adminPassword;


    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginAttribute{" +
                "telephone='" + telephone + '\'' +
                ", password='" + password + '\'' +
                ", adminId='" + adminId + '\'' +
                ", adminPassword='" + adminPassword + '\'' +
                '}';
    }
}
