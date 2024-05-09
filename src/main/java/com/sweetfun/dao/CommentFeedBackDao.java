package com.sweetfun.dao;

import com.sweetfun.domain.CommentFeedBacks;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentFeedBackDao {
    public List<Object> findAll();
    public List<Object> findAllByCommentId(Integer commentId);
    public int updateById(CommentFeedBacks feedBacks);
    public List<Object> findByTime(String createTime, String endTime);
    public int saveFeedBack(CommentFeedBacks commentFeedBacks);
    public int deleteById(Integer id);
}
