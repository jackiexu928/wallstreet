package com.jackie.wallstreet.entity;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 * Description:
 *
 * @author xujj
 * @date 2021/3/25
 */
@Data
public class ImportantNews {
    private Long id;
    private String channelName;            //分组：要闻，A股···
    private String channels;
    private String contentMore;
    private String contentText;
    private Date displayTime;
    private String globalChannelName;
    private String globalMoreUri;
    private Long contentId;
    private String imageUris;
    private Boolean isCalendar;
    private Boolean isFavourite;
    private Boolean isPriced;
    private Boolean isScaling;
    private String reference;
    private String relatedThemes;
    private Integer score;
    private String symbols;                 //关联的股票
    private String tags;
    private String title;
    private String type;
}
