package com.sweetfun.controller;
import com.alibaba.fastjson.JSONObject;
import com.github.houbb.sensitive.word.core.SensitiveWordHelper;
import com.sweetfun.domain.CommentFeedBacks;
import com.sweetfun.service.CommentFeedBackService;
import com.sweetfun.utils.BackResult;
import com.sweetfun.utils.Consts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/commentFeedBack")
public class CommentFeedBackController {
    @Autowired
    private CommentFeedBackService commentFeedBackService;
    @RequestMapping("/findAll")
    public Object findAll() {
        try {
            List<Object> all = commentFeedBackService.findAll();
            System.out.println(all);
            if (all != null) {
                return BackResult.result(1, "查找成功", all);
            } else {
                return BackResult.result(0, "查找失败", null);
            }
        } catch (Exception exception) {
            return BackResult.result(0, exception.getMessage(), null);
        }
    }
    @RequestMapping("/findAllByCommentId")
    public Object findAllByCommentId(@RequestParam Integer commentId) {
        try {
            List<Object> all = commentFeedBackService.findAllByCommentId(commentId);
            System.out.println(all);
            if (all != null) {
                return BackResult.result(1, "查找成功", all);
            } else {
                return BackResult.result(0, "查找失败", null);
            }
        } catch (Exception exception) {
            return BackResult.result(0, exception.getMessage(), null);
        }
    }

    @RequestMapping(value = "/updateById", method = RequestMethod.PUT)
    public Object updateById(@RequestBody CommentFeedBacks commentFeedBacks) {
        try {
            int i = commentFeedBackService.updateById(commentFeedBacks);
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
            List<Object> byTime = commentFeedBackService.findByTime(dates[0], dates[1]);
            if (byTime != null) {
                return BackResult.result(1, "查询成功", null);
            } else {
                return BackResult.result(0, "查询失败", null);
            }
        } catch (Exception exception) {
            return BackResult.result(0, exception.getMessage(), null);
        }
    }

    @RequestMapping(value = "/saveFeedBack", method = RequestMethod.POST)
    public Object saveFeedBack(@RequestBody CommentFeedBacks commentFeedBacks) {
        System.out.println(commentFeedBacks);
        boolean contains = SensitiveWordHelper.contains(commentFeedBacks.getContent());
        JSONObject jsonObject = new JSONObject();
        try {
            if (contains) {
                commentFeedBacks.setStatus(0);
                commentFeedBackService.saveFeedBack(commentFeedBacks);
                jsonObject.put(Consts.CODE, 0);
                jsonObject.put(Consts.MSG, "您的回复包含敏感信息，等带后台进行审核");
            } else {
                int i = commentFeedBackService.saveFeedBack(commentFeedBacks);
                if(i > 0) {
                    jsonObject.put(Consts.CODE, 1);
                    jsonObject.put(Consts.MSG, "回复成功");
                }
            }
        } catch (Exception e) {
            jsonObject.put(Consts.CODE, 0);
            jsonObject.put(Consts.MSG, e.getMessage());
            e.printStackTrace();
        }
        return jsonObject;
    }


    @RequestMapping(value = "/deleteFeedBack/{id}", method = RequestMethod.DELETE)
    public Object deleteFeedBack(@PathVariable("id") String id) {
        JSONObject jsonObject = new JSONObject();
        try {
            int i = commentFeedBackService.deleteById(Integer.parseInt(id));
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
