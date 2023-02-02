package com.sweetfun.service;

import com.sweetfun.domain.BlogContent;

import java.util.List;

public interface BlogContentService {
    public BlogContent findByBlogIntroductionId(Integer blogIntroductionId);
    public List<BlogContent> findAll();
}
