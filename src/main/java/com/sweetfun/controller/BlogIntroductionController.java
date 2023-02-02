package com.sweetfun.controller;

import com.alibaba.fastjson.JSONObject;
import com.sweetfun.domain.BlogIntroduction;
import com.sweetfun.service.BlogIntroductionService;
import com.sweetfun.utils.Consts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 博客简介
 */

@RestController
@RequestMapping("/blogIntroduction")
public class BlogIntroductionController {
    @Autowired
    private BlogIntroductionService blogIntroductionService;
    @RequestMapping("/findAll")
    public Object findAll() {
        JSONObject jsonObject = new JSONObject();
        try {
            List<BlogIntroduction> all = blogIntroductionService.findAll();
            if(all.size() != 0) {
                jsonObject.put(Consts.CODE,1);
                jsonObject.put(Consts.MSG,"查询成功");
                jsonObject.put(Consts.DATA,all);
            }else {
                jsonObject.put(Consts.CODE,1);
                jsonObject.put(Consts.MSG,"没有内容");
                jsonObject.put(Consts.DATA,null);
            }
        }catch (Exception e) {
            e.printStackTrace();
            jsonObject.put(Consts.CODE,1);
            jsonObject.put(Consts.MSG,"查询失败");
        }
        return jsonObject;
    }


    @RequestMapping("/findByType")
    public Object findByType(@RequestParam Integer type) {
        JSONObject jsonObject = new JSONObject();
        try {
            List<BlogIntroduction> all = blogIntroductionService.findByType(type);
            if(all.size() != 0) {
                jsonObject.put(Consts.CODE,1);
                jsonObject.put(Consts.MSG,"查询成功");
                jsonObject.put(Consts.DATA,all);
            }else {
                jsonObject.put(Consts.CODE,1);
                jsonObject.put(Consts.MSG,"没有内容");
                jsonObject.put(Consts.DATA,null);
            }
        }catch (Exception e) {
            e.printStackTrace();
            jsonObject.put(Consts.CODE,1);
            jsonObject.put(Consts.MSG,e.getMessage());
        }
        return jsonObject;
    }

    @RequestMapping("/findById")
    public Object findById(@RequestParam Integer id) {
        JSONObject jsonObject = new JSONObject();
        try {
            BlogIntroduction byId = blogIntroductionService.findById(id);
            if(byId != null) {
                jsonObject.put(Consts.CODE,1);
                jsonObject.put(Consts.MSG,"查询成功");
                jsonObject.put(Consts.DATA,byId);
            }else {
                jsonObject.put(Consts.CODE,1);
                jsonObject.put(Consts.MSG,"没有内容");
                jsonObject.put(Consts.DATA,null);
            }
        }catch (Exception e) {
            e.printStackTrace();
            jsonObject.put(Consts.CODE,1);
            jsonObject.put(Consts.MSG,e.getMessage());
        }
        return jsonObject;
    }
}
