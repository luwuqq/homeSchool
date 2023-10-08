package cn.zfy.school.message.service;

import cn.zfy.school.message.entity.ReplyInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (ReplyInfo)表服务接口
 *
 * @author makejava
 * @since 2023-09-27 09:39:20
 */
public interface ReplyInfoService {

    int replyMessage(ReplyInfo replyInfo);

    int deleteReply(Integer id);

    List<ReplyInfo> selectReplyInfoByMessageId(ReplyInfo replyInfo);
}
