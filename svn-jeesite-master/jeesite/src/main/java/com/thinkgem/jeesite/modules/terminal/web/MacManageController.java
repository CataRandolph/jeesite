package com.thinkgem.jeesite.modules.terminal.web;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.terminal.entity.MacLotteryView;
import com.thinkgem.jeesite.modules.terminal.entity.MacManage;
import com.thinkgem.jeesite.modules.terminal.service.ExchangeAwardService;
import com.thinkgem.jeesite.modules.terminal.service.MacLotteryViewService;
import com.thinkgem.jeesite.modules.terminal.service.MacManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

/**
 * Created by lijunke on 2017/8/3.
 * 票机预警
 */
@Controller
@RequestMapping(value = "${adminPath}/terminal/manage")
public class MacManageController extends BaseController {


    @Autowired
    private MacManageService macManageService;

    @Autowired
    private MacLotteryViewService macLotteryViewService;

    @Autowired
    private ExchangeAwardService exchangeAwardService;


    @RequestMapping(value = {"list", ""})
    public String list(MacManage macManage, HttpServletRequest request, HttpServletResponse response, Model model) {
        Page<MacManage> page = macManageService.find(new Page<MacManage>(request, response), macManage);
        model.addAttribute("page", page);
        return "modules/terminal/macManageList";
    }

    /**
     * 根据id查询单条数据，返回对象
     *
     * @param macManage
     * @param model
     * @return
     */
    @RequestMapping(value = "form")
    public String form(MacManage macManage, Model model) {
        logger.info("查询票机数据！");

        if (StringUtils.isNoneBlank(macManage.getMacId())) {
            macManage = macManageService.get(macManage.getMacId());
            if (macManage.getLotName() != null) {
                macManage.setLotNames(macManage.getLotName().split(" "));
            }
            model.addAttribute("type", "修改");
        }
        List<MacLotteryView> lotList = macLotteryViewService.find();
        if (lotList != null) {
            model.addAttribute("lotList", lotList);
        }
        model.addAttribute("macManage", macManage);
        return "modules/terminal/macManageForm";
    }

    /**
     * 更新或修改票机数据
     *
     * @param macManage
     * @param model
     * @return
     */
    @RequestMapping(value = "save")
    public String updateOrSave(MacManage macManage, Model model) {

        boolean flag;
        if (StringUtils.isNotBlank(macManage.getType())) {
            //update
            flag = false;
            logger.info("更新票机数据！");
          /*  macManage.setUpdateTime(new Date());*/
        } else {
            flag = true;
            //add
            logger.info("添加票机数据！");
            macManage.setUpdateTime(new Date());
            macManage.setCreateTime(new Date());
        }
        macManageService.merge(macManage, flag);
        return "redirect:" + adminPath + "/terminal/manage/";
    }

    /**
     * 删除票机数据
     *
     * @param macManage
     * @param model
     * @return
     */
    @RequestMapping(value = "delete")
    public String delete(MacManage macManage, Model model) {
        macManageService.deleteManage(macManage);
        return "redirect:" + adminPath + "/terminal/manage/";
    }


    /**
     * 验证票机是否存在
     *
     * @param macId
     * @param response
     * @return
     */
    @RequestMapping(value = "check")
    @ResponseBody
    public String check(String macId, String type, HttpServletResponse response) {
        PrintWriter out;
        try {
            out = response.getWriter();
            if (null == type || type.equals("") || type.length() == 0) {
                out.write(macManageService.get(macId) != null ? "false" : "true");
            } else {
                out.write("true");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
