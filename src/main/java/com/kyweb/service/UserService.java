package com.kyweb.service;

import com.kyweb.vo.UserVo;

/**
 * Created by zl on 2015/8/27.
 */

public interface UserService {


    /**
     * 获得一个UserVo对象
     * @param name
     * @return
     */
    UserVo getUserInfo(String name);


}
