package com.sweetfun.dao;

import com.sweetfun.domain.BlogIntroduction;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public interface BlogOperationsDao {
    public int giveALike(Integer blogId);
    public int viewNumAdd(Integer blogId);
    public HashMap<String, Integer> Statistics();
    public List<Object> blogNumByType();
    public List<Object> BlogViewRanking();
    public List<Object> RecentBlogs();
    public List<Object> getBlogNumberByDay();
}
