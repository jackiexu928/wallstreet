package com.jackie.wallstreet.schedule;

import com.jackie.wallstreet.service.WallStreetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * Created with IntelliJ IDEA
 * Description:
 *
 * @author xujj
 * @date 2021/3/25
 */
@Configuration
@EnableScheduling
@Slf4j
public class WallStreetTask {
    @Autowired
    private WallStreetService wallStreetService;

    /**
     * 只看重要的
     * 每半小时查询入库
     */
    @Scheduled(cron = "0 0/30 * * * ?")
    private void getImportantNews(){
        wallStreetService.saveInfo();
    }

    /**
     * 查看普通快讯
     * 如包含重要信息，则以email的方式发送
     * 间隔10分钟
     */
    @Scheduled(cron = "0 0/15 * * * ?")
    private void getContent(){
        wallStreetService.glanceOver();
    }
}
