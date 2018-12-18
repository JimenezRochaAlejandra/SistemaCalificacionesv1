CREATE DATABASE  IF NOT EXISTS `calificaciones` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `calificaciones`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: calificaciones
-- ------------------------------------------------------
-- Server version	5.7.18-log

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
-- Table structure for table `alumno`
--

DROP TABLE IF EXISTS `alumno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `alumno` (
  `id_alumno` varchar(10) NOT NULL,
  `nombre` varchar(40) DEFAULT NULL,
  `apelidoPaterno` varchar(40) DEFAULT NULL,
  `apellidoMaterno` varchar(40) DEFAULT NULL,
  `carrera` varchar(60) DEFAULT NULL,
  `semestre` int(2) DEFAULT NULL,
  `tipoCurso` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id_alumno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alumno`
--

LOCK TABLES `alumno` WRITE;
/*!40000 ALTER TABLE `alumno` DISABLE KEYS */;
/*!40000 ALTER TABLE `alumno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grupo`
--

DROP TABLE IF EXISTS `grupo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `grupo` (
  `id_grupo` int(11) NOT NULL,
  `grupo` varchar(4) DEFAULT NULL,
  `horario` varchar(20) DEFAULT NULL,
  `periodo` varchar(40) DEFAULT NULL,
  `anio` int(11) DEFAULT NULL,
  `id_alumno` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id_grupo`),
  KEY `alumno_idx` (`id_alumno`),
  CONSTRAINT `alumno` FOREIGN KEY (`id_alumno`) REFERENCES `alumno` (`id_alumno`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grupo`
--

LOCK TABLES `grupo` WRITE;
/*!40000 ALTER TABLE `grupo` DISABLE KEYS */;
/*!40000 ALTER TABLE `grupo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `materia`
--

DROP TABLE IF EXISTS `materia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `materia` (
  `id_materia` varchar(10) NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `id_grupo` varchar(5) DEFAULT NULL,
  `CURP_profesor` varchar(18) DEFAULT NULL,
  PRIMARY KEY (`id_materia`),
  KEY `fk_curp_profesor_idx` (`CURP_profesor`),
  CONSTRAINT `fk_curp_profesor` FOREIGN KEY (`CURP_profesor`) REFERENCES `profesor` (`CURP`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `materia`
--

LOCK TABLES `materia` WRITE;
/*!40000 ALTER TABLE `materia` DISABLE KEYS */;
/*!40000 ALTER TABLE `materia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `profesor`
--

DROP TABLE IF EXISTS `profesor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `profesor` (
  `CURP` varchar(18) NOT NULL,
  `nombreUsuario` varchar(16) NOT NULL,
  `contrasena` varchar(16) NOT NULL,
  `nombre` varchar(40) NOT NULL,
  `apellidoPaterno` varchar(40) DEFAULT NULL,
  `apellidoMaterno` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`CURP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profesor`
--

LOCK TABLES `profesor` WRITE;
/*!40000 ALTER TABLE `profesor` DISABLE KEYS */;
INSERT INTO `profesor` VALUES ('MACD950403MOCRRL07','Carolina','caro12345','Carolina','Martínez','Carrera'),('MAHG891226MOCRRB07','Gabriela','gaby12345','Gabriela','Martínez','Hernández');
/*!40000 ALTER TABLE `profesor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rubrica`
--

DROP TABLE IF EXISTS `rubrica`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rubrica` (
  `valor1` float DEFAULT NULL,
  `valor2` float DEFAULT NULL,
  `valor3` float DEFAULT NULL,
  `valor4` float DEFAULT NULL,
  `valor5` float DEFAULT NULL,
  `valor6` float DEFAULT NULL,
  `valor7` float DEFAULT NULL,
  `valor8` float DEFAULT NULL,
  `valor9` float DEFAULT NULL,
  `valor10` float DEFAULT NULL,
  `cal1val1` float DEFAULT NULL,
  `cal2val2` float DEFAULT NULL,
  `cal3val3` float DEFAULT NULL,
  `cal4val4` float DEFAULT NULL,
  `cal5val5` float DEFAULT NULL,
  `cal6val6` float DEFAULT NULL,
  `cal7val7` float DEFAULT NULL,
  `cal8val8` float DEFAULT NULL,
  `cal9val9` float DEFAULT NULL,
  `cal10val10` float DEFAULT NULL,
  `id_unidad` int(11) DEFAULT NULL,
  `id_materia` varchar(10) DEFAULT NULL,
  KEY `id_unidad_idx` (`id_unidad`),
  KEY `materia_idx` (`id_materia`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rubrica`
--

LOCK TABLES `rubrica` WRITE;
/*!40000 ALTER TABLE `rubrica` DISABLE KEYS */;
/*!40000 ALTER TABLE `rubrica` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `unidad`
--

DROP TABLE IF EXISTS `unidad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `unidad` (
  `id_unidad` int(11) DEFAULT NULL,
  `clave_materia` varchar(10) DEFAULT NULL,
  `calificacion` float DEFAULT NULL,
  KEY `materia_idx` (`clave_materia`),
  CONSTRAINT `materia` FOREIGN KEY (`clave_materia`) REFERENCES `materia` (`id_materia`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `unidad`
--

LOCK TABLES `unidad` WRITE;
/*!40000 ALTER TABLE `unidad` DISABLE KEYS */;
/*!40000 ALTER TABLE `unidad` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-12-11 16:25:18
