package com.jackie.wallstreet.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created with IntelliJ IDEA
 * Description:
 *
 * @author xujj
 * @date 2021/3/25
 */
@FeignClient("shares")
public interface SharesFeignClient {

    @GetMapping("/select/getSelectRecords")
    String getSelectRecords();
}
