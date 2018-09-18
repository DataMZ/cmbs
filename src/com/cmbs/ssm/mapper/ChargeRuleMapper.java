package com.cmbs.ssm.mapper;


import com.cmbs.ssm.pojo.ChargeRule;

import java.util.List;

public interface ChargeRuleMapper {
    int addChargeRule(ChargeRule chargeRule);
    ChargeRule queryChargeRule(ChargeRule chargeRule);
    List<ChargeRule> queryByFuncId(String funcId);


}
