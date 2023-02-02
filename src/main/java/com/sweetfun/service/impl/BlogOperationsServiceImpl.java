package com.sweetfun.service.impl;

import com.sweetfun.dao.BlogOperationsDao;
import com.sweetfun.service.BlogOperationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
