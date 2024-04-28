package com.sweetfun.controller;
import com.sweetfun.domain.Admin;
import com.sweetfun.service.AdminService;
import com.sweetfun.utils.BackResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;
    @RequestMapping("/login")
    public Object login(@RequestBody Admin admin) {
        System.out.println(admin);
        Admin login = adminService.login(admin);
        if (login != null) {
            return BackResult.result(1, "登录成功", login);
        } else {
            return BackResult.result(0, "登录失败", null);
        }
    }
}
