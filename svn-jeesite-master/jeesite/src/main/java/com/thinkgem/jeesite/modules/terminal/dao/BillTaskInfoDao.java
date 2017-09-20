/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.terminal.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.terminal.entity.BillTaskInfo;

/**
 * 订单任务信息Dao
 * @author Matthew
 * @version 2017-08-04
 */
@MyBatisDao
public interface BillTaskInfoDao extends CrudDao<BillTaskInfo> {

}