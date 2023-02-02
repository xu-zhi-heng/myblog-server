package com.sweetfun.service.impl;
import com.sweetfun.dao.LoginDao;
import com.sweetfun.domain.User;
import com.sweetfun.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginDao loginDao;
    @Override
    public User Login(User user) {
        return loginDao.Login(user);
    }
}
