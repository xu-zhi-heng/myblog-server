package com.sweetfun.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.houbb.sensitive.word.core.SensitiveWordHelper;
import com.sweetfun.domain.Comments;
import com.sweetfun.domain.vo.CommentsVo;
import com.sweetfun.service.CommentsService;
import com.sweetfun.utils.BackResult;
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
        boolean contains = SensitiveWordHelper.contains(comments.getCommentContent());
        JSONObject jsonObject = new JSONObject();
        try {
            if (contains) {
                comments.setStatus(0);
                commentsService.saveUserComments(comments);
                jsonObject.put(Consts.CODE, 0);
                jsonObject.put(Consts.MSG, "您的评论包含敏感信息，等带后台进行审核");
            } else {
                int i = commentsService.saveUserComments(comments);
                if(i > 0) {
                    jsonObject.put(Consts.CODE, 1);
                    jsonObject.put(Consts.MSG, "评论成功");
                }
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

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public Object findAll() {
        try {
            List<Object> objects = commentsService.findAll();
            System.out.println(objects);
            if (objects.size() != 0) {
                return BackResult.result(1, "查询成功", objects);
            } else {
                return BackResult.result(1, "没有数据", null);
            }
        } catch (Exception exception) {
            return BackResult.result(0, exception.getMessage(), null);
        }
    }

    @RequestMapping(value = "/updateById", method = RequestMethod.PUT)
    public Object updateById(@RequestBody Comments comments) {
        try {
            int i = commentsService.updateById(comments);
            if (i != 0) {
                return BackResult.result(1, "更新成功", null);
            } else {
                return BackResult.result(0, "更新失败", null);
            }
        } catch (Exception exception) {
            return BackResult.result(0, exception.getMessage(), null);
        }
    }
    @RequestMapping(value = "/findByTime", method = RequestMethod.GET)
    public Object findByTime(@RequestParam("date") String[] dates) {
        try {
            List<Object> byTime = commentsService.findByTime(dates[0], dates[1]);
            if (byTime != null) {
                return BackResult.result(1, "查询成功", byTime);
            } else {
                return BackResult.result(0, "查询失败", null);
            }
        } catch (Exception exception) {
            return BackResult.result(0, exception.getMessage(), null);
        }
    }
}
