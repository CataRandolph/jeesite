package com.example.demo.action;

import com.example.demo.service.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lijunke on 2017/7/18.
 */

@RestController
public class DubboController {

    @Autowired
    public ResponseService response;

    @RequestMapping(value = "/invoke")
    @ResponseBody
    public String invoke(){
        String message = response.reply();
        return message;
    }

}
