package com.kyweb.controller;

import com.kyweb.service.KyDateService;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.Date;

@Controller
@RequestMapping(value="/standard")
public class KyController {

    @Resource(name="kyDateServiceImpl")
    KyDateService kyDateServiceImpl;

    /**
     * 当输入地址时返回默认地址
     * @param model
     * @return
     */
    @ApiOperation(value="look for the days",notes="requires noting")
    @RequestMapping("/getLastDays")
    public String index(Model model){
        int allowTime=kyDateServiceImpl.miniTime(new Date());
        model.addAttribute("time",allowTime);
        return "index";
    }


    
}
