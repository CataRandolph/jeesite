package com.thinkgem.jeesite.common.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import static com.thinkgem.jeesite.common.datasource.DataBaseContextHolder.getCurrentLookupKey;

/**
 * Created by lijunke on 2017/9/6.
 * <p>
 * 动态数据源
 *
 * 返回map中的数据源
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return getCurrentLookupKey();
    }
}
