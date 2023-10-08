package cn.zfy.school.message.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (ReplyInfo)实体类
 *
 * @author makejava
 * @since 2023-09-27 09:39:20
 */
public class ReplyInfo implements Serializable {
    private static final long serialVersionUID = -66074438988528201L;

    private Integer id;

    private Integer messageId;

    private Integer authorAccount;

    private String authorName;

    private String content;

    private String date;

    private int pageNumber;      // 当前页码
    private int pageSize;        // 每页数据数量
    private int startNumber;    //开始页码

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getStartNumber() {
        return startNumber;
    }

    public void setStartNumber(int startNumber) {
        this.startNumber = startNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public Integer getAuthorAccount() {
        return authorAccount;
    }

    public void setAuthorAccount(Integer authorAccount) {
        this.authorAccount = authorAccount;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "ReplyInfo{" +
                "id=" + id +
                ", messageId=" + messageId +
                ", authorAccount=" + authorAccount +
                ", authorName='" + authorName + '\'' +
                ", content='" + content + '\'' +
                ", date='" + date + '\'' +
                ", pageNumber=" + pageNumber +
                ", pageSize=" + pageSize +
                ", startNumber=" + startNumber +
                '}';
    }
}

