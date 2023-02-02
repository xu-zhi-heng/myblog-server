package com.sweetfun.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sweetfun.domain.Exercise;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExerciseVo extends Exercise {
    private Integer id;
    private Integer number;
    private String name;
    private String content;
    private String answer;
    private String train;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date time;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date updateTime;
    private Integer exerciseType;
    private String label;
    private String[] labelName;

    @Override
    public String toString() {
        return "ExerciseVo{" +
                "id=" + id +
                ", number=" + number +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", answer='" + answer + '\'' +
                ", train='" + train + '\'' +
                ", time=" + time +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", exerciseType=" + exerciseType +
                ", label='" + label + '\'' +
                ", labelName=" + Arrays.toString(labelName) +
                '}';
    }
}
