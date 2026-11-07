-- MySQL dump 10.13  Distrib 8.0.46, for Linux (x86_64)
--
-- Host: localhost    Database: analisisResultado
-- ------------------------------------------------------
-- Server version	8.0.46

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
-- Table structure for table `analisis-asignatura`
--

DROP TABLE IF EXISTS `analisis-asignatura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `analisis-asignatura` (
  `asignatura_id` bigint NOT NULL AUTO_INCREMENT,
  `abreviatura` varchar(255) DEFAULT NULL,
  `nivel` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`asignatura_id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `analisis-asignatura`
--

LOCK TABLES `analisis-asignatura` WRITE;
/*!40000 ALTER TABLE `analisis-asignatura` DISABLE KEYS */;
INSERT INTO `analisis-asignatura` VALUES (1,'len','ESO1','Lengua Castellana'),(2,'len','ESO2','Lengua Castellana'),(3,'len','ESO3','Lengua Castellana'),(4,'len','ESO4','Lengua Castellana'),(5,'len','BACH1','Lengua Castellana'),(6,'len','BACH2','Lengua Castellana'),(7,'mat','ESO1','Matemáticas'),(8,'mat','ESO2','Matemáticas'),(9,'mat','ESO3','Matemáticas'),(10,'mat','ESO4','Matemáticas'),(11,'mat','BACH1','Matemáticas'),(12,'mat','BACH2','Matemáticas'),(13,'his','ESO1','Historia'),(14,'his','ESO2','Historia'),(15,'his','ESO3','Historia'),(16,'his','ESO4','Historia'),(17,'his','BACH1','Historia'),(18,'his','BACH2','Historia'),(19,'fis','ESO1','Física'),(20,'fis','ESO2','Física'),(21,'fis','ESO3','Física'),(22,'fis','ESO4','Física'),(23,'fis','BACH1','Física'),(24,'fis','BACH2','Física'),(25,'ing','ESO1','Inglés'),(26,'ing','ESO2','Inglés'),(27,'ing','ESO3','Inglés'),(28,'ing','ESO4','Inglés'),(29,'ing','BACH1','Inglés'),(30,'ing','BACH2','Inglés'),(31,'bio','ESO1','Biología'),(32,'bio','ESO2','Biología'),(33,'bio','ESO3','Biología'),(34,'bio','ESO4','Biología'),(35,'bio','BACH1','Biología'),(36,'bio','BACH2','Biología');
/*!40000 ALTER TABLE `analisis-asignatura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `analisis-docente`
--

DROP TABLE IF EXISTS `analisis-docente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `analisis-docente` (
  `docente_id` bigint NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL,
  `usuario_id` bigint DEFAULT NULL,
  PRIMARY KEY (`docente_id`),
  UNIQUE KEY `UK4tt6yxqk1hchcr9x0psvhfby2` (`usuario_id`),
  CONSTRAINT `FKc8fnt6vwaes0h6a7ek2phyid` FOREIGN KEY (`usuario_id`) REFERENCES `analisis-usuario` (`usuario_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `analisis-docente`
--

LOCK TABLES `analisis-docente` WRITE;
/*!40000 ALTER TABLE `analisis-docente` DISABLE KEYS */;
INSERT INTO `analisis-docente` VALUES (1,'Ana García López',1),(2,'Luis Martínez Sánchez',2),(3,'Marta Fernández Ruiz',3),(4,'Carlos Gómez Navarro',4),(5,'Laura Díaz Moreno',5),(6,'Javier Romero Torres',6),(7,'Elena Vázquez Molina',7),(8,'David Ortega Castro',8),(9,'Sara Navarro Iglesias',9),(10,'Pablo Serrano Vega',10);
/*!40000 ALTER TABLE `analisis-docente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `analisis-grupo`
--

DROP TABLE IF EXISTS `analisis-grupo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `analisis-grupo` (
  `grupo_id` bigint NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`grupo_id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `analisis-grupo`
--

LOCK TABLES `analisis-grupo` WRITE;
/*!40000 ALTER TABLE `analisis-grupo` DISABLE KEYS */;
INSERT INTO `analisis-grupo` VALUES (1,'ESO1-A'),(2,'ESO1-B'),(3,'ESO1-C'),(4,'ESO1-D'),(5,'ESO2-A'),(6,'ESO2-B'),(7,'ESO2-C'),(8,'ESO2-D'),(9,'ESO3-A'),(10,'ESO3-B'),(11,'ESO3-C'),(12,'ESO3-D'),(13,'ESO4-A'),(14,'ESO4-B'),(15,'ESO4-C'),(16,'ESO4-D'),(17,'BACH1-A'),(18,'BACH1-B'),(19,'BACH1-C'),(20,'BACH1-D'),(21,'BACH2-A'),(22,'BACH2-B'),(23,'BACH2-C'),(24,'BACH2-D');
/*!40000 ALTER TABLE `analisis-grupo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `analisis-respuesta`
--

DROP TABLE IF EXISTS `analisis-respuesta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `analisis-respuesta` (
  `respuesta_id` bigint NOT NULL AUTO_INCREMENT,
  `dif_bajo_nivel` bit(1) NOT NULL,
  `dif_carencia_medios` bit(1) NOT NULL,
  `dif_escaso_habito` bit(1) NOT NULL,
  `dif_falta_motivacion` bit(1) NOT NULL,
  `dif_influencia_clima` bit(1) NOT NULL,
  `dif_mal_ambiente` bit(1) NOT NULL,
  `dif_otra` varchar(255) DEFAULT NULL,
  `dif_poca_colaboracion` bit(1) NOT NULL,
  `numero_alumnos_aprobados` int NOT NULL,
  `numero_alumnos_grupo` int NOT NULL,
  `propuestas_mejora` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`respuesta_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `analisis-respuesta`
--

LOCK TABLES `analisis-respuesta` WRITE;
/*!40000 ALTER TABLE `analisis-respuesta` DISABLE KEYS */;
INSERT INTO `analisis-respuesta` VALUES (1,_binary '\0',_binary '',_binary '\0',_binary '\0',_binary '\0',_binary '\0','',_binary '',20,20,'');
/*!40000 ALTER TABLE `analisis-respuesta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `analisis-resultado`
--

DROP TABLE IF EXISTS `analisis-resultado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `analisis-resultado` (
  `asignatura_id` bigint NOT NULL,
  `docente_id` bigint NOT NULL,
  `grupo_id` bigint NOT NULL,
  `respuesta_id` bigint DEFAULT NULL,
  PRIMARY KEY (`asignatura_id`,`docente_id`,`grupo_id`),
  UNIQUE KEY `UKqyu5822a120e2a1jlo43mt3gd` (`respuesta_id`),
  KEY `FK76xf2xys1uai4yhfwts1n46v2` (`docente_id`),
  KEY `FKqfqgmvugq1lrcd06ibgbypvu` (`grupo_id`),
  CONSTRAINT `FK4618i6tpkafku1ejiidb90kpg` FOREIGN KEY (`asignatura_id`) REFERENCES `analisis-asignatura` (`asignatura_id`),
  CONSTRAINT `FK76xf2xys1uai4yhfwts1n46v2` FOREIGN KEY (`docente_id`) REFERENCES `analisis-docente` (`docente_id`),
  CONSTRAINT `FKgb2f09i816994353akb7yh3d7` FOREIGN KEY (`respuesta_id`) REFERENCES `analisis-respuesta` (`respuesta_id`),
  CONSTRAINT `FKqfqgmvugq1lrcd06ibgbypvu` FOREIGN KEY (`grupo_id`) REFERENCES `analisis-grupo` (`grupo_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `analisis-resultado`
--

LOCK TABLES `analisis-resultado` WRITE;
/*!40000 ALTER TABLE `analisis-resultado` DISABLE KEYS */;
INSERT INTO `analisis-resultado` VALUES (1,1,1,NULL),(1,1,2,NULL),(1,1,3,NULL),(1,1,4,NULL),(2,1,6,NULL),(2,1,7,NULL),(2,1,8,NULL),(5,1,17,NULL),(5,1,18,NULL),(6,1,21,NULL),(6,1,22,NULL),(7,2,1,NULL),(7,2,2,NULL),(8,2,5,NULL),(8,2,6,NULL),(9,2,9,NULL),(9,2,10,NULL),(10,2,13,NULL),(10,2,14,NULL),(11,2,17,NULL),(11,2,18,NULL),(12,2,21,NULL),(12,2,22,NULL),(13,3,1,NULL),(13,3,2,NULL),(14,3,5,NULL),(14,3,6,NULL),(15,3,9,NULL),(15,3,10,NULL),(16,3,13,NULL),(16,3,14,NULL),(17,3,17,NULL),(17,3,18,NULL),(18,3,21,NULL),(18,3,22,NULL),(21,4,11,NULL),(21,4,12,NULL),(22,4,15,NULL),(22,4,16,NULL),(23,4,19,NULL),(23,4,20,NULL),(24,4,23,NULL),(24,4,24,NULL),(25,5,1,NULL),(25,5,2,NULL),(26,5,5,NULL),(26,5,6,NULL),(27,5,9,NULL),(27,5,10,NULL),(28,5,13,NULL),(28,5,14,NULL),(29,5,17,NULL),(30,5,21,NULL),(33,6,11,NULL),(33,6,12,NULL),(34,6,15,NULL),(34,6,16,NULL),(35,6,19,NULL),(35,6,20,NULL),(36,6,23,NULL),(36,6,24,NULL),(2,1,5,1);
/*!40000 ALTER TABLE `analisis-resultado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `analisis-tema`
--

DROP TABLE IF EXISTS `analisis-tema`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `analisis-tema` (
  `tema_id` bigint NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL,
  `asignatura_id` bigint DEFAULT NULL,
  PRIMARY KEY (`tema_id`),
  KEY `FKjsuirgi8abht030ae0fujfuql` (`asignatura_id`),
  CONSTRAINT `FKjsuirgi8abht030ae0fujfuql` FOREIGN KEY (`asignatura_id`) REFERENCES `analisis-asignatura` (`asignatura_id`)
) ENGINE=InnoDB AUTO_INCREMENT=121 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `analisis-tema`
--

LOCK TABLES `analisis-tema` WRITE;
/*!40000 ALTER TABLE `analisis-tema` DISABLE KEYS */;
INSERT INTO `analisis-tema` VALUES (1,'Unidad 1 - Comunicación',1),(2,'Unidad 2 - Gramática',1),(3,'Unidad 3 - Ortografía',1),(4,'Unidad 4 - Literatura',1),(5,'Unidad 5 - Expresión escrita',1),(6,'Unidad 1 - Comunicación',2),(7,'Unidad 2 - Gramática',2),(8,'Unidad 3 - Ortografía',2),(9,'Unidad 4 - Literatura',2),(10,'Unidad 5 - Expresión escrita',2),(11,'Unidad 1 - Comunicación',3),(12,'Unidad 2 - Gramática',3),(13,'Unidad 3 - Ortografía',3),(14,'Unidad 4 - Literatura',3),(15,'Unidad 5 - Expresión escrita',3),(16,'Unidad 1 - Comunicación',4),(17,'Unidad 2 - Gramática',4),(18,'Unidad 3 - Ortografía',4),(19,'Unidad 4 - Literatura',4),(20,'Unidad 5 - Expresión escrita',4),(21,'Unidad 1 - Sintaxis',5),(22,'Unidad 2 - Literatura medieval',5),(23,'Unidad 3 - Renacimiento',5),(24,'Unidad 4 - Comentario de texto',5),(25,'Unidad 5 - Argumentación',5),(26,'Unidad 1 - Literatura contemporánea',6),(27,'Unidad 2 - Sintaxis avanzada',6),(28,'Unidad 3 - Comentario crítico',6),(29,'Unidad 4 - Teatro español',6),(30,'Unidad 5 - Poesía española',6),(31,'Unidad 1 - Números',7),(32,'Unidad 2 - Álgebra',7),(33,'Unidad 3 - Geometría',7),(34,'Unidad 4 - Proporcionalidad',7),(35,'Unidad 5 - Estadística',7),(36,'Unidad 1 - Números enteros',8),(37,'Unidad 2 - Ecuaciones',8),(38,'Unidad 3 - Funciones',8),(39,'Unidad 4 - Geometría',8),(40,'Unidad 5 - Probabilidad',8),(41,'Unidad 1 - Potencias',9),(42,'Unidad 2 - Polinomios',9),(43,'Unidad 3 - Ecuaciones',9),(44,'Unidad 4 - Trigonometría',9),(45,'Unidad 5 - Estadística',9),(46,'Unidad 1 - Números reales',10),(47,'Unidad 2 - Funciones',10),(48,'Unidad 3 - Geometría analítica',10),(49,'Unidad 4 - Probabilidad',10),(50,'Unidad 5 - Estadística',10),(51,'Unidad 1 - Límites',11),(52,'Unidad 2 - Derivadas',11),(53,'Unidad 3 - Integrales',11),(54,'Unidad 4 - Probabilidad',11),(55,'Unidad 5 - Geometría',11),(56,'Unidad 1 - Álgebra',12),(57,'Unidad 2 - Derivadas',12),(58,'Unidad 3 - Integrales',12),(59,'Unidad 4 - Probabilidad',12),(60,'Unidad 5 - Estadística',12),(61,'Unidad 1 - Prehistoria',13),(62,'Unidad 2 - Edad Antigua',13),(63,'Unidad 3 - Grecia',13),(64,'Unidad 4 - Roma',13),(65,'Unidad 5 - Hispania',13),(66,'Unidad 1 - Edad Media',14),(67,'Unidad 2 - Al-Ándalus',14),(68,'Unidad 3 - Reinos cristianos',14),(69,'Unidad 4 - La Reconquista',14),(70,'Unidad 5 - La Edad Moderna',14),(71,'Unidad 1 - Renacimiento',15),(72,'Unidad 2 - Reforma protestante',15),(73,'Unidad 3 - Monarquías absolutas',15),(74,'Unidad 4 - Ilustración',15),(75,'Unidad 5 - Revoluciones',15),(76,'Unidad 1 - Revolución Industrial',16),(77,'Unidad 2 - Imperialismo',16),(78,'Unidad 3 - Primera Guerra Mundial',16),(79,'Unidad 4 - Guerra Civil española',16),(80,'Unidad 5 - Segunda Guerra Mundial',16),(81,'Unidad 1 - Crisis del Antiguo Régimen',17),(82,'Unidad 2 - Liberalismo',17),(83,'Unidad 3 - Revolución Industrial',17),(84,'Unidad 4 - Colonialismo',17),(85,'Unidad 5 - España contemporánea',17),(86,'Unidad 1 - Restauración borbónica',18),(87,'Unidad 2 - Segunda República',18),(88,'Unidad 3 - Guerra Civil',18),(89,'Unidad 4 - Dictadura franquista',18),(90,'Unidad 5 - Transición democrática',18),(91,'Unidad 1 - La materia',19),(92,'Unidad 2 - Movimiento',19),(93,'Unidad 3 - Fuerzas',19),(94,'Unidad 4 - Energía',19),(95,'Unidad 5 - Electricidad',19),(96,'Unidad 1 - Cinemática',20),(97,'Unidad 2 - Dinámica',20),(98,'Unidad 3 - Trabajo',20),(99,'Unidad 4 - Calor',20),(100,'Unidad 5 - Ondas',20),(101,'Unidad 1 - Movimiento rectilíneo',21),(102,'Unidad 2 - Leyes de Newton',21),(103,'Unidad 3 - Gravitación',21),(104,'Unidad 4 - Fluidos',21),(105,'Unidad 5 - Electricidad',21),(106,'Unidad 1 - Electromagnetismo',22),(107,'Unidad 2 - Óptica',22),(108,'Unidad 3 - Energía',22),(109,'Unidad 4 - Física moderna',22),(110,'Unidad 5 - Tecnología',22),(111,'Unidad 1 - Vectores',23),(112,'Unidad 2 - Mecánica',23),(113,'Unidad 3 - Campo gravitatorio',23),(114,'Unidad 4 - Campo eléctrico',23),(115,'Unidad 5 - Termodinámica',23),(116,'Unidad 1 - Ondas',24),(117,'Unidad 2 - Óptica',24),(118,'Unidad 3 - Relatividad',24),(119,'Unidad 4 - Física cuántica',24),(120,'Unidad 5 - Física nuclear',24);
/*!40000 ALTER TABLE `analisis-tema` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `analisis-tema_Resultado`
--

DROP TABLE IF EXISTS `analisis-tema_Resultado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `analisis-tema_Resultado` (
  `desarrollada` bit(1) NOT NULL,
  `evaluada` bit(1) NOT NULL,
  `observaciones` varchar(255) DEFAULT NULL,
  `resultado_asignatura_id` bigint NOT NULL,
  `resultado_docente_id` bigint NOT NULL,
  `resultado_grupo_id` bigint NOT NULL,
  `tema_id` bigint NOT NULL,
  PRIMARY KEY (`resultado_asignatura_id`,`resultado_docente_id`,`resultado_grupo_id`,`tema_id`),
  KEY `FKdge12rvfgx72xcxcm3yvjdrs4` (`tema_id`),
  CONSTRAINT `FKdge12rvfgx72xcxcm3yvjdrs4` FOREIGN KEY (`tema_id`) REFERENCES `analisis-tema` (`tema_id`),
  CONSTRAINT `FKjqkr8xpkxivgudpk0stgdflgx` FOREIGN KEY (`resultado_asignatura_id`, `resultado_docente_id`, `resultado_grupo_id`) REFERENCES `analisis-resultado` (`asignatura_id`, `docente_id`, `grupo_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `analisis-tema_Resultado`
--

LOCK TABLES `analisis-tema_Resultado` WRITE;
/*!40000 ALTER TABLE `analisis-tema_Resultado` DISABLE KEYS */;
INSERT INTO `analisis-tema_Resultado` VALUES (_binary '',_binary '','',2,1,5,6),(_binary '',_binary '','',2,1,5,7),(_binary '',_binary '','',2,1,5,8),(_binary '',_binary '','',2,1,5,9),(_binary '',_binary '','',2,1,5,10);
/*!40000 ALTER TABLE `analisis-tema_Resultado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `analisis-usuario`
--

DROP TABLE IF EXISTS `analisis-usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `analisis-usuario` (
  `usuario_id` bigint NOT NULL AUTO_INCREMENT,
  `password` varchar(255) DEFAULT NULL,
  `role` enum('ADMIN','USER') DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`usuario_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `analisis-usuario`
--

LOCK TABLES `analisis-usuario` WRITE;
/*!40000 ALTER TABLE `analisis-usuario` DISABLE KEYS */;
INSERT INTO `analisis-usuario` VALUES (1,'{bcrypt}$2a$10$ziSxLc7pPG2H0Mpcd6ls0uIv6MdJdZCoWbQoG2KHLYKpvZFK4.bWK','ADMIN','angalo'),(2,'{bcrypt}$2a$10$RdyjFIMMpcaFO9fXheQIvOoNoN7uBXmkZDorVPd3cBmsj2O5cneKy','USER','lumasa'),(3,'{bcrypt}$2a$10$HwMeMFv1DKn3Yz3FHumxeuhAB/dZqFGJ8FqapnAfM5/gI0iSj3VU.','USER','maferu'),(4,'{bcrypt}$2a$10$JbhDOaokLP2ZhK2EX3kHbuMx.sCDfbXlLCCRdH/aG38NDXbxfaQu2','USER','cogona'),(5,'{bcrypt}$2a$10$JfQW9bKYUmSrxa5BkbbmsO1UeFseTt2e3WOh5iD2NXQsvS6X7obUe','USER','ladimo'),(6,'{bcrypt}$2a$10$Lmzy6o5SLhzAN4htQpc2bOdnNgyVPuP4VANau00lKfasqSxO9FTW.','USER','jaroto'),(7,'{bcrypt}$2a$10$JkgNr/vv0CXjvEI/QmQ8HuSG88SeVo.MB5Fgo0HBUI80m.Nl9DWf6','USER','elvamo'),(8,'{bcrypt}$2a$10$KM5j4nX/.o7tRKznv65xu.9qeVz.vhTxu36YG4JzX4aG77nuN6Esm','USER','daorca'),(9,'{bcrypt}$2a$10$UIIUgt6h.gBDqjCMKfr0Q.YPMONLgPKdyA6Nree4pw4jPYSoU/Gvq','USER','sanaig'),(10,'{bcrypt}$2a$10$0jVvtqHL1txW2TbuQwqqie4J0xxUlqluEG6O9BHQcwxOZ0YKHPiRm','USER','paserve');
/*!40000 ALTER TABLE `analisis-usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-11-07  8:51:22
