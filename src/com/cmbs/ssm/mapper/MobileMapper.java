package com.cmbs.ssm.mapper;

import com.cmbs.ssm.pojo.Mobile;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface MobileMapper {
    List<Mobile> queryByIsAviable();
    int addMobile(Mobile mobile) throws DataAccessException;
    int updateMobileNotAvai(Mobile mobile);
}
