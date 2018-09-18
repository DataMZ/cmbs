package com.cmbs.ssm.service.impl;

import com.cmbs.ssm.mapper.ChargeMapper;
import com.cmbs.ssm.mapper.ChargeRuleMapper;
import com.cmbs.ssm.pojo.Charge;
import com.cmbs.ssm.pojo.ChargeRule;
import com.cmbs.ssm.service.ChargeRuleService;
import com.cmbs.ssm.utils.BusinessMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: zwc
 * @date: 2018/9/11 12:29
 * @description:
 */
@Service
public class ChargeRuleServiceImp implements ChargeRuleService {
    @Autowired
    private ChargeRuleMapper chargeRuleMapper;
    @Autowired
    private ChargeMapper chargeMapper;

    @Override
    public boolean addOrUpdateChargeRule(String business,String[] costItems) {
        boolean isAdd = false;
        ChargeRule chargeRule = new ChargeRule();
        for(String costItem:costItems) {
            chargeRule.setChargeCode(costItem);
            chargeRule.setFuncId(business);
            chargeRule.setFuncName(BusinessMap.getFuncMap().get(business));
            if(chargeRuleMapper.queryChargeRule(chargeRule)==null) {
                if(chargeRuleMapper.addChargeRule(chargeRule)==1) {
                    isAdd = true;
                }
            }
        }
        return isAdd;
    }

    @Override
    public Double getFuncFeeById(String funcId) {
        List<ChargeRule> chargeRules = chargeRuleMapper.queryByFuncId(funcId);
        Charge charge = new Charge();
        double fee = 0.0;
        for(ChargeRule chargeRule:chargeRules) {
            charge.setChargeCode(chargeRule.getChargeCode());
            Charge chargeTmp = chargeMapper.queryChargeByCode(charge);
            fee += chargeTmp.getCharge();
        }
        return fee;
    }
}
