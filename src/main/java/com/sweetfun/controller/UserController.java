package com.sweetfun.controller;

import com.alibaba.fastjson.JSONObject;
import com.sweetfun.domain.User;
import com.sweetfun.service.UserService;
import com.sweetfun.utils.Consts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/findByUserId")
    public Object login(@RequestParam Integer userId) {
        JSONObject jsonObject = new JSONObject();
        try {
            User user = userService.findByUserId(userId);
            if(user != null) {
                jsonObject.put(Consts.CODE,1);
                jsonObject.put(Consts.MSG,"查询成功");
                jsonObject.put(Consts.DATA,user);
            }else {
                jsonObject.put(Consts.CODE,1);
                jsonObject.put(Consts.MSG,"没有查到该用户");
                jsonObject.put(Consts.DATA,null);
            }
            return jsonObject;
        }catch (Exception e) {
            e.printStackTrace();
            jsonObject.put(Consts.CODE,0);
            jsonObject.put(Consts.MSG,e.getMessage());
            return jsonObject;
        }
    }
}
