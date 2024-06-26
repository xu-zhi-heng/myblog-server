package com.sweetfun.controller;

import com.alibaba.fastjson.JSONObject;
import com.sweetfun.domain.Collect;
import com.sweetfun.service.CollectService;
import com.sweetfun.utils.BackResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/collect")
public class CollectController {
    @Autowired
    private CollectService collectService;

    @GetMapping("/findAll")
    public Object getAllCollect() {
        JSONObject jsonObject = null;
        List<Object> all = collectService.findAll();
        if (all != null) {
            jsonObject = (JSONObject) BackResult.result(1, "查询成功", all);
        } else {
            jsonObject = (JSONObject) BackResult.result(0, "数据为空", null);
        }
        return jsonObject;
    }


    @GetMapping("/findByUserId")
    public Object findByUserId(@RequestParam int userId) {
        JSONObject jsonObject = null;
        List<Collect> all = collectService.findByUserId(userId);
        if (all != null) {
            jsonObject = (JSONObject) BackResult.result(1, "查询成功", all);
        } else {
            jsonObject = (JSONObject) BackResult.result(0, "数据为空", null);
        }
        return jsonObject;
    }

    @GetMapping("/findByTime")
    public Object findByUserId(@RequestParam String time) {
        JSONObject jsonObject = null;
        List<Object> all = collectService.findByTime(time);
        if (all != null) {
            jsonObject = (JSONObject) BackResult.result(1, "查询成功", all);
        } else {
            jsonObject = (JSONObject) BackResult.result(0, "数据为空", null);
        }
        return jsonObject;
    }

    @GetMapping("/findByUserIdAndBlogIntroductionId")
    public Object findByUserIdAndBlogIntroductionId(@RequestParam int userId, @RequestParam int blogIntroductionId) {
        JSONObject jsonObject = null;
        Collect byUserIdAndBlogIntroductionId = collectService.findByUserIdAndBlogIntroductionId(userId, blogIntroductionId);
        if (byUserIdAndBlogIntroductionId != null) {
            jsonObject = (JSONObject) BackResult.result(1, "查询成功", byUserIdAndBlogIntroductionId);
        } else {
            jsonObject = (JSONObject) BackResult.result(0, "数据为空", null);
        }
        return jsonObject;
    }

    @DeleteMapping("/deleteById/{id}")
    public Object deleteById(@PathVariable("id") int id) {
        JSONObject jsonObject = null;
        try {
            collectService.deleteCollect(id);
            jsonObject = (JSONObject) BackResult.result(1, "删除成功", null);
        } catch (Exception exception) {
            jsonObject = (JSONObject) BackResult.result(0, exception.getMessage(), null);
        }
        return jsonObject;
    }

    @PostMapping("/addCollect")
    public Object addCollect(@RequestBody Collect collect) {
        JSONObject jsonObject = null;
        try {
            int count = collectService.addCollect(collect);
            jsonObject = (JSONObject) BackResult.result(1, "添加成功", collect.getId());
        } catch (Exception exception) {
            jsonObject = (JSONObject) BackResult.result(0, exception.getMessage(), null);
        }
        return jsonObject;
    }

    @PostMapping("/updateCollect")
    public Object updateCollect(@RequestBody Collect collect) {
        JSONObject jsonObject = null;
        try {
            collectService.updateCollect(collect);
            jsonObject = (JSONObject) BackResult.result(1, "更新成功", null);
        } catch (Exception exception) {
            jsonObject = (JSONObject) BackResult.result(0, exception.getMessage(), null);
        }
        return jsonObject;
    }
}
