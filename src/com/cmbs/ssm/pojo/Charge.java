package com.cmbs.ssm.pojo;

/**
 * @author: zwc
 * @date: 2018/9/10 23:37
 * @description:
 */
public class Charge {
    private String chargeCode;
    private String chargeName;
    private double charge;

    public String getChargeCode() {
        return chargeCode;
    }

    public void setChargeCode(String chargeCode) {
        this.chargeCode = chargeCode;
    }

    public String getChargeName() {
        return chargeName;
    }

    public void setChargeName(String chargeName) {
        this.chargeName = chargeName;
    }

    public double getCharge() {
        return charge;
    }

    public void setCharge(double charge) {
        this.charge = charge;
    }
}
