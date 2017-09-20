package com.thinkgem.jeesite.modules.terminal.entity;

import com.thinkgem.jeesite.common.persistence.DataEntity;
import com.thinkgem.jeesite.common.utils.DateUtils;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by lijunke on 2017/8/14.
 * 财务信息
 */
public class FinanceInfo extends DataEntity<FinanceInfo> {

    private String macId;
    private BigDecimal aroseMoney;       //发生金额
    private BigDecimal beforeMoney;      //发生前金额
    private BigDecimal currentBalance;   //当前余额
    private Date addTime;                //添加时间
    private String remarks;              //备注
    private Integer correctType;         //修正类型      1.补回出票款 2.补回派奖金 3.冲销充值  4.补扣出票款


    private Date beginDate = DateUtils.parseDateAndType(); //开始时间
    private Date endDate = new Date(System.currentTimeMillis());  //结束时间

    public BigDecimal getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(BigDecimal currentBalance) {
        this.currentBalance = currentBalance;
    }

    public Integer getCorrectType() {
        return correctType;
    }

    public void setCorrectType(Integer correctType) {
        this.correctType = correctType;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public BigDecimal getAroseMoney() {
        return aroseMoney;
    }

    public void setAroseMoney(BigDecimal aroseMoney) {
        this.aroseMoney = aroseMoney;
    }

    public BigDecimal getBeforeMoney() {
        return beforeMoney;
    }

    public void setBeforeMoney(BigDecimal beforeMoney) {
        this.beforeMoney = beforeMoney;
    }

    public String getMacId() {
        return macId;
    }

    public void setMacId(String macId) {
        this.macId = macId;
    }

    @Override
    public String getRemarks() {
        return remarks;
    }

    @Override
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
