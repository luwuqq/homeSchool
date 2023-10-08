package cn.zfy.school.message.dao;

import cn.zfy.school.message.entity.ReplyInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (ReplyInfo)表数据库访问层
 *
 * @author makejava
 * @since 2023-09-27 09:39:20
 */
public interface ReplyInfoDao {

    int replyMessage(ReplyInfo replyInfo);

    int deleteReply(Integer id);

    List<ReplyInfo> selectReplyInfoByMessageId(ReplyInfo replyInfo);
}

