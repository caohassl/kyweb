CREATE TABLE `tb_quartz` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `message` varchar(200) DEFAULT NULL COMMENT '定时消息和消息模板',
  `quartz_time` varchar(20) DEFAULT NULL COMMENT '若是定时提醒，则有时间',
  `user_name` varchar(30) DEFAULT NULL COMMENT '姓名',
  `message_type` varchar(2) NOT NULL COMMENT '消息类型：0--定时\n1--短信',
  `message_target` varchar(500) DEFAULT NULL COMMENT '存目标手机号，用逗号分隔',
  `message_status` varchar(2) DEFAULT NULL COMMENT '短信0--未发送，1--已发送',
  `message_send_time` varchar(20) DEFAULT NULL COMMENT '短信发送时间',
  `insert_time` varchar(20) DEFAULT NULL COMMENT '短信或者定时任务插入时间',
  `update_time` varchar(20) DEFAULT NULL COMMENT '跟新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='定时和消息表'