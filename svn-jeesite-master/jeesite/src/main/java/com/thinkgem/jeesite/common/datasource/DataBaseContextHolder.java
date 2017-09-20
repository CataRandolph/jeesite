package com.thinkgem.jeesite.common.datasource;

/**
 * Created by lijunke on 2017/9/6.
 * <p>
 * 通过threadLoad存储dataSource
 */
public class DataBaseContextHolder {

    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();


    public static String getCurrentLookupKey() {
        return contextHolder.get();
    }


    public static void setCurrentLookupKey(String currentLookupKey) {
        contextHolder.set(currentLookupKey);
    }


    public static void removeCurrentLookupKey() {
        contextHolder.remove();
    }
}
