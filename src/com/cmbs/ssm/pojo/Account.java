package com.cmbs.ssm.pojo;

/**
 * @author: zwc
 * @date: 2018/9/5 22:57
 * @description:
 */
public class Account {
    private int accountId;
    private String contactPerson;
    private String contactAddress;
    private Double contactBalance;

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getContactAddress() {
        return contactAddress;
    }

    public void setContactAddress(String contactAddress) {
        this.contactAddress = contactAddress;
    }

    public Double getContactBalance() {
        return contactBalance;
    }

    public void setContactBalance(Double contactBalance) {
        this.contactBalance = contactBalance;
    }
}
