package com.jackie.wallstreet;

import com.jackie.stockbean.message.dto.request.MailReqDTO;
import com.jackie.wallstreet.client.MessageFeignClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WallstreetApplicationTests {
    @Autowired
    private MessageFeignClient messageFeignClient;

    @Test
    void contextLoads() {
    }

    @Test
    void testMessageClient(){
        MailReqDTO reqDTO = new MailReqDTO();
        reqDTO.setTo("jackiemagic@sina.com");
        reqDTO.setSubject("test");
        reqDTO.setContent("testttt");
        messageFeignClient.sendMail(reqDTO);
    }

}
