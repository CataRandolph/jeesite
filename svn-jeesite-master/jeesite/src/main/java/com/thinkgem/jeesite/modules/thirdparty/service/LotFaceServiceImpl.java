package com.thinkgem.jeesite.modules.thirdparty.service;

import com.thinkgem.jeesite.modules.thirdparty.dal.LotFaceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lijunke on 2017/9/6.
 */

@Service
public class LotFaceServiceImpl implements LotFaceService{

    @Autowired
    LotFaceDao lotFaceDao;

    @Override
    public int count() {
        return lotFaceDao.count();
    }
}
