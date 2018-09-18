package com.cmbs.ssm.service;

import com.cmbs.ssm.pojo.Operator;
import com.cmbs.ssm.pojo.OperatorVo;
import com.cmbs.ssm.pojo.Page;

import java.util.List;

/**
 * @author: zwc
 * @date: 2018/9/4 11:35
 * @description:
 */
public interface OperatorService {
    boolean loginCheck(String rights, String username, String passwd);
    Operator queryOperatorById(String username);
    boolean addOperator(Operator operator);
    int queryCount();
    List<Operator> queryOperatorByPage(Page page);
    boolean deleteOperatorById(String username);
    boolean deleteOperatorsById(String[] usernames);
    boolean updateOperator(Operator operator);
    boolean updateOperatorNoPwd(Operator operator);

    int queryCountById(Operator operator); // 请求记录数通过id
    int queryCountByName(Operator operator); // 请求记录数通过姓名
    int queryCountByIdAndName(Operator operator); // 请求记录数通过姓名和id

    List<Operator> queryOperatorPageById(OperatorVo operatorVo); // 通过页面类进行查询
    List<Operator> queryOperatorPageByName(OperatorVo operatorVo); // 通过页面类进行查询
    List<Operator> queryOperatorPageByIdAndName(OperatorVo operatorVo);




}
