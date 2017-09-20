/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.thirdparty.service;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.modules.thirdparty.entity.IssueSale;
import com.thinkgem.jeesite.modules.thirdparty.entity.SaleProject;

import java.util.List;

/**
 * 期次销量信息Service
 * @author Matthew
 * @version 2017-09-11
 */

public interface IssueSaleService {

	/**
	 * 分页查询
	 */
	Page<IssueSale> find(Page<IssueSale> page, IssueSale issueSale);

	/**
	 * 查询
	 */
	List<IssueSale> find(IssueSale issueSale);

}