package com.sweetfun.service.impl;

import com.sweetfun.dao.BlogTypeDao;
import com.sweetfun.domain.BlogType;
import com.sweetfun.service.BlogTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogTypeServiceImpl implements BlogTypeService {
    @Autowired
    private BlogTypeDao blogTypeDao;
    @Override
    public boolean insert(BlogType blogType) {
        return blogTypeDao.insert(blogType);
    }

    @Override
    public List<BlogType> getAllBlogType() {
        return blogTypeDao.getAllBlogType();
    }

    @Override
    public boolean update(BlogType blogType) {
        return blogTypeDao.update(blogType);
    }

    @Override
    public boolean delete(int id) {
        return blogTypeDao.delete(id);
    }

    @Override
    public BlogType findBlogTypeById(int id) {
        return blogTypeDao.findBlogTypeById(id);
    }
}
