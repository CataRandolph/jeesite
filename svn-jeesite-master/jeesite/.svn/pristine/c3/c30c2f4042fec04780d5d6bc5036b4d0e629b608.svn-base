package com.thinkgem.jeesite.modules.terminal.service;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.terminal.dao.FinanceInfoDao;
import com.thinkgem.jeesite.modules.terminal.dao.MacManageDao;
import com.thinkgem.jeesite.modules.terminal.entity.FinanceInfo;
import com.thinkgem.jeesite.modules.terminal.entity.MacManage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by lijunke on 2017/8/14.
 */
@Service
@Transactional(readOnly = true)
public class FinanceInfoServiceImpl extends CrudService<FinanceInfoDao, FinanceInfo> implements FinanceInfoService {

    @Autowired
    FinanceInfoDao financeInfoDao;

    @Autowired
    MacManageDao macManageDao;

    /**
     * 分页查询
     *
     * @param page
     * @param financeInfo
     * @return
     */
    @Override
    public Page<FinanceInfo> findList(Page<FinanceInfo> page, FinanceInfo financeInfo) {
        return findPage(page, financeInfo);
    }

    /**
     * 数据修正
     *
     * @param financeInfo
     */
    @Override
    public void insert(FinanceInfo financeInfo) {
        try {
            logger.info("要修正的类型为{}", financeInfo.getCorrectType());
            financeInfo.setBeforeMoney(financeInfo.getCurrentBalance());
            financeInfo = this.byCorrectType(financeInfo);
            int id = this.updatePresetMoney(financeInfo);
            if (id > 0) {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Long time = System.currentTimeMillis();
                String d = format.format(time);
                Date date = format.parse(d);
                financeInfo.setAddTime(date);
                int maxId = financeInfoDao.insert(financeInfo);
                if (maxId > 0) {
                    logger.info("金额修正成功,修正数据添加成功！");
                }
            }
        } catch (Exception e) {
            logger.error("修正数据失败！");
            e.printStackTrace();
        }
    }


    /**
     * 更新票机预设金额
     *
     * @param financeInfo
     */
    public int updatePresetMoney(FinanceInfo financeInfo) {
        try {
            logger.info("开始更新票机预设金额！");
            MacManage manage = new MacManage();
            manage.setMacId(financeInfo.getMacId());
            manage.setMoney(financeInfo.getCurrentBalance());
            int id = macManageDao.updateMoney(manage);
            if (id > 0) {
                logger.info("开始更新票机预设金额成功！");
                return id;
            }
        } catch (Exception e) {
            logger.info("更新票机预设金额失败！");
            e.printStackTrace();
        }
        return -1;
    }

    /**
     * 1.补回出票款 2.补回派奖金 3.冲销充值  4.补扣出票款
     *
     * @param financeInfo
     * @return
     */
    private FinanceInfo byCorrectType(FinanceInfo financeInfo) {

        if (null != financeInfo.getCorrectType()) {
            //1.补回出票款
            if (financeInfo.getCorrectType().equals(1)) {
                financeInfo.setCurrentBalance(financeInfo.getCurrentBalance().add(financeInfo.getAroseMoney()));

                // 2.补回派奖金
            } else if (financeInfo.getCorrectType().equals(2)) {
                financeInfo.setCurrentBalance(financeInfo.getCurrentBalance().add(financeInfo.getAroseMoney()));

                // 3.冲销充值
            } else if (financeInfo.getCorrectType().equals(3)) {
                financeInfo.setCurrentBalance(financeInfo.getCurrentBalance().add(financeInfo.getAroseMoney()));

                //4.补扣出票款  减
            } else {
                financeInfo.setCurrentBalance(financeInfo.getCurrentBalance().subtract(financeInfo.getAroseMoney()));
            }
        }
        return financeInfo;
    }
}
