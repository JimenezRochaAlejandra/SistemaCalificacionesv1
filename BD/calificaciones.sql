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
  `numeroControl` varchar(10) NOT NULL,
  `nombre_completo` varchar(100) DEFAULT NULL,
  `carrera` varchar(60) DEFAULT NULL,
  `semestre` varchar(2) DEFAULT NULL,
  `tipoCurso` varchar(10) DEFAULT NULL,
  `id_materia` varchar(3) DEFAULT NULL,
  `nombre_materia` varchar(50) DEFAULT NULL,
  `anio_materia` varchar(4) DEFAULT NULL,
  `periodo` varchar(20) DEFAULT NULL,
  `hora` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`numeroControl`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alumno`
--

LOCK TABLES `alumno` WRITE;
/*!40000 ALTER TABLE `alumno` DISABLE KEYS */;
INSERT INTO `alumno` VALUES ('14161298','Martinez Carrera Dulce Carolina','Ing. en Sistemas Computacionales','0','','ISC','Lenguajes de interfaz','2018','Agosto - Diciembre','09:00-10:00'),('14161784','Herrera Perez Jose de Jesus','Ing. en Sistemas Computacionales','0','','ISC','Lenguajes de interfaz','2018','Agosto - Diciembre','09:00-10:00'),('15164785','Martinez Hernandez Gabriela','Ing. en Sistemas Computacionales','0','','ISC','Lenguajes de interfaz','2018','Agosto - Diciembre','09:00-10:00');
/*!40000 ALTER TABLE `alumno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `materia`
--

DROP TABLE IF EXISTS `materia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `materia` (
  `id_materia` varchar(3) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `anio` varchar(4) NOT NULL,
  `periodo` varchar(20) NOT NULL,
  `numeroUnidades` int(11) DEFAULT NULL,
  `hora` varchar(11) DEFAULT NULL,
  `CURP_profesor` varchar(18) DEFAULT NULL,
  PRIMARY KEY (`id_materia`,`nombre`,`anio`,`periodo`),
  KEY `fk_curp_profesor_idx` (`CURP_profesor`),
  CONSTRAINT `fk_curp_profesor` FOREIGN KEY (`CURP_profesor`) REFERENCES `profesor` (`CURP`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `materia`
--

LOCK TABLES `materia` WRITE;
/*!40000 ALTER TABLE `materia` DISABLE KEYS */;
INSERT INTO `materia` VALUES ('ISB','Estructura de datos','2018','Enero - Junio',4,'10:00-11:00','MAHG891226MOCRRB07');
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
  `valor1` varchar(20) DEFAULT NULL,
  `cal1val1` int(11) DEFAULT NULL,
  `valor2` varchar(20) DEFAULT NULL,
  `cal2val2` int(11) DEFAULT NULL,
  `valor3` varchar(20) DEFAULT NULL,
  `cal3val3` int(11) DEFAULT NULL,
  `valor4` varchar(20) DEFAULT NULL,
  `cal4val4` int(11) DEFAULT NULL,
  `valor5` varchar(20) DEFAULT NULL,
  `cal5val5` int(11) DEFAULT NULL,
  `valor6` varchar(20) DEFAULT NULL,
  `cal6val6` int(11) DEFAULT NULL,
  `valor7` varchar(20) DEFAULT NULL,
  `cal7val7` int(11) DEFAULT NULL,
  `valor8` varchar(20) DEFAULT NULL,
  `cal8val8` int(11) DEFAULT NULL,
  `valor9` varchar(20) DEFAULT NULL,
  `cal9val9` int(11) DEFAULT NULL,
  `valor10` varchar(20) DEFAULT NULL,
  `cal10val10` int(11) DEFAULT NULL,
  `id_unidad` int(11) DEFAULT NULL,
  `id_materia` varchar(10) DEFAULT NULL,
  `nombreMateria` varchar(50) DEFAULT NULL,
  `anioMateria` varchar(4) DEFAULT NULL,
  `periodo` varchar(20) DEFAULT NULL,
  KEY `id_unidad_idx` (`id_unidad`),
  KEY `materia_idx` (`id_materia`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rubrica`
--

LOCK TABLES `rubrica` WRITE;
/*!40000 ALTER TABLE `rubrica` DISABLE KEYS */;
INSERT INTO `rubrica` VALUES ('Programas',10,'Mapas',10,'Asistencia',10,'Tareas',10,'Examen',60,'',0,'',0,'',0,'',0,'',0,1,'ISB','Lenguajes de interfaz','2018','Agosto - Diciembre'),('apuntes',10,'extra',10,'a',10,'b',10,'c',10,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,'ISA','Lenguajes de interfaz','2018','Agosto - Diciembre'),('a',10,'b',10,'c',10,'d',10,'e',10,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,3,'ISC','Estructura de datos','2018','Agosto - Diciembre');
/*!40000 ALTER TABLE `rubrica` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `unidad`
--

DROP TABLE IF EXISTS `unidad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `unidad` (
  `numeroControl` varchar(8) DEFAULT NULL,
  `id_unidad` int(11) DEFAULT NULL,
  `clave_materia` varchar(10) DEFAULT NULL,
  `nombreMateria` varchar(50) DEFAULT NULL,
  `anio` varchar(4) DEFAULT NULL,
  `periodo` varchar(20) DEFAULT NULL,
  `calificacion` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `unidad`
--

LOCK TABLES `unidad` WRITE;
/*!40000 ALTER TABLE `unidad` DISABLE KEYS */;
INSERT INTO `unidad` VALUES ('14161298',1,'ISB','Estructura de datos','2018','Agosto - Diciembre',100),('14161784',1,'ISB','Estructura de datos','2018','Agosto - Diciembre',75),('15164785',1,'ISB','Estructura de datos','2018','Agosto - Diciembre',89),('14161298',2,'ISB','Estructura de datos','2018','Agosto - Diciembre',90),('14161784',2,'ISB','Estructura de datos','2018','Agosto - Diciembre',50),('15164785',2,'ISB','Estructura de datos','2018','Agosto - Diciembre',100),('14161298',3,'ISB','Estructura de datos','2018','Agosto - Diciembre',92),('14161784',3,'ISB','Estructura de datos','2018','Agosto - Diciembre',83),('15164785',3,'ISB','Estructura de datos','2018','Agosto - Diciembre',98);
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

-- Dump completed on 2018-12-18  2:07:42
