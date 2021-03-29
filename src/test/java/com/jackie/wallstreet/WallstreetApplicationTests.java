package com.jackie.wallstreet;

import com.jackie.wallstreet.service.MailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WallstreetApplicationTests {
    @Autowired
    private MailService mailService;

    @Test
    void contextLoads() {
    }

    @Test
    void testMessage(){
        mailService.sendSimpleMail("jackiemagic@sina.com;137469680@qq.com", "test", "测试");
    }

}
