package com.sweetfun.dao;

import com.sweetfun.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    public User findByUserId(Integer userId);
    public List<User> findAll();
    public boolean deleteById(int userId);
    public int totalUserNumber();
    public boolean updateUser(User user);
    public boolean addUser(User user);
}
