package com.thinkgem.jeesite.modules.terminal.service;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.modules.act.entity.ExcelReport;
import com.thinkgem.jeesite.modules.terminal.entity.ExchangeAward;
import java.util.List;


/**
 * Created by Matthew on 2017/8/10.
 * 兑奖服务接口
 */
public interface ExchangeAwardService {

    /**
     * 查询分页
     * @param exchangeAward
     * @return
     */
    Page<ExchangeAward> find(Page<ExchangeAward> managePage,ExchangeAward exchangeAward);

    /**
     * 数据汇总
     * @param exchangeAward
     * @return
     */
    Page<ExchangeAward> sum(Page<ExchangeAward> managePage,ExchangeAward exchangeAward);


    List<ExchangeAward> find(ExchangeAward exchangeAward);


    /**
     * 生成excel
     */
    ExcelReport generateExcel(ExchangeAward exchangeAward, String title, String fileName);


    /**
     * 生成text
     */
    void generateTxt(String fileName,String baseDir);


    /**
     *查询所有彩种
     * @return
     */
    List<String> byLotName();
}
