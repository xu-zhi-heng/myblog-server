package com.sweetfun.dao;

import com.sweetfun.domain.Collect;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Repository
public interface CollectDao {
    public List<Object> findAll();
    public List<Collect> findByUserId(int userId);
    public int addCollect(Collect collect);
    public void deleteCollect(int id);
    public void updateCollect(Collect collect);
    public Collect findByUserIdAndBlogIntroductionId(@Param("userId") int userId, @Param("blogIntroductionId") int blogIntroductionId);

    public List<Object> findByTime(String time);
}
