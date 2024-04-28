package com.sweetfun.service;

import com.sweetfun.domain.BlogIntroduction;

import java.util.List;

public interface BlogIntroductionService {
    public List<BlogIntroduction> findAll();
    public List<BlogIntroduction> findAllByUserId(Integer userId);
    public List<BlogIntroduction> findByType(Integer type);
    public BlogIntroduction findById(Integer id);
    public void saveBlogIntro(BlogIntroduction blogIntroduction);
    public void updateById(BlogIntroduction blogStatus);
    public List<BlogIntroduction> findByKeyWord(String keyWord);
}
