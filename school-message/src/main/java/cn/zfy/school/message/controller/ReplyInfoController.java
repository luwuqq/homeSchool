package cn.zfy.school.message.controller;

import cn.zfy.school.common.utils.DateUtil;
import cn.zfy.school.message.entity.MessageInfo;
import cn.zfy.school.message.entity.ReplyInfo;
import cn.zfy.school.message.service.ReplyInfoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (ReplyInfo)表控制层
 *
 * @author makejava
 * @since 2023-09-27 09:39:20
 */
@RestController
@RequestMapping("message/replyInfo")
public class ReplyInfoController {
    /**
     * 服务对象
     */
    @Resource
    private ReplyInfoService replyInfoService;

    /**
     * 回复消息
     */
    @RequestMapping("replyMessage")
    public int replyMessage(@RequestBody ReplyInfo replyInfo) {
        String date = DateUtil.getStringDateShort();
        replyInfo.setDate(date);
        System.out.println(replyInfo.toString());
        return replyInfoService.replyMessage(replyInfo);
    }

    @RequestMapping("selectReplyInfoByMessageId")
    public List<ReplyInfo> selectReplyInfoByMessageId(@RequestBody ReplyInfo replyInfo) {
        int startNumber = (replyInfo.getPageNumber() - 1) * replyInfo.getPageSize();
        replyInfo.setStartNumber(startNumber);
        System.out.println(replyInfo.toString());
//        System.out.println(replyInfoService.selectReplyInfoByMessageId(replyInfo.getMessageId()).toString());
        return replyInfoService.selectReplyInfoByMessageId(replyInfo);
    }

    /**
     * 删除回复
     */
    @RequestMapping("deleteReply")
    public int deleteReply(@RequestBody ReplyInfo replyInfo) {
        return replyInfoService.deleteReply(replyInfo.getId());
    }

}

