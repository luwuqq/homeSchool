package cn.zfy.school.message.service.impl;

import cn.zfy.school.message.entity.MessageInfo;
import cn.zfy.school.message.dao.MessageInfoDao;
import cn.zfy.school.message.service.MessageInfoService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * (MessageInfo)表服务实现类
 *
 * @author makejava
 * @since 2023-09-27 09:39:00
 */
@Service("messageInfoService")
public class MessageInfoServiceImpl implements MessageInfoService {
    @Resource
    private MessageInfoDao messageInfoDao;

    @Override
    public int sendMessage(MessageInfo messageInfo) {
        return messageInfoDao.sendMessage(messageInfo);
    }

    @Override
    public int deleteMessage(Integer id) {
        return messageInfoDao.deleteMessage(id);
    }

    @Override
    public List<MessageInfo> selectMessageInfoByClassNumberOrAccount(MessageInfo messageInfo) {

        return messageInfoDao.selectMessageInfoByClassNumberOrAccount(messageInfo);
    }

    @Override
    public List<MessageInfo> selectMessageInfoAndReplyInfoById(MessageInfo messageInfo) {
        return messageInfoDao.selectMessageInfoAndReplyInfoById(messageInfo);
    }
}
