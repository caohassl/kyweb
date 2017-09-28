package com.kyweb.controller;

import com.alibaba.fastjson.JSON;
import com.kyweb.service.QuartzService;
import com.kyweb.utils.CommonUtil;
import com.kyweb.vo.QuartzVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/9/25.
 */
@Controller
@Slf4j
@RequestMapping("/timeController")
public class TimeController {

    @Resource
    private QuartzService quartzServiceImpl;

    /**
     * 插入一条记录
     * @param quartzVo
     * @param session
     * @return
     */
    @RequestMapping("/addTime")
    @ResponseBody
    public Map addTime(QuartzVo quartzVo, HttpSession session){
        log.info("{}开始插入数据{}",session.getAttribute("name"), JSON.toJSONString(quartzVo));
        Map<String,Object> map=new HashMap<String,Object>();
        String args[]=new String[]{"message","quartzTime"};
        String result=CommonUtil.checkBeanPropertiesHaveBlank(quartzVo,args);
        if(!StringUtils.isEmpty(result)){
            map.put("code","no");
            map.put("message",result);
        }
        int i=quartzServiceImpl.insertQuarzMessage(quartzVo);
        map.put("code","yes");
        log.info("{}开始插入数据{}成功",session.getAttribute("name"));
    return map;
    }
}
