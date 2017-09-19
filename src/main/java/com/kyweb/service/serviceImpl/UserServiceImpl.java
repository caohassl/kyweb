package com.kyweb.service.serviceImpl;

import com.kyweb.mapper.TbUserMapper;
import com.kyweb.model.TbUser;
import com.kyweb.service.UserService;
import com.kyweb.vo.UserVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zl on 2015/8/27.
 */

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    TbUserMapper tbuserMapper;

    public UserVo getUserInfo(String name){
        TbUser tbUser=tbuserMapper.findTbUser(name);
        UserVo userVo=new UserVo();
        if(null!=tbUser){
            BeanUtils.copyProperties(tbUser,userVo);
        }
        return userVo;
    }

}
