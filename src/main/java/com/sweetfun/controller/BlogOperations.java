package com.sweetfun.controller;

import com.alibaba.fastjson.JSONObject;
import com.sweetfun.domain.BlogIntroduction;
import com.sweetfun.service.BlogOperationsService;
import com.sweetfun.utils.BackResult;
import com.sweetfun.utils.Consts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * 对博客的一些操作，例如点赞，浏览等等
 */
@RestController
@RequestMapping("/blogOperations")
public class BlogOperations {
    @Autowired
    private BlogOperationsService blogOperationsService;
    @RequestMapping(value = "/giveALike", method = RequestMethod.GET)
    public Object giveAlIke(@RequestParam Integer blogId) {
        JSONObject jsonObject = new JSONObject();
        int i = blogOperationsService.giveALike(blogId);
        if (i != 0) {
            jsonObject.put(Consts.CODE, 1);
            jsonObject.put(Consts.MSG, "点赞成功");
        } else {
            jsonObject.put(Consts.CODE, 0);
            jsonObject.put(Consts.MSG, "点赞失败");
        }
        return jsonObject;
    }

    @RequestMapping(value = "/viewNumAdd/{blogId}", method = RequestMethod.PUT)
    public Object viewNumAdd(@PathVariable("blogId") Integer blogId) {
        JSONObject jsonObject = new JSONObject();
        try {
            int i = blogOperationsService.viewNumAdd(blogId);
            if (i != 0) {
                jsonObject.put(Consts.CODE, 1);
                jsonObject.put(Consts.MSG, "点赞成功");
            } else {
                jsonObject.put(Consts.CODE, 0);
                jsonObject.put(Consts.MSG, "点赞失败");
            }
        } catch (Exception e) {
            jsonObject.put(Consts.CODE, 0);
            jsonObject.put(Consts.MSG, e.getMessage());
        }
        return jsonObject;
    }

    @RequestMapping("/statistics")
    public Object Statistics() {
        try {
            HashMap<String, Integer> statistics = blogOperationsService.Statistics();
            System.out.println(statistics);
            if (statistics != null) {
                return BackResult.result(1, "查询成功", statistics);
            } else {
                return BackResult.result(1, "没有数据", null);
            }
        } catch (Exception exception) {
            return BackResult.result(0, exception.getMessage(), null);
        }
    }

    @RequestMapping("/blogNumByType")
    public Object blogNumByType() {
        try {
            List<Object> objects = blogOperationsService.blogNumByType();
            System.out.println(objects);
            if (objects != null) {
                return BackResult.result(1, "查询成功", objects);
            } else {
                return BackResult.result(1, "没有数据", null);
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return BackResult.result(0, exception.getMessage(), null);
        }
    }

    @RequestMapping("/BlogViewRanking")
    public Object BlogViewRanking() {
        try {
            List<Object> objects = blogOperationsService.BlogViewRanking();
            System.out.println(objects);
            if (objects != null) {
                return BackResult.result(1, "查询成功", objects);
            } else {
                return BackResult.result(1, "没有数据", null);
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return BackResult.result(0, exception.getMessage(), null);
        }
    }


    @RequestMapping("/recentBlogs")
    public Object recentBlogs() {
        try {
            List<Object> objects = blogOperationsService.RecentBlogs();
            System.out.println(objects);
            if (objects != null) {
                return BackResult.result(1, "查询成功", objects);
            } else {
                return BackResult.result(1, "没有数据", null);
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return BackResult.result(0, exception.getMessage(), null);
        }
    }

    // 获取最近7天每天系统博客的数量
    @RequestMapping("/getBlogNumberByDay")
    public Object getBlogNumberByDay() {
        try {
            List<Object> objects = blogOperationsService.getBlogNumberByDay();
            System.out.println(objects);
            if (objects != null) {
                return BackResult.result(1, "查询成功", objects);
            } else {
                return BackResult.result(1, "没有数据", null);
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return BackResult.result(0, exception.getMessage(), null);
        }
    }
}
