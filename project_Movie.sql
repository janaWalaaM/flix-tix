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
-- Table structure for table `Movie`
--

DROP TABLE IF EXISTS `Movie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Movie` (
  `MovieID` int NOT NULL,
  `MovieName` varchar(45) DEFAULT NULL,
  `Description` varchar(500) DEFAULT NULL,
  `MovieGenre` varchar(45) DEFAULT NULL,
  `MovieTrailer` varchar(200) DEFAULT NULL,
  `MoviePoster` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`MovieID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Movie`
--

LOCK TABLES `Movie` WRITE;
/*!40000 ALTER TABLE `Movie` DISABLE KEYS */;
INSERT INTO `Movie` VALUES (1,'The Dark Knight','Batman faces his greatest challenge yet -\n the Joker. Packed with action and intense performances','Action','https://youtu.be/EXeTwQWrcwY?si=Cf14X6FxRk6hKBiX','https://contentserver.com.au/assets/598411_p173378_p_v8_au.jpg'),(2,'Black Iron Submarine','A global consortium of engineers assembles at the \"Pacific Buoy\" for the \nunveiling of an advanced law enforcement camera system. Conan and friends, there for a casual visit,\n receive alarming news of a murder by Gin. Intrigued, Conan discreetly explores the situation,\n uncovering Black Organization activities. Tensions escalate when an engineer is kidnapped, \nand an unsettling presence near Haibara adds an element of mystery,\nheightened by eerie sounds from the ocean.','Action','https://youtu.be/0rNpSmVmN2U?si=DgpIGNJ3F7xh46YR','https://www.detectiveconanworld.com/wiki/images/4/4b/Movie_26.jpg'),(3,'Kimitachi wa dô ikiru ka','A young boy named Mahito yearning for his mother \nventures into a world shared by the living and the dead. \nThere, death comes to an end, and life finds a new beginning.','Drama','https://youtu.be/UIabnyxTVpc?si=E9ANFsvpYGAbUJZP','http://www.impawards.com/intl/japan/2023/posters/kimitachi_wa_do_ikiru_ka_ver5_xlg.jpg'),(4,'Luca','In a framework of adventure and fantasy, an Italian boy\n meets a sea monster masquerading as a human, and a strong \nfriendship is established between them that defies all \ncircumstances onthe charming Italian beaches in Luca.\n','Animation','https://youtu.be/YdAIBlPVe9s?si=ZJlT5sWkRx7Ij3G9','https://i.pinimg.com/736x/fa/40/82/fa4082a604c926df889c892a694e3bfa.jpg'),(5,'MANDOOB','In the heart of Riyadh, where desperation and opportunity collide,\n MANDOOB brings forth the gripping tale of Fahad Algadaani, a mentally\n fragile man racing against time to save his ailing father.','Drama','https://youtu.be/kbfEXH6T4vA?si=qFDHKKQ8v4cd07ag','https://m.media-amazon.com/images/M/MV5BOWZhNDY5NjYtMDhiMy00NzBmLTgyMWMtNzFhNTMwZGM4YTJjXkEyXkFqcGdeQXVyMTE5MDUyNDkx._V1_FMjpg_UX1000_.jpg'),(6,'Cruella','The film revolves around the story of the previous life of Corla de Ville\n and her childhood before she turned into the evil lady in the animated film 101 Dalmatians, \nwhere we will see the factors that led to this transformation in Cruella','Comedy','https://youtu.be/gmRKv7n2If8?si=-EYQANvh188Bi-gH','https://i.pinimg.com/564x/10/b7/1b/10b71b813167aec755f4c52c06eeb344.jpg'),(7,'Elemental','Follows Ember and Wade, in a city where fire-,\n water-, earth- and air-residents live together.','Animation','https://youtu.be/hXzcyx9V0xw?si=cnU7n2d5DBeWCLyw','https://m.media-amazon.com/images/M/MV5BZjYxYWVjMDMtZGRjZS00ZDE4LTk0OWUtMjUyOTI4MmYxNjgwXkEyXkFqcGdeQXVyMTUzMTg2ODkz._V1_.jpg'),(8,'Suzume ','A modern action adventure road story where a 17-year-old girl named Suzume \nhelps a mysterious young man close doors from the other side that are releasing\n disasters all over in Japan.','Fantasy','https://youtu.be/5pTcio2hTSw?si=wm5BHL9Gr8DaOVgR','https://s3.amazonaws.com/nightjarprod/content/uploads/sites/130/2023/03/14120624/vIeu8WysZrTSFb2uhPViKjX9EcC-scaled.jpg'),(9,'The Beekeeper','One man\'s brutal campaign for vengeance takes \non national stakes after it\'s revealed he\'s a former \noperative of a powerful and clandestine organization \nknown as Beekeepers.','Action','https://youtu.be/SzINZZ6iqxY?si=2caIQuEBSoMt8Let','https://amc-theatres-res.cloudinary.com/v1696452292/amc-cdn/production/2/movies/74100/74082/PosterDynamic/159114.jpg'),(10,'Interstellar','When Earth becomes uninhabitable in the future, a farmer and ex-NASA pilot, Joseph Cooper, is tasked to pilot a spacecraft, along with a team of researchers, to find a new planet for humans','Science Fiction','  https://youtu.be/zSWdZVtXT7E?si=bgIrWtmj75-CTF28','https://m.media-amazon.com/images/M/MV5BZjdkOTU3MDktN2IxOS00OGEyLWFmMjktY2FiMmZkNWIyODZiXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_.jpg');
/*!40000 ALTER TABLE `Movie` ENABLE KEYS */;
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
