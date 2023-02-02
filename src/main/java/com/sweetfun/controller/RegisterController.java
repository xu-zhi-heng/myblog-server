package com.sweetfun.controller;

import com.alibaba.fastjson.JSONObject;
import com.sweetfun.domain.User;
import com.sweetfun.service.RegisterService;
import com.sweetfun.utils.Consts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {
    @Autowired
    private RegisterService registerService;
    @RequestMapping(value = "/user/register",method = RequestMethod.POST)
    public Object Register(@RequestBody User user) {
        JSONObject jsonObject = new JSONObject();
        boolean register = registerService.Register(user);
        if(register) {
            jsonObject.put(Consts.CODE,1);
            jsonObject.put(Consts.MSG,"注册成功");
        }else {
            jsonObject.put(Consts.CODE,0);
            jsonObject.put(Consts.MSG,"注册失败");
        }
        return jsonObject;
    }
}
