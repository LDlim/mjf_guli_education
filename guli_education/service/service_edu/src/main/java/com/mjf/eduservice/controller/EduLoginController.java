package com.mjf.eduservice.controller;

import com.mjf.commonutils.ResponseObject;
import org.springframework.web.bind.annotation.*;

/**
 * 登录接口
 *
 * @author LDlim
 * @date 2021/1/11 19:55
 */
@RestController
@RequestMapping("/user")
@CrossOrigin
public class EduLoginController {

    @PostMapping("/login")
    public ResponseObject login() {
        return ResponseObject.responseSuccess()
                .setData("token", "admin");
    }

    @GetMapping("/info")
    public ResponseObject info() {
        return ResponseObject.responseSuccess()
                .setData("roles", "super_admin")
                .setData("name", "admin")
                .setData("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
    }

    @PostMapping("/logout")
    public ResponseObject logout() {
        return ResponseObject.responseSuccess()
                .setData("token", "admin");
    }
}
