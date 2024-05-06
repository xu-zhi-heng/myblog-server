package com.sweetfun.service;

import com.sweetfun.domain.Collect;

import java.util.List;

public interface CollectService {
    public List<Object> findAll();
    public List<Collect> findByUserId(int userId);
    public int addCollect(Collect collect);
    public void deleteCollect(int id);
    public void updateCollect(Collect collect);
    public Collect findByUserIdAndBlogIntroductionId(int userId, int blogIntroductionId);

    public List<Object> findByTime(String time);
}
