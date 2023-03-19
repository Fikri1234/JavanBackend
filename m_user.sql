-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: user_mgmt_menu
-- ------------------------------------------------------
-- Server version	8.0.22

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `tbl_user`
--

DROP TABLE IF EXISTS `tbl_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` enum('ADMIN','USER','MAKER','CHECKER','APPROVER') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_user`
--

LOCK TABLES `tbl_user` WRITE;
/*!40000 ALTER TABLE `tbl_user` DISABLE KEYS */;
INSERT INTO `tbl_user` VALUES (1,'brullyz@gmail.com','$2a$08$GA5EWEF5oG8bAfGgT45UQeHHw.8VOdmW5yIINXpNVpS1fW/kGFn2e','ADMIN'),(2,'maker@gmail.com','$2a$08$Xoo1AyyYqTW0No1X5MiUhuCvML/dXrpmlpjJaFJmGrZ5xJeiszPFy','MAKER'),(3,'checker@gmail.com','$2a$08$C3Nt1JEyMv8190l2HDKmMeJXEJzvHsUlX7IfELHLbMEiVrAscGowi','CHECKER'),(4,'approver@gmail.com','$2a$08$IjPbSlkM7a3N0OpdFxMtdeP6KxPc8towA/WFwmgmaW8nq9AE.miuK','APPROVER');
/*!40000 ALTER TABLE `tbl_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `m_param`
--

DROP TABLE IF EXISTS `m_param`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `m_param` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `PARAM_NAME` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `PARAM_VALUE` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `PARAM_DESCRIPTION` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `CREATED_BY` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `CREATED_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `LAST_UPDATE_BY` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `LAST_UPDATE` timestamp NULL DEFAULT NULL,
  `ENABLED` tinyint DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `m_param`
--

LOCK TABLES `m_param` WRITE;
/*!40000 ALTER TABLE `m_param` DISABLE KEYS */;
INSERT INTO `m_param` VALUES (1,'MAX_LOGIN_FAILED_ATTEMPTS','3',NULL,'admin','2021-08-10 01:07:07',NULL,NULL,1),(2,'JWT_EXPIRES','1600','jwt expired','admin','2021-08-11 06:12:16','admin','2021-08-11 08:58:19',1),(3,'JWT_KEY','G4m@techk7f3=a',NULL,'admin','2021-08-11 07:10:01','admin','2021-08-11 07:10:01',1),(4,'LIMIT_RESET_PASSWORD','1800',NULL,'admin','2021-08-12 07:14:45','admin','2021-08-12 07:14:45',1),(5,'HOSTNAME_SERVER','api.dev-lmspim.lan.egov.co.id','hostname aplikasi utk download dll','admin','2021-08-12 07:15:34','admin','2021-08-30 10:49:17',1),(6,'AGREGASI_MASUK_START','07:00',NULL,'admin','2021-08-12 07:15:34','admin','2021-08-30 10:49:17',1),(7,'AGREGASI_MASUK_END','08:00',NULL,'admin','2021-08-12 07:15:34','admin','2021-08-30 10:49:17',1),(8,'AGREGASI_KELUAR_START','16:00',NULL,'admin','2021-08-12 07:15:34','admin','2021-08-30 10:49:17',1),(9,'AGREGASI_KELUAR_END','17:00',NULL,'admin','2021-08-12 07:15:34','admin','2021-08-30 10:49:17',1),(10,'UUID_TEMPLATE_TUGAS_PELAJARAN','c9e39d6f-52fd-4178-9d3c-97091e682ff0','','admin','2021-08-12 07:15:34','admin','2021-08-30 10:49:17',1),(11,'UUID_TEMPLATE_UJIAN_KUIS','a401a6e6-9384-45a8-aa29-0fae729ec897','','admin','2021-08-12 07:15:34','admin','2021-08-30 10:49:17',1),(12,'LOG_TIME_UJIAN_REMAINING','120',NULL,'admin','2021-08-12 07:15:34','admin','2021-08-30 10:49:17',1),(13,'LOG_TIME_UJIAN_ALACARTE_REMAINING','120',NULL,'admin','2021-08-12 07:15:34','admin','2021-08-30 10:49:17',1),(14,'UUID_TEMPLATE_MATERI_ALACARTE_KUIS','a401a6e6-9384-45a8-aa29-0fae729ec897',NULL,'admin','2021-08-12 07:15:34','admin','2021-08-30 10:49:17',1),(15,'LIMITATION_FOR_RANDOM_DATA','5',NULL,'admin','2021-08-12 07:15:34','admin','2021-08-30 10:49:17',1),(16,'OAUTH2_SMARTBANGKOM_URL_LOGIN','https://smartbangkom.lan.go.id:9001/oauth/token',NULL,'admin','2021-08-12 07:15:34','admin','2021-08-30 10:49:17',1),(17,'OAUTH2_SMARTBANGKOM_CREDENTIALS','USER_CLIENT_APP:password',NULL,'admin','2021-08-12 07:15:34','admin','2021-08-30 10:49:17',1),(18,'OAUTH2_SMARTBANGKOM_GRANT_TYPE','password',NULL,'admin','2021-08-12 07:15:34','admin','2021-08-30 10:49:17',1),(19,'OAUTH2_SMARTBANGKOM_PARAM_USERNAME','admin',NULL,'admin','2021-08-12 07:15:34','admin','2021-08-30 10:49:17',1),(20,'OAUTH2_SMARTBANGKOM_PARAM_PASSWORD','veteran10',NULL,'admin','2021-08-12 07:15:34','admin','2021-08-30 10:49:17',1),(21,'OAUTH2_SMARTBANGKOM_URL_UPDATE_PESERTA','https://smartbangkom.lan.go.id:8092/peserta/tambahnilai/',NULL,'admin','2021-08-12 07:15:34','admin','2021-08-30 10:49:17',1),(22,'UUID_BUKU_MANUAL','a401a6e6-9384-45a8-aa29-0fae729ec897',NULL,'admin','2021-08-12 07:15:34','admin','2021-08-30 10:49:17',1);
/*!40000 ALTER TABLE `m_param` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pajak`
--

DROP TABLE IF EXISTS `pajak`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pajak` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nomor_resi` varchar(255) DEFAULT NULL,
  `tanggal` timestamp NULL DEFAULT NULL,
  `status` enum('PENDING','REJECTED','APPROVED') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` timestamp NULL DEFAULT NULL,
  `role` enum('ADMIN','USER','MAKER','CHECKER','APPROVER') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `updated_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `updated_date` timestamp NULL DEFAULT NULL,
  `update_role` enum('ADMIN','USER','MAKER','CHECKER','APPROVER') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pajak`
--

LOCK TABLES `pajak` WRITE;
/*!40000 ALTER TABLE `pajak` DISABLE KEYS */;
INSERT INTO `pajak` VALUES (1,'1234','2022-02-13 00:00:00','APPROVED','maker@gmail.com','2023-03-19 15:01:21','MAKER',NULL,NULL,'ADMIN'),(2,'12345','2022-02-13 00:00:00','APPROVED','maker@gmail.com','2023-03-19 15:02:09','MAKER',NULL,NULL,'ADMIN'),(3,'1111','2022-02-13 00:00:00','REJECTED','maker@gmail.com','2023-03-19 15:12:38','MAKER',NULL,NULL,'ADMIN'),(4,'2222','2022-05-13 00:00:00','APPROVED','maker@gmail.com','2023-03-19 15:16:06','MAKER',NULL,NULL,'ADMIN'),(6,'333','2022-05-13 00:00:00','PENDING','maker@gmail.com','2023-03-19 15:27:56','MAKER',NULL,NULL,'USER');
/*!40000 ALTER TABLE `pajak` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-03-19 22:31:34
