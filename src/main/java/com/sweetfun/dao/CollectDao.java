package com.sweetfun.dao;

import com.sweetfun.domain.Collect;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CollectDao {
    public List<Collect> findAll();
    public List<Collect> findByUserId(int userId);
    public void addCollect(Collect collect);
    public void deleteCollect(int id);
    public void updateCollect(Collect collect);
}
