/*
SQLyog Community v13.1.5  (64 bit)
MySQL - 5.5.62 : Database - product
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`product` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */;

USE `product`;

/*Table structure for table `product` */

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `BATCH` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `CODE` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `COMPANY` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `DEAL` int(11) NOT NULL DEFAULT '0',
  `EXPIRY_DATE` date DEFAULT NULL,
  `FREE` int(11) NOT NULL DEFAULT '0',
  `IS_ACTIVE` tinyint(1) NOT NULL DEFAULT '1',
  `IS_DELETED` tinyint(1) NOT NULL DEFAULT '0',
  `MRP` int(11) NOT NULL DEFAULT '0',
  `NAME` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `RATE` int(11) NOT NULL DEFAULT '0',
  `STOCK` int(11) NOT NULL DEFAULT '0',
  `SUPPLIER` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `product` */

insert  into `product`(`ID`,`BATCH`,`CODE`,`COMPANY`,`DEAL`,`EXPIRY_DATE`,`FREE`,`IS_ACTIVE`,`IS_DELETED`,`MRP`,`NAME`,`RATE`,`STOCK`,`SUPPLIER`) values 
(1,'sxaa','11aa','Ramu',12,'2020-12-02',2,0,0,23,'asss',23,12,'Ramp'),
(2,'wdd','wee','raju',21,'2023-12-02',2,0,0,33,'ww',32,12,'ramp'),
(3,'wd22','wee23','raju45',213,'2023-12-03',24,0,0,334,'ww23',342,123,'ramp75');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dob` datetime NOT NULL,
  `email_id` varchar(255) COLLATE utf8_bin NOT NULL,
  `gender` varchar(255) COLLATE utf8_bin NOT NULL,
  `is_active` bit(1) NOT NULL,
  `is_deleted` bit(1) NOT NULL,
  `mobile_number` varchar(255) COLLATE utf8_bin NOT NULL,
  `name` varchar(255) COLLATE utf8_bin NOT NULL,
  `otp` int(11) NOT NULL,
  `pwd` varchar(255) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `user` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
