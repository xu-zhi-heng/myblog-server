package com.sweetfun.controller;

import com.alibaba.fastjson.JSONObject;
import com.sweetfun.domain.BlogContent;
import com.sweetfun.service.BlogContentService;
import com.sweetfun.utils.BackResult;
import com.sweetfun.utils.Consts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 博客内容
 */
@RestController
@RequestMapping("/blogContent")
public class BlogContentController {
    @Autowired
    private BlogContentService blogContentService;
    @RequestMapping("/findBlogContentByBlogIntroductionId")
    public Object findBlogContentByBlogIntroductionId(@RequestParam Integer blogIntroductionId) {
        System.out.println(blogIntroductionId);
        JSONObject jsonObject = new JSONObject();
        BlogContent byBlogIntroductionId = blogContentService.findByBlogIntroductionId(blogIntroductionId);
        try {
            if(byBlogIntroductionId != null) {
                jsonObject.put(Consts.CODE,1);
                jsonObject.put(Consts.MSG,"查询成功");
                jsonObject.put(Consts.DATA,byBlogIntroductionId);
            }else {
                jsonObject.put(Consts.CODE,1);
                jsonObject.put(Consts.MSG,"没有内容");
                jsonObject.put(Consts.DATA,null);
            }
        }catch (Exception e) {
            e.printStackTrace();
            jsonObject.put(Consts.CODE,0);
            jsonObject.put(Consts.MSG,e.getMessage());
        }
        return jsonObject;
    }


    @RequestMapping("/saveBlogContent")
    public Object saveBlogContent(@RequestBody BlogContent blogContent) {
        try {
            blogContentService.saveBlogContent(blogContent);
            return BackResult.result(1, "插入成功", null);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return BackResult.result(0, e.getMessage(), null);
        }
    }

    @RequestMapping("/updateByIntroId")
    public Object updateByIntroId(@RequestBody BlogContent blogContent) {
        try {
            blogContentService.updateBlogContent(blogContent);
            return BackResult.result(1, "更新成功", null);
        } catch (Exception e) {
            return BackResult.result(0, e.getMessage(), null);
        }
    }
}
