-- This is a sample database for the Software Guild
-- Created by Sarah Dutkiewicz, February 2016
-- Script written for MySQL

-- Drop the database if it exists, as this is purely a sample database
DROP DATABASE IF EXISTS SGRoster;

-- Create a new database for our SGRoster example
CREATE DATABASE SGRoster;

-- Switch to the database
-- Note that SQL commands are not case-sensitive 
use SGRoster;

-- Create a table of our cohorts
CREATE TABLE Cohort
(CohortID int NOT NULL auto_increment,
StartDate date NOT NULL,
Subject varchar(50) NOT NULL,
Location varchar(50) NOT NULL,
PRIMARY KEY(CohortID));

-- Create a table of our apprentices
CREATE TABLE Apprentice
(ApprenticeID int NOT NULL auto_increment,
FirstName varchar(50) NOT NULL,
LastName varchar(50) NOT NULL,
PRIMARY KEY(ApprenticeID));

-- Create the bridge table
CREATE TABLE ApprenticeCohort
(ApprenticeID int NOT NULL,
CohortID int NOT NULL);

-- Create the foreign key relationships
ALTER TABLE ApprenticeCohort ADD CONSTRAINT fk_ApprenticeCohort_Apprentice FOREIGN KEY (ApprenticeID) REFERENCES Apprentice(ApprenticeID);
ALTER TABLE ApprenticeCohort ADD CONSTRAINT fk_ApprenticeCohort_Cohort FOREIGN KEY (CohortID) REFERENCES Cohort(CohortID);

-- Insert cohorts
INSERT INTO Cohort VALUES (123, '2017-01-09', 'Java', 'Akron'),(140, '2017-01-09','.NET','Louisville'),(172, '2017-02-06', 'Java', 'Minneapolis');

-- Insert apprentices
INSERT INTO Apprentice VALUES (1212, 'Barbara', 'Smith'), (1382, 'Brenda', 'Smith'), (1523, 'Bill', 'Smith'), (1678, 'Bartholomew', 'Smith'), (1872, 'Bob', 'Smith');

-- Assign apprentices to cohorts

INSERT INTO ApprenticeCohort (ApprenticeID, CohortID)
VALUES (1523,123), (1872, 172), (1382, 172), (1212, 140), (1678, 123);

USE `SGRoster`;
DROP procedure IF EXISTS `GetCohortsByLocation`;

DELIMITER $$
USE `SGRoster`$$
CREATE PROCEDURE `GetCohortsByLocation` (IN location VARCHAR(50))
BEGIN
	SELECT * FROM Cohort WHERE Location = location;
END
$$

DELIMITER ;

USE `SGRoster`;
DROP procedure IF EXISTS `GetCohortById`;

DELIMITER $$
USE `SGRoster`$$
CREATE PROCEDURE `GetCohortById` (IN inCohortId int)
BEGIN
	SELECT * FROM Cohort WHERE CohortID = inCohortId;
END
$$

DELIMITER ;
