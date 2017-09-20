
package com.thinkgem.jeesite.modules.thirdparty.web;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.terminal.entity.ExchangeAward;
import com.thinkgem.jeesite.modules.terminal.service.ExchangeAwardService;
import com.thinkgem.jeesite.modules.thirdparty.entity.SaleProject;
import com.thinkgem.jeesite.modules.thirdparty.service.SaleProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;

/**
 * 投注方案信息Controller
 * @author Matthew
 * @version 2017-08-04
 */
@Controller
@RequestMapping(value = "${adminPath}/thirdParty/project")
public class SaleProjectController extends BaseController {

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd-HH_mm_ss");


	@Autowired
	private SaleProjectService service;

	@Autowired
	private ExchangeAwardService exchangeAwardService;

	
	@ModelAttribute
	public SaleProject get(@RequestParam(required=false) String id) {
		SaleProject entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = service.getProject(id);
		}
		if (entity == null){
			entity = new SaleProject();
		}
		return entity;
	}
	
	@RequestMapping(value = {"list", ""})
	public String list(SaleProject saleProject, HttpServletRequest request, HttpServletResponse response, Model model) {
		String flag= request.getParameter("flag");
		if(saleProject.getIdType()!=null && saleProject.getIdType()==2 && saleProject.getOrderId()!=null && !"".equals(saleProject.getOrderId())){
			saleProject.setProjId(Long.parseLong(saleProject.getOrderId()));
		}
		if(null==flag){
			saleProject = new SaleProject();
			saleProject.setTimeType(2);
		}
		Page<SaleProject> page = service.find(new Page<SaleProject>(request, response), saleProject);
		ExchangeAward macs = new ExchangeAward();
		macs.setLotNameList(exchangeAwardService.byLotName());
		model.addAttribute("macs",macs);
		model.addAttribute("page", page);
		return "modules/thirdParty/saleProjectList";
	}

}