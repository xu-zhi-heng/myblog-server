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
