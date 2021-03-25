package com.jackie.wallstreet.domain.response;

import lombok.Data;

/**
 * Created with IntelliJ IDEA
 * Description:
 *
 * @author xujj
 * @date 2021/3/24
 */
@Data
public class HttpResponse {
    private Integer code;
    private String message;
    private HttpData data;
}
