package com.sweetfun.service.impl;

import com.sweetfun.dao.RegisterDao;
import com.sweetfun.domain.User;
import com.sweetfun.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    private RegisterDao registerDao;
    @Override
    public boolean Register(User user) {
        return registerDao.Register(user);
    }
}
