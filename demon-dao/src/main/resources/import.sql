/*
Date: 2016-06-21 22:31:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- 商品表
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `media_id` bigint(11) DEFAULT NULL,
  `nickname` varchar(50) DEFAULT NULL,
  `account` varchar(50) DEFAULT NULL,
  `head_img_url` varchar(200) DEFAULT NULL,
  `summary` varchar(500) DEFAULT NULL,
  `isv` varchar(1) DEFAULT NULL,
  `industry_id` int(11) DEFAULT NULL,
  `fans_num` int(8) DEFAULT NULL,
  `price` float(10,2) DEFAULT '0.00',
  `wb_url` varchar(200) DEFAULT NULL,
  `detail` longtext,
  `wx_simple_imagetext` varchar(10) DEFAULT NULL,
  `wx_more_imagetext_one` varchar(50) DEFAULT NULL,
  `wx_simple_imagetext_two` varchar(50) DEFAULT NULL,
  `wx_simple_imagetextn` varchar(50) DEFAULT NULL,
  `show_in_index` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- 行业分类表
-- ----------------------------
DROP TABLE IF EXISTS `industry_type`;
CREATE TABLE `industry_type` (
  `industry_id` bigint(11) NOT NULL AUTO_INCREMENT,
  `industry_name` varchar(50) DEFAULT NULL,
  `show_status` int(1) DEFAULT NULL,
  `show_order` int(1) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  PRIMARY KEY (`industry_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- 媒体分类表
-- ----------------------------
DROP TABLE IF EXISTS `media_type`;
CREATE TABLE `media_type` (
  `media_id` bigint(11) NOT NULL AUTO_INCREMENT,
  `media_name` varchar(50) DEFAULT NULL,
  `icon_url` varchar(200) DEFAULT NULL,
  `show_status` int(1) DEFAULT NULL,
  `show_order` int(2) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  PRIMARY KEY (`media_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- 订单表
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `id` bigint(11) NOT NULL,
  `user_id` bigint(11) DEFAULT NULL,
  `media_name` varchar(50) DEFAULT NULL,
  `send_method` varchar(20) DEFAULT NULL,
  `ad_type` varchar(20) DEFAULT NULL,
  `activity_name` varchar(200) DEFAULT NULL,
  `title` varchar(100) DEFAULT NULL,
  `author` varchar(50) DEFAULT NULL,
  `activity_time` datetime DEFAULT NULL,
  `forward_link` varchar(500) DEFAULT NULL,
  `forward_title` varchar(500) DEFAULT NULL,
  `direct_img_url` varchar(200) DEFAULT NULL,
  `cover_img_url` varchar(200) DEFAULT NULL,
  `goods_id` bigint(11) DEFAULT NULL,
  `price` float(10,2) DEFAULT NULL,
  `pay_status` int(2) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- 推广计划表
-- ----------------------------
DROP TABLE IF EXISTS `promotion_plan`;
CREATE TABLE `promotion_plan` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(11) DEFAULT NULL,
  `demand` longtext,
  `date` datetime DEFAULT NULL,
  `price` float(10,2) DEFAULT NULL,
  `status` int(5) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- 用户表表
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) UNIQUE DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `contact` varchar(100) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `mailbox` varchar(50) DEFAULT NULL,
  `fixed_phone` varchar(50) DEFAULT NULL,
  `qq` varchar(20) DEFAULT NULL,
  `com_short` varchar(255) DEFAULT NULL,
  `com_full` varchar(255) DEFAULT NULL,
  `com_address` varchar(255) DEFAULT NULL,
  `com_homepage` varchar(255) DEFAULT NULL,
  `com_microblog` varchar(255) DEFAULT NULL,
  `com_desc` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
alter table user AUTO_INCREMENT=10000000000;

-- ----------------------------
-- 后台管理员表
-- ----------------------------
DROP TABLE IF EXISTS `user_platform`;
CREATE TABLE `user_platform` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `login_username` varchar(50) UNIQUE DEFAULT NULL,
  `login_password` varchar(50) DEFAULT NULL,
  `role` varchar(11) DEFAULT NULL,
  `gmt_create` datetime DEFAULT NULL,
  `gmt_motify` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
alter table user_platform AUTO_INCREMENT=20000000000;

-- ----------------------------
-- 后台管理员表初始化测试数据
-- 超级管理员账户：admin 密码：admin01
-- ----------------------------
insert into user_platform (gmt_create, gmt_motify, login_password, login_username, role) values ("2016-06-26 15:51:03","2016-06-26 15:51:03","FFFDE1E68BAEB8DF53C3F5D440D7FC64","admin","SUPER_ADMIN");

-- ----------------------------
-- Date: 2016-06-22  更新内容
-- ----------------------------
/*标记媒体分类是否是在首页显示*/
ALTER TABLE `media_type` ADD COLUMN `show_index`  int(1) NULL AFTER `icon_url`;
/*标记商品是否是在首页显示*/
ALTER TABLE `goods` ADD COLUMN `show_in_index`  int(1) NULL AFTER `wx_simple_imagetextn`;

-- ----------------------------
-- 新增轮播图表
-- ----------------------------
DROP TABLE IF EXISTS `turn_img`;
CREATE TABLE `turn_img` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `img_url` varchar(300) DEFAULT NULL,
  `img_text` varchar(300) DEFAULT NULL,
  `img_link` varchar(100) DEFAULT NULL,
  `show_status` int(1) DEFAULT NULL,
  `show_order` int(1) DEFAULT NULL,
  `type` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- 媒体大类表初始化测试数据
-- ----------------------------
INSERT INTO `media_type` VALUES ('1', '微播粉丝通', null, '1', null, null, null, null);
INSERT INTO `media_type` VALUES ('2', '微播大号', null, '1', null, null, null, null);
INSERT INTO `media_type` VALUES ('3', '微信公众号', null, '1', null, null, null, null);
INSERT INTO `media_type` VALUES ('4', '微信朋友圈', null, '1', null, null, null, null);
INSERT INTO `media_type` VALUES ('5', '广点通', null, '1', null, null, null, null);
INSERT INTO `media_type` VALUES ('6', '智慧推', null, '1', null, null, null, null);
INSERT INTO `media_type` VALUES ('7', '陌陌', null, '1', null, null, null, null);
INSERT INTO `media_type` VALUES ('8', '今日头条', null, '1', null, null, null, null);

-- ----------------------------
-- 轮播图初始化测试数据
-- ----------------------------
INSERT INTO `turn_img` VALUES ('1', 'https://aecpm.alicdn.com/simba/img/TB117XhKFXXXXcCXpXXSutbFXXX.jpg', null, '小g', null, null, '1');
INSERT INTO `turn_img` VALUES ('2', 'https://img.alicdn.com/tps/TB1TwM0KpXXXXXJaXXXXXXXXXXX-520-280.jpg', null, '你猜这图是啥', null, null, '1');
INSERT INTO `turn_img` VALUES ('3', 'https://img.alicdn.com/tps/TB1lgAuKpXXXXaQXFXXXXXXXXXX-520-280.png', null, '呵呵哒1', null, null, '1');
INSERT INTO `turn_img` VALUES ('4', 'https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=62160148,875527585&fm=116&gp=0.jpg', null, '新风尚奖', null, null, '2');
INSERT INTO `turn_img` VALUES ('5', 'https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=3529695996,3767693256&fm=116&gp=0.jpg', null, '新媒体奖', null, null, '2');

-- ----------------------------
-- 商品表初始化测试数据
-- ----------------------------
INSERT INTO `goods` VALUES ('1', '1', '杨幂', null, 'http://hiphotos.baidu.com/zhixin/abpic/item/4bac30738bd4b31c6138add385d6277f9e2ff817.jpg', '杨幂，1986年9月12日出生于北京市，中国内地影视女演员、流行乐歌手、影视制片人。2005年，杨幂进入北京电影学院表演系本科班就读。2006年，杨幂因在武侠剧《神雕侠侣》中饰演郭襄而崭露头角。2008年，凭借历史剧《王昭君》获得第7届中国金鹰电视艺术节最佳女演员奖提名。2009年，杨幂在“80后新生代娱乐大明星”评选活动中与其她三位女演员共同被评为“四小花旦”', null, null, '30001', '0.00', null, null, null, null, null, null, '1');
INSERT INTO `goods` VALUES ('2', '1', '李易峰', null, 'http://c.hiphotos.baidu.com/baike/whcrop%3D100%2C100/sign=59751ff98a1001e94e69424dd77e46dd/11385343fbf2b21169aad35ecd8065380cd78e1e.jpg', '哥，你为什么这么丑', null, null, '2889', '0.00', null, null, null, null, null, null, '1');
INSERT INTO `goods` VALUES ('3', '1', '邓紫棋', null, 'http://hiphotos.baidu.com/zhixin/abpic/item/7aad4ae736d12f2e8155b1a64dc2d56284356860.jpg', '邓紫棋（G.E.M.），原名邓诗颖，1991年8月16日生于中国上海，4岁移居香港，中国香港创作型女歌手。2008年7月10日', null, null, '4567', '0.00', null, null, null, null, null, null, '1');
INSERT INTO `goods` VALUES ('4', '1', 'Angelababy', null, 'https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=523395346,19022666&fm=58', '杨颖（Angelababy），1989年2月28日出生于上海，中国影视女演员。2003年以模特身份出道。2007年将演艺事业的重心转向大银幕。2009年主演爱情电影《全城热恋》。2011年在电影《夏日乐悠悠》中首次担任女主角。2012年凭借爱情电影《第一次》获得第十三届华语电影传媒大奖“最受瞩目女演员奖”。2013年1月，《南都娱乐周刊》举办新生代四小花旦的评选活动，杨颖以70分的综合得分当选为新“四小花旦”之一；同年主演电视剧处女作《大汉情缘之云中歌》', null, null, '567892', '0.00', null, null, null, null, null, null, '1');
INSERT INTO `goods` VALUES ('5', '1', '杨洋', null, 'https://ss0.baidu.com/-Po3dSag_xI4khGko9WTAnF6hhy/image/h%3D200/sign=a618a3589f25bc31345d06986edd8de7/a5c27d1ed21b0ef49038eec8dbc451da80cb3e57.jpg', '老了，都不知道你是啥时候火的', null, null, '45673', '0.00', null, null, null, null, null, null, '1');
INSERT INTO `goods` VALUES ('6', '1', '胡歌', null, 'https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=1545947155,1766765649&fm=58', '你这个大色魔呀', null, null, '341223', '0.00', null, null, null, null, null, null, '1');
INSERT INTO `goods` VALUES ('7', '1', '江疏影', null, 'https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=93637882,2843582375&fm=58', '火了吧，开心吧', null, null, '45642', '0.00', null, null, null, null, null, null, null);

-- ----------------------------
-- 招贤纳士表
-- ----------------------------
DROP TABLE IF EXISTS `job_info`;
CREATE TABLE `job_info` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `type_id` int(11) DEFAULT NULL,
  `job_name` varchar(50) DEFAULT NULL,
  `experience` varchar(50) DEFAULT NULL,
  `degree` varchar(50) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `detail` longtext,
  `create_time` datetime DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- 招贤纳士测试数据
-- ----------------------------
INSERT INTO `job_info` VALUES ('1', '6', '产品经理', '两年以上', '本科', '杭州', null, null, null);
INSERT INTO `job_info` VALUES ('2', '5', 'Java工程师', '一年以上', '本科', '杭州', null, null, null);
INSERT INTO `job_info` VALUES ('3', '6', '数据分析', '5年以上', '本科', '杭州', null, null, null);
INSERT INTO `job_info` VALUES ('4', '5', '前端开发', '一年以上', '本科', '杭州', null, null, null);
INSERT INTO `job_info` VALUES ('5', null, '技术', null, null, null, null, null, null);
INSERT INTO `job_info` VALUES ('6', null, '产品', null, null, null, null, null, null);
INSERT INTO `job_info` VALUES ('7', null, '设计', null, null, null, null, null, null);
INSERT INTO `job_info` VALUES ('8', null, '公关', null, null, null, null, null, null);
INSERT INTO `job_info` VALUES ('9', null, '市场', null, null, null, null, null, null);
INSERT INTO `job_info` VALUES ('10', null, '运营', null, null, null, null, null, null);

-- ----------------------------
-- 文章表
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `id` bigint(11) NOT NULL,
  `title` varchar(200) DEFAULT NULL,
  `detail` longtext,
  `type` int(1) DEFAULT NULL,
  `show_order` int(1) DEFAULT NULL,
  `show_in_index` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- 文章测试数据
-- ----------------------------
INSERT INTO `article` VALUES ('1', '自媒体行业应告别野蛮生长', '由于种种因素推动，２０１６年注定将成为自媒体发展突飞猛进的一年。尤其值得关注的是，随着各大平台同时发力拉拢自媒体，彼此对于自媒体的争夺也将日趋激烈。而自媒体行业本身如何告别“野蛮生长”，提升自身素质与发展质量也显得日益迫切。\r\n\r\n　　４月２３日，以Ｘ时代为主题的２０１６腾讯汽车创领者峰会在北京举行。５０余位业内重量级嘉宾及２００余家主流媒体莅临现场，从新格局、新媒介、新技术以及新用户四大话题进行观点分享及现场互动。此次峰会除了汽车企业、互联网公司与学者之间激烈的观点碰撞之外，最受关注的莫过于腾讯推出的“芒种计划”与“千乘计划”。\r\n\r\n　　腾讯宣布，在“芒种计划”基础上，即斥资２亿元扶持原创内容、百分之百底层广告分成的计划之外，再追加５００万元，额外用于汽车自媒体奖励。这就是腾讯的“千乘计划”。按照腾讯网副总编辑葛 的话说，“千乘计划”的发布将助力现有内容生态的重建，并给广大自媒体带来更好的平台与空间。\r\n\r\n　　在此之前一天，搜狐也宣布将全面支持ＶＲ自媒体。４月２２日，搜狐公司董事局主席张朝阳在第二届搜狐视频出品人大会上表示，搜狐视频今年将继续推动自媒体ＰＧＣ的战略发展。民生视频方面，目前搜狐视频启动了内部代号为“千里眼”的项目，招募两千位“千里眼”志愿者覆盖全国三百个城市，上传全国各地发生的热门民生事件。此外，搜狐视频产品中心总监郑韬还表示，搜狐视频即将成为全面支持ＶＲ的自媒体平台。\r\n\r\n　　而在“金牌计划”中，经搜狐视频平台核准为金牌出品人的，将会得到搜狐视频的推广资源、联合出品、分成比例的１．５倍提升以及股权合作。搜狐视频此次宣布，２０１６年将针对金牌出品人投入１０亿推广资源，１亿元现金支持和５亿元广告资源支持，投入资源计划综合超１６亿元，并希望通过金牌出品人计划打造３０家估值过亿元的出品人团队。\r\n\r\n　　作为主要门户之一的新浪也在大力发展网络自媒体。譬如，新浪财经最近推出的头条号奖励计划规定，根据每月底统计头条号本月阅读总量，对排名前１０的头条号作者进行奖励，奖金共１０万元。除了内容奖励，另外还有拉人奖励和产品改进奖励。拉人奖励是根据当月拓展流量总和排名对邀请者进行奖励，奖金共２万元。\r\n\r\n　　实际上，加入自媒体争夺战的平台还有很多，网易、百度、今日头条等都纷纷发力打造自媒体平台，抛出各种诱饵，竭力吸引自媒体人加盟，自媒体争夺战愈演愈烈。\r\n\r\n　　为何这些平台要拼尽全力笼络自媒体？其实原因很简单，随着社会发展，特别是移动互联网快速崛起，最近的自媒体很火。相比于传统媒体，自媒体更为活跃，从内容生产、表达方式到传播方式，都更加贴近受众。加上优秀自媒体人都是各行各业精英，在获取信息、掌握资源和话语权等方面具有一定优势。\r\n\r\n　　过去是内容生产者追着门户编辑求发稿，而现在是各大平台疯抢内容生产者。很明显，无论是在过去追逐平台，还是在现在将目光转向内容生产者，本质上都是对“流量分配权”的争夺。\r\n\r\n　　可以说，伴随着自媒时代的到来，很大程度上，媒体类平台抢夺优秀自媒体资源已经变成了人才大战，各大平台都在想方设法网聚优势资源。从目前来看，拥有微信、ＱＱ、门户网站以及天天快报等优势传播渠道的腾讯，在自媒体平台打造上暂时占据了上风。\r\n\r\n　　不过，现在各大平台都在大力网聚优秀自媒体资源，不断创新，试图反超腾讯。由于传播渠道日渐多元化，平台优势已经不是新闻类平台决胜的关键，优质原创内容的可持续生产才是决定竞争中谁胜谁负的最主要因素。所以，最终谁能胜出？还需走着瞧。\r\n\r\n　　需要指出的是，尽管眼下不少自媒体大号拿到了千万级别的投资。在所谓的资本寒冬期，这样的表现让人眼前一亮。但是从自媒体行业来看发展良莠不齐，有些自媒体为了博得关注发布低俗不良信息甚至虚假信息，碰触红线被封号的事情时有发生。\r\n\r\n　　因此，自媒体行业如何告别“野蛮生长”，不断提升自身素质与发展质量显得日益迫切。这要求自媒体人必须坚持正确舆论导向，重视改进创新，特别是要认真学习落实有关规定，增强行业自律，不得刊发、转载未经核实的信息，坚决杜绝虚假信息和不良信息，促进自媒体和网络空间健康规范发展', '1', null, '1');
INSERT INTO `article` VALUES ('2', '连接一切：自媒体的未来是什么？？', '在微信社交时代，自媒体的未来是什么？如果您有足够的耐心看完此文，相信您心中会有一个属于自己的答案。\r\n　　从营销的角度看，最好的传播，就是用最有效的途径，触达需要被影响的人群。在过去的数百年中，媒体一直在扮演着这个“途径”的角色。\r\n　　在连接一切的移动互联网时代，社交的时间成本大幅降低，过去依靠电话、会议、会面去沟通的方式，已经逐渐被微信所取代。如果说互联网改变了社会分工的区域障碍，那么在移动社交时代，带来的是沟通与协作方式的一种彻底变革。\r\n　　变革的结果，是过去很多不可逾越的成本壁垒，被轻而易举的攻破：当大公司的管理层还在疲于出差开会，或为昂贵的可视会议系统买单时，小微公司的团队，几个微信群，便可以轻松解决绝大多数跨越区域、跨时差的沟通。\r\n　　从事数年的营销工作，微信给我工作方式带来的最大变化，是工作效率的成倍增长。例如，仅通过朋友圈，便可以随时掌握客户的动态、关系群等重要信息。只要你能合理规划时间和精力，原本疲于奔波和应酬不断的销售工作，便可以通过更高效的方式解决。团队内部的资源协调、整合、人员调配和分工，也从未如今天这般高效和便捷。\r\n　　这些变化的背后，意味着很多“小而美”的团队和公司，具备了和那些“庞然大物”公司竞争的筹码。这有点像PC时代，淘宝改变了无数个体经营者的命运；在移动社交时代，拥有海量用户的微信、陌陌、无秘等显性/隐性社交工具，同样会像当年的淘宝一样，再一次改变人们对商业活动的认知。\r\n　　这不禁让我想起了，从去年开始火爆的微信“自媒体”。其实，在过去的八年中，我的职业始终不在汽车媒体记者圈，只是“童济仁”这个名字，从论坛、播客、微博、微信等各种平台一路走来。我一直觉得，写作是思考的过程，也是知识沉淀和积累的最好方式，多年前，在创立《童济仁的汽车评论》的时候，我也从未曾想过，这个所谓的“自媒体”的未来是什么？\r\n　　但最奇妙的化学反应，发生在了微信时代的到来，社交传播第一次让我接触到了《童济仁的汽车评论》背后的那些读者群体。事实上，得益于“童济仁”与“同济人”的天然血缘关系，这些读者群让我受益匪浅。\r\n　　例如，正是因为“童济仁”这个介质，一群拥有相似特质的年轻一代汽车菁英们，去年在上海共同成立了TaecTalk（泰閣説）这个线上、线下相结合的小组织，他们覆盖了汽车产业链的各个环节，微信群里每一个热门话题的深度讨论，每月一次的线下聚会分享，都让这个群体内的成员有所收获。\r\n　　如果没有连接一切的微信和移动社交，我也许永远不知道，PC端文章巨大浏览量背后的那些人是谁？在PC时代，与他们沟通交流的成本，可能是一般人所无法承受的，更不用说去成立一个像TaecTalk这样的资源人脉共享“董事会”。\r\n　　这几年工作的重心，一直聚焦在互联网和汽车营销的结合点。如今这两个圈子之间，正在发生着越来越多的“化学反应”，是汽车人主动拥抱互联网？还是互联网人颠覆汽车的高门槛？在激烈的冲突和碰撞过程中，同样诞生了很多有趣的商业机会，这是这个特殊时代，给予那些有梦想的年轻人的恩赐。\r\n　　对于那些具备汽车行业扎实的实战背景，又善于接受移动互联网新鲜事物的年轻一代而言，现在也许就是一个最好的时代。任何一个细分领域都会在这场汽车与互联网深度融合的博弈中，释放出值得“为之一搏”的机会。连接一切的移动社交工具，又极大地降低了这些小而美的创新团队，和行业巨头们博弈的门槛。\r\n　　移动社交时代，确实也让很多传统媒体人迷失了方向，同时也给了那些在细分领域耕耘多年的专业人士，一个快速被认识/认可的过程。媒体记者、撰稿人也同样是细分领域的专业人士，今日头条彻底颠覆了传统媒体的版面、位置、推广概念，如今在移动端众多媒体APP平台化的时代，自媒体也迎来了从未有过的传播力和影响力。\r\n　　这是否意味着，个人成为品牌的自媒体时代来临了吗？答案是残酷的NO！对于绝大多数个人/小作坊而言，如果无法拥有细分领域绝对的话语权，很快就会在这场移动社交泡沫中灰飞烟灭。\r\n　　在移动互联网时代，优质的自媒体，最终会借助资本、经营、公司化等多种方式，将“自媒体”变成“媒体”，并逐渐成为公众普遍关注和接受的新媒体形式。在汽车圈，这个过程可能会比其它圈子稍慢一些，但这一变化趋势，是不可逆转的。\r\n　　就如同罗辑思维、吴晓波频道等。最终，汽车领域也会出现一些提供高质量视频、优质内容、多种表现形式的“品牌媒体”，这些专业化“品牌媒体”的背后，是庞大、专业的制作和创意团队，是一个大体量的商业公司，而不是简单拉几个人，凭借兴趣爱好码码字儿的“小作坊”。\r\n　　趋势性的变化不可逆转，唯一的差异在于，因为汽车圈相对封闭的生态体系和较高的专业门槛，会让这个过程来得略迟一些，但从目前的趋势看，这一过程正在加速到来。\r\n　　最终，那些少数的幸存者，会从“自媒体”蜕变成“媒体”，成功者需要感谢的，还是这个千载难逢的移动互联网时代，社交连接一切，带给他们的这一次千载难逢的洗牌机会。\r\n　　版权声明：\r\n　　本文为《童济仁的汽车评论》独家原创稿件，禁止任何形式的转载或改编，如有任何侵权行为，侵权者将承担相应的法律责任！', '2', null, '1');

