package com.thinkgem.jeesite.common.datasource;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * Created by lijunke on 2017/9/6.
 * <p>
 * 数据源拦截器，切面处理
 */
@Aspect
@Component
public class DataSourceInterceptor implements Serializable{

    @Pointcut("execution(* com.thinkgem.jeesite.*.*.dao.*.*(..))")
    public void dataSource() {
    }

    @Pointcut("execution(* com.thinkgem.jeesite.*.*.dal.*.*(..))")
    public void dataSourceTwo() {
    }


    @Before(value = "dataSource()")
    public void setDataSource(JoinPoint joinpoint) {
        DataBaseContextHolder.setCurrentLookupKey("dataSource");
    }

    @Before(value = "dataSourceTwo()")
    public void setDataSourceTwo(JoinPoint joinpoint) {
        DataBaseContextHolder.setCurrentLookupKey("dataSourceTwo");
    }


}
