package com.jackie.wallstreet.entity;

import lombok.Data;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: Jackie Xu
 * @date: 2021-03-28
 */
@Data
public class MessageRecord {
    private Long id;
    private Long contentId;
    private String title;
    private String contentText;
    private Date createTime;
}
