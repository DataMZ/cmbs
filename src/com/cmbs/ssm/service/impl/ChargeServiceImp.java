package com.cmbs.ssm.service.impl;

import com.cmbs.ssm.mapper.ChargeMapper;
import com.cmbs.ssm.pojo.Charge;
import com.cmbs.ssm.service.ChargeService;
import com.cmbs.ssm.utils.BusinessMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author: zwc
 * @date: 2018/9/10 23:43
 * @description:
 */
@Service
public class ChargeServiceImp  implements ChargeService {
    @Autowired
    private ChargeMapper chargeMapper;

    @Override
    public boolean addOrUpdateCharge(Charge charge) {
        boolean isAddOrUpdate = false;
        if(chargeMapper.queryChargeByCode(charge) != null) {
            if(chargeMapper.updateCharge(charge) == 1) {
                isAddOrUpdate = true;
            }
        }else {
            Map<String,String> chargeMap = BusinessMap.getChargeMap();
            charge.setChargeName(chargeMap.get(charge.getChargeCode()));
            if(chargeMapper.addCharge(charge) == 1) {
                isAddOrUpdate = true;
            }
        }
        return isAddOrUpdate;
    }

    @Override
    public Charge queryChargeByCode(Charge charge) {
        return chargeMapper.queryChargeByCode(charge);
    }
}
