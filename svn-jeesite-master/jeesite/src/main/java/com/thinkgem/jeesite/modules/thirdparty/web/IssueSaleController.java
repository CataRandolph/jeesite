
package com.thinkgem.jeesite.modules.thirdparty.web;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.terminal.entity.ExchangeAward;
import com.thinkgem.jeesite.modules.terminal.service.ExchangeAwardService;
import com.thinkgem.jeesite.modules.thirdparty.entity.IssueSale;
import com.thinkgem.jeesite.modules.thirdparty.service.IssueSaleService;
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
 * 期次销量信息Controller
 * @author Matthew
 * @version 2017-09-12
 */
@Controller
@RequestMapping(value = "${adminPath}/thirdParty/issueSale")
public class IssueSaleController extends BaseController {

	@Autowired
	private IssueSaleService service;

	@Autowired
	private ExchangeAwardService exchangeAwardService;


	@RequestMapping(value = {"list", ""})
	public String list(IssueSale IssueSale, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<IssueSale> page = service.find(new Page<IssueSale>(request, response), IssueSale);
		ExchangeAward macs = new ExchangeAward();
		macs.setLotNameList(exchangeAwardService.byLotName());
		model.addAttribute("macs",macs);
		model.addAttribute("page", page);
		return "modules/thirdParty/issueSaleList";
	}

}