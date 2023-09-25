-- MySQL dump 10.13  Distrib 5.7.42, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: stu_db
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
-- Table structure for table `tb_stu_grade`
--

DROP TABLE IF EXISTS `tb_stu_grade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_stu_grade` (
  `grade_id` int(11) NOT NULL AUTO_INCREMENT,
  `subject` varchar(45) DEFAULT NULL,
  `grade` double DEFAULT NULL,
  `stu_id` int(11) DEFAULT NULL,
  `test_date` date DEFAULT NULL,
  PRIMARY KEY (`grade_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_stu_grade`
--

LOCK TABLES `tb_stu_grade` WRITE;
/*!40000 ALTER TABLE `tb_stu_grade` DISABLE KEYS */;
INSERT INTO `tb_stu_grade` VALUES (1,'语文',41,21,'2023-09-21'),(2,'数学',23,21,'2023-09-21'),(3,'英语',25.5,21,'2023-09-22'),(4,'科学',87,21,'2023-09-22'),(5,'语文',34.5,22,'2023-09-21'),(6,'数学',73,22,'2023-09-21'),(7,'英语',95,22,'2023-09-22'),(8,'科学',27,22,'2023-09-22'),(9,'语文',96.5,23,'2023-09-21'),(10,'数学',45.5,23,'2023-09-21'),(11,'英语',79.5,23,'2023-09-22'),(12,'科学',75,23,'2023-09-22'),(13,'语文',65.5,24,'2023-09-21'),(14,'数学',88,24,'2023-09-21'),(15,'英语',45.5,24,'2023-09-22'),(16,'科学',86,24,'2023-09-22');
/*!40000 ALTER TABLE `tb_stu_grade` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-09-25 14:30:46
