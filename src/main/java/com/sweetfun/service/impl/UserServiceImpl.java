package com.sweetfun.service.impl;

import com.sweetfun.dao.UserDao;
import com.sweetfun.domain.User;
import com.sweetfun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User findByUserId(Integer userId) {
        return userDao.findByUserId(userId);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public boolean deleteById(int userId) {
        return userDao.deleteById(userId);
    }

    @Override
    public int totalUserNumber() {
        return userDao.totalUserNumber();
    }

    @Override
    public boolean updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public boolean addUser(User user) {
        return userDao.addUser(user);
    }
}
