package com.sweetfun.service.impl;

import com.sweetfun.dao.CommentsDao;
import com.sweetfun.domain.Comments;
import com.sweetfun.domain.vo.CommentsVo;
import com.sweetfun.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentsServiceImpl implements CommentsService {
    @Autowired
    private CommentsDao commentsDao;
    @Override
    public List<Comments> findByBlogIntroductionId(Integer blogIntroductionId) {
        return commentsDao.findByBlogIntroductionId(blogIntroductionId);
    }

    @Override
    public List<CommentsVo> findUserComments(Integer blogIntroductionId) {
        return commentsDao.findUserComments(blogIntroductionId);
    }

    @Override
    public int saveUserComments(Comments comments) {
        return commentsDao.saveUserComments(comments);
    }

    @Override
    public int deleteComment(Integer userId) {
        return commentsDao.deleteComment(userId);
    }

    @Override
    public List<Object> findAll() {
        return commentsDao.findAll();
    }

    @Override
    public int updateById(Comments comments) {
        return commentsDao.updateById(comments);
    }

    @Override
    public List<Object> findByTime(String createTime, String endTime) {
        return commentsDao.findByTime(createTime, endTime);
    }
}
