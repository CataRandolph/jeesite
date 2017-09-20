package com.thinkgem.jeesite.modules.terminal.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.terminal.entity.MacManage;

import java.util.List;


/**
 * Created by lijunke on 2017/8/3.
 *票机预警dao接口
 */
@MyBatisDao
public interface MacManageDao extends CrudDao<MacManage> {

    int updateRestRecord();

    List<String> byMacId();

    int updateMoney(MacManage manage);
}
