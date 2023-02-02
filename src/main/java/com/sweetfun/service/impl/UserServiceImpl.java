package com.sweetfun.service.impl;

import com.sweetfun.dao.UserDao;
import com.sweetfun.domain.User;
import com.sweetfun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User findByUserId(Integer userId) {
        return userDao.findByUserId(userId);
    }
}
