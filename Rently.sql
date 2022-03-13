-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: us-cdbr-east-05.cleardb.net    Database: heroku_9a58b6e4b09aa09
-- ------------------------------------------------------
-- Server version	5.6.50-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `devices`
--

DROP TABLE IF EXISTS `devices`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `devices` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `device_name` varchar(30) DEFAULT NULL,
  `device_description` varchar(100) DEFAULT NULL,
  `state` varchar(10) DEFAULT NULL,
  `objective` varchar(10) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `amount` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `devices`
--

LOCK TABLES `devices` WRITE;
/*!40000 ALTER TABLE `devices` DISABLE KEYS */;
INSERT INTO `devices` VALUES (1,'pressure Device','measure pressure of blood','new','rent',15,30),(4,'sugar tester','device used to measure sugar in blood','new','rent',300,150),(14,'dental lighter','device used to emit high light','used','sell',50,10),(24,'heater','used to clean instruments','used','rent',100,45);
/*!40000 ALTER TABLE `devices` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `devices_transactions`
--

DROP TABLE IF EXISTS `devices_transactions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `devices_transactions` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `device_id` int(11) DEFAULT NULL,
  `hospital_username` varchar(30) DEFAULT NULL,
  `transaction_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `amount` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `device_id` (`device_id`),
  KEY `hospital_username` (`hospital_username`),
  CONSTRAINT `devices_transactions_ibfk_1` FOREIGN KEY (`device_id`) REFERENCES `devices` (`id`),
  CONSTRAINT `devices_transactions_ibfk_2` FOREIGN KEY (`hospital_username`) REFERENCES `hospitals` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `devices_transactions`
--

LOCK TABLES `devices_transactions` WRITE;
/*!40000 ALTER TABLE `devices_transactions` DISABLE KEYS */;
/*!40000 ALTER TABLE `devices_transactions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hospitals`
--

DROP TABLE IF EXISTS `hospitals`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hospitals` (
  `username` varchar(30) NOT NULL,
  `name` varchar(30) DEFAULT NULL,
  `address` varchar(80) DEFAULT NULL,
  `phone_number` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`username`),
  CONSTRAINT `hospitals_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hospitals`
--

LOCK TABLES `hospitals` WRITE;
/*!40000 ALTER TABLE `hospitals` DISABLE KEYS */;
INSERT INTO `hospitals` VALUES ('username','H2','a','012'),('userx','Hospital X','location','123'),('usery','Hospital Y','location','123'),('useryu','Hospita X','location','123');
/*!40000 ALTER TABLE `hospitals` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `username` varchar(30) NOT NULL,
  `password` varchar(80) DEFAULT NULL,
  `role` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('Hassan','12345','admin'),('username','123','hospital'),('userx','123','hospital'),('usery','123','hospital'),('useryu','123456','hospital');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-03-13 20:15:12
