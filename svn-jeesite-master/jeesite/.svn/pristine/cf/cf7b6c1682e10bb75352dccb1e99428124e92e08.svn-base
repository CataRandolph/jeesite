package com.thinkgem.jeesite.modules.terminal.task;

import com.thinkgem.jeesite.modules.sys.utils.DictUtils;
import com.thinkgem.jeesite.modules.terminal.service.TicketInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Lazy(false)
@Component("ticketExportTxtJob")
public class TicketExportTxtJob {

    @Autowired
    TicketInfoService service;

    @Value("${ticket.txtTitle}")
    String fileName;

    @Scheduled(cron = "0 50 05 ? * *")
    public void export() {
        String baseDir = DictUtils.getDictValue("ticketFile");
        service.exportTxt(fileName,baseDir);
    }
}