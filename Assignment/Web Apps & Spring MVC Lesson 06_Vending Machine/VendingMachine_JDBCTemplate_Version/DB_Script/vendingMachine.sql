DROP DATABASE IF EXISTS VendingMachine;

CREATE DATABASE VendingMachine;

USE VendingMachine;

/* item */
CREATE TABLE item(
  item_id INT NOT NULL AUTO_INCREMENT,
  item_name VARCHAR(10) NOT NULL,
  item_price DECIMAL(4,2) NOT NULL,
  item_quantity INT NOT NULL,
  PRIMARY KEY(item_id)
);


/* Predefined Data */
INSERT INTO item(item_name, item_price, item_quantity) VALUES ('item #1', '2.75', 10);
INSERT INTO item(item_name, item_price, item_quantity) VALUES ('item #2', '3.75', 2);
INSERT INTO item(item_name, item_price, item_quantity) VALUES ('item #3', '1.25', 8);
INSERT INTO item(item_name, item_price, item_quantity) VALUES ('item #4', '2.75', 10);
/* Data above is for testing purpose */


