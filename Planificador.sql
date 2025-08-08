-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: planificador
-- ------------------------------------------------------
-- Server version	8.0.33

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
-- Table structure for table `asignacion`
--

DROP TABLE IF EXISTS `asignacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `asignacion` (
  `id_asignacion` int NOT NULL,
  `id_estudiante` int NOT NULL,
  `id_Materia` int NOT NULL,
  `id_profesor` int NOT NULL,
  `id_aula` int NOT NULL,
  `id_horario` int NOT NULL,
  PRIMARY KEY (`id_asignacion`),
  KEY `id_estudiante` (`id_estudiante`),
  KEY `id_Materia` (`id_Materia`),
  KEY `id_profesor` (`id_profesor`),
  KEY `id_aula` (`id_aula`),
  KEY `id_horario` (`id_horario`),
  CONSTRAINT `asignacion_ibfk_1` FOREIGN KEY (`id_estudiante`) REFERENCES `estudiante` (`id_estudiante`),
  CONSTRAINT `asignacion_ibfk_2` FOREIGN KEY (`id_Materia`) REFERENCES `materia` (`id_Materia`),
  CONSTRAINT `asignacion_ibfk_3` FOREIGN KEY (`id_profesor`) REFERENCES `profesor` (`id_profesor`),
  CONSTRAINT `asignacion_ibfk_4` FOREIGN KEY (`id_aula`) REFERENCES `aula` (`id_aula`),
  CONSTRAINT `asignacion_ibfk_5` FOREIGN KEY (`id_horario`) REFERENCES `horario` (`id_horario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `aula`
--

DROP TABLE IF EXISTS `aula`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `aula` (
  `id_aula` int NOT NULL,
  `Nombre` varchar(50) DEFAULT NULL,
  `Capacidad` int DEFAULT NULL,
  PRIMARY KEY (`id_aula`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `estudiante`
--

DROP TABLE IF EXISTS `estudiante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estudiante` (
  `id_estudiante` int NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(20) DEFAULT NULL,
  `EmailEstudiante` varchar(50) NOT NULL,
  `Carrera` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id_estudiante`),
  CONSTRAINT `estudiante_chk_1` CHECK ((`EmailEstudiante` like _utf8mb4'%_@_%._%'))
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `horario`
--

DROP TABLE IF EXISTS `horario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `horario` (
  `id_horario` int NOT NULL,
  `dia` varchar(10) DEFAULT NULL,
  `Fechainicio` varchar(20) NOT NULL,
  `FechaFin` varchar(20) NOT NULL,
  `id_aula` int NOT NULL,
  PRIMARY KEY (`id_horario`),
  KEY `id_aula` (`id_aula`),
  CONSTRAINT `horario_ibfk_1` FOREIGN KEY (`id_aula`) REFERENCES `aula` (`id_aula`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `materia`
--

DROP TABLE IF EXISTS `materia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `materia` (
  `id_Materia` int NOT NULL,
  `nombre` varchar(20) DEFAULT NULL,
  `Creditos` int DEFAULT NULL,
  `Descripcion` varchar(100) DEFAULT NULL,
  `id_estudiante` int NOT NULL,
  `id_profesor` int NOT NULL,
  PRIMARY KEY (`id_Materia`),
  KEY `id_estudiante` (`id_estudiante`),
  KEY `id_profesor` (`id_profesor`),
  CONSTRAINT `materia_ibfk_1` FOREIGN KEY (`id_estudiante`) REFERENCES `estudiante` (`id_estudiante`),
  CONSTRAINT `materia_ibfk_2` FOREIGN KEY (`id_profesor`) REFERENCES `profesor` (`id_profesor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `profesor`
--

DROP TABLE IF EXISTS `profesor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `profesor` (
  `id_profesor` int NOT NULL,
  `Nombre` varchar(20) DEFAULT NULL,
  `EmailProfesor` varchar(50) NOT NULL,
  `Especialidad` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_profesor`),
  CONSTRAINT `profesor_chk_1` CHECK ((`EmailProfesor` like _utf8mb4'%_@_%._%'))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-08-07 21:33:41
