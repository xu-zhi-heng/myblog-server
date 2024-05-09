package com.sweetfun.service;

import org.springframework.stereotype.Service;

import java.util.List;


public interface UserDataStaticService {
    public List<Object> getLatestComment(Integer userId);
    public List<Object> getTopsBlog(Integer userId);
    public List<Object> getHotBlog(Integer userId);
}
