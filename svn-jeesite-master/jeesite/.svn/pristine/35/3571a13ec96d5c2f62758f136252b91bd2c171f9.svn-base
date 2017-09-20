package com.thinkgem.jeesite.modules.thirdparty.service;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.thirdparty.dal.SaleProjectDao;
import com.thinkgem.jeesite.modules.thirdparty.entity.SaleProject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * 投注方案信息Service
 * @author Matthew
 * @version 2017-08-2504
 */
@Service("saleProjectService")
@Transactional(readOnly = true)
public class SaleProjectServiceImpl extends CrudService<SaleProjectDao,SaleProject> implements SaleProjectService {

	SimpleDateFormat adf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@Override
	public Page<SaleProject> find(Page<SaleProject> page, SaleProject SaleProject) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SaleProject.setPage(page);
		List<SaleProject> list = dao.findList(SaleProject);
		page.setList(list);
		return page;
	}
	@Override
	public List<SaleProject> find(SaleProject SaleProject) {
		return dao.findList(SaleProject);
	}

	@Override
	public SaleProject getProject(String id) {
		SaleProject ti =new SaleProject();
		ti.setProjId(Long.parseLong(id));
		SaleProject entity = dao.get(ti);
		return entity;
	}

}