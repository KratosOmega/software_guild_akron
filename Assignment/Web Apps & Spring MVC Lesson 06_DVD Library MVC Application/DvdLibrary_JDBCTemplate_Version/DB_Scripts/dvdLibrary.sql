DROP DATABASE IF EXISTS DvdLibrary;

CREATE DATABASE DvdLibrary;

/* 
  If not state that "USE DvdLibrary", then has to add "DvdLibrary." before the table name 
  to indicate which database the table is in
*/
USE DvdLibrary;

CREATE TABLE dvd(
  dvd_id INT NOT NULL AUTO_INCREMENT, 
  dvd_title VARCHAR(30) NOT NULL,
  dvd_releaseDate VARCHAR(10) NOT NULL, 
  dvd_mmpaRating VARCHAR(5) NOT NULL,
  dvd_director VARCHAR(15) NOT NULL,
  dvd_studio VARCHAR(15) NOT NULL,
  dvd_note TEXT NOT NULL,
  PRIMARY KEY(dvd_id)
);

/* bridge table */

/* pre-set data */ 




