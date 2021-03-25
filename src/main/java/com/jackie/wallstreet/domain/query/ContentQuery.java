package com.jackie.wallstreet.domain.query;

import lombok.Data;

/**
 * Created with IntelliJ IDEA
 * Description:
 * channel: global-channel
 *      * client: pc
 *      * limit: 20
 *      * first_page: true
 *      * accept: live,vip-live
 *
 * @author xujj
 * @date 2021/3/24
 */
@Data
public class ContentQuery implements WallStreetCnQuery{
    private String channel;
    private String client;
    private Integer limit;
    private Boolean firstPage;
    private String accept;

    @Override
    public String getParamsStr() {
        return "channel=" + channel + "&client=" + client + "&limit=" + limit + "&first_page=" + firstPage + "&accept=" + accept;
    }

    public ContentQuery(String channel) {
        this.channel = channel;
        this.client = "pc";
        this.limit = 20;
        this.firstPage = true;
        this.accept = "live,vip-live";
    }
}
