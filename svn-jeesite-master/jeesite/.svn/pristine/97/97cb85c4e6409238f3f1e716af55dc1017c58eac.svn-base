/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.terminal.service;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.common.utils.*;
import com.thinkgem.jeesite.modules.act.entity.ExcelReport;
import com.thinkgem.jeesite.modules.terminal.dao.TicketInfoDao;
import com.thinkgem.jeesite.modules.terminal.entity.TicketInfo;
import com.thinkgem.jeesite.modules.terminal.entity.TicketInfoPO;
import net.sf.json.JSONArray;
import org.activiti.engine.impl.util.json.JSONObject;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.*;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 出票信息Service
 * @author Matthew
 * @version 2017-08-04
 */
@Service("ticketInfoService")
@Transactional(readOnly = true)
public class TicketInfoServiceImpl extends CrudService<TicketInfoDao,TicketInfo> implements TicketInfoService{

	SimpleDateFormat adf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@Override
	public Page<TicketInfo> find(Page<TicketInfo> page, TicketInfo ticketInfo) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH		:mm:ss");
		ticketInfo.setPage(page);
		List<TicketInfo> list = dao.findList(ticketInfo);
		for(TicketInfo ti:list){
			ti.setBillTimeStr(sdf.format(ti.getBillTime()));
			if(null!=ti.getCalcPrizeTime()){
				ti.setCalcPrizeTimeStr(sdf.format(ti.getCalcPrizeTime()));
				if(ti.getCalcPrizeTimeStr().contains("1970")||ti.getCalcPrizeTimeStr().contains("1900")){
					ti.setCalcPrizeTimeStr("");
				}
			}
			if(null!=ti.getCashPrizeTime()){
				ti.setCashPrizeTimeStr(sdf.format(ti.getCashPrizeTime()));
				if(ti.getCashPrizeTimeStr().contains("1970")||ti.getCashPrizeTimeStr().contains("1900")){
					ti.setCashPrizeTimeStr("");
				}
			}
			ti.setIsWinPrizeStr(prizeStatus(ti.getIsWinPrize()));
		}
		page.setList(list);
		return page;
	}

	@Override
	public Page<TicketInfo> sum(Page<TicketInfo> page, TicketInfo ticketInfo) {
//		ticketInfo.setPage(page);
		List<TicketInfo> listdemo = dao.findList(ticketInfo);
		Double sumbillMoeny=0.00;
		Double sumcashPrizeMoney=0.00;
		double calcPrizeMoney=0.00;
		List<TicketInfo> list=new ArrayList<>();
		for(TicketInfo ti:listdemo){
			sumbillMoeny +=ti.getBillMoeny();
			sumcashPrizeMoney+=ti.getCashPrizeMoney();
			calcPrizeMoney+=ti.getCalcPrizeMoney();
		}
//		NumberFormat nf = NumberFormat.getInstance();
//		nf.setGroupingUsed(false);
		TicketInfo ticket =new TicketInfo();
		ticket.setBillMoeny(sumbillMoeny);
		ticket.setCashPrizeMoney(sumcashPrizeMoney);
		ticket.setCalcPrizeMoney(calcPrizeMoney);
		if(ticketInfo.getMacID()!=null){
			ticket.setMacID(ticketInfo.getMacID());
		}
		if(ticketInfo.getOptId()!=null){
			ticket.setOrderID(ticketInfo.getOptId());
		}
		if(ticketInfo.getLotName()!=null){
			ticket.setLotName(ticketInfo.getLotName());
		}
		if(ticketInfo.getIsWinPrize()!=null){
			ticket.setIsWinPrizeStr(prizeStatus(ticketInfo.getIsWinPrize()));
		}
		list.add(ticket);
		page.setList(list);
		return page;
	}

	@Override
	public List<TicketInfo> find(TicketInfo ticketInfo) {
		return dao.findList(ticketInfo);
	}

	@Override
	public TicketInfo getTicket(String id) {
		TicketInfo ti =new TicketInfo();
		ti.setRecID(Integer.parseInt(id));
		TicketInfo entity = dao.get(ti);
		return entity;
	}

	/**
	 * 导出出票文件Excel
	 */
	@Override
	public ExcelReport generateExcel(TicketInfo ticketInfo,String title,String fileName) {
		ExcelReport ep = new ExcelReport();
		ep.setTitle(fileName);
		ep.setFileName(fileName);
		String headers[] = new String[] {"票号","方案号","机器编号","交易金额","倍数","交易时间","出票彩期","彩种","任务号","中奖状态","兑奖金额","计奖金额","兑奖时间","计奖时间","彩票内容"};
		String attrs[] = new String[] {
				"billOrder", "optId", "macID", "billMoeny", "billMulti", "billTime", "billIssue", "lotName", "taskID", "isWinPrize", "cashPrizeMoney", "calcPrizeMoney", "cashPrizeTime", "calcPrizeTime", "billChip"};
		List<TicketInfo> listA = dao.findList(ticketInfo);
		List<TicketInfoPO> lists =new ArrayList<>();
		for(TicketInfo t:listA){
			TicketInfoPO po =new TicketInfoPO();
			BeanUtils.copyProperties(t, po);
			po.setIsWinPrize(prizeStatus(t.getIsWinPrize()));
			lists.add(po);
		}
		JSONArray data= JSONArray.fromObject(lists);
		ep.setHeader(headers);
		ep.setAttrs(attrs);
		ep.setData(data);
		return ep;
	}

	/**
	 * 导出出票文件txt
	 */
	@Override
	public  void exportTxt(String fileName,String baseDir) {
		BufferedWriter bw =null;
		SimpleDateFormat adf = new SimpleDateFormat("yyyyMMdd");
		TicketInfo ticketInfo = new TicketInfo();
		String dateStr = adf.format(new Date());
		//获取前一天的数据
		String beginDate = DateUtils.getPreDate();
		String endDate = DateUtils.getDate();
		try {
			ticketInfo.setBeginDate(null);
			ticketInfo.setEndDate(null);
			ticketInfo.setBeginDates(beginDate);
			ticketInfo.setEndDates(endDate);
			ticketInfo.setTimeType(0);
			List<TicketInfo> list = dao.findList(ticketInfo);
//			if( list.size() != 0){
				/**创建txt*/
				fileName =fileName+dateStr+"_1.txt";
				baseDir = baseDir + dateStr;
				createFile( new File(baseDir));//判断目录是否存在  不存在则创建
				bw = FileUtil.getBufferedWriter(baseDir +"/"+fileName, "UTF-8");
				createTxt(bw,list);
				//关闭流对象
				FileUtil.closeBufferedWriter(bw);
				//上传至服务器
				File files= new File(baseDir +"/"+ fileName);
				uploadFtp(files, dateStr);
//			}
		} catch (Exception e) {
			logger.error("生成"+fileName+"文件失败：", e);
		} finally {
			//关闭流对象
			FileUtil.closeBufferedWriter(bw);
		}
	}

	/**
	 * 创建txt
	 */
	public void createTxt(BufferedWriter bw,List<TicketInfo> list){
		try {
			if (null == list || list.size() == 0) {
				bw.write("0");
				bw.newLine();
			}
			int i = 0;
			if (null != list && list.size() > 0) {
				bw.write(list.size() + "");
				bw.newLine();
				String[] names = new String[]{"macID", "billMoeny", "orderID", "recID", "billTime", "billIssue"};
				for (TicketInfo ti : list) {
					JSONObject info = new JSONObject();
					if(ti.getMacID()==null){
						info.put("macID","");
					}else{
						info.put("macID", ti.getMacID());
					}
					if(ti.getBillMoeny()==null){
						info.put("billMoeny","");
					}else{
						info.put("billMoeny", ti.getBillMoeny());
					}
					if(ti.getOrdersID()==null){
						info.put("orderID", "");
					}else{
						info.put("orderID", ti.getOrdersID());
					}
					info.put("recID", ti.getRecID());
					info.put("billTime",adf.format(ti.getBillTime()));
					if(ti.getBillIssue()==null){
						info.put("billIssue", "");
					}else{
						info.put("billIssue", ti.getBillIssue());
					}
					if (i == 0) {
						writeTxt(bw, info, true, names);
					} else {
						writeTxt(bw, info, false, names);
					}
					i++;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}