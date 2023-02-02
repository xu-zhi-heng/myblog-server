package com.sweetfun.service;

import com.sweetfun.domain.BlogIntroduction;

import java.util.List;

public interface BlogIntroductionService {
    public List<BlogIntroduction> findAll();
    public List<BlogIntroduction> findByType(Integer type);
    public BlogIntroduction findById(Integer id);
}
