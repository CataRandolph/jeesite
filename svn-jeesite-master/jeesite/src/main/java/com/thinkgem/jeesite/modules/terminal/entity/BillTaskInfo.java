package com.thinkgem.jeesite.modules.terminal.entity;

import com.thinkgem.jeesite.common.persistence.DataEntity;
import com.thinkgem.jeesite.common.utils.DateUtils;

import java.util.Date;

/**
 * 任务信息Entity
 *
 * @author Matthew
 * @version 2017-08-04
 */
public class BillTaskInfo extends DataEntity<BillTaskInfo> {


    private Long taskId; //ID
    private Long optId; //方案号
    private Long lotId; //彩种ID
    private String lotName;//彩种名称
    private Long lotIssue; //彩期
    private String macID; //票机编号
    private Long bchipId; //
    private Long echipId; //
    private String userChip;//投注内容
    private Long chipMul;//倍数
    private Long chipCount;//
    private Long chipMoney;//投注金额
    private Date billTime;//出票时间
    private Long biller;//出票人
    private Integer billState;//出票状态
    final String STATE_INIT = "0";      //-等待处理     *
    final String STATE_USERCANCEL = "7";      //-用户撤单    取消投注*
    final String STATE_WAITCANCEL = "6";      //-新系统出票失败，等待取消出票*
    final String STATE_PRINTING = "10";     //-出票中    *
    final String STATE_CANCELPRINT = "11";     //-待出票（取消出票）*
    final String STATE_PRINTED = "12";     //-已出票       *
    final String STATE_TRANSRALL = "51";     //-出票任务全部转移到异地出票
    final String STATE_TRANSRSOME = "52";     //-出票任务部分转移到异地出票
    final String STATE_CANCELBONUS = "80";     //-待派奖（取消奖金发放）
    final String STATE_LIMITED_FAIL = "89";     //-限号撤单 Add By Liuzh 2014.08.04
    final String STATE_FINISH_FAIL = "90";     //-已撤单
    final String STATE_FINISH_SUCC = "99";     //-已结算
    private Long taskType; //任务类型
    private Long coopId;  //
    private Long chipItemNum;//
    private Date downTime;//拆票时间
    private Long minMatchId;//最小场次ID
    private Long billType;//出票类型
    private Long playId; //
    private Long bigType;//
    private String lastMatchId;//
    private Date latestPrintTime;//
    private String cityCode;//
    private Integer timeType;
    private Date beginDate = DateUtils.parseDateAndType(); //开始时间
    private Date endDate = new Date(System.currentTimeMillis());  //结束时间


    public String getLotName() {
        return lotName;
    }

    public void setLotName(String lotName) {
        this.lotName = lotName;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public Long getOptId() {
        return optId;
    }

    public void setOptId(Long optId) {
        this.optId = optId;
    }

    public Long getLotId() {
        return lotId;
    }

    public void setLotId(Long lotId) {
        this.lotId = lotId;
    }

    public Long getLotIssue() {
        return lotIssue;
    }

    public void setLotIssue(Long lotIssue) {
        this.lotIssue = lotIssue;
    }

    public String getMacID() {
        return macID;
    }

    public void setMacID(String macID) {
        this.macID = macID;
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

    public Long getBchipId() {
        return bchipId;
    }

    public void setBchipId(Long bchipId) {
        this.bchipId = bchipId;
    }

    public Long getEchipId() {
        return echipId;
    }

    public void setEchipId(Long echipId) {
        this.echipId = echipId;
    }

    public String getUserChip() {
        return userChip;
    }

    public void setUserChip(String userChip) {
        this.userChip = userChip;
    }

    public Long getChipMul() {
        return chipMul;
    }

    public void setChipMul(Long chipMul) {
        this.chipMul = chipMul;
    }

    public Long getChipCount() {
        return chipCount;
    }

    public void setChipCount(Long chipCount) {
        this.chipCount = chipCount;
    }

    public Long getChipMoney() {
        return chipMoney;
    }

    public void setChipMoney(Long chipMoney) {
        this.chipMoney = chipMoney;
    }

    public Date getBillTime() {
        return billTime;
    }

    public void setBillTime(Date billTime) {
        this.billTime = billTime;
    }

    public Long getBiller() {
        return biller;
    }

    public void setBiller(Long biller) {
        this.biller = biller;
    }

    public Integer getBillState() {
        return billState;
    }

    public void setBillState(Integer billState) {
        this.billState = billState;
    }

    public Integer getTimeType() {
        return timeType;
    }

    public void setTimeType(Integer timeType) {
        this.timeType = timeType;
    }

    public Long getTaskType() {
        return taskType;
    }

    public void setTaskType(Long taskType) {
        this.taskType = taskType;
    }

    public Long getCoopId() {
        return coopId;
    }

    public void setCoopId(Long coopId) {
        this.coopId = coopId;
    }

    public Long getChipItemNum() {
        return chipItemNum;
    }

    public void setChipItemNum(Long chipItemNum) {
        this.chipItemNum = chipItemNum;
    }

    public Date getDownTime() {
        return downTime;
    }

    public void setDownTime(Date downTime) {
        this.downTime = downTime;
    }

    public Long getMinMatchId() {
        return minMatchId;
    }

    public void setMinMatchId(Long minMatchId) {
        this.minMatchId = minMatchId;
    }

    public Long getBillType() {
        return billType;
    }

    public void setBillType(Long billType) {
        this.billType = billType;
    }

    public Long getPlayId() {
        return playId;
    }

    public void setPlayId(Long playId) {
        this.playId = playId;
    }

    public Long getBigType() {
        return bigType;
    }

    public void setBigType(Long bigType) {
        this.bigType = bigType;
    }

    public String getLastMatchId() {
        return lastMatchId;
    }

    public void setLastMatchId(String lastMatchId) {
        this.lastMatchId = lastMatchId;
    }

    public Date getLatestPrintTime() {
        return latestPrintTime;
    }

    public void setLatestPrintTime(Date latestPrintTime) {
        this.latestPrintTime = latestPrintTime;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }
}
