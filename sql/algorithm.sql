CREATE SCHEMA algorithm ;

CREATE TABLE algorithm.algorithm (
	UUID varchar(36) PRIMARY KEY,
	NAME varchar(100),
	NUMBER int(11),
	SITE varchar(100), 
	TYPE varchar(30),
	URL varchar(255)
);

ALTER SCHEMA algorithm  DEFAULT CHARACTER SET utf8  DEFAULT COLLATE utf8_general_ci ;
ALTER TABLE algorithm.algorithm CONVERT TO CHARACTER SET utf8;