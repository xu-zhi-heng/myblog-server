package com.sweetfun.service;

import com.sweetfun.domain.CommentFeedBacks;

import java.util.List;

public interface CommentFeedBackService {
    public List<Object> findAll();
    public List<Object> findAllByCommentId(Integer commentId);
    public int updateById(CommentFeedBacks feedBacks);
    public List<Object> findByTime(String createTime, String endTime);
    public int saveFeedBack(CommentFeedBacks commentFeedBacks);
    public int deleteById(Integer id);
}
