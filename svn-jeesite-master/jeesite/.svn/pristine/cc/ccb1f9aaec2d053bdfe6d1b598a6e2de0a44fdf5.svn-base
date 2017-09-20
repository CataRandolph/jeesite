/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.thirdparty.service;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.modules.thirdparty.entity.SaleProject;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 投注方案信息Service
 * @author Matthew
 * @version 2017-09-11
 */

public interface SaleProjectService {

	/**
	 * 分页查询
	 */
	Page<SaleProject> find(Page<SaleProject> page, SaleProject saleProject);

	/**
	 * 查询
	 */
	List<SaleProject> find(SaleProject billTaskInfo);


	/**
	 * 详情
	 */
	SaleProject getProject(String id);

}