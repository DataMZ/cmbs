package com.cmbs.ssm.service.impl;

import com.cmbs.ssm.mapper.MobileMapper;
import com.cmbs.ssm.mapper.OperatorMapper;
import com.cmbs.ssm.pojo.Mobile;
import com.cmbs.ssm.pojo.Operator;
import com.cmbs.ssm.pojo.OperatorVo;
import com.cmbs.ssm.pojo.Page;
import com.cmbs.ssm.service.OperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @author: zwc
 * @date: 2018/9/4 11:36
 * @description:
 */
@Service
public class OperatorServiceImpl implements OperatorService {
    @Autowired
    private OperatorMapper operatorMapper;
    /**
     * 验证登录信息
     * @param rights 权限
     * @param username 用户名称
     * @param passwd 密码
     * @return 布尔值
     */
    @Override
    public boolean loginCheck(String rights, String username, String passwd) {
        boolean isLogin = false;
        Operator operator = operatorMapper.queryOperatorById(username);
        if(rights.equals("0") && !Objects.isNull(operator) ) {
            if(operator.getIsAdmin().equals("Y") && operator.getPwd().equals(passwd.trim())) {
                isLogin = true;
            }
        }else if(rights.equals("1") && !Objects.isNull(operator)) {
            if(operator.getPwd().equals(passwd.trim())) {
                isLogin = true;
            }
        }
        return isLogin;
    }

    /**
     * 根据用户名获得opreator对象
     * @param username 用户名
     * @return Operator对象
     */
    @Override
    public Operator queryOperatorById(String username) {
        return operatorMapper.queryOperatorById(username);
    }

    @Override
    public boolean addOperator(Operator operator) {
        boolean isAdd = false;
        if(operatorMapper.addOperator(operator) == 1) {
            isAdd = true;
        }
        return isAdd;
    }

    @Override
    public int queryCount() {
        return operatorMapper.queryCount();
    }

    @Override
    public List<Operator> queryOperatorByPage(Page page) {
        return operatorMapper.queryOperatorByPage(page);
    }


    @Override
    public boolean deleteOperatorById(String username) {
        boolean isDelete = false;
        if(operatorMapper.deleteOperatorById(username) == 1) {
            isDelete = true;
        }
        return isDelete;
    }

    @Override
    public boolean deleteOperatorsById(String[] usernames) {
        boolean isDelete = true;
        for (String username:usernames) {
            if(operatorMapper.deleteOperatorById(username) != 1) {
                isDelete = false;
            }
        }
        return isDelete;
    }

    @Override
    public boolean updateOperator(Operator operator) {
        boolean isUpdate = false;
        if(operatorMapper.updateOperator(operator) == 1) {
            isUpdate = true;
        }
        return isUpdate;
    }

    @Override
    public boolean updateOperatorNoPwd(Operator operator) {
        boolean isUpdate = false;
        if(operatorMapper.updateOperatorNoPwd(operator) == 1) {
            isUpdate = true;
        }
        return isUpdate;
    }


    @Override
    public int queryCountById(Operator operator) {
        return operatorMapper.queryCountById(operator);
    }

    @Override
    public int queryCountByName(Operator operator) {
        return operatorMapper.queryCountByName(operator);
    }

    @Override
    public int queryCountByIdAndName(Operator operator) {
        return operatorMapper.queryCountByIdAndName(operator);
    }

    @Override
    public List<Operator> queryOperatorPageById(OperatorVo operatorVo) {
        return operatorMapper.queryOperatorPageById(operatorVo);
    }

    @Override
    public List<Operator> queryOperatorPageByName(OperatorVo operatorVo) {
        return operatorMapper.queryOperatorPageByName(operatorVo);
    }

    @Override
    public List<Operator> queryOperatorPageByIdAndName(OperatorVo operatorVo) {
        return operatorMapper.queryOperatorPageByIdAndName(operatorVo);
    }


}
