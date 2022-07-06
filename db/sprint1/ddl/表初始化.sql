CREATE TABLE `tea_record`
(
    `id`               bigint(20)    not null auto_increment,
    `record_detail_id` bigint(20)    not null comment '详情id',
    `open_id`          varchar(100)  not null comment 'openId',
    `brand_id`         bigint(20)    not null comment '奶茶品牌id',
    `name`             varchar(30)   not null comment '奶茶名称',
    `price`            decimal(5, 2) not null comment '奶茶价格',
    `temperature`      tinyint(4)    not null comment '温度(枚举)',
    `brix`             varchar(10)   not null comment '糖度(枚举)',
    `score`            tinyint(2)    not null comment '评分',
    `mood`             varchar(10)            default null comment '此刻心情(枚举)',
    `purchase_time`    varchar(20)   not null comment '购买时间',
    `create_time`      datetime               default null,
    `update_time`      datetime               default null,
    `lock_version`     smallint(6)   not null default '0',
    primary key (id),
    key `idx_open_id` (`open_id`) using btree,
    key `idx_record_detail_id` (`record_detail_id`) using btree
) engine = InnoDB
  default charset = utf8 comment ='奶茶记录表';


CREATE TABLE `tea_record_detail`
(
    `id`           bigint(20)   not null auto_increment,
    `open_id`      varchar(100) not null comment 'openId',
    `toppings`     varchar(50)           default null comment '小料',
    `remark`       text                  default null comment '评价',
    `pic_url`      varchar(200)          default null comment '图片',
    `create_time`  datetime              default null,
    `update_time`  datetime              default null,
    `lock_version` smallint(6)  not null default '0',
    primary key (id)
) engine = InnoDB
  default charset = utf8 comment ='记录详情表';

create table `tea_brand`
(
    `id`               bigint(20)   not null auto_increment,
    `name`             varchar(20)  not null comment '名称',
    `pic_url`          varchar(100)          default null comment '图标',
    `open_id`          varchar(100) not null comment 'openId(系统自建0)',
    `char_group`       char(5)               default null comment '首字母分组',
    `group_sort_index` smallint(6)           default null comment '组内排序',
    `create_time`      datetime              default null,
    `update_time`      datetime              default null,
    `lock_version`     smallint(6)  not null default '0',
    primary key (id),
    unique key `uidx_name` (`name`) using btree
) engine = InnoDB
  default charset = utf8 comment ='品牌表';



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
    key `idx_open_id` (`open_id`) using btree
) engine = InnoDB
  default charset = utf8 comment ='我的品牌';