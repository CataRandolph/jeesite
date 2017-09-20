package com.thinkgem.jeesite.modules.terminal.service;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.common.utils.DateUtils;
import com.thinkgem.jeesite.common.utils.FileUtil;
import com.thinkgem.jeesite.modules.act.entity.ExcelReport;
import com.thinkgem.jeesite.modules.terminal.dao.ExchangeAwardDao;
import com.thinkgem.jeesite.modules.terminal.entity.ExchangeAward;
import com.thinkgem.jeesite.modules.terminal.entity.ExchangeAwardPO;
import net.sf.json.JSONArray;
import org.activiti.engine.impl.util.json.JSONObject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Matthew on 2017/8/10.
 */
@Service
@Transactional(readOnly = true)
public class ExchangeAwardServiceImpl extends CrudService<ExchangeAwardDao, ExchangeAward> implements ExchangeAwardService{
    SimpleDateFormat adf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @Autowired
    ExchangeAwardDao exchangeAwardDao;


    /**
     * 分页查询数据
     * @param exchangeAwardPage
     * @param exchangeAward
     * @return
     */
    @Override
    public Page<ExchangeAward> find(Page<ExchangeAward> exchangeAwardPage, ExchangeAward exchangeAward) {
//        Page<ExchangeAward> pages = findPage(exchangeAwardPage,exchangeAward);
//        List<ExchangeAward> list = pages.getList();
//        for(ExchangeAward ea: list){
//            ea.setIsBigPrizeStr("大奖");
//        }
        return findPage(exchangeAwardPage,exchangeAward);
    }
    @Override
    public Page<ExchangeAward> sum(Page<ExchangeAward> exchangeAwardPage, ExchangeAward exchangeAward) {
        List<ExchangeAward> page= dao.findList(exchangeAward);
        BigDecimal sumcashPrizeMoney =new BigDecimal("0.0000");
        BigDecimal calcPrizeMoney=new BigDecimal("0.0000");
        List<ExchangeAward> list=new ArrayList<>();
        for(ExchangeAward ti:page){
            sumcashPrizeMoney =sumcashPrizeMoney.add(ti.getCashPrizeMoney());
            calcPrizeMoney =calcPrizeMoney.add(ti.getCalcPrizeMoney());
        }
        ExchangeAward exchange =new ExchangeAward();
        exchange.setCashPrizeMoney(sumcashPrizeMoney);
        exchange.setCalcPrizeMoney(calcPrizeMoney);
        if(exchangeAward.getMacId()!=null){
            exchange.setMacId(exchangeAward.getMacId());
        }
        if(exchangeAward.getOptId()!=null){
            exchange.setOptId(exchangeAward.getOptId());
        }
        if(exchangeAward.getLotName()!=null){
            exchange.setLotName(exchangeAward.getLotName());
        }
        if(exchangeAward.getIsWinPrize()!=null){
            exchange.setIsWinPrize(exchangeAward.getIsWinPrize());
        }
        if(exchangeAward.getIsCashPrize()!=null){
            exchange.setIsCashPrize(exchangeAward.getIsCashPrize());
        }
        if(exchangeAward.getIsBigPrize()!=null){
            exchange.setIsBigPrize(exchangeAward.getIsBigPrize());
        }
        list.add(exchange);
        exchangeAwardPage.setList(page);
        return exchangeAwardPage;
    }

    @Override
    public List<ExchangeAward> find(ExchangeAward exchangeAward){
        return dao.findList(exchangeAward);
    }

    /**
     * 生成excel
     */
    @Override
    public ExcelReport generateExcel(ExchangeAward exchangeAward, String title, String fileName) {
        ExcelReport ep = new ExcelReport();
        ep.setTitle(fileName);
        ep.setFileName(fileName);
        String headers[] = new String[] {"票机编号","方案号","彩种","是否兑奖","中奖状态","兑奖金额","计奖金额","大小奖","兑奖时间","计奖时间","投注结果"};
        String attrs[] = new String[] {
                "macId", "optId","lotName", "isCashPrize", "isWinPrize", "cashPrizeMoney", "calcPrizeMoney", "cashPrizeTime", "calcPrizeTime", "billChipBon"};

        List<ExchangeAward> listA = dao.findList(exchangeAward);
        List<ExchangeAwardPO> list =new ArrayList<>();
        for(ExchangeAward t:listA){
            ExchangeAwardPO po =new ExchangeAwardPO();
            BeanUtils.copyProperties(t, po);
            po.setIsWinPrize(prizeStatus(t.getIsWinPrize()));
            switch (t.getIsCashPrize()) {
                case 0:
                    po.setIsCashPrize("未兑奖");
                    break;
                case 1:
                    po.setIsCashPrize("已兑奖");
                    break;
            }
            list.add(po);
        }
        JSONArray data= JSONArray.fromObject(list);
        ep.setHeader(headers);
        ep.setAttrs(attrs);
        ep.setData(data);
        return ep;
    }

    /**
     *  获取所有彩种
     * @return
     */
    @Override
    public List<String> byLotName() {
        return exchangeAwardDao.byLotName();
    }

    /**
     * 导出兑奖文件txt
     */
    @Override
    public  void generateTxt(String fileName,String baseDir) {
        BufferedWriter bw =null;
        SimpleDateFormat adf = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        ExchangeAward exchangeAward = new ExchangeAward();
        String dateStr = adf.format(new Date());

        try {
            //获取前一天的数据
            String beginDate = DateUtils.getPreDate();
            exchangeAward.setBeginDate(null);
            exchangeAward.setEndDate(null);
            exchangeAward.setBeginDates(beginDate);
            exchangeAward.setEndDates(sdf.format(new Date()));
            exchangeAward.setType(1);
            List<ExchangeAward> list = dao.findList(exchangeAward);
//            if( list.size() != 0){
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
//            }
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
    public void createTxt(BufferedWriter bw,List<ExchangeAward> list){
        try {
            if (null == list || list.size() == 0) {
                bw.write("0");
                bw.newLine();
            }
            int i = 0;
            if (null != list && list.size() > 0) {
                bw.write(list.size() + "");
                bw.newLine();
                String[] names = new String[]{"macId", "recID", "billMoeny", "billIssue","billTime","cashPrizeMoney", "calcPrizeMoney","calcPrizeTime", "optId"};
                for (ExchangeAward ti : list) {
                    JSONObject info = new JSONObject();
                    if(ti.getMacId()==null){
                        info.put("macId","");
                    }else{
                        info.put("macId", ti.getMacId());
                    }
                    if(ti.getRecID()==null){
                        info.put("recID", "");
                    }else{
                        info.put("recID", ti.getRecID());
                    }
                    if(ti.getBillMoeny()==null){
                        info.put("billMoeny", "");
                    }else{
                        info.put("billMoeny", ti.getBillMoeny());
                    }
                    if(ti.getBillIssue()==null){
                        info.put("billIssue", "");
                    }else{
                        info.put("billIssue", ti.getBillIssue());
                    }if(ti.getBillTime()==null){
                        info.put("billTime", "");
                    }else{
                        info.put("billTime", adf.format(ti.getBillTime()));
                    }
                    if(ti.getCashPrizeMoney()==null){
                        info.put("cashPrizeMoney", "");
                    }else{
                        info.put("cashPrizeMoney", ti.getCashPrizeMoney());
                    }
                    if(ti.getCalcPrizeMoney()==null){
                        info.put("calcPrizeMoney", "");
                    }else{
                        info.put("calcPrizeMoney",ti.getCalcPrizeMoney());
                    }
                    if(ti.getCalcPrizeTime()==null){
                        info.put("calcPrizeTime", "");
                    }else{
                        info.put("calcPrizeTime", adf.format(ti.getCalcPrizeTime()));
                    }
                    if(ti.getOrderID()==null){
                        info.put("optId","");
                    }else{
                        info.put("optId", ti.getOrderID());
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
