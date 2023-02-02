package com.sweetfun.dao;

import com.sweetfun.domain.Comments;
import com.sweetfun.domain.vo.CommentsVo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentsDao {
    public List<Comments> findByBlogIntroductionId(Integer blogIntroductionId);
    public List<CommentsVo> findUserComments(Integer blogIntroductionId);
    public int saveUserComments(Comments comments);
    public int deleteComment(Integer userId);
}
