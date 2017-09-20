package com.thinkgem.jeesite.modules.terminal.service;


import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.modules.terminal.entity.MacManage;

import java.util.List;

/**
 * Created by lijunke on 2017/8/3.
 * 票机预警service
 */

public interface MacManageService {

    /**
     * 根据机器编号，是否启用查询所有数据
     *
     * @param managePage
     * @param macManage
     * @return
     */
    Page<MacManage> find(Page<MacManage> managePage, MacManage macManage);


    /**
     * 根据MacId查询，返回单个对象
     *
     * @param macId
     * @return
     */
    MacManage get(String macId);


    /**
     * 更新或保存数据
     *
     * @param mac
     * @param flag
     */
    void merge(MacManage mac, boolean flag);

    /**
     * 删除票机
     * @param macManage
     */
    void delete(MacManage macManage);


    /**
     * 重置当日金额、张数为0
     */
    void restRecord();


    /**
     * 获取所有的票机id
     * @return
     */
    List<String> byMacId();


    void deleteManage(MacManage macManage);
}
