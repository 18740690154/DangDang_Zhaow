/*==============================================================*/
/* DBMS name:      ORACLE Version 10g                           */
/* Created on:     2018/05/30 星期三 下午 8:52:02               */
/*==============================================================*/

drop table d_admin cascade constraints;

drop table d_category cascade constraints;

drop table d_book cascade constraints;

drop table d_user cascade constraints;

drop table d_address cascade constraints;

drop table d_order cascade constraints;

drop table d_item cascade constraints;

    select * from d_admin;

    select * from d_category;

	 select * from d_book;
	
	 select * from d_user;

--  select * from d_address;

--  select * from d_order;

--  select * from d_item;

/*==============================================================*/
/* Table: d_admin                                           */
/*==============================================================*/
create table d_admin   (
   id                  VARCHAR2(40)                    not null,
   username            VARCHAR2(40),  --用户名
   password            VARCHAR2(40),  --密码
   constraint PK_D_ADMIN primary key (id)
);

insert into d_admin values ('1', 'admin','admin');		

/*==============================================================*/
/* Table: d_category                                           */
/*==============================================================*/
create table d_category  (
   id                   VARCHAR2(40)                    not null,
   cate_name            VARCHAR2(30),  --类别名
   count                NUMBER(8),     --图书数量 
   parent_id            VARCHAR2(40),  --父类别id
   levels               NUMBER(1),     --等级
   constraint PK_D_CATEGORY primary key (id)
);

insert into d_category values ('1', '小说', 9, '0',1);
insert into d_category values ('2', '武侠小说', 3, '1',2);
insert into d_category values ('3', '言情小说', 1, '1',2);
insert into d_category values ('4', '玄幻小说', 1, '1',2);
insert into d_category values ('5', '校园小说', 4, '1',2);
insert into d_category values ('6', '名著', 4, '0',1);
insert into d_category values ('7', '红楼梦', 1, '6',2);
insert into d_category values ('8', '西游记', 1, '6',2);
insert into d_category values ('9', '三国', 1, '6',2);
insert into d_category values ('10', '水浒传', 1, '6',2);
insert into d_category values ('11', '外语', 9, '0',1);
insert into d_category values ('12', '英语', 2, '11',2);
insert into d_category values ('13', '德语', 0, '11',2);
insert into d_category values ('14', '法语', 1, '11',2);
insert into d_category values ('15', '葡萄牙语', 1, '11',2);
insert into d_category values ('16', '汉语言', 1, '11',2);
insert into d_category values ('17', '日语', 1, '11',2);
insert into d_category values ('18', '韩语', 3, '11',2);
insert into d_category values ('19', '儿童', 0, '0',1);
insert into d_category values ('20', '0~3岁', 0, '19',2);
insert into d_category values ('21', '4~6岁', 0, '19',2);
insert into d_category values ('22', '7~12岁', 0, '19',2);
insert into d_category values ('23', '13~15岁', 0, '19',2);
insert into d_category values ('24', '16~18岁', 0, '19',2);
insert into d_category values ('25', '儿童心理学', 0, '19',2);
insert into d_category values ('26', '胎教', 0, '19',2);
insert into d_category values ('27', '计算机科学与技术', 2, '0',1);
insert into d_category values ('28', '计算机基础', 2, '27',2);
insert into d_category values ('29', 'c语言基础', 0, '27',2);
insert into d_category values ('30', '数据库', 0, '27',2);
insert into d_category values ('31', '计算机组成', 0, '27',2);
insert into d_category values ('32', '信号与系统', 0, '27',2);
insert into d_category values ('33', '数字电子线路', 0, '27',2);
insert into d_category values ('34', '模拟电子线路', 0, '27',2);

/*==============================================================*/
/* Table: d_book                                               */
/*==============================================================*/
create table d_book  (
   id                   VARCHAR2(40)                    not null,
   book_name            VARCHAR2(30),    --图书名
   author               VARCHAR2(20),    --作者
   price                NUMERIC(10, 2),  --价格
   dd_price             NUMERIC(10, 2),  --当当价
   company              VARCHAR2(40),    --出版社
   publish_time         DATE,            --出版时间
   publish_count        VARCHAR2(20),    --出版字数
   isbn                 VARCHAR2(20),    --isbn编码
   print_time           DATE,            --打印时间
   print_count          VARCHAR2(20),    --打印字数
   sale_count           NUMBER(8),       --销售量
   edition             	VARCHAR2(20),    --版次
   impression          	VARCHAR2(20),    --印次
   format               VARCHAR2(20),    --开本
   paper                VARCHAR2(20), 	 --纸张
   pack                 VARCHAR2(20),	 --包装
   page_count           NUMBER(5),   	 --页数
   word_count           NUMBER(10),		 --字数 
   stock_count          NUMBER(10),      --库存量						
   e_recommend          VARCHAR2(256),    --编辑推荐
   c_introduction       VARCHAR2(256),   --内容简介
   author_abstract		VARCHAR2(256),	 --作者简介
   catalogue            VARCHAR2(256),	 --基本目录
   m_comments		    VARCHAR2(256),   --媒体评论
   src                  VARCHAR2(20),    --封面图片路径
   cate_id              VARCHAR2(40),    --所属类别
   constraint PK_D_BOOK primary key (id)
);

insert into d_book values ('101', '一个陌生女人的来信', '薛莹莹', '56.50', '52.50', '青春出版社', to_date('2018-08-15 ', 'yyyy-mm-dd'), '1050000', '13246523', to_date('2018-08-15','yyyy-mm-dd '), '10521231',10000,'第三版','第四次印刷','8k','胶版纸','线装本',351,1050000,20000,'编辑推荐','内容简介','作者简介','基本目录','媒体评论','16.jpg','1');
insert into d_book values ('102', '悲伤逆流成河', '刘旭', '42.50', '39.50', '青春出版社', to_date('2018-08-15', 'yyyy-mm-dd'), '10534000', '1534523', to_date('2018-08-15','yyyy-mm-dd'),'1343431',2000,'第一版', '第四次印刷', '4k','胶版纸','线装本',351,1050000,20000,'编辑推荐','内容简介','作者简介','基本目录','媒体评论','17.jpg','1');
insert into d_book values ('103', '老子说', '薛莹莹','55.50','48.50','青春出版社',to_date('2018-08-15','yyyy-mm-dd'),'1054000','43423',to_date('2018-08-15','yyyy-mm-dd'),'111431', 2000,'第一版','第四次印刷', '4k','胶版纸','线装本',351,1050000,20000,'编辑推荐','内容简介','作者简介','基本目录','媒体评论','17.jpg','1');
insert into d_book values ('104', '达芬奇.密码', '薛莹莹', '12.50', '10.50', '青春出版社', to_date('2018-08-15','yyyy-mm-dd'),'1114000','156323', to_date('2018-08-15','yyyy-mm-dd'),'1385431',2000,'第一版', '第四次印刷', '4k','胶版纸','线装本',351,1050000,20000,'编辑推荐','内容简介','作者简介','基本目录','媒体评论','17.jpg','1');
insert into d_book values ('105', '淘气包与马小跳', '薛莹莹', '53.50', '39.50', '青春出版社', to_date('2018-08-15','yyyy-mm-dd'),'10534012','3534523', to_date('2018-08-15', 'yyyy-mm-dd'),'134342',2000,'第一版', '第四次印刷', '4k','胶版纸','线装本',351,1050000,20000,'编辑推荐','内容简介','作者简介','基本目录','媒体评论','17.jpg','1');
insert into d_book values ('106', '夏洛的网', '薛莹莹', '36.50', '30.50', '青春出版社', to_date('2018-08-15','yyyy-mm-dd'),'10534321','1204523', to_date('2018-08-15','yyyy-mm-dd '),'185431', 2000,'第一版', '第四次印刷', '4k','胶版纸','线装本',351,1050000,20000,'编辑推荐','内容简介','作者简介','基本目录','媒体评论','17.jpg','1');
insert into d_book values ('107', '十里桃花', '唐七', '56.50', '55.50','青春出版社', to_date('2018-08-15','yyyy-mm-dd'),'1053485','19852523', to_date('2018-08-15','yyyy-mm-dd'),'1348651',2000,'第一版', '第四次印刷', '4k','胶版纸','线装本',351,1050000,20000,'编辑推荐','内容简介','作者简介','基本目录','媒体评论','17.jpg','1');
insert into d_book values ('108', '卢隐', '薛莹莹', '56.50', '55.50', '青春出版社', to_date('2018-08-15','yyyy-mm-dd'),'1079879000','146515523', to_date('2018-08-15','yyyy-mm-dd'),'134398652',2000,'第一版', '第四次印刷', '4k','胶版纸','线装本',351,1050000,20000,'编辑推荐','内容简介','作者简介','基本目录','媒体评论','17.jpg','1');
insert into d_book values ('109', '全职高手', '薛莹莹', '50', '49.50','青春出版社', to_date('2018-08-15','yyyy-mm-dd'),'1056850','89456523', to_date('2018-08-15','yyyy-mm-dd'),'134398652',2000,'第一版', '第四次印刷', '4k','胶版纸','线装本',351,1050000,20000,'编辑推荐','内容简介','作者简介','基本目录','媒体评论','17.jpg','1');
insert into d_book values ('110', '扶摇皇后', '薛莹莹', '33.50', '30','青春出版社', to_date('2018-08-15','yyyy-mm-dd'),'87651352','87652', to_date('2018-08-15','yyyy-mm-dd hh24'),'1385621',2000,'第一版', '第四次印刷', '4k','胶版纸','线装本',351,1050000,20000,'编辑推荐','内容简介','作者简介','基本目录','媒体评论','17.jpg','1');
insert into d_book values ('111', '阳光城', '薛莹莹', '33', '29.50','青春出版社',to_date('2018-08-15','yyyy-mm-dd'),'865532','98561', to_date('2018-08-15','yyyy-mm-dd'),'185321',2000,'第一版', '第四次印刷', '4k','胶版纸','线装本',351,1050000,20000,'编辑推荐','内容简介','作者简介','基本目录','媒体评论','17.jpg','1');
insert into d_book values ('112', '小妇人', '郭敬明', '39.50', '39.50','最小说文化出版社',to_date('2018-08-15','yyyy-mm-dd'),'132434', '153', to_date('2018-08-15','yyyy-mm-dd'),'1321',2000,'第一版', '第四次印刷', '4k','胶版纸','线装本',351,1050000,20000,'编辑推荐','内容简介','作者简介','基本目录','媒体评论','17.jpg','1');
insert into d_book values ('113', '简.爱', '郭敬明', '58.50', '39.50','最小说文化出版社',to_date('2018-08-15','yyyy-mm-dd '),'132440', '15423', to_date('2018-08-15','yyyy-mm-dd'),'13431', 2000,'第一版', '第四次印刷', '4k','胶版纸','线装本',351,1050000,20000,'编辑推荐','内容简介','作者简介','基本目录','媒体评论','17.jpg','1');
insert into d_book values ('114', 'java培训', '郭敬明', '58.50', '39.50','最小说文化出版社',to_date('2018-08-15','yyyy-mm-dd '),'132440', '15423', to_date('2018-08-15','yyyy-mm-dd'),'13431', 2000,'第一版', '第四次印刷', '4k','胶版纸','线装本',351,1050000,20000,'编辑推荐','内容简介','作者简介','基本目录','媒体评论','17.jpg','1');
insert into d_book values ('115', '红楼梦', '曹雪芹', '58.50', '39.50','薛莹莹有限公司出版社',to_date('2018-08-15','yyyy-mm-dd '),'132440', '15423', to_date('2018-08-15','yyyy-mm-dd'),'13431', 2000,'第一版', '第四次印刷', '4k','胶版纸','线装本',351,1050000,20000,'编辑推荐','内容简介','作者简介','基本目录','媒体评论','17.jpg','1');
insert into d_book values ('116', '西游记', '吴承恩', '58.50', '39.50','薛莹莹有限公司出版社',to_date('2018-08-15','yyyy-mm-dd '),'132440', '15423', to_date('2018-08-15','yyyy-mm-dd'),'13431', 2000,'第一版', '第四次印刷', '4k','胶版纸','线装本',351,1050000,20000,'编辑推荐','内容简介','作者简介','基本目录','媒体评论','17.jpg','1');
insert into d_book values ('117', '三国', '罗贯中', '58.50', '39.50','薛莹莹有限公司出版社',to_date('2018-08-15','yyyy-mm-dd '),'132440', '15423', to_date('2018-08-15','yyyy-mm-dd'),'13431', 2000,'第一版', '第四次印刷', '4k','胶版纸','线装本',351,1050000,20000,'编辑推荐','内容简介','作者简介','基本目录','媒体评论','17.jpg','1');
insert into d_book values ('118', '水浒传', '薛莹莹', '58.50', '39.50','薛莹莹有限公司出版社',to_date('2018-08-15','yyyy-mm-dd'),'132440', '15423', to_date('2018-08-15','yyyy-mm-dd'),'13431', 2000,'第一版', '第四次印刷', '4k','胶版纸','线装本',351,1050000,20000,'编辑推荐','内容简介','作者简介','基本目录','媒体评论','17.jpg','1');
insert into d_book values ('119', '俞敏洪英语', '俞敏洪', '58.50', '39.50','薛莹莹有限公司出版社',to_date('2018-08-15','yyyy-mm-dd'),'132440','15423', to_date('2018-08-15','yyyy-mm-dd'),'13431',2000,'第一版', '第四次印刷', '4k','胶版纸','线装本',351,1050000,20000,'编辑推荐','内容简介','作者简介','基本目录','媒体评论','17.jpg','1');
insert into d_book values ('120', '完形填空', '薛莹莹', '58.50', '39.50','薛莹莹有限公司出版社',to_date('2018-08-15','yyyy-mm-dd'),'132440','15423',to_date('2018-08-15','yyyy-mm-dd'),'13431',2000,'第一版','第四次印刷', '4k','胶版纸','线装本',351,1050000,20000,'编辑推荐','内容简介','作者简介','基本目录','媒体评论','17.jpg','1');
insert into d_book values ('1211', '儿童心理学', '薛莹莹', '58.50', '39.50','薛莹莹有限公司出版社',to_date('2018-08-15','yyyy-mm-dd'),'132440', '15423', to_date('2018-08-15','yyyy-mm-dd'),'13431',2000,'第一版', '第四次印刷', '4k','胶版纸','线装本',351,1050000,20000,'编辑推荐','内容简介','作者简介','基本目录','媒体评论','17.jpg','1');
insert into d_book values ('1221', '孩子的成长', '薛莹莹', '58.50', '39.50','薛莹莹有限公司出版社',to_date('2018-08-15','yyyy-mm-dd'),'132440', '15423', to_date('2018-08-15','yyyy-mm-dd'),'13431',2000,'第一版', '第四次印刷', '4k','胶版纸','线装本',351,1050000,20000,'编辑推荐','内容简介','作者简介','基本目录','媒体评论','17.jpg','1');
insert into d_book values ('1231', '计算机原理', '薛莹莹', '58.50', '39.50','薛莹莹有限公司出版社',to_date('2018-08-15','yyyy-mm-dd'),'132440', '15423', to_date('2018-08-15','yyyy-mm-dd'),'13431',2000,'第一版', '第四次印刷', '4k','胶版纸','线装本',351,1050000,20000,'编辑推荐','内容简介','作者简介','基本目录','媒体评论','17.jpg','1');
insert into d_book values ('1241', '计算机组成原理', '薛莹莹', '58.50', '39.50','薛莹莹有限公司出版社',to_date('2018-08-15','yyyy-mm-dd'),'132440', '15423', to_date('2018-08-15','yyyy-mm-dd'),'13431',2000,'第一版','第四次印刷', '4k','胶版纸','线装本',351,1050000,20000,'编辑推荐','内容简介','作者简介','基本目录','媒体评论','17.jpg','1');
/*==============================================================*/
/* Table: d_user                                               */
/*==============================================================*/
create table d_user  (
   id                   VARCHAR2(40)                    not null,
   nick_name            VARCHAR2(64),  --昵称
   email                VARCHAR2(64),  --邮箱
   password             VARCHAR2(32),  --密码
   status               NUMBER(8),     --状态
   regist_time          DATE,          --注册时间
   salt                 VARCHAR2(10),  --盐
   constraint PK_D_USER primary key (id)
);
insert into d_user values ('111', '小可爱', '15236674712@163.com', '111111', 1, to_date('2018-06-20 11:55:52', 'yyyy-mm-dd hh24:mi:ss'),'df43');

/*==============================================================*/
/* Table: dd_address                                            */
/*==============================================================*/
create table d_address  (
   id                   VARCHAR2(40)                    not null,
   name                 VARCHAR2(20),  --姓名
   detail               VARCHAR2(20),  --地址
   zip_code             VARCHAR2(20),  --邮编
   phone               VARCHAR2(20),  --手机
   user_id              VARCHAR2(40),  --用户id
   constraint PK_D_ADDRESS primary key (id)
);

/*==============================================================*/
/* Table: dd_order                                              */
/*==============================================================*/
create table d_order  (
   id                   VARCHAR2(40)                    not null,
   order_number         VARCHAR2(30),    --订单编号
   order_times          DATE,            --订单时间
   order_state          VARCHAR2(30),	 --订单状态
   addr_user            VARCHAR2(30),    --收货人
   addr_name            VARCHAR2(30),    --收货地址
   total_price          NUMERIC(12, 2),  --总价
   addr_id              VARCHAR2(40),    --地址id
   user_id              VARCHAR2(40),    --用户id
   constraint PK_D_ORDER primary key (id)
);

insert into d_order values('11111','11111111',to_date('2020-3-25','yyyy-mm-dd'),'未支付', '张三','北京',10000.00,'111111','222222');
/*==============================================================*/
/* Table: d_item                                               */
/*==============================================================*/
create table d_item  (
   id                   VARCHAR2(40)                    not null,
   book_name            VARCHAR2(20),   --图书名
   book_src             VARCHAR2(20),   --图片路径
   price				NUMERIC(8, 2),	 --价格
   dd_price             NUMERIC(8, 2),  --dd价
   count                NUMBER(8),       --数量
   amount               NUMERIC(8, 2),   --小计
   book_id              VARCHAR2(40),    --图书id
   order_id             VARCHAR2(40),    --订单id
   constraint PK_D_ITEM primary key (id)
);