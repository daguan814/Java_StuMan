-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: stu_sx
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8mb4 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cvk`
--

DROP TABLE IF EXISTS `cvk`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `cvk` (
  `课程名` char(12) NOT NULL,
  `课号1` char(10) DEFAULT NULL,
  `课号2` char(10) DEFAULT NULL,
  `课号3` char(10) DEFAULT NULL,
  `课号4` char(10) DEFAULT NULL,
  PRIMARY KEY (`课程名`),
  UNIQUE KEY `CVK_课程名_uindex` (`课程名`),
  UNIQUE KEY `CVK_课号1_uindex` (`课号1`),
  UNIQUE KEY `CVK_课号2_uindex` (`课号2`),
  UNIQUE KEY `CVK_课号3_uindex` (`课号3`),
  UNIQUE KEY `cvk_课号4_uindex` (`课号4`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='课程与课号对照表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cvk`
--

LOCK TABLES `cvk` WRITE;
/*!40000 ALTER TABLE `cvk` DISABLE KEYS */;
INSERT INTO `cvk` VALUES ('c语言','k4','k9','k14','k20'),('python程序设计','k5','k10','k15','k19'),('人工智能','k2','k7','k12','k18'),('数据结构','k3','k8','k13','k17'),('软件工程导论','k1','k6','k11','k16');
/*!40000 ALTER TABLE `cvk` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grade1`
--

DROP TABLE IF EXISTS `grade1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `grade1` (
  `学号` int(11) NOT NULL,
  `C语言` int(11) DEFAULT NULL,
  `python程序设计` int(11) DEFAULT NULL,
  `人工智能` int(11) DEFAULT NULL,
  `数据结构` int(11) DEFAULT NULL,
  `软件工程导论` int(11) DEFAULT NULL,
  `市场营销` int(11) DEFAULT NULL,
  `企业管理` int(11) DEFAULT NULL,
  PRIMARY KEY (`学号`),
  UNIQUE KEY `grade_学号_uindex` (`学号`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='成绩表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grade1`
--

LOCK TABLES `grade1` WRITE;
/*!40000 ALTER TABLE `grade1` DISABLE KEYS */;
INSERT INTO `grade1` VALUES (10301,4,16,55,7,63,NULL,0),(10302,74,10,0,88,66,NULL,NULL),(10303,80,42,29,35,64,NULL,NULL),(10304,11,27,97,53,71,NULL,NULL),(10305,19,32,41,76,68,NULL,NULL),(10306,97,18,49,66,23,NULL,NULL),(10307,46,73,12,12,1,NULL,NULL),(10308,100,63,81,97,3,NULL,NULL),(10309,20,62,99,18,32,NULL,NULL),(10310,25,21,71,0,6,NULL,NULL),(10311,66,15,19,69,9,NULL,NULL),(10312,41,62,97,76,86,NULL,NULL),(10313,4,42,85,66,22,NULL,NULL),(10314,84,60,67,84,89,NULL,NULL),(10315,60,49,94,71,93,NULL,NULL),(10316,45,5,21,2,7,NULL,NULL),(10317,29,46,39,3,12,NULL,NULL),(10318,96,38,39,58,51,NULL,NULL),(10319,28,63,93,47,48,NULL,NULL),(10320,93,63,11,88,22,NULL,NULL),(10321,23,74,92,17,59,NULL,NULL),(10322,95,29,40,38,43,NULL,NULL),(10323,5,1,49,6,5,NULL,NULL),(10324,84,99,74,76,0,NULL,NULL),(10325,95,10,0,40,55,NULL,NULL),(10326,8,30,29,59,1,NULL,NULL),(10327,71,59,80,95,2,NULL,NULL),(10328,55,9,32,98,70,NULL,NULL),(10329,7,2,29,32,51,NULL,NULL),(10330,53,37,39,46,5,NULL,NULL),(10331,83,9,94,37,93,NULL,NULL),(10332,86,1,74,8,96,NULL,NULL),(10333,58,38,79,72,40,NULL,NULL),(10334,58,33,47,80,58,NULL,NULL),(10335,9,71,24,81,18,NULL,NULL),(10336,51,99,91,91,80,NULL,NULL),(10401,91,54,85,83,16,NULL,NULL),(10402,87,49,36,52,74,NULL,NULL),(10403,9,76,51,45,2,NULL,NULL),(10404,94,69,51,35,93,NULL,NULL),(10405,70,42,69,72,52,NULL,NULL),(10406,62,20,79,12,20,NULL,NULL),(10407,54,90,7,18,74,NULL,NULL),(10408,85,13,10,88,69,NULL,NULL),(10409,88,98,82,73,8,NULL,NULL),(10410,24,16,34,14,74,NULL,NULL),(10411,7,2,94,19,83,NULL,NULL),(10412,54,8,22,7,16,NULL,NULL),(10413,25,44,13,92,41,NULL,NULL),(10414,39,70,12,82,36,NULL,NULL),(10415,73,26,39,63,4,NULL,NULL),(10416,76,11,62,27,20,NULL,NULL),(10417,68,50,29,57,54,NULL,NULL),(10418,86,48,64,65,67,NULL,NULL),(10419,24,66,49,93,33,NULL,NULL),(10420,62,48,87,38,94,NULL,NULL),(10421,21,6,71,35,20,NULL,NULL),(10422,26,44,51,93,27,NULL,NULL),(10423,36,3,48,82,19,NULL,NULL),(10424,77,26,74,1,58,NULL,NULL),(10425,70,42,69,72,52,NULL,NULL),(10426,62,20,79,12,20,NULL,NULL),(10427,54,90,7,18,74,NULL,NULL),(10428,85,13,10,88,69,NULL,NULL),(10429,88,98,82,73,8,NULL,NULL),(10430,24,16,34,14,74,NULL,NULL),(10431,7,2,94,19,83,NULL,NULL),(10432,54,8,22,7,16,NULL,NULL),(10433,25,44,13,92,41,NULL,NULL),(10434,7,2,94,19,83,NULL,NULL),(10435,54,8,22,7,16,NULL,NULL),(10436,25,44,13,92,41,NULL,NULL),(10437,39,70,12,82,36,NULL,NULL);
/*!40000 ALTER TABLE `grade1` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grade2`
--

DROP TABLE IF EXISTS `grade2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `grade2` (
  `学号` int(11) NOT NULL,
  `高等数学1` int(11) DEFAULT NULL,
  `高等数学2` int(11) DEFAULT NULL,
  `概率论` int(11) DEFAULT NULL,
  `线性代数` int(11) DEFAULT NULL,
  `离散结构` int(11) DEFAULT NULL,
  `离散数学` int(11) DEFAULT NULL,
  `傅里叶级数` int(11) DEFAULT NULL,
  PRIMARY KEY (`学号`),
  UNIQUE KEY `grade_学号_uindex` (`学号`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='成绩表下学期';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grade2`
--

LOCK TABLES `grade2` WRITE;
/*!40000 ALTER TABLE `grade2` DISABLE KEYS */;
INSERT INTO `grade2` VALUES (10301,4,16,55,7,63,NULL,NULL),(10302,74,10,0,88,66,NULL,NULL),(10303,80,42,29,35,64,NULL,NULL),(10304,11,27,97,53,71,NULL,NULL),(10305,19,32,41,76,68,NULL,NULL),(10306,97,18,49,66,23,NULL,NULL),(10307,46,73,12,12,1,NULL,NULL),(10308,100,63,81,97,3,NULL,NULL),(10309,20,62,99,18,32,NULL,NULL),(10310,25,21,71,0,6,NULL,NULL),(10311,66,15,NULL,69,9,NULL,NULL),(10312,41,62,97,76,86,NULL,NULL),(10313,4,42,85,66,22,NULL,NULL),(10314,84,60,67,84,89,NULL,NULL),(10315,60,49,94,71,93,NULL,NULL),(10316,45,5,21,NULL,7,NULL,NULL),(10317,29,46,39,3,NULL,NULL,NULL),(10318,96,38,39,58,51,NULL,NULL),(10319,28,63,93,47,48,NULL,NULL),(10320,93,63,11,88,22,NULL,NULL),(10321,23,NULL,92,17,59,NULL,NULL),(10322,95,29,40,38,43,NULL,NULL),(10323,5,1,49,6,5,NULL,NULL),(10324,84,99,74,76,0,NULL,NULL),(10325,95,10,0,40,55,NULL,NULL),(10326,8,30,29,59,1,NULL,NULL),(10327,71,59,80,95,2,NULL,NULL),(10328,55,9,32,98,70,NULL,NULL),(10329,7,2,29,32,51,NULL,NULL),(10330,53,37,39,46,5,NULL,NULL),(10331,83,9,94,37,93,NULL,NULL),(10332,86,1,74,8,96,NULL,NULL),(10333,58,38,79,72,40,NULL,NULL),(10334,58,33,47,80,58,NULL,NULL),(10335,9,71,24,81,18,NULL,NULL),(10336,51,99,91,91,80,NULL,NULL),(10401,91,54,85,83,16,NULL,NULL),(10402,87,49,36,52,74,NULL,NULL),(10403,9,76,51,45,2,NULL,NULL),(10404,94,69,51,35,93,NULL,NULL),(10405,70,42,69,72,52,NULL,NULL),(10406,62,20,79,12,20,NULL,NULL),(10407,54,90,7,18,74,NULL,NULL),(10408,85,13,10,88,69,NULL,NULL),(10409,88,98,82,73,8,NULL,NULL),(10410,24,16,34,14,74,NULL,NULL),(10411,7,2,94,19,83,NULL,NULL),(10412,54,8,22,7,16,NULL,NULL),(10413,25,44,13,92,41,NULL,NULL),(10414,39,70,12,82,36,NULL,NULL),(10415,73,26,39,63,4,NULL,NULL),(10416,76,11,62,27,20,NULL,NULL),(10417,68,50,29,57,54,NULL,NULL),(10418,86,48,64,65,67,NULL,NULL),(10419,24,66,49,93,33,NULL,NULL),(10420,62,48,87,38,94,NULL,NULL),(10421,21,6,71,35,20,NULL,NULL),(10422,26,44,51,93,27,NULL,NULL),(10423,36,3,48,82,19,NULL,NULL),(10424,77,26,74,1,58,NULL,NULL),(10425,70,42,69,72,52,NULL,NULL),(10426,62,20,79,12,20,NULL,NULL),(10427,54,90,7,18,74,NULL,NULL),(10428,85,13,10,88,69,NULL,NULL),(10429,88,98,82,73,8,NULL,NULL),(10430,24,16,34,14,74,NULL,NULL),(10431,7,2,94,19,83,NULL,NULL),(10432,54,8,22,7,16,NULL,NULL),(10433,25,44,13,92,41,NULL,NULL),(10434,7,2,94,19,83,NULL,NULL),(10435,54,8,22,7,16,NULL,NULL),(10436,25,44,13,92,41,NULL,NULL),(10437,39,70,12,82,36,NULL,NULL);
/*!40000 ALTER TABLE `grade2` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stu`
--

DROP TABLE IF EXISTS `stu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `stu` (
  `学号` char(6) NOT NULL,
  `密码` char(20) NOT NULL DEFAULT '123123',
  `班级` char(6) NOT NULL DEFAULT '软件三班',
  `姓名` char(5) NOT NULL,
  `性别` char(1) NOT NULL DEFAULT '男',
  `年龄` int(2) NOT NULL,
  `账号状态` char(3) NOT NULL DEFAULT '可用',
  `选修1` char(10) DEFAULT NULL,
  `选修2` char(10) DEFAULT NULL,
  PRIMARY KEY (`学号`),
  UNIQUE KEY `Stu_学号_uindex` (`学号`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='学生个人信息及各科成绩表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stu`
--

LOCK TABLES `stu` WRITE;
/*!40000 ALTER TABLE `stu` DISABLE KEYS */;
INSERT INTO `stu` VALUES ('10301','123123','软件三班','王念','女',20,'可用',NULL,NULL),('10302','123123','软件三班','雨天','女',19,'可用',NULL,NULL),('10303','123123','软件三班','卢芳','女',19,'可用',NULL,NULL),('10304','123123','软件三班','唐晓婷','女',19,'可用',NULL,NULL),('10305','123123','软件三班','周怡君','女',19,'可用',NULL,NULL),('10306','123123','软件三班','刘景怡','女',21,'可用',NULL,NULL),('10307','123123','软件三班','邓旭波','男',20,'可用',NULL,NULL),('10308','123123','软件三班','鲁和丰','男',19,'可用',NULL,NULL),('10309','123123','软件三班','杨凯杰','男',19,'可用',NULL,NULL),('10310','123123','软件三班','罗炜雄','男',21,'可用',NULL,NULL),('10311','123123','软件三班','龚胜伟','男',19,'可用',NULL,NULL),('10312','123123','软件三班','徐显奇','男',20,'可用',NULL,NULL),('10313','123123','软件三班','郑椅民','男',20,'已毕业',NULL,NULL),('10314','123123','软件三班','谭旺成','男',21,'可用',NULL,NULL),('10315','123123','软件三班','冯诗其','男',20,'可用',NULL,NULL),('10316','123123','软件三班','谢铭哲','男',19,'可用',NULL,NULL),('10317','123123','软件三班','蔡文淦','男',19,'可用',NULL,NULL),('10318','123123','软件三班','郑先铭','男',19,'可用',NULL,NULL),('10319','123123','软件三班','冻世龙','男',21,'可用',NULL,NULL),('10320','123123','软件三班','王剑波','男',21,'可用',NULL,NULL),('10321','123123','软件三班','蒙俊良','男',20,'可用',NULL,NULL),('10322','123123','软件三班','刘世龙','男',20,'可用',NULL,NULL),('10323','123123','软件三班','邱金明','男',20,'可用',NULL,NULL),('10324','123123','软件三班','古已兴','男',20,'可用',NULL,NULL),('10325','123123','软件三班','罗渊','男',21,'已毕业',NULL,NULL),('10326','123123','软件三班','曹阳','男',19,'禁用',NULL,NULL),('10327','123123','软件三班','李思明','男',19,'可用',NULL,NULL),('10328','123123','软件三班','林子葳','男',19,'可用',NULL,NULL),('10329','123123','软件三班','杨明冈','男',21,'可用',NULL,NULL),('10330','123123','软件三班','凌熙','女',20,'禁用',NULL,NULL),('10331','123123','软件三班','谭家柽','男',21,'可用',NULL,NULL),('10332','123123','软件三班','谢鹏','男',19,'可用',NULL,NULL),('10333','123123','软件三班','庞博友','男',21,'可用',NULL,NULL),('10334','123123','软件三班','朱子翰','男',20,'可用',NULL,NULL),('10335','123123','软件三班','林昌龙','男',21,'可用',NULL,NULL),('10336','123123','软件三班','王子航','男',20,'可用',NULL,NULL),('10401','123123','软件四班','宋思彤','女',19,'可用',NULL,NULL),('10402','123123','软件四班','韦珍','女',21,'可用',NULL,NULL),('10403','123123','软件四班','彭元皓','女',21,'可用',NULL,NULL),('10404','123123','软件四班','农燕霖','女',22,'可用',NULL,NULL),('10405','123123','软件四班','王怡','女',20,'可用',NULL,NULL),('10406','123123','软件四班','陈燕','女',20,'可用',NULL,NULL),('10407','123123','软件四班','罗倍富','男',20,'可用',NULL,NULL),('10408','123123','软件四班','刘玉松','男',21,'可用',NULL,NULL),('10409','123123','软件四班','侯岳杉','男',20,'可用',NULL,NULL),('10410','123123','软件四班','宁宇其','男',20,'可用',NULL,NULL),('10411','123123','软件四班','梁杰','男',21,'可用',NULL,NULL),('10412','123123','软件四班','周宇航','男',20,'可用',NULL,NULL),('10413','123123','软件四班','张建豪','男',20,'可用',NULL,NULL),('10414','123123','软件四班','严志文','男',21,'可用',NULL,NULL),('10415','123123','软件四班','陆平刚','男',21,'可用',NULL,NULL),('10416','123123','软件四班','张志强','男',22,'可用',NULL,NULL),('10417','123123','软件四班','江飞帆','男',20,'可用',NULL,NULL),('10418','123123','软件四班','唐伟铭','男',20,'可用',NULL,NULL),('10419','123123','软件四班','李佳瑞','男',20,'可用',NULL,NULL),('10420','123123','软件四班','刘明','男',20,'禁用',NULL,NULL),('10421','123123','软件四班','黄靖','男',23,'可用',NULL,NULL),('10422','123123','软件四班','吴飞','男',20,'可用',NULL,NULL),('10423','123123','软件四班','钟富耀','男',20,'可用',NULL,NULL),('10424','123123','软件四班','钟林','男',20,'可用',NULL,NULL),('10425','123123','软件四班','许宜强','男',21,'可用',NULL,NULL),('10426','123123','软件四班','杨贤庆','男',21,'可用',NULL,NULL),('10427','123123','软件四班','陈春霖','男',20,'可用',NULL,NULL),('10428','123123','软件四班','蒙剑宇','男',21,'可用',NULL,NULL),('10429','123123','软件四班','梁德洲','男',21,'可用',NULL,NULL),('10430','123123','软件四班','杨洵','男',20,'可用',NULL,NULL),('10431','123123','软件四班','唐晨','男',21,'可用',NULL,NULL),('10432','123123','软件四班','梁宇鹏','男',20,'可用',NULL,NULL),('10433','123123','软件四班','文杰龙','男',20,'可用',NULL,NULL),('10434','123123','软件四班','刘天喜','男',21,'可用',NULL,NULL),('10435','123123','软件四班','吕强','男',20,'可用',NULL,NULL),('10436','123123','软件四班','李泰宇','男',22,'可用',NULL,NULL),('10437','123123','软件四班','崔胜利','男',20,'可用',NULL,NULL);
/*!40000 ALTER TABLE `stu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tea`
--

DROP TABLE IF EXISTS `tea`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tea` (
  `职工号` char(5) NOT NULL,
  `密码` char(20) NOT NULL DEFAULT '123456',
  `姓名` char(4) NOT NULL,
  `性别` char(1) NOT NULL DEFAULT '男',
  `课号` char(4) DEFAULT NULL,
  `课号2` char(4) DEFAULT NULL,
  PRIMARY KEY (`职工号`),
  UNIQUE KEY `tea_课号_uindex` (`课号`),
  UNIQUE KEY `tea_课号2_uindex` (`课号2`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='教师信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tea`
--

LOCK TABLES `tea` WRITE;
/*!40000 ALTER TABLE `tea` DISABLE KEYS */;
INSERT INTO `tea` VALUES ('001','134652','管理员','男',NULL,NULL),('s101','123456','陆安琴','女','k15','k20'),('s102','123456','罗锐','女','k14','k19'),('s103','123456','陈秀娟','女','k1','k6'),('s104','123456','黄玉晴','女','k2','k7'),('s105','123456','甘如宁','男','k3','k8'),('s106','123456','刘锟','男','k4','k9'),('s107','123456','林鸿毅','男','k5','k10'),('s108','123456','董呈海','男','k11','k16'),('s109','123456','张浩','男','k12','k17'),('s110','123456','殷铁林','男','k13','k18');
/*!40000 ALTER TABLE `tea` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-09-14 16:00:43
