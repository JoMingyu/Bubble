-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: bubble
-- ------------------------------------------------------
-- Server version	5.7.19-log

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
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `account` (
  `email` varchar(255) NOT NULL,
  `id` varchar(255) NOT NULL,
  `pw` varchar(255) NOT NULL,
  `nickname` varchar(31) NOT NULL,
  `gender` char(1) NOT NULL,
  `signup_date` date NOT NULL,
  `mileage` int(11) NOT NULL,
  `profile_image_name` varchar(127) DEFAULT NULL,
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES ('city7310@naver.com','123','123','PlanB','F','2017-03-04',2400,NULL),('geni429@gmail.com','1234','1234','근촐','F','2017-04-01',5000,NULL);
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `account_sns`
--

DROP TABLE IF EXISTS `account_sns`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `account_sns` (
  `email` varchar(255) NOT NULL,
  `nickname` varchar(31) NOT NULL,
  `gender` char(1) NOT NULL,
  `signup_date` date NOT NULL,
  `mileage` int(11) NOT NULL,
  `profile_image_name` varchar(127) DEFAULT NULL,
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account_sns`
--

LOCK TABLES `account_sns` WRITE;
/*!40000 ALTER TABLE `account_sns` DISABLE KEYS */;
/*!40000 ALTER TABLE `account_sns` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `email_codes`
--

DROP TABLE IF EXISTS `email_codes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `email_codes` (
  `email` varchar(255) NOT NULL,
  `code` char(6) NOT NULL,
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `email_codes`
--

LOCK TABLES `email_codes` WRITE;
/*!40000 ALTER TABLE `email_codes` DISABLE KEYS */;
/*!40000 ALTER TABLE `email_codes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `market`
--

DROP TABLE IF EXISTS `market`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `market` (
  `preset_id` int(11) NOT NULL,
  `upload_date` date NOT NULL,
  `is_free` tinyint(4) NOT NULL,
  PRIMARY KEY (`preset_id`),
  CONSTRAINT `market_fk` FOREIGN KEY (`preset_id`) REFERENCES `preset` (`preset_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `market`
--

LOCK TABLES `market` WRITE;
/*!40000 ALTER TABLE `market` DISABLE KEYS */;
INSERT INTO `market` VALUES (1,'2017-09-01',1),(2,'2017-09-01',0),(3,'2017-09-01',0),(6,'2017-09-01',1),(7,'2017-09-01',1),(8,'2017-09-01',0);
/*!40000 ALTER TABLE `market` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `own_preset`
--

DROP TABLE IF EXISTS `own_preset`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `own_preset` (
  `owner` varchar(255) NOT NULL,
  `preset_id` int(11) NOT NULL,
  `added_date` date NOT NULL,
  `poss` tinyint(4) NOT NULL,
  PRIMARY KEY (`owner`,`preset_id`),
  KEY `own_preset_fk_idx` (`preset_id`),
  CONSTRAINT `own_preset_fk` FOREIGN KEY (`preset_id`) REFERENCES `preset` (`preset_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `own_preset`
--

LOCK TABLES `own_preset` WRITE;
/*!40000 ALTER TABLE `own_preset` DISABLE KEYS */;
INSERT INTO `own_preset` VALUES ('geni429@gmail.com',1,'2017-08-17',1),('geni429@gmail.com',2,'2017-08-17',1),('geni429@gmail.com',3,'2017-08-17',1),('geni429@gmail.com',4,'2017-08-17',1),('geni429@gmail.com',5,'2017-08-17',1),('geni429@gmail.com',6,'2017-08-17',0);
/*!40000 ALTER TABLE `own_preset` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `preset`
--

DROP TABLE IF EXISTS `preset`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `preset` (
  `preset_id` int(11) NOT NULL AUTO_INCREMENT,
  `owner` varchar(255) NOT NULL,
  `title` varchar(511) NOT NULL,
  `uploaded` tinyint(4) NOT NULL,
  `male_like_count` int(11) NOT NULL,
  `femaile_like_count` int(11) NOT NULL,
  `download_count` int(11) NOT NULL,
  `creation_date` date NOT NULL,
  `hash_tags` varchar(1023) NOT NULL,
  `image_name` varchar(127) DEFAULT NULL,
  PRIMARY KEY (`preset_id`,`owner`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `preset`
--

LOCK TABLES `preset` WRITE;
/*!40000 ALTER TABLE `preset` DISABLE KEYS */;
INSERT INTO `preset` VALUES (1,'geni429@gmail.com','개시발',1,5,6,50,'2017-09-01','[\"#치킨\", \"#피자\"]',NULL),(2,'geni429@gmail.com','으악',1,3,11,60,'2017-09-01','[\"#정규형\"]',NULL),(3,'geni429@gmail.com','꺅',1,8,6,40,'2017-09-01','[\"#야구\", \"#윤석민\"]',NULL),(4,'geni429@gmail.com','으어어',0,0,0,0,'2017-09-01','[\"#태훈이\", \"#태훈이얼굴\"]',NULL),(5,'geni429@gmail.com','ㅁㅇㄴㄹ',0,0,0,0,'2017-09-01','[\"#중식\", \"#짬뽕\"]',NULL),(6,'city7310@naver.com','배그',1,10,5,14,'2017-09-01','[\"#남자\", \"#상남자\"]',NULL),(7,'city7310@naver.com','롤하고싶다',1,6,85,32,'2017-09-01','[\"#초콜릿\", \"#근철이\"]',NULL),(8,'city7310@naver.com','치킨먹고싶',1,91,8,58,'2017-09-01','[\"#파스타\", \"#카페인\"]',NULL),(9,'city7310@naver.com','ㅁㄴㄹㅇ',0,0,0,0,'2017-09-01','[\"#알약\", \"#두봉지\"]',NULL);
/*!40000 ALTER TABLE `preset` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `preset_options`
--

DROP TABLE IF EXISTS `preset_options`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `preset_options` (
  `preset_id` int(11) NOT NULL,
  `exposure` double NOT NULL,
  `contrast` int(11) NOT NULL,
  `highlight` int(11) NOT NULL,
  `blackpoint` int(11) NOT NULL,
  `white` int(11) NOT NULL,
  `black` int(11) NOT NULL,
  `temperature` int(11) NOT NULL,
  `tone` int(11) NOT NULL,
  `chroma` int(11) NOT NULL,
  PRIMARY KEY (`preset_id`),
  CONSTRAINT `preset_options_fk` FOREIGN KEY (`preset_id`) REFERENCES `preset` (`preset_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `preset_options`
--

LOCK TABLES `preset_options` WRITE;
/*!40000 ALTER TABLE `preset_options` DISABLE KEYS */;
INSERT INTO `preset_options` VALUES (1,1,1,1,1,1,1,1,1,1),(2,4,0,5,4,0,0,5,4,4),(3,5,1,4,4,2,0,2,4,5),(4,5,4,7,5,8,4,3,5,6),(5,1,6,4,4,0,0,3,0,4),(6,1,2,4,65,7,2,0,2,1),(7,14,42,4,4,4,5,0,2,5),(8,2,1,8,5,5,3,1,4,1),(9,7,4,2,8,4,10,2,4,3);
/*!40000 ALTER TABLE `preset_options` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-09-02  2:41:54
