package com.jackie.wallstreet.factory;

import com.alibaba.fastjson.JSON;
import com.jackie.stockbean.wallstreet.entity.ImportantNews;
import com.jackie.wallstreet.domain.response.HttpItem;

import java.util.Date;

/**
 * Created with IntelliJ IDEA
 * Description:
 *     private Boolean isCalendar;
 *     private Boolean isFavourite;
 *     private Boolean isPriced;
 *     private Boolean isScaling;
 *     private String reference;
 *     private String relatedThemes;
 *     private Integer score;
 *     private String symbols;
 *     private String tags;
 *     private String title;
 *     private String type;
 *
 * @author xujj
 * @date 2021/3/25
 */
public class ImportaneNewsFactory {
    public static ImportantNews getEntity(HttpItem item, String channelName){
        ImportantNews importantNews = new ImportantNews();
        importantNews.setChannelName(channelName);
        importantNews.setChannels(JSON.toJSONString(item.getChannels()));
        importantNews.setContentMore(item.getContentMore());
        importantNews.setContentText(item.getContentText());
        importantNews.setDisplayTime(new Date(item.getDisplayTime() * 1000));
        importantNews.setGlobalChannelName(item.getGlobalChannelName());
        importantNews.setGlobalMoreUri(item.getGlobalMoreUri());
        importantNews.setContentId(item.getId());
        importantNews.setImageUris(JSON.toJSONString(item.getImageUris()));
        importantNews.setIsCalendar(item.getIsCalendar());
        importantNews.setIsFavourite(item.getIsFavourite());
        importantNews.setIsPriced(item.getIsPriced());
        importantNews.setIsScaling(item.getIsScaling());
        importantNews.setReference(item.getReference());
        importantNews.setRelatedThemes(JSON.toJSONString(item.getRelatedThemes()));
        importantNews.setScore(item.getScore());
        importantNews.setSymbols(JSON.toJSONString(item.getSymbols()));
        importantNews.setTags(JSON.toJSONString(item.getTags()));
        importantNews.setTitle(item.getTitle());
        importantNews.setType(item.getType());
        return importantNews;
    }
}
