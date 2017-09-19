package com.kyweb.service;

import com.kyweb.model.TbUser;
import com.kyweb.vo.UserVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kyweb.mapper.TbUserMapper;

/**
 * Created by zl on 2015/8/27.
 */

@Service
public class UserService {

    @Autowired
    TbUserMapper tbuserMapper;

    public UserVo getUserInfo(){
        TbUser tbUser=tbuserMapper.findTbUser("name");
        UserVo userVo=null;
        if(null!=tbUser){
            BeanUtils.copyProperties(tbUser,userVo);
        }
        return userVo;
    }

}
