package com.sweetfun.service.impl;

import com.sweetfun.dao.CollectDao;
import com.sweetfun.domain.Collect;
import com.sweetfun.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectServiceImpl implements CollectService {

    @Autowired
    private CollectDao collectDao;
    @Override
    public List<Collect> findAll() {
        return collectDao.findAll();
    }

    @Override
    public List<Collect> findByUserId(int userId) {
        return collectDao.findByUserId(userId);
    }

    @Override
    public void addCollect(Collect collect) {
        collectDao.addCollect(collect);
    }

    @Override
    public void deleteCollect(int id) {
        collectDao.deleteCollect(id);
    }

    @Override
    public void updateCollect(Collect collect) {
        collectDao.updateCollect(collect);
    }
}
