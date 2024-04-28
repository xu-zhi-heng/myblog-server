package com.sweetfun.service.impl;

import com.sweetfun.dao.CommentFeedBackDao;
import com.sweetfun.domain.CommentFeedBacks;
import com.sweetfun.service.CommentFeedBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentFeedBackServiceImpl implements CommentFeedBackService {
    @Autowired
    private CommentFeedBackDao feedBackDao;
    @Override
    public List<Object> findAll() {
        return feedBackDao.findAll();
    }

    @Override
    public List<Object> findAllByCommentId(Integer commentId) {
        return feedBackDao.findAllByCommentId(commentId);
    }

    @Override
    public int updateById(CommentFeedBacks feedBacks) {
        return feedBackDao.updateById(feedBacks);
    }

    @Override
    public List<Object> findByTime(String createTime, String endTime) {
        return findByTime(createTime, endTime);
    }

    @Override
    public int saveFeedBack(CommentFeedBacks commentFeedBacks) {
        return feedBackDao.saveFeedBack(commentFeedBacks);
    }
}
