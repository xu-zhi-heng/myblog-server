package com.sweetfun.dao;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDataStaticDao {
    public List<Object> getLatestComment(Integer userId);
    public List<Object> getTopsBlog(Integer userId);
    public List<Object> getHotBlog(Integer userId);
}
