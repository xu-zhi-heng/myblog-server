package com.sweetfun.service.impl;

import com.sweetfun.dao.BlogOperationsDao;
import com.sweetfun.domain.BlogIntroduction;
import com.sweetfun.service.BlogOperationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class BlogOperationsServiceImpl implements BlogOperationsService {
    @Autowired
    private BlogOperationsDao blogOperationsDao;
    @Override
    public int giveALike(Integer blogId) {
        return blogOperationsDao.giveALike(blogId);
    }

    @Override
    public int viewNumAdd(Integer blogId) {
        return blogOperationsDao.viewNumAdd(blogId);
    }

    @Override
    public HashMap<String, Integer> Statistics() {
        return blogOperationsDao.Statistics();
    }

    @Override
    public List<Object> blogNumByType() {
        return blogOperationsDao.blogNumByType();
    }

    @Override
    public List<BlogIntroduction> BlogViewRanking() {
        return blogOperationsDao.BlogViewRanking();
    }

    @Override
    public List<BlogIntroduction> RecentBlogs() {
        return blogOperationsDao.RecentBlogs();
    }
}
