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
INSERT INTO `categorie` VALUES (1,'Homme','homme1.jpg'),(2,'Femme','femme1.jpg'),(3,'Enfant','enfant1.jpg'),(4,'Accessoires','accessoire1.jpg');
/*!40000 ALTER TABLE `categorie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `commande`
--

DROP TABLE IF EXISTS `commande`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `commande` (
  `idCommande` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `idUser` int(10) unsigned NOT NULL,
  `montantCommande` double NOT NULL,
  `isOpenPanier` tinyint(1) NOT NULL,
  PRIMARY KEY (`idCommande`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `commande`
--

LOCK TABLES `commande` WRITE;
/*!40000 ALTER TABLE `commande` DISABLE KEYS */;
INSERT INTO `commande` VALUES (47,2,0,0),(48,2,0,0),(49,2,0,1),(50,0,0,0);
/*!40000 ALTER TABLE `commande` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detailcommande`
--

DROP TABLE IF EXISTS `detailcommande`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detailcommande` (
  `idCommande` int(10) unsigned NOT NULL,
  `idProduit` int(10) unsigned NOT NULL,
  `prixProduit` double NOT NULL,
  `quantite` int(11) DEFAULT NULL,
  KEY `detailcommande_fk_1` (`idProduit`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detailcommande`
--

LOCK TABLES `detailcommande` WRITE;
/*!40000 ALTER TABLE `detailcommande` DISABLE KEYS */;
INSERT INTO `detailcommande` VALUES (10,1,975,1),(10,1,975,1),(10,5,1085,1),(10,9,40,1),(10,9,40,1),(10,9,40,1),(10,9,40,1),(10,1,975,1),(10,5,1085,1),(10,5,1085,1),(10,1,975,1),(46,1,975,1),(46,9,40,1),(46,5,1085,1),(46,5,1085,1),(46,5,1085,1),(46,5,1085,1),(46,5,1085,1),(46,5,1085,1),(46,1,975,1),(47,9,40,1),(47,1,975,1),(47,1,975,1),(47,5,1085,1),(48,1,975,1),(49,5,1085,1),(50,1,975,1),(50,5,1085,1);
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
  `prixProduit` double DEFAULT NULL,
  PRIMARY KEY (`idProduit`),
  KEY `produit_fk` (`idCategorie`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produit`
--

LOCK TABLES `produit` WRITE;
/*!40000 ALTER TABLE `produit` DISABLE KEYS */;
INSERT INTO `produit` VALUES (1,'Angiolo Wholecut Oxford\r\n',1,'homme1.jpg\r\n','Construit à partir d\'une seule pièce de cuir de veau bruni, cet élégant oxford italien offre un attrait propre et classique.\r\n',975),(2,'Shark\' Sandal\r\n',1,'homme2.jpg\r\n','Les sandales durables sont fabriquées à la main par des artisans qualifiés à partir de matériaux respectueux de la Terre pour assurer un environnement sain.\r\n',295.69),(3,'Regal Double Monk Strap Shoe\r\n',1,'homme3.jpg\r\n','Le cuir italien brillant et richement coloré enrichit une chaussure moine espagnole audacieuse avec une texture légèrement altérée.',985),(4,'Durbin Derby Sneaker\r\n',1,'homme4.jpg\r\n','Des matériaux souples et des surpiqûres méticuleuses mettent à jour un beau derby italien équipé d\'un bout recouvert et fixé sur une semelle en caoutchouc contrastante sportive.',529.49),(5,'Papillon Sandal 105\r\n',2,'femme1.jpg\r\n','Cette saison, sortez avec notre sandale tendance. Notre sandale Papilion est méticuleusement confectionnée en Italie à partir de daim velours vert jungle. \r\n',1085),(6,'Badgley Mischka \'Gorgeous\' Crystal Embellished Pointy Toe Pump\r\n',2,'femme2.jpg\r\n','Un design extravagant en cristal placé scintille au talon d\'une pompe en satin magnifique en forme avec un joli bout pointu et doté d\'une assise plantaire rembourrée en mousse pour que vous puissiez danser toute la nuit.\r\n',985.59),(7,'Brochamour Crystal Buckle Flat\r\n',2,'femme3.jpg','Une boucle en cristal scintillant avec des pierres en forme de cœur ardentes donne un effet wow instantané à une pompe en velours de fabrication italienne dans une silhouette classique à bout pointu.\r\n',1595.89),(8,'Lara Peep Toe Bootie\r\n',2,'femme4.jpg','Une ligne de dessus plongeante sinueuse et un bout ouvert rehaussent l\'attitude sensuelle d\'un bottillon en satin noble avec un nœud signature.\r\n',1095.19),(9,'Jefferson Water Friendly Slip-On Vegan Sneaker\r\n',3,'enfant1.jpg','Une silhouette de baskets classique est mise à jour en EVA ultra-léger pour une sensation confortable et coussinée.\r\n',40),(10,'Ankle Strap Ballerina Shoe\r\n',3,'enfant2.jpg','La bordure festonnée ajoute une jolie touche à une ballerine coussinée sécurisée par une fine bride de cheville.\r\n',255),(11,'Leather Crib Shoe',3,'enfant3.jpg','Les détails richelieu offrent une finition impeccable et la doublure en tissu offre un confort pour une chaussure de berceau douce en cuir lisse et blanc.\r\n',55.99),(12,'Neumel II Waterproof Chukka\r\n',3,'enfant4.jpg','Une semelle antidérapante Treadlite by UGG ™ est à la base d\'une botte chukka imperméable chauffée par une doublure UGGpure confortable.\r\n',130.59),(13,'Binder Clip Metallic Diagonal Stripe Leather Flap Bag\r\n',4,'accessoire1.jpg','Les rayures diagonales emblématiques bénéficient d\'une mise à jour glamour et ultra-brillante sur ce sac à rabat en cuir de veau habilement marqué d\'une pince à reliure gravée du logo.\r\n',1540),(14,'Thierry Lasry Rhodeo 43mm Small Round Sunglasses\r\n',4,'accessoire2.jpg','RHUDE, basée à Los Angeles, s\'associe au créateur de lunettes français Thierry Lasry sur ces teintes audacieuses faites à la main à partir d\'acétate italien Mazzucchelli incroyablement durable.\r\n',490),(15,'Baby-X Roller Coaster Buckle Backpack\r\n',4,'accessoire3.jpg','Matthew Williams a rétréci son sac à dos Tank et a ajouté une bandoulière en cuir amovible pour que vous ayez une autre option de transport.\r\n',655.59),(16,'Virginie Fur Felt Hat\r\n',4,'accessoire4.jpg','Une fine bande veloutée entoure un chapeau à large bord couture confectionné en Allemagne à partir d\'un riche feutre de lapin imperméable et façonné avec une couronne moulée.\r\n',670.19);
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'admin'),(2,'client');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `idUser` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nomClient` tinytext NOT NULL,
  `email` tinytext NOT NULL,
  `password` tinytext NOT NULL,
  `idRole` int(10) unsigned NOT NULL,
  PRIMARY KEY (`idUser`),
  KEY `client_fk` (`idRole`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'admin','admin@gmail.com','admin',1),(2,'Isabel','isabelstreich@gmail.com','is',2),(3,'Dmytro','dlunhu@gmail.com','dl',2);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
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

-- Dump completed on 2020-05-21 19:05:06
