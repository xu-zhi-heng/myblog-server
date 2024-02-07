package com.sweetfun.controller;

import com.alibaba.fastjson.JSONObject;
import com.sweetfun.domain.BlogType;
import com.sweetfun.service.BlogTypeService;
import com.sweetfun.utils.BackResult;
import com.sweetfun.utils.Consts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/BlogType")
public class BlogTypeController {
    @Autowired
    private BlogTypeService blogTypeService;
    @RequestMapping(value = "/getAllBlogType",method = RequestMethod.GET)
    public Object getAllBlogType() {
        JSONObject jsonObject = new JSONObject();
        try {
            List<BlogType> allBlogType = blogTypeService.getAllBlogType();
            if(allBlogType != null || !allBlogType.isEmpty()) {
                jsonObject.put(Consts.CODE,1);
                jsonObject.put(Consts.MSG,"查询成功");
                jsonObject.put(Consts.DATA,allBlogType);
            }else {
                jsonObject.put(Consts.CODE,1);
                jsonObject.put(Consts.MSG,"没有内容");
                jsonObject.put(Consts.DATA,allBlogType);
            }
        }catch (Exception e) {
            jsonObject.put(Consts.CODE,0);
            jsonObject.put(Consts.MSG,e.getMessage());
        }
        return jsonObject;
    }


    @RequestMapping("/addBlogType")
    public Object addBlogType(@RequestBody BlogType blogType) {
        JSONObject jsonObject = null;
        try {
            boolean insert = blogTypeService.insert(blogType);
            if (insert) {
                jsonObject = (JSONObject) BackResult.result(1, "添加成功", null);
            } else {
                jsonObject= (JSONObject) BackResult.result(0, "添加失败", null);
            }
        } catch (Exception e) {
            return BackResult.result(0, e.getMessage(), null);
        }
        return jsonObject;
    }

    @RequestMapping("/updateBlogType")
    public Object updateBlog(@RequestBody BlogType blogType) {
        JSONObject jsonObject = null;
        try {
            boolean insert = blogTypeService.update(blogType);
            if (insert) {
                jsonObject = (JSONObject) BackResult.result(1, "更新成功", null);
            } else {
                jsonObject= (JSONObject) BackResult.result(0, "更新失败", null);
            }
        } catch (Exception e) {
            return BackResult.result(0, e.getMessage(), null);
        }
        return jsonObject;
    }


    @RequestMapping("/deleteBlogTypeById")
    public Object deleteBlogTypeById(@RequestParam Integer id) {
        JSONObject jsonObject = null;
        try {
            boolean delete = blogTypeService.delete(id);
            if (delete) {
                jsonObject = (JSONObject) BackResult.result(1, "删除成功", null);
            } else {
                jsonObject= (JSONObject) BackResult.result(0, "删除失败", null);
            }
        } catch (Exception e) {
            return BackResult.result(0, e.getMessage(), null);
        }
        return jsonObject;
    }


}
