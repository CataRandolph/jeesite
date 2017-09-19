package com.example.demo.service;

import com.alibaba.dubbo.config.annotation.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by lijunke on 2017/7/18.
 */
@Component
public class ResponseServiceImpl implements ResponseService {
    private static final Logger log = LoggerFactory.getLogger(ResponseServiceImpl.class);


    @Reference(version = "1.0.0")
    public RequestService requestService;


    @Override
    public String reply() {
        String message = requestService.sayHello();
        log.info("调用dubbo接口接收的内容为：" + message);
        return message;
    }
}
