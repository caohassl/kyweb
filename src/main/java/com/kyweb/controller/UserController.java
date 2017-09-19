package com.kyweb.controller;

import com.kyweb.service.UserService;
import com.kyweb.vo.UserVo;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by zl on 2015/8/27.
 */
@Controller
@RequestMapping("/userController")
public class UserController {

    private Logger logger = Logger.getLogger(UserController.class);

    @Resource
    private UserService userServiceImpl;

    @RequestMapping("/getUserInfo")
    @ResponseBody
    public UserVo getUserInfo() {
        UserVo userVo = userServiceImpl.getUserInfo("admin");
        if (userVo != null) {
            System.out.println("user.getName():" + userVo.getName());
        }
        return userVo;
    }
}
