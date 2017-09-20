package com.thinkgem.jeesite.modules.terminal.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.terminal.entity.FinanceInfo;

/**
 * Created by lijunke on 2017/8/14.
 */
@MyBatisDao
public interface FinanceInfoDao  extends CrudDao<FinanceInfo> {

}
