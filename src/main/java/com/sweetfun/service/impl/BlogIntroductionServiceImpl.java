package com.sweetfun.service.impl;
import com.sweetfun.dao.BlogIntroductionDao;
import com.sweetfun.domain.BlogIntroduction;
import com.sweetfun.service.BlogIntroductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BlogIntroductionServiceImpl implements BlogIntroductionService {
    @Autowired
    private BlogIntroductionDao blogIntroductionDao;
    @Override
    public List<BlogIntroduction> findAll() {
        return blogIntroductionDao.findAll();
    }
    @Override
    public List<BlogIntroduction> findByType(Integer type) {
        return blogIntroductionDao.findByType(type);
    }

    @Override
    public BlogIntroduction findById(Integer id) {
        return blogIntroductionDao.findById(id);
    }
}
