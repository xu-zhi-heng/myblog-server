package com.sweetfun.controller;

import com.alibaba.fastjson.JSONObject;
import com.sweetfun.domain.BlogType;
import com.sweetfun.service.BlogTypeService;
import com.sweetfun.utils.Consts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}
