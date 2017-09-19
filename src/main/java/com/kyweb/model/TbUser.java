package com.kyweb.model;

import lombok.Data;

/**
 * Created by zl on 2015/8/27.
 */
@Data
public class TbUser {
    /**
     * 主键id
     */
    private String id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 密码
     */
    private String password;
    /**
     * 创建时间
     */
    private String insertTime;
    /**
     * 修改时间
     */
}
