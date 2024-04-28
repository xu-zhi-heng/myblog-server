package com.sweetfun.dao;

import com.sweetfun.domain.Admin;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminDao {
    public Admin login(Admin admin);
}
