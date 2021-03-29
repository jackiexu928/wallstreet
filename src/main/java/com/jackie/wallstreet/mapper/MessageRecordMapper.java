package com.jackie.wallstreet.mapper;

import com.jackie.wallstreet.entity.MessageRecord;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: Jackie Xu
 * @date: 2021-03-28
 */
@Mapper
public interface MessageRecordMapper {

    @Select("select count(*) from message_record where content_id = #{contentId}")
    int selectCountByContentId(Long contentId);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into message_record(content_id, title, content_text, create_time) " +
            "values(#{contentId}, #{title}, #{contentText}, #{createTime})")
    int insert(MessageRecord record);
}
