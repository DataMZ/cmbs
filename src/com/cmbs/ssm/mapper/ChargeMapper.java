package com.cmbs.ssm.mapper;

import com.cmbs.ssm.pojo.Charge;

public interface ChargeMapper {
    int addCharge(Charge charge);
    Charge queryChargeByCode(Charge charge);
    int updateCharge(Charge charge);
}
