package com.sweetfun.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogOperationsDao {
    public int giveALike(Integer blogId);
    public int viewNumAdd(Integer blogId);
}
