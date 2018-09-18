package com.cmbs.ssm.service;

import com.cmbs.ssm.pojo.Customer;

/**
 * @author: zwc
 * @date: 2018/9/8 14:51
 * @description:
 */
public interface CustomerService {
    Customer queryByIdTypeAndNum(Customer customer); //查询customer
    boolean idCardCodeVerify(String cardcode);//身份证校验
    boolean officerCardCodeVerify(String cardcode); // 军官证校验
    boolean passportCardCodeVerify(String cardcode); // 护照校验
    Customer setDateFormat(Customer customer); //增加日期格式化
    Customer setIdCardName(Customer customer); //增加id类型别名
    boolean addCustomer(Customer customer); //增加数据
    boolean updateByIdTypeAndNum(Customer customer); //修改数据

}
