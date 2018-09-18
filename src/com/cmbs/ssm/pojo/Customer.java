package com.cmbs.ssm.pojo;

import java.util.Date;

/**
 * @author: zwc
 * @date: 2018/9/8 14:33
 * @description:
 */
public class Customer {
    private int customerId;
    private String idType;
    private String idNumber;
    private String customerName;
    private Date customerBirthday;
    private String customerSex;
    private String customerAddress;
    // 额外
    private String idTypeStr; //证件类型字符串
    private String customerBirthdayFormat; //格式化成yyyy-MM-dd


    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Date getCustomerBirthday() {
        return customerBirthday;
    }

    public void setCustomerBirthday(Date customerBirthday) {
        this.customerBirthday = customerBirthday;
    }

    public String getCustomerSex() {
        return customerSex;
    }

    public void setCustomerSex(String customerSex) {
        this.customerSex = customerSex;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getIdTypeStr() {
        return idTypeStr;
    }

    public void setIdTypeStr(String idTypeStr) {
        this.idTypeStr = idTypeStr;
    }

    public String getCustomerBirthdayFormat() {
        return customerBirthdayFormat;
    }

    public void setCustomerBirthdayFormat(String customerBirthdayFormat) {
        this.customerBirthdayFormat = customerBirthdayFormat;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", idType='" + idType + '\'' +
                ", idNumber='" + idNumber + '\'' +
                ", customerName='" + customerName + '\'' +
                ", customerBirthday=" + customerBirthday +
                ", customerSex='" + customerSex + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", idTypeStr='" + idTypeStr + '\'' +
                ", customerBirthdayFormat='" + customerBirthdayFormat + '\'' +
                '}';
    }
}
