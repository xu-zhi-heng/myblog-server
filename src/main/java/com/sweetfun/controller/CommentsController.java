package com.sweetfun.controller;

import com.alibaba.fastjson.JSONObject;
import com.sweetfun.domain.BlogType;
import com.sweetfun.domain.Comments;
import com.sweetfun.domain.vo.CommentsVo;
import com.sweetfun.service.CommentsService;
import com.sweetfun.utils.Consts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentsController {
    @Autowired
    private CommentsService commentsService;
    @RequestMapping("/findCommentsByBlogIntroductionId")
    public Object findCommentsByBlogIntroductionId(@RequestParam Integer blogIntroductionId) {
        JSONObject jsonObject = new JSONObject();
        try {
            List<Comments> byBlogIntroductionId = commentsService.findByBlogIntroductionId(blogIntroductionId);
            if(byBlogIntroductionId != null || !byBlogIntroductionId.isEmpty()) {
                jsonObject.put(Consts.CODE,1);
                jsonObject.put(Consts.MSG,"查询成功");
                jsonObject.put(Consts.DATA,byBlogIntroductionId);
            }else {
                jsonObject.put(Consts.CODE,1);
                jsonObject.put(Consts.MSG,"没有内容");
                jsonObject.put(Consts.DATA,byBlogIntroductionId);
            }
        } catch (Exception e) {
            jsonObject.put(Consts.CODE,0);
            jsonObject.put(Consts.MSG,e.getMessage());
        }
        return jsonObject;
    }

    @RequestMapping(value = "/findUserComments", method = RequestMethod.GET)
    public Object findUserComments(@RequestParam Integer blogIntroductionId) {
        JSONObject jsonObject = new JSONObject();
        try {
            List<CommentsVo> userComments = commentsService.findUserComments(blogIntroductionId);
            if(userComments != null || !userComments.isEmpty()) {
                jsonObject.put(Consts.CODE,1);
                jsonObject.put(Consts.MSG,"查询成功");
                jsonObject.put(Consts.DATA,userComments);
            }else {
                jsonObject.put(Consts.CODE,1);
                jsonObject.put(Consts.MSG,"没有内容");
                jsonObject.put(Consts.DATA,userComments);
            }
        } catch (Exception e) {
            jsonObject.put(Consts.CODE, 0);
            jsonObject.put(Consts.MSG, e.getMessage());
        }
        return jsonObject;
    }

    @RequestMapping(value = "/saveUserComments", method = RequestMethod.POST)
    public Object saveUserComments(@RequestBody Comments comments) {
        System.out.println(comments);
        JSONObject jsonObject = new JSONObject();
        try {
            int i = commentsService.saveUserComments(comments);
            if(i > 0) {
                jsonObject.put(Consts.CODE, 1);
                jsonObject.put(Consts.MSG, "评论成功");
            }
        } catch (Exception e) {
            jsonObject.put(Consts.CODE, 0);
            jsonObject.put(Consts.MSG, e.getMessage());
            e.printStackTrace();
        }
        return jsonObject;
    }

    @RequestMapping(value = "/deleteComment/{id}", method = RequestMethod.DELETE)
    public Object deleteComment(@PathVariable("id") String id) {
        JSONObject jsonObject = new JSONObject();
        try {
            int i = commentsService.deleteComment(Integer.parseInt(id));
            if(i > 0) {
                jsonObject.put(Consts.CODE, 1);
                jsonObject.put(Consts.MSG, "删除成功");
            }
        } catch (Exception e) {
            jsonObject.put(Consts.CODE, 0);
            jsonObject.put(Consts.MSG, e.getMessage());
            e.printStackTrace();
        }
        return jsonObject;
    }
}
