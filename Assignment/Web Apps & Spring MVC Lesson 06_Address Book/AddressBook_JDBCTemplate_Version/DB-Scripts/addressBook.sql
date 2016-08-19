SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */
/*!40101 SET NAMES utf8 */

--
-- Database: AddressBook
--
DROP DATABASE IF EXISTS AddressBook;

CREATE DATABASE AddressBook;

USE AddressBook;

-- -----------------------------------------------

--
-- Table structure for table [Address]
--

CREATE TABLE IF NOT EXISTS ab_address(
  address_id INT(11) NOT NULL AUTO_INCREMENT,
  first_name VARCHAR(20) NOT NULL,
  last_name VARCHAR(20) NOT NULL,
  house_number VARCHAR(10) NOT NULL,
  street VARCHAR(20) NOT NULL,
  city VARCHAR(20) NOT NULL,
  state_id INT(11) NOT NULL,
  zipcode_id INT(11) NOT NULL,
  country_id INT(11) NOT NULL,
  PRIMARY KEY (address_id),
  KEY state_id (state_id),
  KEY zipcode_id (zipcode_id),
  KEY country_id (country_id)
) ENGINE = InnoDB DEFAULT CHARSET = latin1 AUTO_INCREMENT = 1;

-- -----------------------------------------------

--
-- Table structure for table [State]
--

CREATE TABLE IF NOT EXISTS ab_state(
  state_id INT(11) NOT NULL AUTO_INCREMENT,
  state_name VARCHAR(20) NOT NULL,
  PRIMARY KEY (state_id)
) ENGINE = InnoDB DEFAULT CHARSET = latin1 AUTO_INCREMENT = 1;

-- -----------------------------------------------

--
-- Table structure for table [ZipCode]
--

CREATE TABLE IF NOT EXISTS ab_zipcode(
  zipcode_id INT(11) NOT NULL AUTO_INCREMENT,
  area_name VARCHAR(20) NOT NULL,
  PRIMARY KEY (zipcode_id)
) ENGINE = InnoDB DEFAULT CHARSET = latin1 AUTO_INCREMENT = 1;

-- -----------------------------------------------

--
-- Table structure for table [Country]
--

CREATE TABLE IF NOT EXISTS ab_country(
  country_id INT(11) NOT NULL AUTO_INCREMENT,
  country_name VARCHAR(20) NOT NULL,
  PRIMARY KEY (country_id)
) ENGINE = InnoDB DEFAULT CHARSET = latin1 AUTO_INCREMENT = 1;

-- -----------------------------------------------

-- 
-- Constraints for tables after they are create (You can also add constraints when you initially create them)
-- 

--
-- Constraints for table [Address]
--
ALTER TABLE ab_address 
ADD CONSTRAINT address_state_fk 
FOREIGN KEY (state_id) REFERENCES ab_state (state_id) ON DELETE NO ACTION;

ALTER TABLE ab_address 
ADD CONSTRAINT address_zipcode_fk 
FOREIGN KEY (zipcode_id) REFERENCES ab_zipcode (zipcode_id) ON DELETE NO ACTION;

ALTER TABLE ab_address 
ADD CONSTRAINT address_country_fk 
FOREIGN KEY (country_id) REFERENCES ab_country (country_id) ON DELETE NO ACTION;






















