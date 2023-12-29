-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: bankmanagementsystem
-- ------------------------------------------------------
-- Server version	8.0.35

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
-- Table structure for table `bank`
--

DROP TABLE IF EXISTS `bank`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bank` (
  `pin` varchar(20) DEFAULT NULL,
  `ddate` varchar(60) DEFAULT NULL,
  `ttype` varchar(30) DEFAULT NULL,
  `amount` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bank`
--

LOCK TABLES `bank` WRITE;
/*!40000 ALTER TABLE `bank` DISABLE KEYS */;
INSERT INTO `bank` VALUES ('7330','Fri Dec 29 13:39:47 IST 2023','Deposit','100000'),('7330','Fri Dec 29 13:43:22 IST 2023','debit','50000'),('4374','Fri Dec 29 13:43:22 IST 2023','credit','50000'),('4374','Fri Dec 29 13:44:30 IST 2023','Deposit','30000'),('4374','Fri Dec 29 13:45:46 IST 2023','debit','6055'),('7330','Fri Dec 29 13:45:46 IST 2023','credit','6055'),('4374','Fri Dec 29 13:45:53 IST 2023','debit','6055'),('7330','Fri Dec 29 13:45:53 IST 2023','credit','6055'),('4374','Fri Dec 29 13:45:56 IST 2023','debit','6055'),('7330','Fri Dec 29 13:45:56 IST 2023','credit','6055'),('4374','Fri Dec 29 13:45:59 IST 2023','debit','6055'),('7330','Fri Dec 29 13:45:59 IST 2023','credit','6055'),('4374','Fri Dec 29 13:46:01 IST 2023','debit','6055'),('7330','Fri Dec 29 13:46:01 IST 2023','credit','6055'),('4374','Fri Dec 29 13:46:04 IST 2023','debit','6055'),('7330','Fri Dec 29 13:46:04 IST 2023','credit','6055'),('4374','Fri Dec 29 13:46:06 IST 2023','debit','6055'),('7330','Fri Dec 29 13:46:06 IST 2023','credit','6055'),('4374','Fri Dec 29 13:46:09 IST 2023','debit','6055'),('7330','Fri Dec 29 13:46:09 IST 2023','credit','6055'),('4374','Fri Dec 29 13:46:11 IST 2023','debit','6055'),('7330','Fri Dec 29 13:46:11 IST 2023','credit','6055');
/*!40000 ALTER TABLE `bank` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-29 14:16:52
