package com.sweetfun.controller;
import com.alibaba.fastjson.JSONObject;
import com.sweetfun.domain.User;
import com.sweetfun.service.LoginService;
import com.sweetfun.utils.Consts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;
    @RequestMapping(value = "/user/login",method = RequestMethod.POST)
    public Object login(@RequestBody User user) {
        JSONObject jsonObject = new JSONObject();
        User login = loginService.Login(user);
        if(login != null) {
            jsonObject.put(Consts.CODE,1);
            jsonObject.put(Consts.MSG,"登陆成功");
            jsonObject.put(Consts.DATA,login);
        }else {
            jsonObject.put(Consts.CODE,0);
            jsonObject.put(Consts.MSG,"用户名或密码不对");
        }
        return jsonObject;
    }
}
