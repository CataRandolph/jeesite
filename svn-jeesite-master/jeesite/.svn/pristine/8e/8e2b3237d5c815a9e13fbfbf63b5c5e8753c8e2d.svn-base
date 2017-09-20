package com.thinkgem.jeesite.modules.thirdparty.dal;

import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.annotation.MapperScan;

/**
 * Created by lijunke on 2017/9/6.
 */
@MapperScan
@MyBatisDao
public interface LotFaceDao {

    @Select("select count(1) from Joblock with (nolock)")
    int count();

}
