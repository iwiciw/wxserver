DROP TABLE IF EXISTS tea_record;
CREATE TABLE `tea_record`
(
    `id`            bigint(20)    not null auto_increment,
    `open_id`       varchar(100)  not null comment 'openId',
    `brand_id`      bigint(20)    not null comment '奶茶品牌id',
    `tea_name`      varchar(30)   not null comment '奶茶名称',
    `price`         decimal(5, 2) not null comment '奶茶价格',
    `temperature`   varchar(10)   not null comment '温度(枚举)',
    `brix`          tinyint(2)    not null comment '糖度(枚举)',
    `score`         tinyint(2)    not null comment '评分',
    `cup`           varchar(10)   not null comment '份量',
    `mood`          varchar(10)            default null comment '此刻心情(枚举)',
    `purchase_time` char(10)      not null comment '购买时间',
    `create_time`   datetime               default null,
    `update_time`   datetime               default null,
    `lock_version`  smallint(6)   not null default '0',
    primary key (id),
    key `idx_open_id` (`open_id`) using btree,
    key `idx_purchase_time` (`purchase_time`) using btree,
    key `idx_brand_id` (`brand_id`) using btree,
    key `idx_name` (`tea_name`) using btree
) engine = InnoDB
  default charset = utf8 comment ='奶茶记录表';

DROP TABLE IF EXISTS tea_record_detail;
CREATE TABLE `tea_record_detail`
(
    `id`           bigint(20)   not null auto_increment,
    `record_id`    bigint(20)   not null comment '记录表id',
    `open_id`      varchar(100) not null comment 'openId',
    `toppings`     varchar(50)           default null comment '小料',
    `remark`       text                  default null comment '评价',
    `pic_url`      varchar(200)          default null comment '图片',
    `create_time`  datetime              default null,
    `update_time`  datetime              default null,
    `lock_version` smallint(6)  not null default '0',
    primary key (id),
    key `idx_record_id` (`record_id`) using btree
) engine = InnoDB
  default charset = utf8 comment ='记录详情表';

DROP TABLE IF EXISTS tea_brand;
create table `tea_brand`
(
    `id`               bigint(20)   not null auto_increment,
    `brand_name`       varchar(20)  not null comment '名称',
    `pic_url`          varchar(100)          default null comment '图标',
    `open_id`          varchar(100) not null comment 'openId(系统自建0)',
    `char_group`       char(5)               default null comment '首字母分组',
    `group_sort_index` smallint(6)           default null comment '组内排序',
    `create_time`      datetime              default null,
    `update_time`      datetime              default null,
    `lock_version`     smallint(6)  not null default '0',
    primary key (id),
    unique key `uidx_name` (`brand_name`) using btree
) engine = InnoDB
  default charset = utf8 comment ='品牌表';


DROP TABLE IF EXISTS user_tea_brand;
create table `user_tea_brand`
(
    `id`           bigint(20)   not null auto_increment,
    `open_id`      varchar(100) not null comment 'openId',
    `brand_id`     bigint(20)   not null comment '品牌id',
    `sort_index`   smallint(6)           default null comment '排序因子',
    `create_time`  datetime              default null,
    `update_time`  datetime              default null,
    `lock_version` smallint(6)  not null default '0',
    primary key (id),
    unique key `uidx_open_brand_id` (`open_id`, `brand_id`) using btree
) engine = InnoDB
  default charset = utf8 comment ='我的品牌';