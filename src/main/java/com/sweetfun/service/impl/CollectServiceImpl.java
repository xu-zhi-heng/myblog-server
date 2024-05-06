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
    public List<Object> findAll() {
        return collectDao.findAll();
    }

    @Override
    public List<Collect> findByUserId(int userId) {
        return collectDao.findByUserId(userId);
    }

    @Override
    public int addCollect(Collect collect) {
       return collectDao.addCollect(collect);
    }

    @Override
    public void deleteCollect(int id) {
        collectDao.deleteCollect(id);
    }

    @Override
    public void updateCollect(Collect collect) {
        collectDao.updateCollect(collect);
    }

    @Override
    public Collect findByUserIdAndBlogIntroductionId(int userId, int blogIntroductionId) {
        return collectDao.findByUserIdAndBlogIntroductionId(userId, blogIntroductionId);
    }

    @Override
    public List<Object> findByTime(String time) {
        return collectDao.findByTime(time);
    }
}
