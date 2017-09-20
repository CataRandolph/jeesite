/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.thirdparty.dal;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.thirdparty.entity.SaleProject;

/**
 * 投注方案信息Dao
 * @author Matthew
 * @version 2017-09-11
 */
@MyBatisDao
public interface SaleProjectDao extends CrudDao<SaleProject> {

}