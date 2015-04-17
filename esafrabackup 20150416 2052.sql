-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.27-community-nt


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema base
--

CREATE DATABASE IF NOT EXISTS base;
USE base;

--
-- Definition of table `bus`
--

DROP TABLE IF EXISTS `bus`;
CREATE TABLE `bus` (
  `id` int(11) NOT NULL auto_increment,
  `num` varchar(255) default NULL,
  `line_id` int(11) default NULL,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `UK_rg1b0crnf61v4flku3amx12j0` (`num`),
  KEY `FK_a93ju84mbgpfdtankm32kpeiq` (`line_id`),
  CONSTRAINT `FK_a93ju84mbgpfdtankm32kpeiq` FOREIGN KEY (`line_id`) REFERENCES `line` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bus`
--

/*!40000 ALTER TABLE `bus` DISABLE KEYS */;
INSERT INTO `bus` (`id`,`num`,`line_id`) VALUES 
 (1,'B01',1),
 (2,'B02',1),
 (3,'B03',2),
 (4,'B04',2);
/*!40000 ALTER TABLE `bus` ENABLE KEYS */;


--
-- Definition of table `line`
--

DROP TABLE IF EXISTS `line`;
CREATE TABLE `line` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(255) default NULL,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `UK_1txihr05piyvvos50iaaxk6gm` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `line`
--

/*!40000 ALTER TABLE `line` DISABLE KEYS */;
INSERT INTO `line` (`id`,`name`) VALUES 
 (1,'Tun-Lambadouza'),
 (2,'Tun-Sfax');
/*!40000 ALTER TABLE `line` ENABLE KEYS */;


--
-- Definition of table `station`
--

DROP TABLE IF EXISTS `station`;
CREATE TABLE `station` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(255) default NULL,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `UK_ovvr5506rucq3pwpt2if867pd` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `station`
--

/*!40000 ALTER TABLE `station` DISABLE KEYS */;
INSERT INTO `station` (`id`,`name`) VALUES 
 (3,'Lambadouza'),
 (4,'Rouad'),
 (2,'Safax'),
 (1,'Tun');
/*!40000 ALTER TABLE `station` ENABLE KEYS */;


--
-- Definition of table `stop`
--

DROP TABLE IF EXISTS `stop`;
CREATE TABLE `stop` (
  `date` datetime NOT NULL,
  `idBus` int(11) NOT NULL,
  `idstation` int(11) NOT NULL,
  `nbFreePlaces` int(11) default NULL,
  PRIMARY KEY  (`date`,`idBus`,`idstation`),
  KEY `FK_au9o10tbutoj6y3mt4h6aarwj` (`idBus`),
  KEY `FK_ten037p4krl4q918da817d6n4` (`idstation`),
  CONSTRAINT `FK_ten037p4krl4q918da817d6n4` FOREIGN KEY (`idstation`) REFERENCES `station` (`id`),
  CONSTRAINT `FK_au9o10tbutoj6y3mt4h6aarwj` FOREIGN KEY (`idBus`) REFERENCES `bus` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `stop`
--

/*!40000 ALTER TABLE `stop` DISABLE KEYS */;
INSERT INTO `stop` (`date`,`idBus`,`idstation`,`nbFreePlaces`) VALUES 
 ('2015-04-16 20:49:12',3,4,0),
 ('2015-04-16 21:49:12',1,1,0),
 ('2015-04-16 22:49:12',2,1,0),
 ('2015-04-16 23:49:12',1,2,0),
 ('2015-04-16 23:50:12',2,2,0),
 ('2015-04-16 23:53:12',2,3,0);
/*!40000 ALTER TABLE `stop` ENABLE KEYS */;


--
-- Definition of table `type`
--

DROP TABLE IF EXISTS `type`;
CREATE TABLE `type` (
  `idLine` int(11) NOT NULL,
  `idStation` int(11) NOT NULL,
  `stationOrder` int(11) default NULL,
  `type` varchar(255) default NULL,
  PRIMARY KEY  (`idLine`,`idStation`),
  KEY `FK_dsn2pj901r074eiaiypn4dacc` (`idStation`),
  CONSTRAINT `FK_dsn2pj901r074eiaiypn4dacc` FOREIGN KEY (`idStation`) REFERENCES `station` (`id`),
  CONSTRAINT `FK_8hourg75dug6ri0w1gvmmdb4l` FOREIGN KEY (`idLine`) REFERENCES `line` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `type`
--

/*!40000 ALTER TABLE `type` DISABLE KEYS */;
INSERT INTO `type` (`idLine`,`idStation`,`stationOrder`,`type`) VALUES 
 (1,1,0,'Depart'),
 (1,2,1,'Intermediate'),
 (1,3,2,'Arrival'),
 (2,1,2,'Arrival'),
 (2,2,1,'Intermediate'),
 (2,4,0,'Depart');
/*!40000 ALTER TABLE `type` ENABLE KEYS */;


--
-- Definition of table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `DTYPE` varchar(31) NOT NULL,
  `id` int(11) NOT NULL auto_increment,
  `login` varchar(255) default NULL,
  `name` varchar(255) default NULL,
  `password` varchar(255) default NULL,
  `accesLevel` int(11) default NULL,
  `birthDay` datetime default NULL,
  `cash` double default NULL,
  `gender` bit(1) default NULL,
  `seniority` int(11) default NULL,
  `shift` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`DTYPE`,`id`,`login`,`name`,`password`,`accesLevel`,`birthDay`,`cash`,`gender`,`seniority`,`shift`) VALUES 
 ('Driver',1,'med@driver.tn','Mohamed','0000',NULL,NULL,NULL,NULL,1,'matin'),
 ('Driver',2,'nizar@driver.tn','Nizar','0000',NULL,NULL,NULL,NULL,1,'midi'),
 ('BusMan',3,'seif@man.tn','Seif','0000',5,NULL,NULL,NULL,NULL,NULL),
 ('BusMan',4,'amine@man.tn','Amine','0000',5,NULL,NULL,NULL,NULL,NULL),
 ('Passenger',5,'patricia@passenger.tn','Patricia','0000',NULL,'1991-11-25 00:00:00',120,'',NULL,NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
