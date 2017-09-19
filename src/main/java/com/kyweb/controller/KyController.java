package com.kyweb.controller;

import com.kyweb.service.KyDateService;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.Date;

@Controller
public class KyController {

    @Resource(name="kyDateServiceImpl")
    KyDateService kyDateServiceImpl;

    /**
     * 当输入地址时返回默认地址
     * @return
     */
    @RequestMapping("/")
    public String defaultMethod(Model model){
        int allowTime=kyDateServiceImpl.miniTime(new Date());
        model.addAttribute("time",allowTime);
        return "index";
    }


    
}
