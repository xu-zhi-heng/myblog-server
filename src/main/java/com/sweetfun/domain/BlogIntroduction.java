package com.sweetfun.domain;

public class BlogIntroduction {
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
                '}';
    }
}
