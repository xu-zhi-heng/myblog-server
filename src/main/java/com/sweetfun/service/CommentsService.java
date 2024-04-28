package com.sweetfun.service;

import com.sweetfun.domain.Comments;
import com.sweetfun.domain.vo.CommentsVo;

import java.util.List;

public interface CommentsService {
    // 通过博客简介id获取博客评论内容
    public List<Comments> findByBlogIntroductionId(Integer blogIntroductionId);
    // 同时获取评论内容和评论的用户信息
    public List<CommentsVo> findUserComments(Integer blogIntroductionId);
    // 保存用户评论内容
    public int saveUserComments(Comments comments);
    // 删除评论内容
    public int deleteComment(Integer userId);
    // 获取所有评论内容
    public List<Object> findAll();
    public int updateById(Comments comments);
    public List<Object> findByTime(String createTime, String endTime);
}
