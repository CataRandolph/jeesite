package com.thinkgem.jeesite.modules.terminal.service;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.terminal.dao.MacManageDao;
import com.thinkgem.jeesite.modules.terminal.dao.MacManageRecordDao;
import com.thinkgem.jeesite.modules.terminal.dao.MacUnionLotteryDao;
import com.thinkgem.jeesite.modules.terminal.entity.MacManage;
import com.thinkgem.jeesite.modules.terminal.entity.MacUnionLottery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lijunke on 2017/8/3.
 * 票机预警服务实现类
 */
@Service
@Lazy(false)
@Transactional(readOnly = true)
public class MacManageServiceImpl extends CrudService<MacManageDao, MacManage> implements MacManageService {

    public static final Logger log = LoggerFactory.getLogger(MacManageServiceImpl.class);

    @Autowired
    private MacManageDao dao;

    @Autowired
    private MacManageRecordDao recordDao;

    @Autowired
    private MacUnionLotteryDao macUnionLotteryDao;

    /**
     * 查询分页
     *
     * @param managePage
     * @param macManage
     * @return
     */
    @Override
    public Page<MacManage> find(Page<MacManage> managePage, MacManage macManage) {
        Page<MacManage> page = findPage(managePage, macManage);
        List<MacManage> list = page.getList();
        for (MacManage manage : list) {
            if (manage.getLotName() != null) {
                manage.setLotNameTitle(manage.getLotName());
                if (manage.getLotName().length() > 25) {
                    manage.setLotName(manage.getLotName().substring(0, 25) + "····");
                }
            }
        }
        return page;
    }

    /**
     * 更新或保存票机数据
     *
     * @param mac
     * @param flag
     */
    @Override
    public void merge(MacManage mac, boolean flag) {
        try {
            if (saveReturnId(mac) > 0) {
                if (this.insertMacLottery(mac, flag) >= 0) {
                    logger.info("保存或更新票机数据成功！，保存或更新票机彩种中间表数据成功！");
                } else {
                    logger.error("保存或更新票机彩种中间表数据失败！");
                }
            } else {
                logger.error("票机数据保存或更新失败！");
            }
        } catch (Exception e) {
            log.info("更新或新加票机数据失败！");
            e.printStackTrace();
        }
    }

    /**
     * 为票机彩种中间表添加or修改
     *
     * @param mac
     * @param flag
     * @return
     */
    private int insertMacLottery(MacManage mac, boolean flag) {
        int id = 0;
        try {
            if (!flag) {
                //delete
                id = macUnionLotteryDao.deleteUnion(mac.getMacId());
            }
            if (id >= 0) {
                List<MacUnionLottery> list = new ArrayList();
                if (mac.getLotNames() != null) {
                    for (int i = 0; i < mac.getLotNames().length; i++) {
                        MacUnionLottery unionLottery = new MacUnionLottery();
                        unionLottery.setLotId(Integer.parseInt(mac.getLotNames()[i]));
                        unionLottery.setMacId(mac.getMacId());
                        list.add(unionLottery);
                    }
                    id = macUnionLotteryDao.insert(list);
                    if (id > 0) {
                        logger.info("保存票机彩种中间表成功! 票机id为{}", mac.getMacId());
                    }
                } else {
                    logger.info("当前票机{}没有可保存的彩种数据", mac.getMacId());
                }
            } else {
                logger.error("根据票机删除票机彩种中间表失败,失败的票机编号为:{}", mac.getMacId());
            }
        } catch (NumberFormatException e) {
            logger.error("票机彩种id数字转换异常！票机编号为{}", mac.getMacId());
            e.printStackTrace();
        } catch (Exception e) {
            logger.error("票机彩种保存数据失败!票机编号为{}", mac.getMacId());
            e.printStackTrace();
        }
        return id;
    }

    /**
     * 每天凌晨 重置当日票机金额、张数为0
     */
    @Scheduled(cron = "0 0 0 * * ?")
   /* @Scheduled(cron = "0/60 * * * * ?")*/
    @Override
    public void restRecord() {
        try {
            log.info("开始重置票机打印张数与总金额");
            int id = recordDao.insertRecord();
            if (id != 0) {
                int maxId = dao.updateRestRecord();
                if (maxId != 0) {
                    log.info("票机记录保存成功！，票机重置当日打票金额与张数成功！");
                }
            }
        } catch (Exception e) {
            log.info("重置票机打印张数与金额失败！");
            e.printStackTrace();
        }
    }


    /**
     * 获取所有的票机
     *
     * @return
     */
    @Override
    public List<String> byMacId() {
        return dao.byMacId();
    }

    @Override
    public void deleteManage(MacManage macManage) {
        try {
            int affectId = macUnionLotteryDao.deleteUnion(macManage.getMacId());
            if (affectId >= 0) {
                int id = dao.delete(macManage);
                if (id >= 0) {
                    logger.info("删除票机成功！ 删除票机彩种中间表成功！删除的票机编号为：{}", macManage.getMacId());
                } else {
                    log.error("删除票机数据失败！，根据票机编号为{}", macManage.getMacId());
                }
            } else {
                log.error("删除票机和彩种中间表数据失败！，根据票机编号为{}", macManage.getMacId());
            }
        } catch (Exception e) {
            log.error("票机数据或票机彩种中间表数据删除失败，根据票机编号为{}", macManage.getMacId());
            e.printStackTrace();
        }
    }

}
