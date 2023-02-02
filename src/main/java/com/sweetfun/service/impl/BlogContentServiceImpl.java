package com.sweetfun.service.impl;

import com.sweetfun.dao.BlogContentDao;
import com.sweetfun.domain.BlogContent;
import com.sweetfun.service.BlogContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogContentServiceImpl implements BlogContentService {
    @Autowired
    private BlogContentDao blogContentDao;
    @Override
    public BlogContent findByBlogIntroductionId(Integer blogIntroductionId) {
        return blogContentDao.findByBlogIntroductionId(blogIntroductionId);
    }

    @Override
    public List<BlogContent> findAll() {
        return blogContentDao.findAll();
    }
}
