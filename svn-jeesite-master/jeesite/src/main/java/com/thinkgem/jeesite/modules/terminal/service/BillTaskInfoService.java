/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.terminal.service;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.modules.act.entity.ExcelReport;
import com.thinkgem.jeesite.modules.terminal.entity.BillTaskInfo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 订单任务信息Service
 * @author Matthew
 * @version 2017-08-25
 */
@Service
public interface BillTaskInfoService {

	/**
	 * 分页查询
	 */
	Page<BillTaskInfo> find(Page<BillTaskInfo> page, BillTaskInfo billTaskInfo);

	/**
	 * 查询
	 */
	List<BillTaskInfo> find(BillTaskInfo billTaskInfo);


	/**
	 * 详情
	 */
	BillTaskInfo getTask(String id);

}