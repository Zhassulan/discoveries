--
-- Script was generated by Devart dbForge Studio for MySQL, Version 7.2.53.0
-- Product home page: http://www.devart.com/dbforge/mysql/studio
-- Script date 14.09.2017 10:05:29
-- Server version: 5.5.56
-- Client version: 4.1
--


--
-- Definition for database discoveries
--
DROP DATABASE IF EXISTS discoveries;
CREATE DATABASE discoveries
	CHARACTER SET utf8
	COLLATE utf8_general_ci;

-- 
-- Disable foreign keys
-- 
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;

-- 
-- Set SQL mode
-- 
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 
-- Set character set the client will use to send SQL statements to the server
--
SET NAMES 'utf8';

-- 
-- Set default database
--
USE discoveries;

--
-- Definition for table discoverers
--
CREATE TABLE discoverers (
  id INT(11) NOT NULL AUTO_INCREMENT,
  firstname VARCHAR(255) NOT NULL,
  lastname VARCHAR(255) DEFAULT NULL,
  middlename VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY (id)
)
ENGINE = INNODB
AUTO_INCREMENT = 7
AVG_ROW_LENGTH = 16384
CHARACTER SET utf8
COLLATE utf8_general_ci;

--
-- Definition for table discoveries
--
CREATE TABLE discoveries (
  id INT(11) NOT NULL AUTO_INCREMENT,
  id_star INT(11) NOT NULL,
  id_discoverer INT(11) NOT NULL,
  PRIMARY KEY (id)
)
ENGINE = INNODB
AUTO_INCREMENT = 1
CHARACTER SET utf8
COLLATE utf8_general_ci;

--
-- Definition for table stars
--
CREATE TABLE stars (
  id INT(11) NOT NULL AUTO_INCREMENT,
  title VARCHAR(255) NOT NULL,
  classification VARCHAR(255) NOT NULL,
  x INT(11) NOT NULL,
  y INT(11) NOT NULL,
  PRIMARY KEY (id)
)
ENGINE = INNODB
AUTO_INCREMENT = 1
CHARACTER SET utf8
COLLATE utf8_general_ci;

-- 
-- Dumping data for table discoverers
--
INSERT INTO discoverers VALUES
(6, 'Иван', 'Иванов', 'Иванович');

-- 
-- Dumping data for table discoveries
--

-- Table discoveries.discoveries does not contain any data (it is empty)

-- 
-- Dumping data for table stars
--

-- Table discoveries.stars does not contain any data (it is empty)

-- 
-- Restore previous SQL mode
-- 
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;

-- 
-- Enable foreign keys
-- 
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
