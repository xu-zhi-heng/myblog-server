package com.sweetfun.domain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentFeedBacks {
    private Integer id;
    private Integer userId;
    private Timestamp createTime;
    private Integer commentId;
    private String content;
    private Integer status;
    private Integer supportNum;
    private Integer againstNum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getSupportNum() {
        return supportNum;
    }

    public void setSupportNum(Integer supportNum) {
        this.supportNum = supportNum;
    }

    public Integer getAgainstNum() {
        return againstNum;
    }

    public void setAgainstNum(Integer againstNum) {
        this.againstNum = againstNum;
    }

    @Override
    public String toString() {
        return "CommentFeedBacks{" +
                "id=" + id +
                ", userId=" + userId +
                ", createTime=" + createTime +
                ", commentId=" + commentId +
                ", content='" + content + '\'' +
                ", status=" + status +
                ", supportNum=" + supportNum +
                ", againstNum=" + againstNum +
                '}';
    }
}
