package com.sweetfun.service;

import com.sweetfun.domain.User;

import java.util.List;

public interface UserService {
    public User findByUserId(Integer userId);
    public List<User> findAll();
    public boolean deleteById(int userId);
    public int totalUserNumber();
    public boolean updateUser(User user);
}
