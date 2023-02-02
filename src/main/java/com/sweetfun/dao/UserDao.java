package com.sweetfun.dao;

import com.sweetfun.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    public User findByUserId(Integer userId);
}
