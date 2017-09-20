package com.thinkgem.jeesite.modules.terminal.service;

import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.terminal.dao.MacLotteryViewDao;
import com.thinkgem.jeesite.modules.terminal.entity.MacLotteryView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by lijunke on 2017/8/23.
 */
@Service
@Transactional(readOnly = true)
public class MacLotteryViewServiceImpl extends CrudService<MacLotteryViewDao, MacLotteryView> implements MacLotteryViewService {

    @Autowired
    private MacLotteryViewDao dao;

    @Override
    public List<MacLotteryView> find() {
        return dao.find();
    }
}
