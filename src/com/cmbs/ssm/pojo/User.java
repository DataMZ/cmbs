package com.cmbs.ssm.pojo;

/**
 * @author: zwc
 * @date: 2018/9/9 15:45
 * @description:
 */
public class User {
    private int userId;
    private String mobileNumber;
    private String roamingStatus;
    private String comLevel;
    private int customerId;
    private int accountId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getRoamingStatus() {
        return roamingStatus;
    }

    public void setRoamingStatus(String roamingStatus) {
        this.roamingStatus = roamingStatus;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getComLevel() {
        return comLevel;
    }

    public void setComLevel(String comLevel) {
        this.comLevel = comLevel;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", roamingStatus='" + roamingStatus + '\'' +
                ", comLevel='" + comLevel + '\'' +
                ", customerId=" + customerId +
                ", accountId=" + accountId +
                '}';
    }
}
