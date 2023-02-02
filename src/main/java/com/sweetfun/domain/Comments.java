package com.sweetfun.domain;

import java.io.Serializable;
import java.sql.Timestamp;
public class Comments implements Serializable {
    private Integer id;
    private String commentContent;
    private Integer userId;
    private Integer blogIntroductionId;
    private Timestamp createTime;
    private Timestamp updateTime;
    private Integer supportNum;
    private Integer againstNum;

    public Comments() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getBlogIntroductionId() {
        return blogIntroductionId;
    }

    public void setBlogIntroductionId(Integer blogIntroductionId) {
        this.blogIntroductionId = blogIntroductionId;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
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

    public Comments(Integer id, String commentContent, Integer userId, Integer blogIntroductionId, Timestamp createTime, Timestamp updateTime, Integer supportNum, Integer againstNum) {
        this.id = id;
        this.commentContent = commentContent;
        this.userId = userId;
        this.blogIntroductionId = blogIntroductionId;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.supportNum = supportNum;
        this.againstNum = againstNum;
    }

    @Override
    public String toString() {
        return "Comments{" +
                "id=" + id +
                ", commentContent='" + commentContent + '\'' +
                ", userId=" + userId +
                ", blogIntroductionId=" + blogIntroductionId +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", supportNum=" + supportNum +
                ", againstNum=" + againstNum +
                '}';
    }
}
