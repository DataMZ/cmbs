package com.cmbs.ssm.service.impl;

import com.cmbs.ssm.mapper.UserMapper;
import com.cmbs.ssm.pojo.Mobile;
import com.cmbs.ssm.pojo.User;
import com.cmbs.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: zwc
 * @date: 2018/9/9 16:02
 * @description:
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;


    @Override
    public boolean addUser(User user) {
        boolean isAdd = false;
        if(userMapper.addUser(user) == 1) {
            isAdd = true;
        }
        return isAdd;
    }

    @Override
    public boolean verifyTelAviable(List<Mobile> aviTel, String tel) {
        boolean isTelAviable = false;
        for(Mobile mobile:aviTel) {
            if(mobile.getMobileNumber().equals(tel)) {
                isTelAviable = true;
                break;
            }
        }
        return isTelAviable;
    }
}
