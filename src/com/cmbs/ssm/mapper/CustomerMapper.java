package com.cmbs.ssm.mapper;

import com.cmbs.ssm.pojo.Customer;

public interface CustomerMapper {
    Customer queryByIdTypeAndNum(Customer customer);
    int addCustomer(Customer customer);
    int updateByIdTypeAndNum(Customer customer);
}
