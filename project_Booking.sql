-- MySQL dump 10.13  Distrib 8.0.28, for macos11 (x86_64)
--
-- Host: 127.0.0.1    Database: project
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `Booking`
--

DROP TABLE IF EXISTS `Booking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Booking` (
  `BookingID` int NOT NULL,
  `MoviePrice` varchar(45) DEFAULT NULL,
  `SeatNum` varchar(45) DEFAULT NULL,
  `Date` varchar(45) DEFAULT NULL,
  `Time` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`BookingID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Booking`
--

LOCK TABLES `Booking` WRITE;
/*!40000 ALTER TABLE `Booking` DISABLE KEYS */;
INSERT INTO `Booking` VALUES (1,'Total Price: $90.0','A2, A3','2024-01-31',NULL),(2,'Total Price: $90.0','A3, B2','2024-01-31',NULL),(3,'Total Price: $45.0','C5','2024-02-02',NULL),(4,'Total Price: $90.0','A3, D2','2024-02-09',NULL),(5,'Total Price: $45.0','D2','2024-02-08',NULL),(6,'Total Price: $45.0','D4','2024-02-08',NULL),(7,'Total Price: $45.0','C4','2024-02-08',NULL),(8,'Total Price: $45.0','B4','2024-02-08',NULL),(9,'Total Price: $45.0','D3','2024-02-02',NULL),(10,'Total Price: $45.0','B3','2024-02-08',NULL),(11,'Total Price: $45.0','B3','2024-02-02',NULL),(12,'Total Price: $45.0','A4','2024-02-08',NULL),(13,'Total Price: $45.0','C3','2024-03-08',NULL),(14,'Total Price: $45.0','C3','2024-03-08',NULL),(15,'Total Price: $45.0','D3','2024-02-22',NULL),(16,'Total Price: $90.0','C3, B3','2024-03-08',NULL),(17,'Total Price: $45.0','B4','2024-03-07',NULL),(18,'Total Price: $45.0','B3','2024-03-01',NULL),(19,'Total Price: $45.0','D4','2024-03-07',NULL),(20,'Total Price: $45.0','C4','2024-03-08',NULL),(21,'Total Price: $45.0','C4','2024-03-09',NULL),(22,'Total Price: $45.0','C4','2024-03-08',NULL),(23,'Total Price: $45.0','C4','2024-03-07',NULL);
/*!40000 ALTER TABLE `Booking` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-02-27  5:58:47
