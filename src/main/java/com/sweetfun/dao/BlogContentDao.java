package com.sweetfun.dao;

import com.sweetfun.domain.BlogContent;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogContentDao {
    public BlogContent findByBlogIntroductionId(Integer blogIntroductionId);
    public List<BlogContent> findAll();
}
