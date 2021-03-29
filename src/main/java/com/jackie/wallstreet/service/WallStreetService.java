package com.jackie.wallstreet.service;

import com.alibaba.fastjson.JSON;
import com.jackie.wallstreet.client.SharesFeignClient;
import com.jackie.wallstreet.commom.WallStreetChannel;
import com.jackie.wallstreet.domain.response.HttpItem;
import com.jackie.wallstreet.entity.ImportantNews;
import com.jackie.wallstreet.factory.ImportaneNewsFactory;
import com.jackie.wallstreet.mapper.ImportantNewsMapper;
import com.jackie.wallstreet.util.WallStreetUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.ListUtil;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 * Description:
 *
 * @author xujj
 * @date 2021/3/25
 */
@Service
public class WallStreetService {
    @Autowired
    private ImportantNewsMapper importantNewsMapper;
    @Autowired
    private SharesFeignClient sharesFeignClient;
    @Autowired
    private MailService mailService;

    private static final String[] DEPARTMENT = {"国务院", "财政部", "中国人民银行", "国家发展和改革委员会", "发改委", "商务部",
            "国家统计局", "国务院国有资产监督委员会",
            "加密货币","比特币","以太坊"};

    /**
     * 1.从华尔街见闻网站获取信息
     * 2.如果该条信息在数据库中已存在，则跳过
     * 3.保存信息
     */
    public void saveInfo(){
        List<HttpItem> globalList = WallStreetUtil.getImportantInfo(WallStreetChannel.GLOBAL, null);
        checkAndSave(globalList, WallStreetChannel.GLOBAL);
        List<HttpItem> aStockList = WallStreetUtil.getImportantInfo(WallStreetChannel.A_STOCK, null);
        checkAndSave(aStockList, WallStreetChannel.A_STOCK);
    }

    private void checkAndSave(List<HttpItem> list, WallStreetChannel channel){
        if (list != null){
            for (int i = list.size() - 1; i >= 0; i --){
                ImportantNews importantNews = ImportaneNewsFactory.getEntity(list.get(i), channel.getName());
                int exist = importantNewsMapper
                        .selectByChannelAndContentId(importantNews.getChannelName(), importantNews.getContentId());
                if (exist > 0){
                    continue;
                }
                importantNewsMapper.insert(importantNews);
            }
        }
    }

    /**
     * 浏览快讯，
     * 如果内容包含国务院、财政部、中国人民银行、国家发展和改革委员会（发改委）、商务部、国家统计局、国务院国有资产监督委员会
     * 如果内容包含持有的个股
     * 将内容整合发送email
     */
    public void glanceOver(){
        List<HttpItem> list = WallStreetUtil.getInfomation(WallStreetChannel.GLOBAL);
        List<HttpItem> aStockList = WallStreetUtil.getInfomation(WallStreetChannel.A_STOCK);
        list.addAll(aStockList);
        //查询持有的股票
        String selectRecord = sharesFeignClient.getSelectRecords();
        List<String> selectRecordList = null;
        if (StringUtils.isNotEmpty(selectRecord)) {
            selectRecordList = JSON.parseArray(selectRecord, String.class);
        }
        List<HttpItem> filterList = filterInfo(list, selectRecordList);
        if (ListUtil.isNotEmpty(filterList)){
            StringBuilder stringBuilder = new StringBuilder();
            filterList.forEach(item -> {
                Date date = new Date(item.getDisplayTime() * 1000);
                SimpleDateFormat sdf = new SimpleDateFormat("MM-dd hh:mm");
                stringBuilder.append(sdf.format(date) + "\n");
                stringBuilder.append(item.getContentText() + "\n");
                stringBuilder.append("-------------------------------------------------------------------------------");
            });
            mailService.sendSimpleMail("137469680@qq.com;2543721625@qq.com", "WallStreet", stringBuilder.toString());
        }
    }

    private List<HttpItem> filterInfo(List<HttpItem> list, List<String> recordList){
        List<HttpItem> filterList = new ArrayList<>();
        my: for(HttpItem item : list){
            for (String dept : DEPARTMENT){
                if (item.getContentText().contains(dept)){
                    filterList.add(item);
                    continue my;
                }
            }
            for (String record : recordList){
                if (item.getContentText().contains(record)){
                    filterList.add(item);
                    continue my;
                }
            }
        }
        return filterList;
    }
}
