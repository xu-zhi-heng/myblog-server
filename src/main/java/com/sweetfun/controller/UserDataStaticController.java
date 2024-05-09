package com.sweetfun.controller;

import com.sweetfun.service.UserDataStaticService;
import com.sweetfun.utils.BackResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// 用户行为数据统计
@RestController
@RequestMapping("/userData")
public class UserDataStaticController {
    @Autowired
    private UserDataStaticService userDataStaticService;

    // 根据用户Id获取最新的评论内容
    @GetMapping("/getLatestComment")
    private Object getLatestComment(@RequestParam Integer userId) {
        try {
            List<Object> objects = userDataStaticService.getLatestComment(userId);
            System.out.println(objects);
            if (!objects.isEmpty()) {
                return BackResult.result(1, "查询成功", objects);
            } else {
                return BackResult.result(1, "没有数据", null);
            }
        } catch (Exception exception) {
            return BackResult.result(0, exception.getMessage(), null);
        }
    }

    // 获取用户阅读最的博客内容
    @GetMapping("/getTopsBlog")
    private Object getTopsBlog(@RequestParam Integer userId) {
        try {
            List<Object> objects = userDataStaticService.getTopsBlog(userId);
            System.out.println(objects);
            if (!objects.isEmpty()) {
                return BackResult.result(1, "查询成功", objects);
            } else {
                return BackResult.result(1, "没有数据", null);
            }
        } catch (Exception exception) {
            return BackResult.result(0, exception.getMessage(), null);
        }
    }

    @GetMapping("/getHotBlog")
    private Object getHotBlog(@RequestParam Integer userId) {
        try {
            List<Object> objects = userDataStaticService.getHotBlog(userId);
            System.out.println(objects);
            if (!objects.isEmpty()) {
                return BackResult.result(1, "查询成功", objects);
            } else {
                return BackResult.result(1, "没有数据", null);
            }
        } catch (Exception exception) {
            return BackResult.result(0, exception.getMessage(), null);
        }
    }
}
