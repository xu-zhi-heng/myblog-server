package com.sweetfun.service.impl;

import com.sweetfun.dao.AdminDao;
import com.sweetfun.domain.Admin;
import com.sweetfun.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao adminDao;
    @Override
    public Admin login(Admin admin) {
        return adminDao.login(admin);
    }
}
