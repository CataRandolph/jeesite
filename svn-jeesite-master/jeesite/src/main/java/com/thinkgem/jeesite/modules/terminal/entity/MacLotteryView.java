package com.thinkgem.jeesite.modules.terminal.entity;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * Created by lijunke on 2017/8/23
 */
public class MacLotteryView extends DataEntity<MacLotteryView> {

    public Integer lotId;
    public String  lotValue;


    public Integer getLotId() {
        return lotId;
    }

    public void setLotId(Integer lotId) {
        this.lotId = lotId;
    }

    public String getLotValue() {
        return lotValue;
    }

    public void setLotValue(String lotValue) {
        this.lotValue = lotValue;
    }
}
