package com.sweetfun.domain;

public class BlogIntroduction {
    public BlogIntroduction() {
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    private Integer id;
    private String title;
    private String digest;
    private String picture;
    private Integer viewedNum;
    private Integer thumbNum;
    private Integer commentNum;
    private String icon;
    private Integer type;
    private Integer role;
    private Integer status;
    private Integer userId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Integer getViewedNum() {
        return viewedNum;
    }

    public void setViewedNum(Integer viewedNum) {
        this.viewedNum = viewedNum;
    }

    public Integer getThumbNum() {
        return thumbNum;
    }

    public void setThumbNum(Integer thumbNum) {
        this.thumbNum = thumbNum;
    }

    public Integer getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(Integer commentNum) {
        this.commentNum = commentNum;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public BlogIntroduction(Integer id, String title, String digest, String picture, Integer viewedNum, Integer thumbNum, Integer commentNum, String icon, Integer type, Integer role, Integer status, Integer userId) {
        this.id = id;
        this.title = title;
        this.digest = digest;
        this.picture = picture;
        this.viewedNum = viewedNum;
        this.thumbNum = thumbNum;
        this.commentNum = commentNum;
        this.icon = icon;
        this.type = type;
        this.role = role;
        this.status = status;
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "BlogIntroduction{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", digest='" + digest + '\'' +
                ", picture='" + picture + '\'' +
                ", viewedNum=" + viewedNum +
                ", thumbNum=" + thumbNum +
                ", commentNum=" + commentNum +
                ", icon='" + icon + '\'' +
                ", type=" + type +
                ", role=" + role +
                ", status=" + status +
                ", userId=" + userId +
                '}';
    }
}
