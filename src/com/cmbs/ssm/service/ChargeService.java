package com.cmbs.ssm.service;

import com.cmbs.ssm.pojo.Charge;

public interface ChargeService {
    boolean addOrUpdateCharge(Charge charge);
    Charge queryChargeByCode(Charge charge);
}
