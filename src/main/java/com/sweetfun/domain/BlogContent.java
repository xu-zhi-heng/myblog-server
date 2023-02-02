package com.sweetfun.domain;
import java.sql.Date;
public class BlogContent {
    private Integer id;
    private String content;
    private String categories;
    private String tags;
    private Date create_time;
    private String title;
    private Integer blogIntroductionId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getBlogIntroductionId() {
        return blogIntroductionId;
    }

    public void setBlogIntroductionId(Integer blogIntroductionId) {
        this.blogIntroductionId = blogIntroductionId;
    }

    @Override
    public String toString() {
        return "BlogContent{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", categories='" + categories + '\'' +
                ", tags='" + tags + '\'' +
                ", create_time=" + create_time +
                ", title='" + title + '\'' +
                ", blogIntroductionId=" + blogIntroductionId +
                '}';
    }
}
