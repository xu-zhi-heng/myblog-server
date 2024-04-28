package com.sweetfun.service;

import com.sweetfun.domain.BlogIntroduction;

import java.util.HashMap;
import java.util.List;

public interface BlogOperationsService {
    public int giveALike(Integer blogId);
    public int viewNumAdd(Integer blogId);
    public HashMap<String, Integer> Statistics();
    public List<Object> blogNumByType();
    public List<BlogIntroduction> BlogViewRanking();
    public List<BlogIntroduction> RecentBlogs();
}
