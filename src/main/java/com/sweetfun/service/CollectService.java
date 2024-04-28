package com.sweetfun.service;

import com.sweetfun.domain.Collect;

import java.util.List;

public interface CollectService {
    public List<Collect> findAll();
    public List<Collect> findByUserId(int userId);
    public void addCollect(Collect collect);
    public void deleteCollect(int id);
    public void updateCollect(Collect collect);
}
