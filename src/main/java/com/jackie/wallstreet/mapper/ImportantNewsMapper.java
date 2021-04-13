package com.jackie.wallstreet.mapper;

import com.jackie.stockbean.wallstreet.entity.ImportantNews;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

/**
 * Created with IntelliJ IDEA
 * Description:
 *
 * @author xujj
 * @date 2021/3/25
 */
@Mapper
public interface ImportantNewsMapper {

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into important_news(channel_name, channels, content_more, content_text, display_time, " +
            "global_channel_name, global_more_uri, content_id, image_uris, is_calendar, is_favourite, is_priced, " +
            "is_scaling, reference, related_themes, score, symbols, tags, title, type) " +
            "values(#{channelName}, #{channels}, #{contentMore}, #{contentText}, #{displayTime}, " +
            "#{globalChannelName}, #{globalMoreUri}, #{contentId}, #{imageUris}, #{isCalendar}, #{isFavourite}, #{isPriced}, " +
            "#{isScaling}, #{reference}, #{relatedThemes}, #{score}, #{symbols}, #{tags}, #{title}, #{type})")
    int insert(ImportantNews importantNews);

    @Select("select count(id) from important_news where channel_name = #{channelName} and content_id = #{contentId}")
    int selectByChannelAndContentId(String channelName, Long contentId);
}
