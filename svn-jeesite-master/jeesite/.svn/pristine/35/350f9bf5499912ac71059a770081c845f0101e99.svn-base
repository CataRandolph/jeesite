package com.thinkgem.jeesite.modules.terminal.entity;

import com.thinkgem.jeesite.common.persistence.DataEntity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by lijunke on 2017/8/3.
 *
 * 票机预警实体类
 */
public class MacManage extends DataEntity<MacManage> {

    private String macId;   //机器编号
    private Date createTime;    //创建机器时间
    private Date updateTime;    //预设金额最后一次更新时间 lastUpdateTime
    private BigDecimal money;   //预设金额  （理论值）
    private BigDecimal warningMoney = BigDecimal.valueOf(500);    //预警金额
    private Integer macStatus;     // 1.启动 2.停止     票机状态运行状态
    private Integer isEnable;   // 0.禁用 1.启用     票机属性
    private int ticketQuantity; //当日累计打印票数
    private BigDecimal totalAmount; //当日累计打印总金额
    private Integer chipCountLimit = 1500;   //票机当日限制张数
    private Integer notFinishCount; //待出票数
    private String lotName;
    private String[] lotNames;
    private String lotNameTitle;
    private String orderBy;

    public Integer getNotFinishCount() {
        return notFinishCount;
    }

    public void setNotFinishCount(Integer notFinishCount) {
        this.notFinishCount = notFinishCount;
    }

    public String[] getLotNames() {
        return lotNames;
    }

    public void setLotNames(String[] lotNames) {
        this.lotNames = lotNames;
    }

    public String getLotNameTitle() {
        return lotNameTitle;
    }

    public void setLotNameTitle(String lotNameTitle) {
        this.lotNameTitle = lotNameTitle;
    }

    public String getLotName() {
        return lotName;
    }

    public void setLotName(String lotName) {
        this.lotName = lotName;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public Integer getMacStatus() {
        return macStatus;
    }

    public void setMacStatus(Integer macStatus) {
        this.macStatus = macStatus;
    }

    public Integer getChipCountLimit() {
        return chipCountLimit;
    }

    public void setChipCountLimit(Integer chipCountLimit) {
        this.chipCountLimit = chipCountLimit;
    }

    public int getTicketQuantity() {
        return ticketQuantity;
    }

    public void setTicketQuantity(int ticketQuantity) {
        this.ticketQuantity = ticketQuantity;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String type;     //返回页面需要的参数

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(Integer isEnable) {
        this.isEnable = isEnable;
    }

    public String getMacId() {
        return macId;
    }

    public void setMacId(String macId) {
        this.macId = macId;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public BigDecimal getWarningMoney() {
        return warningMoney;
    }

    public void setWarningMoney(BigDecimal warningMoney) {
        this.warningMoney = warningMoney;
    }
}
