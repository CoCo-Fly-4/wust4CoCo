-- MySQL dump 10.16  Distrib 10.1.24-MariaDB, for debian-linux-gnu (i686)
--
-- Host: localhost    Database: coco
-- ------------------------------------------------------
-- Server version	10.1.24-MariaDB-6

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `movie`
--

DROP TABLE IF EXISTS `movie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `movie` (
  `movieid` int(11) NOT NULL AUTO_INCREMENT,
  `moviename` varchar(60) DEFAULT NULL,
  `classify` varchar(20) DEFAULT NULL,
  `actor` varchar(80) DEFAULT NULL,
  `address` varchar(20) DEFAULT NULL,
  `imgurl` varchar(100) DEFAULT NULL,
  `introduction` varchar(500) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`movieid`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie`
--

LOCK TABLES `movie` WRITE;
/*!40000 ALTER TABLE `movie` DISABLE KEYS */;
INSERT INTO `movie` VALUES (1,'最萌身高差','喜剧片','王水林、高以翔','34602-1-1','http://images.odoukei.com/upload/vod/2016-12-31/201612311483187323.jpg','《最萌身高差》是一部校园爱情喜剧片，由马侃执导，王水林和高以翔等联合演出。影片讲述了发生在夏汐泠和张潇一对最萌身高差恋人身上的喜剧故事'),
(2,'爱的面包魂','喜剧片','陈汉典、陈妍希、林君阳','1532-2-1','http://images.odoukei.com/upload/vod/2016-09-29/14751291504.jpg','陈汉典饰演的乡下面包师一直暗恋陈妍希饰演的店长女儿，但是他求婚未果，又遭大都市来的主厨横刀夺爱，为了抢回心爱的女生，一场面包大赛就此展开。'),
(3,'晚秋','爱情片','汤唯、玄彬、金俊成','1701-1-1','http://images.odoukei.com/upload/vod/2016-09-29/147512916918.jpg','影片讲述了发生在异国他乡的一对陌生男女之间的恋情，两人彼此并不知道的是，她是一名三天后必须回到监狱的女犯人，而他是一名向来逢场作'),
(4,'念念','爱情片','梁洛施、张孝全、柯宇纶','1683-3-1','http://images.odoukei.com/upload/vod/2016-12-22/201612221482406087.jpg','在繁忙的大都市，每个人在快节奏的世界中生活着，繁重的生活重担让他们无瑕估计其他，然而，总有一些阴影在时时影响着他们。究竟旧日恋人能否复合？失散兄妹能否重聚？一个关于爱情与青春的故事，在美丽的绿岛之滨，缓缓铺陈开来……'),
(5,'命中注定','爱情片','汤唯、廖凡','1685-1-1','http://images.odoukei.com/upload/vod/2016-12-22/201612221482406087.jpg','影片《命中住定》讲诉了同住一个屋檐下的谢小雯（李婷玉 饰）和吴盼（程芳 饰）两姐妹的不同选择，所造就的不同命运。'),
(6,'天地逃生','动作片','杰拉德巴特勒','1773-2-1','http://images.odoukei.com/upload/vod/2017-05-13/201705131494654927.jpg','影片的故事设定在了不太遥远的未来，被囚禁在死囚区的关押犯Kabel（杰拉德·巴特勒饰演），无意中成为了那个时代里流行文化的英雄人物。'),
(7,'深渊','科幻片','艾德哈里斯、迈克尔比恩','12675-1-1','http://images.odoukei.com/upload/vod/2016-09-29/14751303101.jpg','深渊,美国核潜艇蒙坦娜号在深海追踪一个不明物体的时辰不幸掉踪，高压潜水钻台深海之心号领班巴德（迈克尔·比恩 Michael Biehn 饰）接到号令负责共同科菲中尉（艾德·哈里斯 Ed Harris 饰）前往救援。'),
(8,'蝙蝠侠-大战超人','科幻片','本阿弗莱克、亨利卡维尔','32248-1-1','http://images.odoukei.com/upload/vod/2016-10-07/201610071475851395.jpg','故事发生在大都会之战18个月后，在那场战斗中许多建筑和市民惨遭波及。因为超人（亨利·卡维尔 饰）帮助人类解决了很多问题而被当做神来膜拜，但超人也因与佐德之战对城市造成的破坏而遭到逮捕和审讯，一度成为都市传说的蝙蝠侠韦恩（本·阿弗莱克 饰）重新出现在人们面前，他似乎正是为了惩罚超人而来'),
(9,'新聊斋之僵尸新娘','恐怖片','杨振鹏、小米、邱士鉴','37773-1-1','http://images.odoukei.com/upload/vod/2017-07-08/201707081499519487.jpg','影片讲述了雨夜，李晓的车陷进了荒野路上的水洼里，冒雨走入附近一座破旧的寺庙，本想寻求帮助，可四下无人。在寺庙的祠堂里，李晓遇到一个同样来避雨的女孩，两人发现了一本记录捉鬼传说的日记《民国灵异录》，开启了一段民国时期的人鬼往事……'),
(10,'窃听风云2','动作片','古天乐、刘青云、吴彦祖','9821-2-1','http://images.odoukei.com/upload/vod/2016-09-29/147512980613.jpg','香港证券商人罗敏生（刘青云 饰）驱车上班途中遭遇车祸，这起看似平平常常的车祸却引来反恐队的关注。原来警方在罗的车内发现军用窃听器，反恐队长何智强（古天乐 饰）怀疑有人正在策划恐怖袭击。随着何的调查，始终藏在暗处监视窃听的退伍军人司马念祖（吴彦祖 饰）也渐渐浮出水面。'),
(11,'宝贝计划','动作片','成龙、古天乐','37228-1-1','http://images.odoukei.com/upload/vod/2017-06-02/201706021496406928.jpg','故事围绕一个刚出生的宝宝开始。人字拖（成龙 饰）虽有不凡的身手，可是终日沉迷赌博毫无人生目标，便与包租公（许冠文 饰）、八达通（古天乐 饰）一起爆窃，干着偷偷摸摸的犯罪事。'),
(12,'异形：契约','科幻片','迈克尔法斯宾德','37124-1-1','http://images.odoukei.com/upload/vod/2017-06-19/201706191497881871.jpg','《异形：契约》，是一部由20世纪福克斯于2017年出品的美国科幻电影，银河系另一端遥远星球的殖民太空船“契约号（Covenant）”发现了一个未知的天堂世界，但其实这里却是一个布满黑暗和危险的世界，这里唯一的居民是“仿生人（Synthetic）”大卫（迈克尔·法斯宾德饰），也是“普罗米修斯号（Prometheus）”唯一的生还者。'),
(13,'银河护卫队2','科幻片','克里斯普拉特','36738-1-1','http://images.odoukei.com/upload/vod/2017-05-01/201705011493636057.jpg','《银河护卫队2》根据漫威漫画改编，讲述了护卫队成员穿越宇宙，继续在外太空的冒险之旅，他们必须共同作战，守护彼此，同时要解开彼得·奎尔的身世之谜的故事。'),
(14,'第一次','爱情片','杨颖、赵又廷、江珊','1705-1-1','http://images.odoukei.com/upload/vod/2017-04-01/201704011491058927.jpg ','一次偶然的机会，宋诗乔（Angelababy/杨颖 饰）在游乐场扮演卡通玩偶的时候，巧遇了引吭高歌的摇滚青年——高中同学宫宁（赵又廷 饰），后者便对她展开了爱情攻势。两人堕入爱河，这也是诗乔第一次感受爱情的美好。而宫宁也开始鼓励诗乔实现跳舞的梦想。然而，爱情从来都不会一帆风顺……'),
(15,'荒村客栈','恐怖片','关智斌、张檬、何美钿','9124-1-1','http://images.odoukei.com/upload/vod/2017-06-29/201706291498739750.jpg','2002年，音乐学院大四的学生孟凡（关智斌 饰）在一次比赛上凭借原创歌曲《对不起，我爱你》一举夺得冠军，自此声名鹊起，还抱得美人归，与出色的女生何盈（何美钿 饰）在一起。 　　几年后，他仍然无法创作出一首全新的代表作，爱情又迟滞不前。一天在网上看见一个叫“荒村”的地方，里面有一个“荒村客栈”，流传着关于明代一个叫胭脂的女子的故事。'),
(16,'笔仙诡影','恐怖片','宋懿洁、蒋欣奇','21423-1-1','http://images.odoukei.com/upload/vod/2017-06-25/201706251498394123.jpg','民国初期，苏承志（王燕阳 饰）带新婚妻子和五个同门师兄妹回老家古宅游玩，一场原为娱乐的笔仙游戏昭示着众人将陷于一场恐怖危机之中。背负秘密的苏母（李艳冰 饰），情仇暗生的师兄妹，神秘的哑巴守林人，突如其来的凶杀案，一桩桩诡异事件接连发生');
/*!40000 ALTER TABLE `movie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (33,'Augusy','angusy11'),
(34,'Andymina','iamfine1'),
(35,'Aabbye','12fdgsdvsv'),
(36,'Abagael','sjf43t3'),
(38,'Adolph','badboy'),
(39,'Dafeine','newdog'),
(40,'Ainsley','bestwishes'),
(41,'Alexandra','okiannsa'),
(42,'Ashling','1032sanhc2'),
(43,'Bakula','5uf89gg'),
(44,'Baldwin','baldwin22'),
(45,'Bancroft','3w9sdkl'),
(46,'Barnaba','toolong'),
(47,'Barnardine','keepthis'),
(48,'Brandon','hdsintss'),
(49,'Brewster','ssssssssss'),
(50,'cococo','cococo'),
(51,'cocoadmin','cocoadmin');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-07-13 22:59:58


