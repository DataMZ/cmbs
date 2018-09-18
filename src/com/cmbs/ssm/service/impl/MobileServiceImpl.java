package com.cmbs.ssm.service.impl;

import com.cmbs.ssm.mapper.MobileMapper;
import com.cmbs.ssm.pojo.Mobile;
import com.cmbs.ssm.service.MobileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: zwc
 * @date: 2018/9/9 16:46
 * @description:
 */
@Service
public class MobileServiceImpl implements MobileService {
    @Autowired
    private MobileMapper mobileMapper;

    @Override
    public List<Mobile> queryByIsAviable() {
        return mobileMapper.queryByIsAviable();
    }

    @Override
    public boolean addMobiles(String startTel, String endTel, String mobileType) {
        System.out.println(startTel);
        long start = Long.parseLong(startTel);
        long end = Long.parseLong(endTel);
        Mobile mobile = new Mobile();
        boolean isAllAdd = true;
        for (Long i = start; i <= end ; i++) {
            mobile.setMobileNumber(String.valueOf(i));
            mobile.setIsAvailable("Y");
            mobile.setCardNumber("");
            mobile.setMobileType(mobileType);
            try {
                mobileMapper.addMobile(mobile);
            }catch (DataAccessException e) {
                isAllAdd = false;
            }
        }
        return isAllAdd;
    }

    @Override
    public boolean updateMobileNotAvai(Mobile mobile) {
        boolean isUpdate = false;
        int rows = mobileMapper.updateMobileNotAvai(mobile);
        System.out.println(rows);
        if(rows == 1) {
            isUpdate = true;
        }
        return isUpdate;
    }

    @Override
    public boolean isPhoneNum(String phone) {
        boolean isPhoneNum = false;
        String phoneNumReg = "^1[34578]\\d{9}$";
        if(phone.matches(phoneNumReg)) {
            isPhoneNum = true;
        }
        return isPhoneNum;
    }
}
