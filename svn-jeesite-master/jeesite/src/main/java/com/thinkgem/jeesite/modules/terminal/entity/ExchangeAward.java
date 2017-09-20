package com.thinkgem.jeesite.modules.terminal.entity;

import com.thinkgem.jeesite.common.persistence.DataEntity;
import com.thinkgem.jeesite.common.utils.DateUtils;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * Created by lijunke on 2017/8/9.
 * <p>
 * 兑奖
 */
public class ExchangeAward extends DataEntity<ExchangeAward> {

    public String macId;                    //机器编号               查询条件
    public Integer isCashPrize;             //兑奖状态               查询条件   是否兑奖
    public Integer isWinPrize;              //中奖状态
    public BigDecimal cashPrizeMoney;       //兑奖金额
    public BigDecimal calcPrizeMoney;       //计奖金额
    public Date cashPrizeTime;              //兑奖时间               查询条件
    public Date calcPrizeTime;              //计奖时间               查询条件
    public Integer optId;                   //方案号
    public String orderID;                   //方案编号
    public String billChipBon;              //场次                  模糊查询条件
    public String lotName;                  //玩法
    private Date billTime;//出票成功时间
    private Double billMoeny;//金额
    private String billIssue;//期次号
    private Integer recID;//系统流水号
    private Integer isBigPrize;//大小奖 1：大奖 2：小奖
//    private String isBigPrizeStr;

    public Integer type = 1;                    //接收页面参数
    private Date beginDate = DateUtils.parseDateAndType(); //开始时间
    private Date endDate = new Date(System.currentTimeMillis());  //结束时间
    public String  beginDates;
    public String  endDates;
    public List<String> macIdList;          //票机编号集合
    public List<String> lotNameList;        //票机编号集合

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getBeginDates() {
        return beginDates;
    }

    public void setBeginDates(String beginDates) {
        this.beginDates = beginDates;
    }

    public String getEndDates() {
        return endDates;
    }

    public void setEndDates(String endDates) {
        this.endDates = endDates;
    }

    public Integer getIsBigPrize() {
        return isBigPrize;
    }

    public void setIsBigPrize(Integer isBigPrize) {
        this.isBigPrize = isBigPrize;
    }

    public Double getBillMoeny() {
        return billMoeny;
    }

    public void setBillMoeny(Double billMoeny) {
        this.billMoeny = billMoeny;
    }

    public Date getBillTime() {
        return billTime;
    }

    public void setBillTime(Date billTime) {
        this.billTime = billTime;
    }

    public String getBillIssue() {
        return billIssue;
    }

    public void setBillIssue(String billIssue) {
        this.billIssue = billIssue;
    }

    public Integer getRecID() {
        return recID;
    }

    public void setRecID(Integer recID) {
        this.recID = recID;
    }
    public List<String> getLotNameList() {
        return lotNameList;
    }

    public void setLotNameList(List<String> lotNameList) {
        this.lotNameList = lotNameList;
    }

    public List<String> getMacIdList() {
        return macIdList;
    }

    public void setMacIdList(List<String> macIdList) {
        this.macIdList = macIdList;
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

    public String getBillChipBon() {
        return billChipBon;
    }

    public void setBillChipBon(String billChipBon) {
        this.billChipBon = billChipBon;
    }

    public BigDecimal getCalcPrizeMoney() {
        return calcPrizeMoney;
    }

    public void setCalcPrizeMoney(BigDecimal calcPrizeMoney) {
        this.calcPrizeMoney = calcPrizeMoney;
    }

    public Date getCalcPrizeTime() {
        return calcPrizeTime;
    }

    public void setCalcPrizeTime(Date calcPrizeTime) {
        this.calcPrizeTime = calcPrizeTime;
    }

    public BigDecimal getCashPrizeMoney() {
        return cashPrizeMoney;
    }

    public void setCashPrizeMoney(BigDecimal cashPrizeMoney) {
        this.cashPrizeMoney = cashPrizeMoney;
    }

    public Date getCashPrizeTime() {
        return cashPrizeTime;
    }

    public void setCashPrizeTime(Date cashPrizeTime) {
        this.cashPrizeTime = cashPrizeTime;
    }

    public Integer getIsCashPrize() {
        return isCashPrize;
    }

    public void setIsCashPrize(Integer isCashPrize) {
        this.isCashPrize = isCashPrize;
    }

    public Integer getIsWinPrize() {
        return isWinPrize;
    }

    public void setIsWinPrize(Integer isWinPrize) {
        this.isWinPrize = isWinPrize;
    }

    public String getLotName() {
        return lotName;
    }

    public void setLotName(String lotName) {
        this.lotName = lotName;
    }

    public String getMacId() {
        return macId;
    }

    public void setMacId(String macId) {
        this.macId = macId;
    }

    public Integer getOptId() {
        return optId;
    }

    public void setOptId(Integer optId) {
        this.optId = optId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
