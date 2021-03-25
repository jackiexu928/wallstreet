package com.jackie.wallstreet.factory;

import com.jackie.wallstreet.domain.query.ContentQuery;
import com.jackie.wallstreet.domain.query.SearchQuery;
import com.jackie.wallstreet.domain.query.WallStreetCnQuery;
import org.apache.commons.lang.StringUtils;

/**
 * Created with IntelliJ IDEA
 * Description:
 *
 * @author xujj
 * @date 2021/3/24
 */
public class WallStreetQueryFactory {
    public static WallStreetCnQuery getQuery(String queryType, String channel, String query){
        if (StringUtils.isNotEmpty(queryType)){
            if (queryType.equalsIgnoreCase("Content")){
                return new ContentQuery(channel);
            } else if (queryType.equalsIgnoreCase("Search")){
                return new SearchQuery(channel, query);
            }
        }
        return null;
    }
}
