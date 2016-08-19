CREATE TABLE `company` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `company_name` varchar(255) NOT NULL,
  `city` varchar(255) DEFAULT NULL,
  `created_on` date NOT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `updated_on` date NOT NULL,
  `updated_by` bigint(20) DEFAULT NULL,
  `state_id` smallint(6) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `created_by` (`created_by`),
  KEY `updated_by` (`updated_by`),
  KEY `state_id` (`state_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

CREATE TABLE `state` (
  `state_id` smallint(6) unsigned NOT NULL AUTO_INCREMENT COMMENT 'PK: Unique state ID',
  `state_name` varchar(32) NOT NULL COMMENT 'State name with first letter capital',
  `state_abbr` varchar(8) DEFAULT NULL COMMENT 'Optional state abbreviation (US is 2 capital letters)',
  PRIMARY KEY (`state_id`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=latin1;

15:14:09  alter table company add CONSTRAINT fk_company_state foreign key(state_id) references state(state_id)  Error Code: 1452. Cannot add or update a child row: a foreign key constraint fails (`guild_operations`.`#sql-5e9_af`, CONSTRAINT `fk_company_state` FOREIGN KEY (`state_id`) REFERENCES `state` (`state_id`)) 0.005 sec
