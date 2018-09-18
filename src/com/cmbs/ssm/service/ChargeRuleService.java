package com.cmbs.ssm.service;

import com.cmbs.ssm.pojo.ChargeRule;

/**
 * @author: zwc
 * @date: 2018/9/11 11:52
 * @description:
 */
public interface ChargeRuleService {
    boolean addOrUpdateChargeRule(String business,String[] costItems);
    Double getFuncFeeById(String funcId);

}
