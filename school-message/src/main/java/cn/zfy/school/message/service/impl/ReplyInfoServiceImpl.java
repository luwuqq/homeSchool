package cn.zfy.school.message.service.impl;

import cn.zfy.school.message.entity.ReplyInfo;
import cn.zfy.school.message.dao.ReplyInfoDao;
import cn.zfy.school.message.service.ReplyInfoService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * (ReplyInfo)表服务实现类
 *
 * @author makejava
 * @since 2023-09-27 09:39:20
 */
@Service("replyInfoService")
public class ReplyInfoServiceImpl implements ReplyInfoService {
    @Resource
    private ReplyInfoDao replyInfoDao;

    @Override
    public int replyMessage(ReplyInfo replyInfo) {

        return replyInfoDao.replyMessage(replyInfo);
    }

    @Override
    public int deleteReply(Integer id) {
        return replyInfoDao.deleteReply(id);
    }

    @Override
    public List<ReplyInfo> selectReplyInfoByMessageId(ReplyInfo replyInfo) {

        return replyInfoDao.selectReplyInfoByMessageId(replyInfo);
    }
}
