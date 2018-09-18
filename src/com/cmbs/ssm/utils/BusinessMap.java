package com.cmbs.ssm.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: zwc
 * @date: 2018/9/11 15:25
 * @description:
 */
public class BusinessMap {
    private static Map<String,String> chargeMap = null;
    private static Map<String,String> cardMap = null;
    private static Map<String,String> funcMap = null;

    public static Map<String,String> getChargeMap(){
        if(chargeMap == null) {
            chargeMap = new HashMap<>();
            chargeMap.put("A","开户费");
            chargeMap.put("B","漫游费");
            chargeMap.put("C","押金");
            chargeMap.put("D","入网费");
            chargeMap.put("E","选号费");
        }
        return chargeMap;
    }

    public static Map<String,String> getCardMap() {
        if(cardMap == null) {
            cardMap = new HashMap<>();
            cardMap.put("0","居民身份证");
            cardMap.put("1","军官证");
            cardMap.put("2","护照");
        }
        return cardMap;
    }

    public static Map<String,String> getFuncMap() {
        if(funcMap == null) {
            funcMap = new HashMap<>();
            funcMap.put("0","开户业务");
            funcMap.put("1","变更漫游状态");
        }
        return funcMap;
    }



}
