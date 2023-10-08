package cn.zfy.school.message.dao;

import cn.zfy.school.message.entity.MessageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * (MessageInfo)表数据库访问层
 *
 * @author makejava
 * @since 2023-09-27 09:38:58
 */
public interface MessageInfoDao {


    int sendMessage(MessageInfo messageInfo);

    int deleteMessage(Integer id);

    List<MessageInfo> selectMessageInfoByClassNumberOrAccount(MessageInfo messageInfo);

    List<MessageInfo> selectMessageInfoAndReplyInfoById(MessageInfo messageInfo);
}

