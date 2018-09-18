package com.cmbs.ssm.service.impl;

import com.cmbs.ssm.mapper.AccountMapper;
import com.cmbs.ssm.pojo.Account;
import com.cmbs.ssm.pojo.Operator;
import com.cmbs.ssm.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: zwc
 * @date: 2018/9/5 23:48
 * @description:
 */
@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountMapper accountMapper;

    @Override
    public boolean loginCheck(String username) {
        boolean isLogin = false;
        try {
            Account account = accountMapper.queryAccountById(Integer.parseInt(username));
            if(account != null && account.getAccountId() == Integer.parseInt(username)) {
                isLogin=true;
            }
        }catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return isLogin;
    }

    @Override
    public Account queryAccountById(String username) {
        int userId;
        try {
            userId = Integer.parseInt(username);
        }catch (NumberFormatException e) {
            return null;
        }
        return accountMapper.queryAccountById(userId);
    }

    @Override
    public boolean addAccount(Account account) {
        boolean isAdd = false;
        if(accountMapper.addAccount(account)==1) {
            isAdd = true;
        }
        return isAdd;
    }

    @Override
    public boolean updateAccountById(Account account) {
        boolean isUpdate = false;
        if(accountMapper.updateAccountById(account) == 1) {
            isUpdate = true;
        }
        return isUpdate;
    }

    @Override
    public Account queryAccountByOthers(Account account) {
        return accountMapper.queryAccountByOthers(account);
    }

}
