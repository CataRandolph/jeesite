package com.thinkgem.jeesite.modules.terminal.service;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.terminal.dao.BillTaskInfoDao;
import com.thinkgem.jeesite.modules.terminal.entity.BillTaskInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * 订单任务信息Service
 * @author Matthew
 * @version 2017-08-2504
 */
@Service("billTaskInfoService")
@Transactional(readOnly = true)
public class BillTaskInfoServiceImpl extends CrudService<BillTaskInfoDao,BillTaskInfo> implements BillTaskInfoService{

	SimpleDateFormat adf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@Override
	public Page<BillTaskInfo> find(Page<BillTaskInfo> page, BillTaskInfo billTaskInfo) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		billTaskInfo.setPage(page);
		List<BillTaskInfo> list = dao.findList(billTaskInfo);
		page.setList(list);
		return page;
	}
	@Override
	public List<BillTaskInfo> find(BillTaskInfo BillTaskInfo) {
		return dao.findList(BillTaskInfo);
	}

	@Override
	public BillTaskInfo getTask(String id) {
		BillTaskInfo ti =new BillTaskInfo();
		ti.setTaskId(Long.parseLong(id));
		BillTaskInfo entity = dao.get(ti);
		return entity;
	}

}