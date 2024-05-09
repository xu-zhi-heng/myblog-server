package com.sweetfun.service.impl;

import com.sweetfun.dao.UserDataStaticDao;
import com.sweetfun.service.UserDataStaticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDataStaticServiceImpl implements UserDataStaticService {
    @Autowired
    private UserDataStaticDao userDataStaticDao;

    @Override
    public List<Object> getLatestComment(Integer userId) {
        return userDataStaticDao.getLatestComment(userId);
    }

    @Override
    public List<Object> getTopsBlog(Integer userId) {
        return userDataStaticDao.getTopsBlog(userId);
    }

    @Override
    public List<Object> getHotBlog(Integer userId) {
        return userDataStaticDao.getHotBlog(userId);
    }
}
