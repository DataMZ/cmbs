package com.cmbs.ssm.service;

import com.cmbs.ssm.pojo.Mobile;
import com.cmbs.ssm.pojo.User;

import java.util.List;

/**
 * @author: zwc
 * @date: 2018/9/9 16:01
 * @description:
 */
public interface UserService {
    boolean addUser(User user);
    boolean verifyTelAviable(List<Mobile> aviTel,String tel);
}
