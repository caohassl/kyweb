package com.kyweb.controller;

import com.kyweb.service.UserService;
import com.kyweb.vo.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by zl on 2015/8/27.
 */
@Controller
@Slf4j
@RequestMapping("/userController")
public class UserController {


    @Resource
    private UserService userServiceImpl;

    @RequestMapping("/getUserInfo")
    @ResponseBody
    public UserVo getUserInfo(String name) {
        UserVo userVo = userServiceImpl.getUserInfo("admin");
        if (userVo != null) {
            System.out.println("user.getName():" + userVo.getName());
        }
        return userVo;
    }
}
