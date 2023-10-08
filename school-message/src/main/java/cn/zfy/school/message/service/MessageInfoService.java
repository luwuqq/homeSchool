package cn.zfy.school.message.service;

import cn.zfy.school.message.entity.MessageInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * (MessageInfo)表服务接口
 *
 * @author makejava
 * @since 2023-09-27 09:39:00
 */
public interface MessageInfoService {

    int sendMessage(MessageInfo messageInfo);

    int deleteMessage(Integer id);

    List<MessageInfo> selectMessageInfoByClassNumberOrAccount(MessageInfo messageInfo);

    List<MessageInfo> selectMessageInfoAndReplyInfoById(MessageInfo messageInfo);
}
