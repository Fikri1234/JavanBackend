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
-- Table structure for table `m_user`
--

DROP TABLE IF EXISTS `m_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `m_user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `m_branch_id` int DEFAULT NULL,
  `username` varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `account_expired` tinyint(1) DEFAULT NULL,
  `account_locked` tinyint(1) DEFAULT NULL,
  `credentials_expired` tinyint(1) DEFAULT NULL,
  `first_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `last_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `gender` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `fail_counter` int DEFAULT '0',
  `change_pwd_counter` int DEFAULT '0',
  `last_login` timestamp NULL DEFAULT NULL,
  `reset_token` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `lembaga_diklat_id` int DEFAULT NULL,
  `m_user_role_id` varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `created_by` varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `created_date` timestamp NULL DEFAULT NULL,
  `last_update_by` varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `last_update` timestamp NULL DEFAULT NULL,
  `enabled` tinyint(1) DEFAULT NULL,
  `role` enum('ADMIN','USER') NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `m_user`
--

LOCK TABLES `m_user` WRITE;
/*!40000 ALTER TABLE `m_user` DISABLE KEYS */;
INSERT INTO `m_user` VALUES (1,1,'admin',0,0,0,NULL,NULL,'brullyz@gmail.com','men1',0,0,'2021-12-18 06:36:20','02ff30f2-f2ba-4099-88f1-73454ab16d58','$2a$08$GA5EWEF5oG8bAfGgT45UQeHHw.8VOdmW5yIINXpNVpS1fW/kGFn2e',NULL,'ROLE_ADMIN','admin','2021-08-11 08:43:16','199510012020121016','2021-08-29 06:19:07',1,'USER'),(2,1,'199209212020122021',0,0,0,NULL,NULL,'arumandaryratri@poliwangi.ac.id','Wanita',0,0,'2021-08-25 07:12:10',NULL,'$2a$08$WSz3dYICoYXlrjgFDShV6uupD2Xud5FaUfNp1YLA7oUD3vmTvlkOm',NULL,'ROLE_ADMIN','admin','2021-08-17 19:20:17','admin','2021-09-08 22:34:12',1,'USER'),(6,NULL,'admin12443',0,0,0,NULL,NULL,'brullyz1@gmail.com','Laki-laki',0,0,'2021-08-12 07:12:36','888f16a9-41ee-429d-b1c3-38b92b68282b','$2a$08$ilOcoDr5ZfvNmAJCjIMEqeK/YXVK9e45IUJbW.akfYLR7pv0fwzyG',NULL,'ROLE_ADMIN','admin','2021-08-19 20:01:35','199510012020121016','2021-08-25 10:26:19',1,'USER'),(7,NULL,'coegcoegcoeg',0,0,0,NULL,NULL,'farhanfarhan@gmail.com','men',0,0,NULL,NULL,'',NULL,'ROLE_ADMIN','199209212020122021','2021-08-20 04:47:54','199209212020122021','2021-08-20 04:47:54',1,'USER'),(8,NULL,'coegcoegcoeg',0,0,0,NULL,NULL,'farhanfarhan@gmail.com','men',0,0,NULL,NULL,'coegcoeg',NULL,'ROLE_ADMIN','199209212020122021','2021-08-20 04:48:50','199209212020122021','2021-08-20 04:48:50',1,'USER'),(9,NULL,'admin123',0,0,0,NULL,NULL,'brullyz2@gmail.com','men',0,0,NULL,'db9de870-f85a-43e8-bdea-c646a6a1c529','$2a$08$8BQlqQMHxoyoMef3wskjpOS2tdtL8p4RCREkemEMNWq0J6XYaBzei',NULL,'ROLE_ADMIN','admin','2021-08-21 04:23:09','admin','2021-08-24 17:40:21',1,'USER'),(10,NULL,'maulidates',0,0,0,NULL,NULL,'maulidair@gmail.com','female',0,0,NULL,NULL,'$2a$08$TnyL8ziz8maJXkbR7zsuKuNEW7JoP8vrKGEp33ob2GiaEPxB2yryy',NULL,'ROLE_PIC','admin','2021-08-21 13:35:50','admin','2021-08-21 13:53:20',1,'USER'),(11,NULL,'maulidatesupdate',0,0,0,'maulida',NULL,'maulida@gamatechno.com','female',0,0,NULL,NULL,'$2a$08$rojWRGhBV/n99lQFl3.z8ucdLTrCvjcL4NzcDSW5qYiOdlffsyRKi',NULL,'ROLE_PESERTA','admin','2021-08-21 13:55:39','admin','2021-08-21 13:55:39',1,'USER'),(12,NULL,'testpassword',0,0,0,NULL,NULL,'maulidamir@gmail.com','female',0,0,NULL,NULL,'$2a$08$8q9c9XH6332As7BvtisgBegiLmg5OSiTotru7ouQq/Ht/hVEZmKsS',NULL,'ROLE_ADMIN','admin','2021-08-21 14:13:06','admin','2021-08-21 14:13:06',1,'USER'),(13,NULL,'199510012020121016',0,0,0,NULL,NULL,'arumandaryratri@poliwangi.ac.id','Wanita',0,0,'2021-08-29 06:04:41',NULL,'$2a$08$Ia/oBwMoxqXHSRdpqTpnY.ysjaNB1xdodDyNAcdm83mD3JsUtAVW2',NULL,'ROLE_PESERTA','199209212020122021','2021-08-25 07:12:35','199209212020122021','2021-08-25 07:12:35',1,'USER'),(14,NULL,'admin12344',0,0,0,NULL,NULL,'brullyz3@gmail.com','men',0,0,NULL,NULL,'$2a$08$9xVYKmCQaqKVWNdCM8gH9u2uroA87J26UAqWOZ2uLEBnppOIAzLxm',NULL,'ROLE_ADMIN','199510012020121016','2021-08-29 04:04:48','199510012020121016','2021-08-29 04:04:48',1,'USER'),(15,NULL,'admin1234554',0,0,0,NULL,NULL,'brullyz4@gmail.com','men',0,0,NULL,NULL,'$2a$08$MuDyqVE8eK0X2B7FrQAnZu8uIDSqKiO7ge3GD.vEcAbqQ.RWOM0My',NULL,'ROLE_ADMIN','199510012020121016','2021-08-29 04:10:05','199510012020121016','2021-08-29 04:10:05',1,'USER'),(16,NULL,'123123123123',0,0,0,NULL,NULL,'brullyz5@gmail.com','men',0,0,NULL,NULL,'$2a$08$G06GAp8brmRjRAD7Yx0r/unzg2iehZ1nm.e2a31TT3xD2spOTUO5G',NULL,'ROLE_ADMIN','199510012020121016','2021-08-29 04:10:11','199510012020121016','2021-08-29 04:10:11',1,'USER'),(17,NULL,'1231231231235',0,0,0,NULL,NULL,'brullyz6@gmail.com','men',0,0,NULL,NULL,'$2a$08$DhcdFA8WqZvBFBgaf6hsiub4rP8lEMYGkmhUZvw8IlheYHXVIrho6',NULL,'ROLE_PENGAJAR','199510012020121016','2021-08-29 04:10:47','199510012020121016','2021-08-31 15:06:39',1,'USER'),(18,NULL,'asedeblabla',0,0,0,NULL,NULL,'asedeblabla@gmail.com','men',0,0,'2021-08-29 06:28:06',NULL,'$2a$08$T8t24tUIrkU33jZ7C4UsougTzTijXf3B1v0D03xHFF2ZPHZGdTMTi',NULL,NULL,'199510012020121016','2021-08-29 06:05:47','199510012020121016','2021-08-29 06:25:33',1,'USER'),(19,NULL,'bluktuuuk',0,0,0,NULL,NULL,'arumandaryratri@poliwangi.ac.id','Wanita',0,0,'2021-08-29 06:30:59',NULL,'$2a$08$sB36Xc1q8x/x1Qw2mIMMguSsB8jQYaFhxSALExvoVpW16JiMnjYVO',NULL,NULL,'asedeblabla','2021-08-29 06:30:15','asedeblabla','2021-08-29 06:30:15',1,'USER'),(20,NULL,'farhanfaturohmen',0,0,0,NULL,NULL,'farhanfaturohmen@gmail.com','men',0,1,'2021-09-02 16:05:33',NULL,'$2a$08$RNdogbvjYp0IJ3XOtPf/EeoxbiiQfB9OEhp51/wOtwNZ4iPjYDZ8e',NULL,NULL,'bluktuuuk','2021-08-29 06:42:18','farhanfaturohmen','2021-08-29 06:44:11',1,'USER'),(21,NULL,'belumupdatetimezone',0,0,0,NULL,NULL,'arumandaryratri@poliwangi.ac.id','Wanita',0,0,NULL,NULL,'$2a$08$R682MXJr0ibDuwWC.gy5p.PC3tMCljZvYSrjeXzrL1epMkx4nAtcO',NULL,NULL,'farhanfaturohmen','2021-09-02 16:06:37','farhanfaturohmen','2021-09-02 16:06:37',1,'USER'),(22,NULL,'sudahupdatetimezone',0,0,0,NULL,NULL,'arumandaryratri@poliwangi.ac.id','Wanita',0,0,'2021-09-02 16:07:22',NULL,'$2a$08$gr/0hWAXl3y5v9nclUmmAubg/uEohMUWkEh.GSHk8VbssiOaId.8y',NULL,NULL,'farhanfaturohmen','2021-09-02 16:06:47','farhanfaturohmen','2021-09-02 16:06:47',1,'USER'),(23,NULL,'smartbangkom',0,0,0,'smartbangkom','smartbangkom','smartbangkom@lan.go.id','men',0,0,'2021-09-06 14:14:14',NULL,'$2a$08$aceRKjlHG45WZ2anyaDZceuYG2Z1y1U8GSm.Gio7FbUMD0TwuDWn2',NULL,NULL,'sudahupdatetimezone','2021-09-03 07:08:42','sudahupdatetimezone','2021-09-03 07:08:42',1,'USER'),(24,NULL,'faisalbinding',0,0,0,NULL,NULL,'arumandaryratri@poliwangi.ac.id','Wanita',0,0,'2021-09-06 11:46:05',NULL,'$2a$08$VaqgKW8srXSgNGcKwEz4OOwSMja.zj1ZHLDi9S5XufBhXAMhCrnyi',NULL,NULL,'smartbangkom','2021-09-03 08:31:12','smartbangkom','2021-09-03 08:31:12',1,'USER'),(25,NULL,'123321123321',0,0,0,NULL,NULL,'coba56@gmail.com','Pria',0,0,NULL,NULL,'$2a$08$NbtMP0QwDxtz.7Rvsyhiy.0DL4ZPiUsMp425RauX7S1Koe7ACLE8K',NULL,NULL,'smartbangkom','2021-09-06 04:04:37','smartbangkom','2021-09-06 04:04:37',1,'USER'),(26,NULL,'8763900098362333',0,0,0,NULL,NULL,'coba6@gmail.com','Pria',0,0,NULL,NULL,'$2a$08$i.EpJpXlkXKnVCoWtWsN7.VVBM22baTuTVu.x6zN3R7qm5J.TtH2i',NULL,NULL,'smartbangkom','2021-09-06 04:10:05','smartbangkom','2021-09-06 04:10:05',1,'USER'),(27,NULL,'7699002544444444',0,0,0,NULL,NULL,'coba16@gmail.com','Pria',0,0,NULL,NULL,'$2a$08$YiVBhzsIO1D.vtjW6qP4X.K3oOzJPlVy0rOF.IogNftvVUHTfwjaC',NULL,NULL,'smartbangkom','2021-09-06 04:13:23','smartbangkom','2021-09-06 04:13:23',1,'USER'),(28,NULL,'99997545567777777',0,0,0,NULL,NULL,'coba15@gmail.com','Pria',0,0,NULL,NULL,'$2a$08$7BMxyfmZPiiEe5kyvW2L5uMqXrPw3deC1.1l/LnMVWqIFwZArqzwa',NULL,NULL,'smartbangkom','2021-09-06 04:15:58','smartbangkom','2021-09-06 04:15:58',1,'USER'),(29,NULL,'997720722222333111',0,0,0,NULL,NULL,'coba14@gmail.com','Pria',0,0,NULL,NULL,'$2a$08$odxUeFvAMXrqrKHtDvk4b./N4PPMWUBpx7MpOfSeK65HsFR3UsGca',NULL,NULL,'smartbangkom','2021-09-06 04:18:41','smartbangkom','2021-09-06 04:18:41',1,'USER'),(30,NULL,'23423634644444422222',0,0,0,NULL,NULL,'coba101@gmail.com','Pria',0,0,NULL,NULL,'$2a$08$vSB761ipS/Lf/CXaESBfiuWW9RNNhiYr.FGhjqE69ilMyVtd7g61W',NULL,NULL,'smartbangkom','2021-09-06 06:22:12','smartbangkom','2021-09-06 06:22:12',1,'USER'),(31,NULL,'881231251252323234222',0,0,0,NULL,NULL,'coba110@gmail.com','Pria',0,0,NULL,NULL,'$2a$08$bxVgZ4sLUPU9bFZH0GRnwugGKmk4HDkXaUvKeaOE/Hh9xnL8H6BFG',NULL,NULL,'smartbangkom','2021-09-06 06:34:52','smartbangkom','2021-09-06 06:34:52',1,'USER'),(32,NULL,'2299991000000222222',0,0,0,NULL,NULL,'coba111@gmail.com','Pria',0,0,NULL,NULL,'$2a$08$o86y64FSbudZb0eFlOGuX.amTQZ2RWO/rOQmrhDFwq27w/sEgnNVC',NULL,NULL,'smartbangkom','2021-09-06 06:59:04','smartbangkom','2021-09-06 06:59:04',1,'USER'),(33,NULL,'9928888000220077343333',0,0,0,NULL,NULL,'coba102@gmail.com','Pria',0,0,NULL,NULL,'$2a$08$nWwuzY0QIn4N9SsChNxBVuU7uoqE4IiFMBEhvDfprhVFeWG6FoTlm',NULL,NULL,'smartbangkom','2021-09-06 06:59:04','smartbangkom','2021-09-06 06:59:04',1,'USER'),(34,NULL,'9900000222888888888833',0,0,0,NULL,NULL,'coba123@gmail.com','Pria',0,0,NULL,NULL,'$2a$08$McQ5tD8FMjFk4.REnGjhb.vVN6PYDiwIRYDIVlM3R9GqCQAN51/O6',NULL,NULL,'smartbangkom','2021-09-06 07:43:28','smartbangkom','2021-09-06 07:43:28',1,'USER'),(35,NULL,'1999213123123123',0,0,0,NULL,NULL,'arumandaryratri@poliwangi.ac.id','Wanita',0,0,NULL,NULL,'$2a$08$65JLQaXxhe/X7e.z/uaUCO1jSs4w6Jy9/mLpvR.GdzZoskB7PE77S',NULL,NULL,'admin','2021-09-09 02:54:24','admin','2021-09-09 02:54:24',1,'USER'),(41,NULL,'admin123aja',0,0,0,NULL,NULL,'brullyz7@gmail.com','men',0,0,NULL,NULL,'$2a$08$oSEkedVj3ri3cq8nNNKcvuPOvcF/.YB52t3u65Mn6hNEYr2acvPvC',NULL,NULL,'admin','2021-09-13 03:18:31','admin','2021-09-13 03:19:01',1,'USER'),(42,NULL,'199510012020121111',0,0,0,'Farhan Faturohman',NULL,'farhanfaturohmen@gmail.com','Pria',0,0,NULL,NULL,'$2a$08$aqAMrwkCgaQaXQ8S50rv6O7lbdHZFCKBrVfqfBNJMx0uqjyu6sZ9C',NULL,NULL,'admin','2021-09-27 13:28:09','admin','2021-09-27 13:28:09',1,'USER');
/*!40000 ALTER TABLE `m_user` ENABLE KEYS */;
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
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pajak`
--

LOCK TABLES `pajak` WRITE;
/*!40000 ALTER TABLE `pajak` DISABLE KEYS */;
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

-- Dump completed on 2023-03-17  6:44:36
