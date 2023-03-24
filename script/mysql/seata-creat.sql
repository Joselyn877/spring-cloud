CREATE table t_order(
                        `id` BIGINT(11) not  null auto_increment PRIMARY key,
                        `user_id` BIGINT(11) DEFAULT null COMMENT '用户id',
                        `product_id` BIGINT(11) DEFAULT null COMMENT '产品id',
                        `clount` INT(11) DEFAULT null COMMENT '数量',
                        `money` DECIMAL(11,0) DEFAULT null COMMENT '金额',
                        `status` INT(1) DEFAULT null COMMENT '订单状态:0-创建中,1-已完结'
)ENGINE=INNODB auto_increment=7 DEFAULT CHARSET=utf8;

select * from t_order;


CREATE table t_storage(
                          `id` BIGINT(11) not  null auto_increment PRIMARY key,
                          `product_id` BIGINT(11) DEFAULT null COMMENT '产品id',
                          `total` BIGINT(11) DEFAULT null COMMENT '总库存',
                          `used` INT(11) DEFAULT null COMMENT '已用库存',
                          `residue` INT(11) DEFAULT null COMMENT '剩余库存'
)ENGINE=INNODB auto_increment=7 DEFAULT CHARSET=utf8;


insert INTO t_storage(`id`,`product_id`,`total`,`used`,`residue`) VALUES('1','1','100','0','100')
select * from t_storage;


CREATE table t_account(
                          `id` BIGINT(11) not  null auto_increment PRIMARY key,
                          `user_id` BIGINT(11) DEFAULT null COMMENT '用户id',
                          `total` BIGINT(11) DEFAULT null COMMENT '总额度',
                          `used` INT(11) DEFAULT null COMMENT '已用额度',
                          `residue` INT(11) DEFAULT null COMMENT '剩余可用额度'
)ENGINE=INNODB auto_increment=7 DEFAULT CHARSET=utf8;

insert INTO t_account(`id`,`user_id`,`total`,`used`,`residue`) VALUES('1','1','1000','0','1000')
select * from t_account;

CREATE TABLE `undo_log`  (
                             `id` bigint(20) NOT NULL AUTO_INCREMENT,
                             `branch_id` bigint(20) NOT NULL,
                             `xid` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
                             `context` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
                             `rollback_info` longblob NOT NULL,
                             `log_status` int(11) NOT NULL,
                             `log_created` datetime(0) NOT NULL,
                             `log_modified` datetime(0) NOT NULL,
                             `ext` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                             PRIMARY KEY (`id`) USING BTREE,
                             UNIQUE INDEX `ux_undo_log`(`xid`, `branch_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;