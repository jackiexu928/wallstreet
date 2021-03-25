package com.jackie.wallstreet.domain.query;

import org.apache.commons.lang.StringUtils;

/**
 * Created with IntelliJ IDEA
 * Description:
 *
 * @author xujj
 * @date 2021/3/24
 */
public class SearchQuery implements WallStreetCnQuery{
    private String query;
    private String channel;
    private Integer limit;
    private Integer score;

    @Override
    public String getParamsStr() {
        return "channel=" + channel + "&limit=" + limit + "&score=" + score +
                (StringUtils.isNotEmpty(query) ? "&query=" + query : "");
    }

    public SearchQuery(String channel, String query) {
        this.channel = channel;
        this.limit = 20;
        this.query = query;
        this.score = StringUtils.isNotEmpty(query) ? 0 : 2;
    }
}
