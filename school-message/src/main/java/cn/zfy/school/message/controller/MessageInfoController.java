package cn.zfy.school.message.controller;

import cn.zfy.school.common.utils.DateUtil;
import cn.zfy.school.message.entity.MessageInfo;
import cn.zfy.school.message.service.MessageInfoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * (MessageInfo)表控制层
 *
 * @author makejava
 * @since 2023-09-27 09:38:57
 */
@RestController
@RequestMapping("message/messageInfo")
public class MessageInfoController {
    /**
     * 服务对象
     */
    @Resource
    private MessageInfoService messageInfoService;

    /**
     * 发送消息
     */
    @RequestMapping("sendMessage")
    public int sendMessage(@RequestBody MessageInfo messageInfo) {
        String date = DateUtil.getStringDateShort();
        messageInfo.setDate(date);
//        System.out.println(messageInfoService.sendMessage(messageInfo));
        return messageInfoService.sendMessage(messageInfo);
    }

    /**
     * 删除消息
     */
    @RequestMapping("deleteMessage")
    public int deleteMessage(@RequestBody MessageInfo messageInfo) {
        return messageInfoService.deleteMessage(messageInfo.getId());
    }

    @RequestMapping("selectMessageInfoByClassNumberOrAccount")
    public List<MessageInfo> selectMessageInfoByClassNumberOrAccount(@RequestBody MessageInfo messageInfo) {
        int startNumber = (messageInfo.getPageNumber() - 1) * messageInfo.getPageSize();
        messageInfo.setStartNumber(startNumber);
//        System.out.println(messageInfo.toString());
        return messageInfoService.selectMessageInfoByClassNumberOrAccount(messageInfo);
    }

    @RequestMapping("selectMessageInfoAndReplyInfoById")
    public List<MessageInfo> selectMessageInfoAndReplyInfoById(@RequestBody MessageInfo messageInfo) {
        int startNumber = (messageInfo.getPageNumber() - 1) * messageInfo.getPageSize();
        messageInfo.setStartNumber(startNumber);
        return messageInfoService.selectMessageInfoAndReplyInfoById(messageInfo);
    }
}

