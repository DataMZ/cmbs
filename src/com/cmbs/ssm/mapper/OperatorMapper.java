package com.cmbs.ssm.mapper;

import com.cmbs.ssm.pojo.Operator;
import com.cmbs.ssm.pojo.OperatorVo;
import com.cmbs.ssm.pojo.Page;

import java.util.List;

public interface OperatorMapper {
    Operator queryOperatorById(String id); // 通过id查询操作员
    int addOperator(Operator operator); // 增加操作员
    List<Operator> queryOperatorByPage(Page page); // 通过页面类进行查询
    int queryCount(); // 请求记录数
    int deleteOperatorById(String id); // 通过id删除操作员
    int updateOperator(Operator operator); // 更新操作员
    int updateOperatorNoPwd(Operator operator); // 更新操作员不更新密码

    int queryCountById(Operator operator); // 请求记录数通过id
    int queryCountByName(Operator operator); // 请求记录数通过姓名
    int queryCountByIdAndName(Operator operator); // 请求记录数通过姓名和id

    List<Operator> queryOperatorPageById(OperatorVo operatorVo); // 通过页面类进行查询
    List<Operator> queryOperatorPageByName(OperatorVo operatorVo); // 通过页面类进行查询
    List<Operator> queryOperatorPageByIdAndName(OperatorVo operatorVo); //

}
