package com.jackie.wallstreet.domain.response;

import com.sun.corba.se.spi.ior.ObjectKey;
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
public class HttpItem {
    private String article;
    private Object author;
    private List<String> channels;
    private Integer commentCount;
    private String content;
    private String contentMore;
    private String contentText;
    private Long displayTime;
    private List<String> fundCodes;
    private String globalChannelName;
    private String globalMoreUri;
    private Boolean hasLiveReading;
    private Long id;
    private List<String> imageUris;
    private Boolean isCalendar;
    private Boolean isFavourite;
    private Boolean isPriced;
    private Boolean isScaling;
    private String reference;
    private List<Object> relatedThemes;
    private Integer score;
    private List<Object> symbols;
    private List<Object> tags;
    private String title;
    private String type;
}
