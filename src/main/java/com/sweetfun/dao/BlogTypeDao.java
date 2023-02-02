package com.sweetfun.dao;
import com.sweetfun.domain.BlogType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogTypeDao {
    public boolean insert(BlogType blogType);   // 插入博客类型
    public List<BlogType> getAllBlogType();     // 获取所有的博客类型
    public boolean update(BlogType blogType);   // 更新博客类型
    public boolean delete(int id);              // 根据id删除某一个博客类型
    public BlogType findBlogTypeById(int id);   // 通过id查询某一个博客类型
}
