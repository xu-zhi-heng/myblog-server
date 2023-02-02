package com.sweetfun.domain.vo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentsVo {
    private Integer id;
    private String commentContent;
    private Integer userId;
    private Integer blogIntroductionId;
    private Timestamp createTime;
    private Timestamp updateTime;
    private Integer supportNum;
    private Integer againstNum;
    private String userName;
    private String userAvator;
    private String username;

    @Override
    public String toString() {
        return "CommentsVo{" +
                "id=" + id +
                ", commentContent='" + commentContent + '\'' +
                ", userId=" + userId +
                ", blogIntroductionId=" + blogIntroductionId +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", supportNum=" + supportNum +
                ", againstNum=" + againstNum +
                ", userName='" + userName + '\'' +
                ", userAvator='" + userAvator + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
