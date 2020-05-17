-- MySQL dump 10.16  Distrib 10.2.31-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: di-boutique
-- ------------------------------------------------------
-- Server version	10.2.31-MariaDB

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
-- Table structure for table `categorie`
--

DROP TABLE IF EXISTS `categorie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categorie` (
  `idCategorie` tinyint(4) NOT NULL AUTO_INCREMENT,
  `nomCategorie` tinytext NOT NULL,
  `imageCategorie` tinytext NOT NULL,
  PRIMARY KEY (`idCategorie`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categorie`
--

LOCK TABLES `categorie` WRITE;
/*!40000 ALTER TABLE `categorie` DISABLE KEYS */;
INSERT INTO `categorie` VALUES (1,'Homme','imageCatHomme'),(2,'Femme','imageCatFemme'),(3,'Enfant','imageCatEnfant'),(4,'Accessoires','imageCatAccessoires');
/*!40000 ALTER TABLE `categorie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `client` (
  `idClient` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nomClient` tinytext NOT NULL,
  `dateInscription` datetime NOT NULL,
  `email` tinytext NOT NULL,
  `password` tinytext NOT NULL,
  `idRole` int(10) unsigned NOT NULL,
  PRIMARY KEY (`idClient`),
  KEY `client_fk` (`idRole`),
  CONSTRAINT `client_fk` FOREIGN KEY (`idrole`) REFERENCES `role` (`idrole`),
  CONSTRAINT `client_fk_1` FOREIGN KEY (`idClient`) REFERENCES `commande` (`idCommande`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `commande`
--

DROP TABLE IF EXISTS `commande`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `commande` (
  `idCommande` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `idClient` int(10) unsigned NOT NULL,
  `montantCommande` double NOT NULL,
  `quantityCommande` float NOT NULL,
  `dateCommande` datetime NOT NULL,
  PRIMARY KEY (`idCommande`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `commande`
--

LOCK TABLES `commande` WRITE;
/*!40000 ALTER TABLE `commande` DISABLE KEYS */;
/*!40000 ALTER TABLE `commande` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detailcommande`
--

DROP TABLE IF EXISTS `detailcommande`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detailcommande` (
  `idCommande` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `idProduit` int(10) unsigned NOT NULL,
  `prixProduit` double NOT NULL,
  `quantityProduit` float NOT NULL,
  PRIMARY KEY (`idCommande`),
  KEY `detailcommande_fk_1` (`idProduit`),
  CONSTRAINT `detailcommande_fk` FOREIGN KEY (`idCommande`) REFERENCES `commande` (`idCommande`),
  CONSTRAINT `detailcommande_fk_1` FOREIGN KEY (`idProduit`) REFERENCES `produit` (`idProduit`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detailcommande`
--

LOCK TABLES `detailcommande` WRITE;
/*!40000 ALTER TABLE `detailcommande` DISABLE KEYS */;
/*!40000 ALTER TABLE `detailcommande` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produit`
--

DROP TABLE IF EXISTS `produit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `produit` (
  `idProduit` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nomProduit` tinytext NOT NULL,
  `idCategorie` tinyint(4) NOT NULL,
  `imageProduit` tinytext NOT NULL,
  `descriptionProduit` tinytext DEFAULT NULL,
  `prixProduit` double NOT NULL,
  `quantityProduit` float NOT NULL,
  PRIMARY KEY (`idProduit`),
  KEY `produit_fk` (`idCategorie`),
  CONSTRAINT `produit_fk` FOREIGN KEY (`idCategorie`) REFERENCES `categorie` (`idCategorie`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produit`
--

LOCK TABLES `produit` WRITE;
/*!40000 ALTER TABLE `produit` DISABLE KEYS */;
/*!40000 ALTER TABLE `produit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `idrole` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nomRole` tinytext NOT NULL,
  PRIMARY KEY (`idrole`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'di-boutique'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-05-17  7:54:05
