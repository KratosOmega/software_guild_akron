DROP DATABASE IF EXISTS MovieCatalog;

CREATE DATABASE MovieCatalog;

USE MovieCatalog;

DROP TABLE IF EXISTS Movie;
CREATE TABLE `Movie` (
  `MovieID` int(11) NOT NULL AUTO_INCREMENT,
  `Title` varchar(30) NOT NULL,
  `RunTime` int(11) DEFAULT NULL,
  `Rating` varchar(30) DEFAULT NULL,
  `ReleaseDate` date DEFAULT NULL,
  PRIMARY KEY (`MovieID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

INSERT INTO `MovieCatalog`.`Movie` (`Title`,`RunTime`,`Rating`,`ReleaseDate`) VALUES ('ZooTopia', 108, 'PG', '20160304');
INSERT INTO `MovieCatalog`.`Movie` (`Title`,`RunTime`,`Rating`,`ReleaseDate`) VALUES ('Maleficent', 97, 'PG', '20140530');
INSERT INTO `MovieCatalog`.`Movie` (`Title`,`RunTime`,`Rating`,`ReleaseDate`) VALUES ('12 Years a Slave', 124, 'R', '20131108');
INSERT INTO `MovieCatalog`.`Movie` (`Title`,`RunTime`,`Rating`,`ReleaseDate`) VALUES ('Muppets Most Wanted', 107, 'PG', '20140321');
INSERT INTO `MovieCatalog`.`Movie` (`Title`,`RunTime`,`Rating`,`ReleaseDate`) VALUES ('Oz The Great And Powerful', 130, 'PG', '20130308');
INSERT INTO `MovieCatalog`.`Movie` (`Title`,`RunTime`,`Rating`,`ReleaseDate`) VALUES ('Monsters University', 104, 'G', '20130621');
INSERT INTO `MovieCatalog`.`Movie` (`Title`,`RunTime`,`Rating`,`ReleaseDate`) VALUES ('Argo', 120, 'R', '20121012');
INSERT INTO `MovieCatalog`.`Movie` (`Title`,`RunTime`,`Rating`,`ReleaseDate`) VALUES ('Spotlight', 128, 'R', '20151125');
INSERT INTO `MovieCatalog`.`Movie` (`Title`,`RunTime`,`Rating`,`ReleaseDate`) VALUES ('Birdman', 119, 'R', '20141114');
INSERT INTO `MovieCatalog`.`Movie` (`Title`,`RunTime`,`Rating`,`ReleaseDate`) VALUES ('The Artist', 100, 'PG-13', '20120120');
INSERT INTO `MovieCatalog`.`Movie` (`Title`,`RunTime`,`Rating`,`ReleaseDate`) VALUES ('The Kings Speech', 109, 'R', '20101225');
INSERT INTO `MovieCatalog`.`Movie` (`Title`,`RunTime`,`Rating`,`ReleaseDate`) VALUES ('Slumdog Millionaire', 120, 'R', '20081225');
INSERT INTO `MovieCatalog`.`Movie` (`Title`,`RunTime`,`Rating`,`ReleaseDate`) VALUES ('The Hurt Locker', 131, 'R', '30090731');
INSERT INTO `MovieCatalog`.`Movie` (`Title`,`RunTime`,`Rating`,`ReleaseDate`) VALUES ('Gladiator', 155, 'R', '20000505');
INSERT INTO `MovieCatalog`.`Movie` (`Title`,`RunTime`,`Rating`,`ReleaseDate`) VALUES ('A Beautiful Mind', 135, 'PG-13', '20020104');
INSERT INTO `MovieCatalog`.`Movie` (`Title`,`RunTime`,`Rating`,`ReleaseDate`) VALUES ('Shakespeare in Love', 123, 'R', '19980108');
INSERT INTO `MovieCatalog`.`Movie` (`Title`,`RunTime`,`Rating`,`ReleaseDate`) VALUES ('Lilo & Stitch', 85, 'PG', '20020621');
INSERT INTO `MovieCatalog`.`Movie` (`Title`,`RunTime`,`Rating`,`ReleaseDate`) VALUES ('Chicago', 103, 'PG-13', '20030124');
INSERT INTO `MovieCatalog`.`Movie` (`Title`,`RunTime`,`Rating`,`ReleaseDate`) VALUES ('Into the Woods', 125, 'PG', '20141225');
INSERT INTO `MovieCatalog`.`Movie` (`Title`,`RunTime`,`Rating`,`ReleaseDate`) VALUES ('Rain Man', 133, 'R', '19881216');

/* This line will set the safe updates off */
SET SQL_SAFE_UPDATES = 0;

/* We are moving our G movies to a kids website, delete all the G rated movies */
DELETE FROM Movie
WHERE Movie.Rating = 'G';

/* Display the edited table */
SELECT *
FROM Movie;
