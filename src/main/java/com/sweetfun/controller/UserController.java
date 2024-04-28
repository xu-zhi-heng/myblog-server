package com.sweetfun.controller;
import com.alibaba.fastjson.JSONObject;
import com.sweetfun.domain.User;
import com.sweetfun.service.UserService;
import com.sweetfun.utils.BackResult;
import com.sweetfun.utils.Consts;
import com.sweetfun.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.sweetfun.utils.UniqueKeyGenerator;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

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

    @RequestMapping("/findAll")
    public Object findAll() {
        Object result = null;
        try {
            List<User> all = userService.findAll();
            if (all != null) {
                result = BackResult.result(1, "查询成功", all);
            } else {
                result = BackResult.result(0, "未查询到数据", null);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
            return BackResult.result(0, exception.getMessage(), null);
        }
        return result;
    }

    @RequestMapping("/deleteById")
    public Object deleteByUserId(@RequestParam Integer userId) {
        Object result = null;
        try {
            boolean flag = userService.deleteById(userId);
            if (flag) {
                result = BackResult.result(1, "删除成功", null);
            } else {
                result = BackResult.result(0, "删除失败", null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return BackResult.result(0, e.getMessage(), null);
        }
        return result;
    }

    @RequestMapping("/totalUser")
    public Object total() {
        Object result = null;
        try {
            int number = userService.totalUserNumber();
            result = BackResult.result(1, "查询成功", number);
        } catch (Exception e) {
            return BackResult.result(0, e.getMessage(), null);
        }
        return result;
    }

    @RequestMapping("/updateUser")
    public Object updateUser(@RequestBody User user) {
        Object result = null;
        user.setPassword(MD5Utils.convertMD5(user.getPassword()));
        try {
            boolean flag = userService.updateUser(user);
            if (flag) {
                result = BackResult.result(1, "更新成功", null);
            } else {
                result = BackResult.result(0, "更新失败", null);
            }
        } catch (Exception e) {
            return BackResult.result(0, e.getMessage(), null);
        }
        return result;
    }

    @RequestMapping("/addUser")
    public Object addUser(@RequestBody User user) {
        try {
            user.setAvatar("https://cdnp3.stackassets.com/fa6fd1e226152eba86fa65cef159cde3d5a40517/store/fd9cf709c1417e2cabff70f3d3d2b3be06d0becd1df0cccfc661d327a3a7/sale_229497_primary_image.jpg");
            user.setUserKey(UniqueKeyGenerator.generateUniqueKey());
            user.setPassword(MD5Utils.convertMD5(user.getPassword()));
            boolean flag = userService.addUser(user);
            if (flag) {
                return BackResult.result(1, "添加成功", null);
            } else {
                return BackResult.result(0, "添加失败", null);
            }
        } catch (Exception e) {
            return BackResult.result(0, e.getMessage(), null);
        }
    }

    @RequestMapping("/uploadImg")
    public Object handleFileUpload(@RequestParam("avatar") MultipartFile file, @RequestParam("userId") Integer userId) {
        String fileName = file.getOriginalFilename();
        try {
            file.transferTo( new File(new File("src\\main\\resources\\static").getAbsolutePath()+ "/" + fileName));
        } catch (Exception e) {
           return BackResult.result(0, e.getMessage(), null);
        }
        String path = "http://localhost:8888/static/" + fileName;
        User user = new User();
        user.setUserId(userId);
        user.setAvatar(path);
        userService.updateUser(user);
        return BackResult.result(1, "更新成功", path);
    }

}
