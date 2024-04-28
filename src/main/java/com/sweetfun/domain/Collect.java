package com.sweetfun.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Date;

public class Collect {
    private int id;
    private int userId;
    private int blogIntroductionId;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date collectDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBlogIntroductionId() {
        return blogIntroductionId;
    }

    public void setBlogIntroductionId(int blogIntroductionId) {
        this.blogIntroductionId = blogIntroductionId;
    }

    public Date getCollectDate() {
        return collectDate;
    }

    public void setCollectDate(Date collectDate) {
        this.collectDate = collectDate;
    }

    @Override
    public String toString() {
        return "Collect{" +
                "id=" + id +
                ", userId=" + userId +
                ", blogIntroductionId=" + blogIntroductionId +
                ", collectDate=" + collectDate +
                '}';
    }
}
