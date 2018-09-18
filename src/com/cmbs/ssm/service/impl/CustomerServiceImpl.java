package com.cmbs.ssm.service.impl;

import com.cmbs.ssm.mapper.CustomerMapper;
import com.cmbs.ssm.pojo.Customer;
import com.cmbs.ssm.service.CustomerService;
import com.cmbs.ssm.utils.BusinessMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Map;

/**
 * @author: zwc
 * @date: 2018/9/8 14:51
 * @description:
 */
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public Customer queryByIdTypeAndNum(Customer customer) {
        return customerMapper.queryByIdTypeAndNum(customer);
    }

    @Override
    public boolean  idCardCodeVerify(String cardcode) {
        //第一代身份证正则表达式(15位)
        String isIDCard1 = "^[1-9]\\d{7}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}$";
        //第二代身份证正则表达式(18位)
        String isIDCard2 ="^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])((\\d{4})|\\d{3}[A-Z])$";

        //验证身份证
        if (cardcode.matches(isIDCard1) || cardcode.matches(isIDCard2)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean officerCardCodeVerify(String cardcode) {
        //军官证7位
        String isIDCard1 = "\\d{7}";
        //校验
        if(cardcode.matches(isIDCard1)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean passportCardCodeVerify(String cardcode) {
        //护照校验7位
        String isIDCard1 = "^1[45][0-9]{7}|G[0-9]{8}|P[0-9]{7}|S[0-9]{7,8}|D[0-9]+$";
        if(cardcode.matches(isIDCard1)) {
            return true;
        }
        return false;
    }


    @Override
    public Customer setDateFormat(Customer customer) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        customer.setCustomerBirthdayFormat(simpleDateFormat.format(customer.getCustomerBirthday()));
        return customer;
    }

    @Override
    public Customer setIdCardName(Customer customer) {
        Map<String,String> cardMap = BusinessMap.getCardMap();
        customer.setIdTypeStr(cardMap.get(customer.getIdType()));
        return customer;
    }

    @Override
    public boolean addCustomer(Customer customer) {
        boolean isAdd = false;
        if(customerMapper.addCustomer(customer)==1) {
            isAdd = true;
        }
        return isAdd;
    }

    @Override
    public boolean updateByIdTypeAndNum(Customer customer) {
        boolean isUpdate = false;
        if(customerMapper.updateByIdTypeAndNum(customer)==1) {
            isUpdate = true;
        }
        return isUpdate;
    }
}
