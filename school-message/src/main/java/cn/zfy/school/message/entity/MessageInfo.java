package cn.zfy.school.message.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (MessageInfo)实体类
 *
 * @author makejava
 * @since 2023-09-27 09:38:59
 */
public class MessageInfo implements Serializable {
    private static final long serialVersionUID = -15490067492529763L;

    private Integer id;

    private Integer authorAccount;

    private Integer classNumber;

    private String course;

    private String content;

    private String date;

    private int pageNumber;      // 当前页码
    private int pageSize;        // 每页数据数量
    private int startNumber;    //开始页码

    private ReplyInfo replyInfo;

    public ReplyInfo getReplyInfo() {
        return replyInfo;
    }

    public void setReplyInfo(ReplyInfo replyInfo) {
        this.replyInfo = replyInfo;
    }

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

    public Integer getAuthorAccount() {
        return authorAccount;
    }

    public void setAuthorAccount(Integer authorAccount) {
        this.authorAccount = authorAccount;
    }

    public Integer getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(Integer classNumber) {
        this.classNumber = classNumber;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
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
        return "MessageInfo{" +
                "id=" + id +
                ", authorAccount=" + authorAccount +
                ", classNumber=" + classNumber +
                ", course='" + course + '\'' +
                ", content='" + content + '\'' +
                ", date='" + date + '\'' +
                ", pageNumber=" + pageNumber +
                ", pageSize=" + pageSize +
                ", startNumber=" + startNumber +
                ", replyInfo=" + replyInfo +
                '}';
    }
}

