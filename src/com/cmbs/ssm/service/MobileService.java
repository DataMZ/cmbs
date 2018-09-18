package com.cmbs.ssm.service;

import com.cmbs.ssm.pojo.Mobile;

import java.util.List;

public interface MobileService {
    List<Mobile> queryByIsAviable();
    boolean addMobiles(String startTel,String endTel,String mobileType);
    boolean updateMobileNotAvai(Mobile mobile);
    boolean isPhoneNum(String phone);
}
