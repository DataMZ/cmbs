package com.cmbs.ssm.mapper;

import com.cmbs.ssm.pojo.Account;
import com.cmbs.ssm.pojo.Operator;

public interface AccountMapper {
    Account queryAccountById(int id); // 通过id查询用户
    int addAccount(Account account); // 增加账户
    int updateAccountById(Account account); // 更改账户
    Account queryAccountByOthers(Account account); // 通过账户信息查询id

}
