package com.cmbs.ssm.service;

import com.cmbs.ssm.pojo.Account;

public interface AccountService {
    boolean loginCheck(String username);
    Account queryAccountById(String username);
    boolean addAccount(Account account);
    boolean updateAccountById(Account account);
    Account queryAccountByOthers(Account account);
}
