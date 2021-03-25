package com.jackie.wallstreet.domain.response;

import lombok.Data;

import java.util.List;

/**
 * Created with IntelliJ IDEA
 * Description:
 *
 * @author xujj
 * @date 2021/3/24
 */
@Data
public class HttpData {
    private Integer count;
    private List<HttpItem> items;
    private String nextCursor;
    private String searchId;
}
