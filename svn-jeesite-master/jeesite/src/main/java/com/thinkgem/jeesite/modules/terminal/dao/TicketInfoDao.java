/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.terminal.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.terminal.entity.TicketInfo;

/**
 * 出票信息Dao
 * @author Matthew
 * @version 2017-08-04
 */
@MyBatisDao
public interface TicketInfoDao extends CrudDao<TicketInfo> {

}