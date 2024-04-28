package com.sweetfun.controller;

import com.alibaba.fastjson.JSONObject;
import com.sweetfun.domain.User;
import com.sweetfun.service.RegisterService;
import com.sweetfun.utils.Consts;
import com.sweetfun.utils.MD5Utils;
import com.sweetfun.utils.UniqueKeyGenerator;
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
        user.setAvatar("https://cdnp3.stackassets.com/fa6fd1e226152eba86fa65cef159cde3d5a40517/store/fd9cf709c1417e2cabff70f3d3d2b3be06d0becd1df0cccfc661d327a3a7/sale_229497_primary_image.jpg");
        String userKey = UniqueKeyGenerator.generateUniqueKey();
        user.setUserKey(userKey);
        String password = user.getPassword();
        user.setPassword(MD5Utils.convertMD5(password));
        boolean register = registerService.Register(user);
        if(register) {
            jsonObject.put(Consts.DATA, userKey);
            jsonObject.put(Consts.CODE,1);
            jsonObject.put(Consts.MSG,"注册成功");
        }else {
            jsonObject.put(Consts.CODE,0);
            jsonObject.put(Consts.MSG,"注册失败");
        }
        return jsonObject;
    }
}
