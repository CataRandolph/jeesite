package com.thinkgem.jeesite.modules.thirdparty.service;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.thirdparty.dal.IssueSaleDao;
import com.thinkgem.jeesite.modules.thirdparty.entity.IssueSale;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * 期次销量信息Service
 * @author Matthew
 * @version 2017-08-2504
 */
@Service("issueSaleService")
@Transactional(readOnly = true)
public class IssueSaleServiceImpl extends CrudService<IssueSaleDao,IssueSale> implements IssueSaleService {

	@Override
	public Page<IssueSale> find(Page<IssueSale> page, IssueSale issueSale) {
		issueSale.setPage(page);
		List<IssueSale> list = dao.findList(issueSale);
		page.setList(list);
		return page;
	}
	@Override
	public List<IssueSale> find(IssueSale issueSale) {
		return dao.findList(issueSale);
	}

}