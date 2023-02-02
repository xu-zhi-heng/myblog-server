package com.sweetfun.controller;

import com.alibaba.fastjson.JSONObject;
import com.sweetfun.service.BlogOperationsService;
import com.sweetfun.utils.Consts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
