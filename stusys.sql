-- MySQL dump 10.13  Distrib 5.7.42, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: stu_db2
-- ------------------------------------------------------
-- Server version	5.7.42-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `tb_stu_attend`
--

DROP TABLE IF EXISTS `tb_stu_attend`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_stu_attend` (
  `attend_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '考勤表主键',
  `stu_id` int(11) DEFAULT NULL COMMENT '学生id',
  `stu_name` varchar(45) DEFAULT NULL COMMENT '学生名字',
  `attend_time` date DEFAULT NULL COMMENT '考勤日期',
  `attend_status` int(11) DEFAULT NULL COMMENT '考勤状态 0-缺勤 1-出勤 2-请假',
  PRIMARY KEY (`attend_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COMMENT='考勤表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_stu_attend`
--

LOCK TABLES `tb_stu_attend` WRITE;
/*!40000 ALTER TABLE `tb_stu_attend` DISABLE KEYS */;
INSERT INTO `tb_stu_attend` VALUES (1,2,'小明','2023-11-11',1),(2,2,'小明','2023-11-12',1),(3,2,'小明','2023-11-13',0),(4,2,'小明','2023-11-14',2);
/*!40000 ALTER TABLE `tb_stu_attend` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_stu_class`
--

DROP TABLE IF EXISTS `tb_stu_class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_stu_class` (
  `class_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '课程id 主键',
  `class_name` varchar(20) DEFAULT NULL COMMENT '课程名字',
  `t_id` int(11) DEFAULT NULL COMMENT '教师表主键',
  PRIMARY KEY (`class_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='班级表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_stu_class`
--

LOCK TABLES `tb_stu_class` WRITE;
/*!40000 ALTER TABLE `tb_stu_class` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_stu_class` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_stu_class_relation`
--

DROP TABLE IF EXISTS `tb_stu_class_relation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_stu_class_relation` (
  `relation_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '学生表主键',
  `stu_id` int(11) DEFAULT NULL COMMENT '课程表主键',
  `class_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`relation_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='班级关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_stu_class_relation`
--

LOCK TABLES `tb_stu_class_relation` WRITE;
/*!40000 ALTER TABLE `tb_stu_class_relation` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_stu_class_relation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_stu_course`
--

DROP TABLE IF EXISTS `tb_stu_course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_stu_course` (
  `course_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '课程id 主键',
  `course_name` varchar(45) DEFAULT NULL COMMENT '课程名字',
  `t_id` int(11) DEFAULT NULL COMMENT '教师表主键',
  PRIMARY KEY (`course_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COMMENT='课程表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_stu_course`
--

LOCK TABLES `tb_stu_course` WRITE;
/*!40000 ALTER TABLE `tb_stu_course` DISABLE KEYS */;
INSERT INTO `tb_stu_course` VALUES (1,'java',1),(2,'日语',2);
/*!40000 ALTER TABLE `tb_stu_course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_stu_homework`
--

DROP TABLE IF EXISTS `tb_stu_homework`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_stu_homework` (
  `h_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '作业表主键',
  `stu_id` int(11) DEFAULT NULL COMMENT '学生表主键',
  `course_id` int(11) DEFAULT NULL COMMENT '课程表主键',
  `grade` varchar(45) DEFAULT NULL COMMENT '作业评价',
  PRIMARY KEY (`h_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COMMENT='作业表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_stu_homework`
--

LOCK TABLES `tb_stu_homework` WRITE;
/*!40000 ALTER TABLE `tb_stu_homework` DISABLE KEYS */;
INSERT INTO `tb_stu_homework` VALUES (1,2,1,'A');
/*!40000 ALTER TABLE `tb_stu_homework` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_stu_stage`
--

DROP TABLE IF EXISTS `tb_stu_stage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_stu_stage` (
  `s_id` int(11) NOT NULL COMMENT '阶段表主键',
  `course_id` int(11) DEFAULT NULL COMMENT '课程表主键',
  `s_name` varchar(45) DEFAULT NULL COMMENT '阶段名字',
  PRIMARY KEY (`s_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='阶段表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_stu_stage`
--

LOCK TABLES `tb_stu_stage` WRITE;
/*!40000 ALTER TABLE `tb_stu_stage` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_stu_stage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_stu_student`
--

DROP TABLE IF EXISTS `tb_stu_student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_stu_student` (
  `stu_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '学生id 主键',
  `stu_name` varchar(45) DEFAULT NULL COMMENT '学生姓名',
  `stu_gender` varchar(45) DEFAULT NULL COMMENT '学生性别',
  `stu_age` int(3) DEFAULT NULL COMMENT '学生年龄',
  `stu_phone` int(20) DEFAULT NULL COMMENT '学生电话',
  `stu_password` varchar(45) DEFAULT NULL COMMENT '学生登录密码',
  `stu_class` varchar(45) DEFAULT NULL COMMENT '学生班级（课程）',
  PRIMARY KEY (`stu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_stu_student`
--

LOCK TABLES `tb_stu_student` WRITE;
/*!40000 ALTER TABLE `tb_stu_student` DISABLE KEYS */;
INSERT INTO `tb_stu_student` VALUES (1,'小张','男',22,123,'123456','0520'),(2,'小明','女',23,1234,'123456','0520');
/*!40000 ALTER TABLE `tb_stu_student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_stu_teacher`
--

DROP TABLE IF EXISTS `tb_stu_teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_stu_teacher` (
  `t_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '教师id 主键',
  `t_name` varchar(20) DEFAULT NULL COMMENT '教师姓名',
  `t_gender` varchar(20) DEFAULT NULL COMMENT '教师性别',
  `t_age` int(3) DEFAULT NULL COMMENT '教师年龄',
  `t_phone` int(20) DEFAULT NULL COMMENT '教师电话',
  `t_position` varchar(45) DEFAULT NULL COMMENT '教师职位',
  `t_password` varchar(20) DEFAULT NULL COMMENT '教师密登录密码',
  PRIMARY KEY (`t_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COMMENT='教师表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_stu_teacher`
--

LOCK TABLES `tb_stu_teacher` WRITE;
/*!40000 ALTER TABLE `tb_stu_teacher` DISABLE KEYS */;
INSERT INTO `tb_stu_teacher` VALUES (1,'刘老师','男',40,654321,'java老师','123456'),(2,'王老师','男',33,6543,'日语老师','123456');
/*!40000 ALTER TABLE `tb_stu_teacher` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-11-15 23:35:55
