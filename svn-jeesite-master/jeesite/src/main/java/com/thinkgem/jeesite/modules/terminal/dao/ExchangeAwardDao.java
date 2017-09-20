package com.thinkgem.jeesite.modules.terminal.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.terminal.entity.ExchangeAward;

import java.util.List;


/**
 * Created by lijunke on 2017/8/9.
 */
@MyBatisDao
public interface ExchangeAwardDao extends CrudDao<ExchangeAward> {

    /**
     *查询所有彩种
     * @return
     */
    List<String> byLotName();
}
