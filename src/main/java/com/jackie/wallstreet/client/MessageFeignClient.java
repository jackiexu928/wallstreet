package com.jackie.wallstreet.client;

import com.jackie.stockbean.message.dto.request.MailReqDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Created with IntelliJ IDEA
 * Description:
 *
 * @author xujj
 * @date 2021/4/12
 */
@FeignClient("message")
public interface MessageFeignClient {

    @PostMapping("message/sendMail")
    String sendMail(MailReqDTO reqDTO);
}
