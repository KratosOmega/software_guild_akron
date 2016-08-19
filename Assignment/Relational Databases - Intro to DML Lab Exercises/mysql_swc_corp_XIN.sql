-- Based on Joes2Pros
SET SQL_SAFE_UPDATES = 0;

DROP DATABASE IF EXISTS SWCCorp;

create database SWCCorp;

use SWCCorp;

CREATE TABLE PayRates
(EmpID int NOT NULL,
YearlySalary DECIMAL(10,4) NULL,
MonthlySalary DECIMAL(10,4) NULL,
HourlyRate DECIMAL(10,4) NULL,
PRIMARY KEY(EmpID));

INSERT INTO PayRates VALUES (1,75000,null,null);
INSERT INTO PayRates VALUES (2,78000,null,null);
INSERT INTO PayRates VALUES (3,null,null,45);
INSERT INTO PayRates VALUES (4,null,6500,null);
INSERT INTO PayRates VALUES (5,null,5800,null);
INSERT INTO PayRates VALUES (6,52000,null,null);
INSERT INTO PayRates VALUES (7,null,6100,null);
INSERT INTO PayRates VALUES (8,null,null,32);
INSERT INTO PayRates VALUES (9,null,null,18);
INSERT INTO PayRates VALUES (10,Null,null,17);
INSERT INTO PayRates VALUES (11,115000,null,null);
INSERT INTO PayRates VALUES (12,null,null,21);

CREATE TABLE MgmtTraining
(
ClassID int PRIMARY KEY AUTO_INCREMENT,
ClassName varchar(50) NOT NULL,
ClassDurationHours int NULL
);

INSERT INTO MgmtTraining (ClassName, ClassDurationHours) VALUES('Embracing Diversity',12);
INSERT INTO MgmtTraining (ClassName, ClassDurationHours) VALUES('Interviewing',6);
INSERT INTO MgmtTraining (ClassName, ClassDurationHours) VALUES('Difficult Negotiations',30);


CREATE TABLE CurrentProducts
(
ProductID INT PRIMARY KEY AUTO_INCREMENT,
ProductName varchar(50) NOT NULL,
RetailPrice DECIMAL(19,4) NULL,
OriginationDate DateTime NULL,
ToBeDeleted bit Null);


INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Underwater Tour 1 Day West Coast',61.48,'20160404',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Underwater Tour 2 Days West Coast',110.67,'20160405',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Underwater Tour 3 Days West Coast',184.45,'20160406',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Underwater Tour 5 Days West Coast',245.93,'20160407',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Underwater Tour 1 Week West Coast',307.42,'20160408',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Underwater Tour 2 Weeks West Coast',553.35,'20160409',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Underwater Tour 1 Day East Coast',80.86,'20160410',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Underwater Tour 2 Days East Coast',145.55,'20160411',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Underwater Tour 3 Days East Coast',242.58,'20160412',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Underwater Tour 5 Days East Coast',323.44,'20160413',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Underwater Tour 1 Week East Coast',404.3,'20160414',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Underwater Tour 2 Weeks East Coast',727.73,'20160415',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Underwater Tour 1 Day Mexico',105.06,'20160416',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Underwater Tour 2 Days Mexico',189.11,'20160417',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Underwater Tour 3 Days Mexico',315.18,'20160418',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Underwater Tour 5 Days Mexico',420.24,'20160419',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Underwater Tour 1 Week Mexico',525.3,'20160420',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Underwater Tour 2 Weeks Mexico',945.53,'20160421',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Underwater Tour 1 Day Canada',85.59,'20160422',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Underwater Tour 2 Days Canada',154.05,'20160423',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Underwater Tour 3 Days Canada',256.76,'20160424',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Underwater Tour 5 Days Canada',342.34,'20160425',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Underwater Tour 1 Week Canada',427.93,'20160426',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Underwater Tour 2 Weeks Canada',770.27,'20160427',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Underwater Tour 1 Day Scandinavia',116.12,'20160428',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Underwater Tour 2 Days Scandinavia',209.01,'20160429',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Underwater Tour 3 Days Scandinavia',348.35,'20160430',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Underwater Tour 5 Days Scandinavia',464.47,'20160501',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Underwater Tour 1 Week Scandinavia',580.59,'20160502',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Underwater Tour 2 Weeks Scandinavia',1045.06,'20160503',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('History Tour 1 Day West Coast',74.62,'20160504',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('History Tour 2 Days West Coast',134.32,'20160505',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('History Tour 3 Days West Coast',223.87,'20160506',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('History Tour 5 Days West Coast',298.49,'20160507',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('History Tour 1 Week West Coast',373.11,'20160508',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('History Tour 2 Weeks West Coast',671.6,'20160509',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('History Tour 1 Day East Coast',107.16,'20160510',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('History Tour 2 Days East Coast',192.89,'20160511',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('History Tour 3 Days East Coast',321.48,'20160512',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('History Tour 5 Days East Coast',428.64,'20160513',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('History Tour 1 Week East Coast',535.8,'20160514',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('History Tour 2 Weeks East Coast',964.43,'20160515',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('History Tour 1 Day Mexico',71.14,'20160516',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('History Tour 2 Days Mexico',128.06,'20160517',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('History Tour 3 Days Mexico',213.43,'20160518',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('History Tour 5 Days Mexico',284.57,'20160519',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('History Tour 1 Week Mexico',355.71,'20160520',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('History Tour 2 Weeks Mexico',640.28,'20160521',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('History Tour 1 Day Canada',113.29,'20160522',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('History Tour 2 Days Canada',203.92,'20160523',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('History Tour 3 Days Canada',339.86,'20160524',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('History Tour 5 Days Canada',453.15,'20160525',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('History Tour 1 Week Canada',566.44,'20160526',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('History Tour 2 Weeks Canada',1019.58,'20160527',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('History Tour 1 Day Scandinavia',111.74,'20160528',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('History Tour 2 Days Scandinavia',201.12,'20160529',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('History Tour 3 Days Scandinavia',335.21,'20160530',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('History Tour 5 Days Scandinavia',446.94,'20160531',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('History Tour 1 Week Scandinavia',558.68,'20160601',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('History Tour 2 Weeks Scandinavia',1005.62,'20160602',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Ocean Cruise Tour 1 Day West Coast',122.44,'20160603',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Ocean Cruise Tour 2 Days West Coast',220.39,'20160604',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Ocean Cruise Tour 3 Days West Coast',367.32,'20160605',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Ocean Cruise Tour 5 Days West Coast',489.76,'20160606',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Ocean Cruise Tour 1 Week West Coast',612.21,'20160607',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Ocean Cruise Tour 2 Weeks West Coast',1101.97,'20160608',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Ocean Cruise Tour 1 Day East Coast',61.86,'20160609',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Ocean Cruise Tour 2 Days East Coast',111.35,'20160610',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Ocean Cruise Tour 3 Days East Coast',185.58,'20160611',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Ocean Cruise Tour 5 Days East Coast',247.44,'20160612',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Ocean Cruise Tour 1 Week East Coast',309.3,'20160613',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Ocean Cruise Tour 2 Weeks East Coast',556.74,'20160614',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Ocean Cruise Tour 1 Day Mexico',32.6,'20160615',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Ocean Cruise Tour 2 Days Mexico',58.68,'20160616',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Ocean Cruise Tour 3 Days Mexico',97.8,'20160617',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Ocean Cruise Tour 5 Days Mexico',130.4,'20160618',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Ocean Cruise Tour 1 Week Mexico',163.01,'20160619',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Ocean Cruise Tour 2 Weeks Mexico',293.41,'20160620',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Ocean Cruise Tour 1 Day Canada',62.54,'20160621',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Ocean Cruise Tour 2 Days Canada',112.58,'20160622',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Ocean Cruise Tour 3 Days Canada',187.63,'20160623',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Ocean Cruise Tour 5 Days Canada',250.18,'20160624',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Ocean Cruise Tour 1 Week Canada',312.72,'20160625',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Ocean Cruise Tour 2 Weeks Canada',562.9,'20160626',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Ocean Cruise Tour 1 Day Scandinavia',107.18,'20160627',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Ocean Cruise Tour 2 Days Scandinavia',192.92,'20160628',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Ocean Cruise Tour 3 Days Scandinavia',321.53,'20160629',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Ocean Cruise Tour 5 Days Scandinavia',428.7,'20160630',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Ocean Cruise Tour 1 Week Scandinavia',535.88,'20160701',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Ocean Cruise Tour 2 Weeks Scandinavia',964.58,'20160702',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Fruit Tasting Tour 1 Day West Coast',85.93,'20160703',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Fruit Tasting Tour 2 Days West Coast',154.68,'20160704',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Fruit Tasting Tour 3 Days West Coast',257.8,'20160705',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Fruit Tasting Tour 5 Days West Coast',343.73,'20160706',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Fruit Tasting Tour 1 Week West Coast',429.67,'20160707',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Fruit Tasting Tour 2 Weeks West Coast',773.4,'20160708',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Fruit Tasting Tour 1 Day East Coast',69.99,'20160709',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Fruit Tasting Tour 2 Days East Coast',125.99,'20160710',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Fruit Tasting Tour 3 Days East Coast',209.98,'20160711',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Fruit Tasting Tour 5 Days East Coast',279.97,'20160712',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Fruit Tasting Tour 1 Week East Coast',349.96,'20160713',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Fruit Tasting Tour 2 Weeks East Coast',629.93,'20160714',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Fruit Tasting Tour 1 Day Mexico',79.6,'20160715',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Fruit Tasting Tour 2 Days Mexico',143.27,'20160716',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Fruit Tasting Tour 3 Days Mexico',238.79,'20160717',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Fruit Tasting Tour 5 Days Mexico',318.39,'20160718',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Fruit Tasting Tour 1 Week Mexico',397.99,'20160719',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Fruit Tasting Tour 2 Weeks Mexico',716.37,'20160720',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Fruit Tasting Tour 1 Day Canada',47.79,'20160721',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Fruit Tasting Tour 2 Days Canada',86.03,'20160722',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Fruit Tasting Tour 3 Days Canada',143.38,'20160723',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Fruit Tasting Tour 5 Days Canada',191.17,'20160724',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Fruit Tasting Tour 1 Week Canada',238.97,'20160725',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Fruit Tasting Tour 2 Weeks Canada',430.14,'20160726',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Fruit Tasting Tour 1 Day Scandinavia',109.38,'20160727',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Fruit Tasting Tour 2 Days Scandinavia',196.89,'20160728',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Fruit Tasting Tour 3 Days Scandinavia',328.15,'20160729',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Fruit Tasting Tour 5 Days Scandinavia',437.53,'20160730',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Fruit Tasting Tour 1 Week Scandinavia',546.91,'20160731',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Fruit Tasting Tour 2 Weeks Scandinavia',984.44,'20160801',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Mountain Lodge 1 Day West Coast',89.5,'20160802',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Mountain Lodge 2 Days West Coast',161.1,'20160803',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Mountain Lodge 3 Days West Coast',268.5,'20160804',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Mountain Lodge 5 Days West Coast',358,'20160805',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Mountain Lodge 1 Week West Coast',447.51,'20160806',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Mountain Lodge 2 Weeks West Coast',805.51,'20160807',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Mountain Lodge 1 Day East Coast',52.68,'20160808',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Mountain Lodge 2 Days East Coast',94.83,'20160809',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Mountain Lodge 3 Days East Coast',158.04,'20160810',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Mountain Lodge 5 Days East Coast',210.72,'20160811',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Mountain Lodge 1 Week East Coast',263.41,'20160812',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Mountain Lodge 2 Weeks East Coast',474.13,'20160813',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Mountain Lodge 1 Day Mexico',87.44,'20160814',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Mountain Lodge 2 Days Mexico',157.38,'20160815',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Mountain Lodge 3 Days Mexico',262.31,'20160816',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Mountain Lodge 5 Days Mexico',349.74,'20160817',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Mountain Lodge 1 Week Mexico',437.18,'20160818',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Mountain Lodge 2 Weeks Mexico',786.92,'20160819',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Mountain Lodge 1 Day Canada',73.7,'20160820',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Mountain Lodge 2 Days Canada',132.66,'20160821',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Mountain Lodge 3 Days Canada',221.09,'20160822',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Mountain Lodge 5 Days Canada',294.79,'20160823',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Mountain Lodge 1 Week Canada',368.49,'20160824',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Mountain Lodge 2 Weeks Canada',663.28,'20160825',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Mountain Lodge 1 Day Scandinavia',32.57,'20160826',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Mountain Lodge 2 Days Scandinavia',58.63,'20160827',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Mountain Lodge 3 Days Scandinavia',97.72,'20160828',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Mountain Lodge 5 Days Scandinavia',130.3,'20160829',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Mountain Lodge 1 Week Scandinavia',162.87,'20160830',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Mountain Lodge 2 Weeks Scandinavia',293.17,'20160831',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Spa & Pleasure Getaway 1 Day West Coast',80.31,'20160901',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Spa & Pleasure Getaway 2 Days West Coast',144.56,'20160902',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Spa & Pleasure Getaway 3 Days West Coast',240.93,'20160903',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Spa & Pleasure Getaway 5 Days West Coast',321.24,'20160904',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Spa & Pleasure Getaway 1 Week West Coast',401.56,'20160905',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Spa & Pleasure Getaway 2 Weeks West Coast',722.8,'20160906',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Spa & Pleasure Getaway 1 Day East Coast',86.48,'20160907',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Spa & Pleasure Getaway 2 Days East Coast',155.67,'20160908',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Spa & Pleasure Getaway 3 Days East Coast',259.45,'20160909',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Spa & Pleasure Getaway 5 Days East Coast',345.94,'20160910',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Spa & Pleasure Getaway 1 Week East Coast',432.42,'20160911',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Spa & Pleasure Getaway 2 Weeks East Coast',778.36,'20160912',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Spa & Pleasure Getaway 1 Day Mexico',98.59,'20160913',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Spa & Pleasure Getaway 2 Days Mexico',177.47,'20160914',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Spa & Pleasure Getaway 3 Days Mexico',295.78,'20160915',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Spa & Pleasure Getaway 5 Days Mexico',394.37,'20160916',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Spa & Pleasure Getaway 1 Week Mexico',492.96,'20160917',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Spa & Pleasure Getaway 2 Weeks Mexico',887.33,'20160918',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Spa & Pleasure Getaway 1 Day Canada',93.38,'20160919',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Spa & Pleasure Getaway 2 Days Canada',168.08,'20160920',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Spa & Pleasure Getaway 3 Days Canada',280.13,'20160921',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Spa & Pleasure Getaway 5 Days Canada',373.51,'20160922',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Spa & Pleasure Getaway 1 Week Canada',466.89,'20160923',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Spa & Pleasure Getaway 2 Weeks Canada',840.39,'20160924',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Spa & Pleasure Getaway 1 Day Scandinavia',97.77,'20160925',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Spa & Pleasure Getaway 2 Days Scandinavia',175.98,'20160926',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Spa & Pleasure Getaway 3 Days Scandinavia',293.3,'20160927',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Spa & Pleasure Getaway 5 Days Scandinavia',391.06,'20160928',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Spa & Pleasure Getaway 1 Week Scandinavia',488.83,'20160929',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Spa & Pleasure Getaway 2 Weeks Scandinavia',879.89,'20160930',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Horseback Tour 1 Day West Coast',74.45,'20161001',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Horseback Tour 2 Days West Coast',134.01,'20161002',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Horseback Tour 3 Days West Coast',223.35,'20161003',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Horseback Tour 5 Days West Coast',297.8,'20161004',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Horseback Tour 1 Week West Coast',372.26,'20161005',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Horseback Tour 2 Weeks West Coast',670.06,'20161006',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Horseback Tour 1 Day East Coast',41.98,'20161007',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Horseback Tour 2 Days East Coast',75.56,'20161008',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Horseback Tour 3 Days East Coast',125.94,'20161009',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Horseback Tour 5 Days East Coast',167.92,'20161010',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Horseback Tour 1 Week East Coast',209.9,'20161011',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Horseback Tour 2 Weeks East Coast',377.81,'20161012',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Horseback Tour 1 Day Mexico',98.33,'20161013',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Horseback Tour 2 Days Mexico',177,'20161014',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Horseback Tour 3 Days Mexico',294.99,'20161015',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Horseback Tour 5 Days Mexico',393.32,'20161016',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Horseback Tour 1 Week Mexico',491.66,'20161017',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Horseback Tour 2 Weeks Mexico',884.98,'20161018',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Horseback Tour 1 Day Canada',45.8,'20161019',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Horseback Tour 2 Days Canada',82.43,'20161020',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Horseback Tour 3 Days Canada',137.39,'20161021',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Horseback Tour 5 Days Canada',183.18,'20161022',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Horseback Tour 1 Week Canada',228.98,'20161023',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Horseback Tour 2 Weeks Canada',412.16,'20161024',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Horseback Tour 1 Day Scandinavia',113.71,'20161025',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Horseback Tour 2 Days Scandinavia',204.69,'20161026',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Horseback Tour 3 Days Scandinavia',341.14,'20161027',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Horseback Tour 5 Days Scandinavia',454.86,'20161028',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Horseback Tour 1 Week Scandinavia',568.57,'20161029',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Horseback Tour 2 Weeks Scandinavia',1023.43,'20161030',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Tiger Watching Tour 1 Day West Coast',50.04,'20161031',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Tiger Watching Tour 2 Days West Coast',90.07,'20161101',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Tiger Watching Tour 3 Days West Coast',150.12,'20161102',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Tiger Watching Tour 5 Days West Coast',200.16,'20161103',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Tiger Watching Tour 1 Week West Coast',250.21,'20161104',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Tiger Watching Tour 2 Weeks West Coast',450.37,'20161105',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Tiger Watching Tour 1 Day East Coast',86.75,'20161106',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Tiger Watching Tour 2 Days East Coast',156.14,'20161107',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Tiger Watching Tour 3 Days East Coast',260.24,'20161108',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Tiger Watching Tour 5 Days East Coast',346.99,'20161109',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Tiger Watching Tour 1 Week East Coast',433.74,'20161110',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Tiger Watching Tour 2 Weeks East Coast',780.72,'20161111',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Tiger Watching Tour 1 Day Mexico',105.12,'20161112',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Tiger Watching Tour 2 Days Mexico',189.22,'20161113',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Tiger Watching Tour 3 Days Mexico',315.36,'20161114',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Tiger Watching Tour 5 Days Mexico',420.48,'20161115',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Tiger Watching Tour 1 Week Mexico',525.61,'20161116',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Tiger Watching Tour 2 Weeks Mexico',946.09,'20161117',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Tiger Watching Tour 1 Day Canada',77.54,'20161118',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Tiger Watching Tour 2 Days Canada',139.58,'20161119',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Tiger Watching Tour 3 Days Canada',232.63,'20161120',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Tiger Watching Tour 5 Days Canada',310.17,'20161121',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Tiger Watching Tour 1 Week Canada',387.71,'20161122',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Tiger Watching Tour 2 Weeks Canada',697.88,'20161123',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Tiger Watching Tour 1 Day Scandinavia',68.27,'20161124',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Tiger Watching Tour 2 Days Scandinavia',122.88,'20161125',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Tiger Watching Tour 3 Days Scandinavia',204.8,'20161126',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Tiger Watching Tour 5 Days Scandinavia',273.07,'20161127',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Tiger Watching Tour 1 Week Scandinavia',341.34,'20161128',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Tiger Watching Tour 2 Weeks Scandinavia',614.4,'20161129',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Winter Tour 1 Day West Coast',45.34,'20161130',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Winter Tour 2 Days West Coast',81.62,'20161201',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Winter Tour 3 Days West Coast',136.03,'20161202',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Winter Tour 5 Days West Coast',181.37,'20161203',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Winter Tour 1 Week West Coast',226.71,'20161204',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Winter Tour 2 Weeks West Coast',408.08,'20161205',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Winter Tour 1 Day East Coast',78.95,'20161206',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Winter Tour 2 Days East Coast',142.11,'20161207',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Winter Tour 3 Days East Coast',236.84,'20161208',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Winter Tour 5 Days East Coast',315.79,'20161209',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Winter Tour 1 Week East Coast',394.74,'20161210',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Winter Tour 2 Weeks East Coast',710.53,'20161211',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Winter Tour 1 Day Mexico',86.59,'20161212',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Winter Tour 2 Days Mexico',155.87,'20161213',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Winter Tour 3 Days Mexico',259.78,'20161214',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Winter Tour 5 Days Mexico',346.37,'20161215',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Winter Tour 1 Week Mexico',432.97,'20161216',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Winter Tour 2 Weeks Mexico',779.34,'20161217',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Winter Tour 1 Day Canada',90.7,'20161218',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Winter Tour 2 Days Canada',163.25,'20161219',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Winter Tour 3 Days Canada',272.09,'20161220',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Winter Tour 5 Days Canada',362.78,'20161221',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Winter Tour 1 Week Canada',453.48,'20161222',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Winter Tour 2 Weeks Canada',816.26,'20161223',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Winter Tour 1 Day Scandinavia',34.51,'20161224',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Winter Tour 2 Days Scandinavia',62.11,'20161225',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Winter Tour 3 Days Scandinavia',103.52,'20161226',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Winter Tour 5 Days Scandinavia',138.02,'20161227',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Winter Tour 1 Week Scandinavia',172.53,'20161228',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Winter Tour 2 Weeks Scandinavia',310.55,'20161229',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Acting Lessons Tour 1 Day West Coast',111.37,'20161230',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Acting Lessons Tour 2 Days West Coast',200.46,'20161231',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Acting Lessons Tour 3 Days West Coast',334.1,'20170101',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Acting Lessons Tour 5 Days West Coast',445.46,'20170102',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Acting Lessons Tour 1 Week West Coast',556.83,'20170103',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Acting Lessons Tour 2 Weeks West Coast',1002.29,'20170104',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Acting Lessons Tour 1 Day East Coast',52.67,'20170105',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Acting Lessons Tour 2 Days East Coast',94.81,'20170106',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Acting Lessons Tour 3 Days East Coast',158.01,'20170107',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Acting Lessons Tour 5 Days East Coast',210.68,'20170108',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Acting Lessons Tour 1 Week East Coast',263.35,'20170109',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Acting Lessons Tour 2 Weeks East Coast',474.03,'20170110',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Acting Lessons Tour 1 Day Mexico',101.07,'20170111',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Acting Lessons Tour 2 Days Mexico',181.92,'20170112',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Acting Lessons Tour 3 Days Mexico',303.2,'20170113',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Acting Lessons Tour 5 Days Mexico',404.27,'20170114',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Acting Lessons Tour 1 Week Mexico',505.34,'20170115',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Acting Lessons Tour 2 Weeks Mexico',909.61,'20170116',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Acting Lessons Tour 1 Day Canada',78.95,'20170117',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Acting Lessons Tour 2 Days Canada',142.11,'20170118',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Acting Lessons Tour 3 Days Canada',236.85,'20170119',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Acting Lessons Tour 5 Days Canada',315.8,'20170120',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Acting Lessons Tour 1 Week Canada',394.75,'20170121',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Acting Lessons Tour 2 Weeks Canada',710.55,'20170122',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Acting Lessons Tour 1 Day Scandinavia',66.9,'20170123',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Acting Lessons Tour 2 Days Scandinavia',120.41,'20170124',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Acting Lessons Tour 3 Days Scandinavia',200.69,'20170125',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Acting Lessons Tour 5 Days Scandinavia',267.59,'20170126',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Acting Lessons Tour 1 Week Scandinavia',334.49,'20170127',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Acting Lessons Tour 2 Weeks Scandinavia',602.07,'20170128',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Cherry Festival Tour 1 Day West Coast',68.55,'20170129',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Cherry Festival Tour 2 Days West Coast',123.39,'20170130',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Cherry Festival Tour 3 Days West Coast',205.66,'20170131',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Cherry Festival Tour 5 Days West Coast',274.21,'20170201',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Cherry Festival Tour 1 Week West Coast',342.76,'20170202',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Cherry Festival Tour 2 Weeks West Coast',616.97,'20170203',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Cherry Festival Tour 1 Day East Coast',108.55,'20170204',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Cherry Festival Tour 2 Days East Coast',195.39,'20170205',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Cherry Festival Tour 3 Days East Coast',325.66,'20170206',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Cherry Festival Tour 5 Days East Coast',434.21,'20170207',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Cherry Festival Tour 1 Week East Coast',542.76,'20170208',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Cherry Festival Tour 2 Weeks East Coast',976.97,'20170209',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Cherry Festival Tour 1 Day Mexico',31.91,'20170210',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Cherry Festival Tour 2 Days Mexico',57.44,'20170211',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Cherry Festival Tour 3 Days Mexico',95.73,'20170212',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Cherry Festival Tour 5 Days Mexico',127.64,'20170213',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Cherry Festival Tour 1 Week Mexico',159.55,'20170214',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Cherry Festival Tour 2 Weeks Mexico',287.18,'20170215',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Cherry Festival Tour 1 Day Canada',34.94,'20170216',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Cherry Festival Tour 2 Days Canada',62.9,'20170217',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Cherry Festival Tour 3 Days Canada',104.83,'20170218',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Cherry Festival Tour 5 Days Canada',139.78,'20170219',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Cherry Festival Tour 1 Week Canada',174.72,'20170220',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Cherry Festival Tour 2 Weeks Canada',314.5,'20170221',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Cherry Festival Tour 1 Day Scandinavia',80.65,'20170222',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Cherry Festival Tour 2 Days Scandinavia',145.17,'20170223',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Cherry Festival Tour 3 Days Scandinavia',241.94,'20170224',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Cherry Festival Tour 5 Days Scandinavia',322.59,'20170225',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Cherry Festival Tour 1 Week Scandinavia',403.24,'20170226',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Cherry Festival Tour 2 Weeks Scandinavia',725.83,'20170227',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Lakes Tour 1 Day West Coast',129.01,'20170228',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Lakes Tour 2 Days West Coast',232.22,'20170301',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Lakes Tour 3 Days West Coast',387.03,'20170302',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Lakes Tour 5 Days West Coast',516.04,'20170303',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Lakes Tour 1 Week West Coast',645.06,'20170304',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Lakes Tour 2 Weeks West Coast',1161.1,'20170305',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Lakes Tour 1 Day East Coast',127.55,'20170306',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Lakes Tour 2 Days East Coast',229.6,'20170307',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Lakes Tour 3 Days East Coast',382.66,'20170308',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Lakes Tour 5 Days East Coast',510.22,'20170309',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Lakes Tour 1 Week East Coast',637.77,'20170310',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Lakes Tour 2 Weeks East Coast',1147.99,'20170311',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Lakes Tour 1 Day Mexico',67.39,'20170312',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Lakes Tour 2 Days Mexico',121.3,'20170313',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Lakes Tour 3 Days Mexico',202.17,'20170314',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Lakes Tour 5 Days Mexico',269.56,'20170315',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Lakes Tour 1 Week Mexico',336.96,'20170316',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Lakes Tour 2 Weeks Mexico',606.52,'20170317',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Lakes Tour 1 Day Canada',77.91,'20170318',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Lakes Tour 2 Days Canada',140.24,'20170319',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Lakes Tour 3 Days Canada',233.73,'20170320',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Lakes Tour 5 Days Canada',311.64,'20170321',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Lakes Tour 1 Week Canada',389.55,'20170322',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Lakes Tour 2 Weeks Canada',701.18,'20170323',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Lakes Tour 1 Day Scandinavia',113.35,'20170324',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Lakes Tour 2 Days Scandinavia',204.04,'20170325',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Lakes Tour 3 Days Scandinavia',340.06,'20170326',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Lakes Tour 5 Days Scandinavia',453.42,'20170327',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Lakes Tour 1 Week Scandinavia',566.77,'20170328',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Lakes Tour 2 Weeks Scandinavia',1020.19,'20170329',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Rain Forest Tour 1 Day West Coast',46.73,'20170330',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Rain Forest Tour 2 Days West Coast',84.11,'20170331',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Rain Forest Tour 3 Days West Coast',140.18,'20170401',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Rain Forest Tour 5 Days West Coast',186.91,'20170402',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Rain Forest Tour 1 Week West Coast',233.64,'20170403',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Rain Forest Tour 2 Weeks West Coast',420.55,'20170404',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Rain Forest Tour 1 Day East Coast',127.2,'20170405',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Rain Forest Tour 2 Days East Coast',228.95,'20170406',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Rain Forest Tour 3 Days East Coast',381.59,'20170407',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Rain Forest Tour 5 Days East Coast',508.79,'20170408',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Rain Forest Tour 1 Week East Coast',635.99,'20170409',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Rain Forest Tour 2 Weeks East Coast',1144.77,'20170410',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Rain Forest Tour 1 Day Mexico',51.06,'20170411',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Rain Forest Tour 2 Days Mexico',91.9,'20170412',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Rain Forest Tour 3 Days Mexico',153.17,'20170413',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Rain Forest Tour 5 Days Mexico',204.23,'20170414',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Rain Forest Tour 1 Week Mexico',255.29,'20170415',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Rain Forest Tour 2 Weeks Mexico',459.52,'20170416',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Rain Forest Tour 1 Day Canada',92.98,'20170417',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Rain Forest Tour 2 Days Canada',167.37,'20170418',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Rain Forest Tour 3 Days Canada',278.95,'20170419',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Rain Forest Tour 5 Days Canada',371.93,'20170420',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Rain Forest Tour 1 Week Canada',464.91,'20170421',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Rain Forest Tour 2 Weeks Canada',836.84,'20170422',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Rain Forest Tour 1 Day Scandinavia',93.81,'20170423',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Rain Forest Tour 2 Days Scandinavia',168.86,'20170424',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Rain Forest Tour 3 Days Scandinavia',281.44,'20170425',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Rain Forest Tour 5 Days Scandinavia',375.25,'20170426',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Rain Forest Tour 1 Week Scandinavia',469.06,'20170427',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Rain Forest Tour 2 Weeks Scandinavia',844.31,'20170428',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('River Rapids Tour 1 Day West Coast',75.39,'20170429',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('River Rapids Tour 2 Days West Coast',135.7,'20170430',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('River Rapids Tour 3 Days West Coast',226.16,'20170501',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('River Rapids Tour 5 Days West Coast',301.55,'20170502',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('River Rapids Tour 1 Week West Coast',376.94,'20170503',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('River Rapids Tour 2 Weeks West Coast',678.48,'20170504',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('River Rapids Tour 1 Day East Coast',124.01,'20170505',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('River Rapids Tour 2 Days East Coast',223.22,'20170506',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('River Rapids Tour 3 Days East Coast',372.04,'20170507',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('River Rapids Tour 5 Days East Coast',496.05,'20170508',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('River Rapids Tour 1 Week East Coast',620.06,'20170509',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('River Rapids Tour 2 Weeks East Coast',1116.11,'20170510',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('River Rapids Tour 1 Day Mexico',41.84,'20170511',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('River Rapids Tour 2 Days Mexico',75.31,'20170512',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('River Rapids Tour 3 Days Mexico',125.51,'20170513',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('River Rapids Tour 5 Days Mexico',167.35,'20170514',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('River Rapids Tour 1 Week Mexico',209.19,'20170515',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('River Rapids Tour 2 Weeks Mexico',376.53,'20170516',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('River Rapids Tour 1 Day Canada',108.76,'20170517',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('River Rapids Tour 2 Days Canada',195.77,'20170518',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('River Rapids Tour 3 Days Canada',326.29,'20170519',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('River Rapids Tour 5 Days Canada',435.05,'20170520',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('River Rapids Tour 1 Week Canada',543.81,'20170521',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('River Rapids Tour 2 Weeks Canada',978.86,'20170522',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('River Rapids Tour 1 Day Scandinavia',36.04,'20170523',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('River Rapids Tour 2 Days Scandinavia',64.88,'20170524',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('River Rapids Tour 3 Days Scandinavia',108.13,'20170525',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('River Rapids Tour 5 Days Scandinavia',144.17,'20170526',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('River Rapids Tour 1 Week Scandinavia',180.21,'20170527',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('River Rapids Tour 2 Weeks Scandinavia',324.38,'20170528',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Snow Ski Tour 1 Day West Coast',35.31,'20170529',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Snow Ski Tour 2 Days West Coast',63.55,'20170530',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Snow Ski Tour 3 Days West Coast',105.92,'20170531',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Snow Ski Tour 5 Days West Coast',141.23,'20170601',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Snow Ski Tour 1 Week West Coast',176.54,'20170602',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Snow Ski Tour 2 Weeks West Coast',317.77,'20170603',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Snow Ski Tour 1 Day East Coast',85.55,'20170604',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Snow Ski Tour 2 Days East Coast',153.99,'20170605',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Snow Ski Tour 3 Days East Coast',256.65,'20170606',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Snow Ski Tour 5 Days East Coast',342.2,'20170607',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Snow Ski Tour 1 Week East Coast',427.76,'20170608',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Snow Ski Tour 2 Weeks East Coast',769.96,'20170609',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Snow Ski Tour 1 Day Mexico',72.79,'20170610',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Snow Ski Tour 2 Days Mexico',131.03,'20170611',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Snow Ski Tour 3 Days Mexico',218.38,'20170612',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Snow Ski Tour 5 Days Mexico',291.17,'20170613',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Snow Ski Tour 1 Week Mexico',363.96,'20170614',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Snow Ski Tour 2 Weeks Mexico',655.13,'20170615',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Snow Ski Tour 1 Day Canada',48.35,'20170616',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Snow Ski Tour 2 Days Canada',87.03,'20170617',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Snow Ski Tour 3 Days Canada',145.05,'20170618',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Snow Ski Tour 5 Days Canada',193.4,'20170619',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Snow Ski Tour 1 Week Canada',241.76,'20170620',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Snow Ski Tour 2 Weeks Canada',435.16,'20170621',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Snow Ski Tour 1 Day Scandinavia',42,'20170622',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Snow Ski Tour 2 Days Scandinavia',75.6,'20170623',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Snow Ski Tour 3 Days Scandinavia',126,'20170624',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Snow Ski Tour 5 Days Scandinavia',168,'20170625',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Snow Ski Tour 1 Week Scandinavia',210.01,'20170626',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Snow Ski Tour 2 Weeks Scandinavia',378.01,'20170627',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Wine Tasting Tour 1 Day West Coast',120.2,'20170628',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Wine Tasting Tour 2 Days West Coast',216.36,'20170629',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Wine Tasting Tour 3 Days West Coast',360.59,'20170630',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Wine Tasting Tour 5 Days West Coast',480.79,'20170701',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Wine Tasting Tour 1 Week West Coast',600.99,'20170702',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Wine Tasting Tour 2 Weeks West Coast',1101.97,'20170703',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Wine Tasting Tour 1 Day East Coast',64.13,'20170704',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Wine Tasting Tour 2 Days East Coast',115.44,'20170705',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Wine Tasting Tour 3 Days East Coast',192.4,'20170706',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Wine Tasting Tour 5 Days East Coast',256.53,'20170707',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Wine Tasting Tour 1 Week East Coast',320.67,'20170708',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Wine Tasting Tour 2 Weeks East Coast',577.2,'20170709',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Wine Tasting Tour 1 Day Mexico',77.31,'20170710',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Wine Tasting Tour 2 Days Mexico',139.15,'20170711',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Wine Tasting Tour 3 Days Mexico',231.92,'20170712',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Wine Tasting Tour 5 Days Mexico',309.23,'20170713',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Wine Tasting Tour 1 Week Mexico',386.54,'20170714',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Wine Tasting Tour 2 Weeks Mexico',695.77,'20170715',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Wine Tasting Tour 1 Day Canada',44.27,'20170716',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Wine Tasting Tour 2 Days Canada',79.68,'20170717',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Wine Tasting Tour 3 Days Canada',132.8,'20170718',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Wine Tasting Tour 5 Days Canada',177.06,'20170719',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Wine Tasting Tour 1 Week Canada',221.33,'20170720',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Wine Tasting Tour 2 Weeks Canada',398.39,'20170721',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Wine Tasting Tour 1 Day Scandinavia',40.56,'20170722',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Wine Tasting Tour 2 Days Scandinavia',73.02,'20170723',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Wine Tasting Tour 3 Days Scandinavia',121.69,'20170724',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Wine Tasting Tour 5 Days Scandinavia',162.26,'20170725',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Wine Tasting Tour 1 Week Scandinavia',202.82,'20170726',0);
INSERT INTO CurrentProducts (ProductName, RetailPrice, OriginationDate, ToBeDeleted) VALUES ('Wine Tasting Tour 2 Weeks Scandinavia',365.08,'20170727',0);

UPDATE CurrentProducts SET ToBeDeleted = 1 WHERE ProductName like '%1 day%';

UPDATE CurrentProducts SET OriginationDate = OriginationDate + 1000;

ALTER TABLE CurrentProducts ADD Category varchar(20) NULL;

UPDATE CurrentProducts SET Category = 'Medium-Stay';
UPDATE CurrentProducts SET Category = 'No-Stay' WHERE ProductName like '%1 day%';
UPDATE CurrentProducts SET Category = 'Overnight-Stay' WHERE ProductName like '%2 day%';
UPDATE CurrentProducts SET Category = 'LongTerm-Stay' WHERE ProductName like '%week%';



create table Employee
(EmpID int primary key not null,
LastName varchar(30) null,
FirstName varchar(20) null,
HireDate datetime null,
LocationID int null);

create table Location
(LocationID INT not null unique,
Street varchar(30) null,
City varchar(20) null,
State char(2) null);

insert into Employee values(1,'Adams','Alex','1/1/01','001');
insert into Employee values(2,'Brown','Barry','1/1/01','001');
insert into Employee values(3,'Osako','Lee','1/1/01','002');
insert into Employee values(4,'Kennson','David','1/1/01','001');
insert into Employee values(5,'Bender','Eric','1/1/01','001');
insert into Employee values(6,'Kendall','Lisa','1/1/01','004');
insert into Employee values(7,'Lonning','David','1/1/01','001');
insert into Employee values(8,'Marshbank','John','1/1/01',null);
insert into Employee values(9,'Newton','James','1/1/01','002');
insert into Employee values(10,'O''Haire','Terry','1/1/01','002');
insert into Employee values(11,'Smith','Sally','1/1/01','001');
insert into Employee values(12,'O''Neil','Barbara','1/1/01','004');

insert into Location values(1,'111 First ST','Seattle', 'WA');
insert into Location values(2,'222 Second AVE', 'Boston','MA');
insert into Location values(3,'333 Third PL','Chicago','IL');
insert into Location values(4,'444 Ruby ST','Spokane', 'WA');

-- Add a new ManagerID field to the Employee table of JProCo
ALTER TABLE Employee
ADD ManagerID int NULL;

-- Update all Seattle Employees to Report to Sally Smith (Expect herself)
UPDATE Employee SET ManagerID = 11
WHERE LocationID =  1 AND EmpID != 11;

-- Update all Boston Employee to report to Lee Osako (except for himself)
UPDATE Employee SET ManagerID = 3
WHERE LocationID = 2 AND EmpID != 3;

-- Update all Spokane Employees to report directly to David Kennson
UPDATE Employee SET ManagerID = 4
WHERE locationID = 4;

-- Set all sales people with no office location to work for David Kennson
UPDATE Employee SET ManagerID = 4
WHERE LocationID IS NULL;

-- Set Lee Osako to work for Sally Smith
UPDATE Employee SET ManagerID = 11
WHERE EmpID = 3;

-- Add a new ManagerID field to the Employee table of JProCo
ALTER TABLE Employee
ADD Status CHAR(12) NULL;

UPDATE Employee SET Status = 'On Leave' WHERE EmpID = 7;
UPDATE Employee SET Status = 'Has Tenure' WHERE EmpID in (12,4);

CREATE TABLE `Grants`
(
GrantID char(3) NOT NULL UNIQUE,
GrantName varchar(50) NOT NULL,
EmpID int,
Amount DECIMAL(10,4));

INSERT INTO `Grants` VALUES ('001','92 Purr_Scents %% team',7,4750);
INSERT INTO `Grants` VALUES ('002','K_Land fund trust',2,15750);
INSERT INTO `Grants` VALUES ('003','Robert@BigStarBank.com',7,18100);
INSERT INTO `Grants` VALUES ('004','Norman''s Outreach',null,21000);
INSERT INTO `Grants` VALUES ('005','BIG 6''s Foundation%',4,21000);
INSERT INTO `Grants` VALUES ('006','TALTA_Kishan International',3,18100);
INSERT INTO `Grants` VALUES ('007','Ben@MoreTechnology.com',010,41000);
INSERT INTO `Grants` VALUES ('008','@Last-U-Can-Help',7,25000);
INSERT INTO `Grants` VALUES ('009','Thank you @.com',11,21500);
INSERT INTO `Grants` VALUES ('010','Call Mom @Com',5,7500);


/* Sally (employeeID 11) is getting married,
change her last name to Green */
UPDATE Employee
SET LastName = 'Green'
WHERE EmpID = '11';

SELECT *
FROM Employee
WHERE EmpID = '11';

/* All the employees in the Spokane location are becoming contractors,
update their status field to External */
UPDATE Employee
INNER JOIN Location
ON Employee.LocationID = Location.LocationID
SET Status = 'External'
WHERE Location.City = 'Spokane';

SELECT *
FROM Employee
WHERE Employee.Status = 'External';

/* The location for Seattle has a typo,
update the street field to read 111 1st Ave */
UPDATE Location
SET Street = '111 1st Ave'
WHERE City = 'Seattle';

SELECT *
FROM Location;

/* A new policy requires that grants for employees in Boston be made for $20,000.
There are two Boston records which aren't set to $20,000.  Please fix them! */
UPDATE Grants g
INNER JOIN Employee AS e
ON e.EmpID = g.EmpID
INNER JOIN Location l
ON e.LocationID = l.LocationID
SET g.Amount = 20000
WHERE l.City = 'Boston';

SELECT e.FirstName, g.Amount
FROM Employee AS e
INNER JOIN Location l
ON e.LocationID = l.LocationID
INNER JOIN Grants AS g
ON e.EmpID = g.EmpID
WHERE l.City = 'Boston';

/* SWCCorp is not teaching long classes anymore for management,
delete all records where the duration is more than 20 hours */
DELETE FROM MgmtTraining
WHERE ClassDurationHours > 20;

SELECT *
FROM MgmtTraining;
