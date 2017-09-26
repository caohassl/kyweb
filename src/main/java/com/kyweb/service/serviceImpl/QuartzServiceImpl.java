package com.kyweb.service.serviceImpl;

import com.kyweb.mapper.TbQuartzMapper;
import com.kyweb.model.TbQuartz;
import com.kyweb.service.QuartzService;
import com.kyweb.vo.QuartzVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/9/25.
 */
@Service
@Slf4j
public class QuartzServiceImpl implements QuartzService {

    @Autowired
    TbQuartzMapper tbQuartzMapper;

    @Override
    public int insertQuarzMessage(QuartzVo quartzVo) {
        TbQuartz tbQuartz=new TbQuartz();
        if(quartzVo!=null){
            BeanUtils.copyProperties(quartzVo,tbQuartz);
        }
        int i=tbQuartzMapper.insert(tbQuartz);
        log.info("成功插入数据{}条",i);
        return i;
    }
}
