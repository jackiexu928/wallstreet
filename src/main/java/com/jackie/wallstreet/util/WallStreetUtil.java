package com.jackie.wallstreet.util;

import com.alibaba.fastjson.JSON;
import com.jackie.wallstreet.commom.WallStreetChannel;
import com.jackie.wallstreet.domain.query.WallStreetCnQuery;
import com.jackie.wallstreet.domain.response.HttpItem;
import com.jackie.wallstreet.domain.response.HttpResponse;
import com.jackie.wallstreet.factory.WallStreetQueryFactory;
import util.ListUtil;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 * Description:
 *
 * @author xujj
 * @date 2021/3/24
 */
public class WallStreetUtil {
    /**
     * 要闻：https://api.wallstcn.com/apiv1/content/lives
     * 参数：
     * channel: global-channel
     * client: pc
     * limit: 20
     * first_page: true
     * accept: live,vip-live
     */
    /**
     * 要闻搜索：https://api.wallstcn.com/apiv1/search/live
     * 参数：
     * query: 以太坊
     * channel: global-channel
     * limit: 20
     * score: 0
     */
    /**
     * 要闻-只看重要的：https://api.wallstcn.com/apiv1/search/live
     * 参数：
     * channel: global-channel
     * limit: 20
     * score: 2
     */
    /**
     * A股：https://api.wallstcn.com/apiv1/content/lives
     * 参数：
     * channel: a-stock-channel
     * client: pc
     * limit: 20
     * first_page: true
     * accept: live,vip-live
     */
    /**
     * A股搜索：https://api.wallstcn.com/apiv1/search/live
     * 参数：
     * query: 贵州茅台
     * channel: a-stock-channel
     * limit: 20
     * score: 0
     */
    /**
     * A股-只看重要的：https://api.wallstcn.com/apiv1/search/live
     * 参数：
     * channel: a-stock-channel
     * limit: 20
     * score: 2
     */

    private static final String API_URL = "https://api.wallstcn.com/apiv1/";
    private static final String CONTENT_URL = "content/lives";
    private static final String SEARCH_URL = "search/live";
    private static final String GLOBAL = "global-channel";
    private static final String A_STOCK = "a-stock-channel";

    public static HttpResponse getInfoFromWallStreet(String httpUrl){
        try {
            URL url = new URL(httpUrl);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestProperty("accept", "*/*");
            con.setRequestProperty("connection", "Keep-Alive");
            con.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
            con.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
            con.setInstanceFollowRedirects(false);
            con.setUseCaches(false);
            con.setAllowUserInteraction(false);
            con.connect();
            StringBuffer sb = new StringBuffer();
            String line = "";
            BufferedReader URLinput = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
            while ((line = URLinput.readLine()) != null) {
                sb.append(line);
            }
            con.disconnect();
            String ss = sb.toString().toLowerCase();
            //System.out.println(ss);
            return JSON.parseObject(ss, HttpResponse.class);
        } catch (Exception e){
            return null;
        }
    }

    /**
     * 获取快讯
     * @param channel
     * @return
     */
    public static List<HttpItem>  getInfomation(WallStreetChannel channel){
        WallStreetCnQuery query = WallStreetQueryFactory.getQuery("Content", channel.getChannel(), null);
        HttpResponse response = getInfoFromWallStreet(API_URL + CONTENT_URL + "?" + query.getParamsStr());
        if (response != null && response.getData() != null && ListUtil.isNotEmpty(response.getData().getItems())){
            return response.getData().getItems();
        }
        return null;
    }

    /**
     * 快讯-只看重要的/搜索
     * @param channel
     * @param query
     * @return
     */
    public static List<HttpItem> getImportantInfo(WallStreetChannel channel, String query){
        WallStreetCnQuery wallStreetCnQuery = WallStreetQueryFactory.getQuery("Search", channel.getChannel(), query);
        HttpResponse response = getInfoFromWallStreet(API_URL + SEARCH_URL + "?" + wallStreetCnQuery.getParamsStr());
        if (response != null && response.getData() != null && ListUtil.isNotEmpty(response.getData().getItems())){
            return response.getData().getItems();
        }
        return null;
    }



    public static void main(String[] args) {
        WallStreetCnQuery query = WallStreetQueryFactory.getQuery("Search", GLOBAL, null);
        String httpUrl = API_URL + SEARCH_URL + "?" + query.getParamsStr();
        HttpResponse infoFromWallStreet = getInfoFromWallStreet(httpUrl);
        System.out.println(JSON.toJSONString(infoFromWallStreet));
        /*long l = 1616635943000l;//2021-03-25 09：32
        Date date = new Date(l);
        System.out.println("ll");*/
    }

}
