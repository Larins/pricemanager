DROP DATABASE IF EXISTS pricemanager;
CREATE DATABASE pricemanager;
USE pricemanager;

DROP TABLE IF EXISTS pricing;
CREATE TABLE pricing (
	id INTEGER PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(25) NOT NULL,
	price NUMERIC(65,2) NOT NULL,
	delay_days VARCHAR(25),
	date_created TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP() ON UPDATE CURRENT_TIMESTAMP()
);

INSERT INTO pricing (name, delay_days, price) VALUES
	('Normal', 10, 100),
	('Rápido', 5, 200),
	('Exprés', 1, 500)
;


DROP TABLE IF EXISTS articles;
CREATE TABLE articles (
	id INTEGER PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(25) NOT NULL,
	postalcode_ini VARCHAR(25) NOT NULL,
	postalcode_fin VARCHAR(25) NOT NULL,
	date_ini DATETIME NOT NULL,
	delay_days VARCHAR(25) NOT NULL,
	price NUMERIC(65,2) NOT NULL,
	qty NUMERIC(65,2) NOT NULL

);

INSERT INTO articles (name, postalcode_ini, postalcode_fin, date_ini, delay_days, price, qty) VALUES
	('Normal', '08860', '17003', '2021-01-01 17:00:00', 10, 100, 12),
	('Rápido', '17006', '08860', '2021-01-25 03:00:00', 5, 200, 33),
	('Exprés', '08840', '08940', '2021-02-14 06:00:00', 1, 500, 9),
	('Rápido', '17003', '08860', '2021-02-28 19:30:00', 5, 200, 10),
	('Exprés', '08840', '17840', '2021-03-05 23:00:00', 1, 500, 22),
	('Rápido', '17001', '08840', '2021-03-22 12:00:00', 5, 200, 32),
	('Normal', '08860', '17003', '2021-04-01 00:30:00', 10, 100, 1),
	('Normal', '08860', '17003', '2021-04-20 22:00:00', 10, 100, 10),
	('Normal', '25007', '17003', '2021-05-07 16:00:00', 10, 100, 5),
	('Exprés', '08840', '25196', '2021-05-21 11:45:00', 1, 500, 14),
	('Exprés', '25198', '17840', '2021-06-01 04:30:00', 1, 500, 21),
	('Normal', '08860', '25007', '2021-06-14 17:50:00', 10, 100, 72),
	('Rápido', '17003', '08860', '2021-07-10 15:30:00', 5, 200, 17),
	('Rápido', '17003', '08860', '2021-07-28 05:30:00', 5, 200, 13),
	('Exprés', '08840', '25196', '2021-08-02 16:30:00', 1, 500, 45),
	('Normal', '08860', '17003', '2021-08-14 14:20:00', 10, 100, 21),
	('Exprés', '08840', '17840', '2021-09-08 09:00:00', 1, 500, 18),
	('Normal', '25007', '17003', '2021-09-22 07:15:00', 10, 100, 29),
	('Rápido', '17003', '08860', '2021-10-14 03:30:00', 5, 200, 4),
	('Normal', '25007', '17003', '2021-10-17 09:55:00', 10, 100, 8)
;


ALTER TABLE articles 
	ADD COLUMN amount NUMERIC(65,2) DEFAULT (price*qty),
	ADD COLUMN date_fin DATETIME DEFAULT DATE_ADD(date_ini, INTERVAL delay_days DAY) AFTER delay_days,
	ADD COLUMN date_created TIMESTAMP DEFAULT CURRENT_TIMESTAMP() ON UPDATE CURRENT_TIMESTAMP()
;



#ARTICLES: con todos los valores generados línea a línea

/*
	DROP TABLE IF EXISTS articles;
	CREATE TABLE articles (
	id INTEGER PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(25) NOT NULL,
	postalcode_ini VARCHAR(25) NOT NULL,
	postalcode_fin VARCHAR(25) NOT NULL,
	price NUMERIC(65,2) NOT NULL,
	qty NUMERIC(65,2) NOT NULL,
	date_ini DATETIME NOT NULL,
	delay_days VARCHAR(25),
	date_fin DATETIME NOT NULL,
	amount NUMERIC(65,2),
	date_created TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP() ON UPDATE CURRENT_TIMESTAMP()
);

INSERT INTO articles (name, postalcode_ini, postalcode_fin, date_ini, delay_days, price, qty, amount, date_fin, date_created) VALUES
	('Normal', '08860', '17003', '2021-01-01 17:00:00', 10, 100, 12, price*qty, DATE_ADD(date_ini, INTERVAL delay_days DAY), CURRENT_TIMESTAMP),
	('Rápido', '17006', '08860', '2021-01-25 03:00:00', 5, 200, 33, price*qty, DATE_ADD(date_ini, INTERVAL delay_days DAY), CURRENT_TIMESTAMP),
	('Exprés', '08840', '08940', '2021-02-14 06:00:00', 1, 500, 9, price*qty, DATE_ADD(date_ini, INTERVAL delay_days DAY), CURRENT_TIMESTAMP),
	('Rápido', '17003', '08860', '2021-02-28 19:30:00', 5, 200, 10, price*qty, DATE_ADD(date_ini, INTERVAL delay_days DAY), CURRENT_TIMESTAMP),
	('Exprés', '08840', '17840', '2021-03-05 23:00:00', 1, 500, 22, price*qty, DATE_ADD(date_ini, INTERVAL delay_days DAY), CURRENT_TIMESTAMP),
	('Rápido', '17001', '08840', '2021-03-22 12:00:00', 5, 200, 32, price*qty, DATE_ADD(date_ini, INTERVAL delay_days DAY), CURRENT_TIMESTAMP),
	('Normal', '08860', '17003', '2021-04-01 00:30:00', 10, 100, 1, price*qty, DATE_ADD(date_ini, INTERVAL delay_days DAY), CURRENT_TIMESTAMP),
	('Normal', '08860', '17003', '2021-04-20 22:00:00', 10, 100, 10, price*qty, DATE_ADD(date_ini, INTERVAL delay_days DAY), CURRENT_TIMESTAMP),
	('Normal', '25007', '17003', '2021-05-07 16:00:00', 10, 100, 5, price*qty, DATE_ADD(date_ini, INTERVAL delay_days DAY), CURRENT_TIMESTAMP),
	('Exprés', '08840', '25196', '2021-05-21 11:45:00', 1, 500, 14, price*qty, DATE_ADD(date_ini, INTERVAL delay_days DAY), CURRENT_TIMESTAMP),
	('Exprés', '25198', '17840', '2021-06-01 04:30:00', 1, 500, 21, price*qty, DATE_ADD(date_ini, INTERVAL delay_days DAY), CURRENT_TIMESTAMP),
	('Normal', '08860', '25007', '2021-06-14 17:50:00', 10, 100, 72, price*qty, DATE_ADD(date_ini, INTERVAL delay_days DAY), CURRENT_TIMESTAMP),
	('Rápido', '17003', '08860', '2021-07-10 15:30:00', 5, 200, 17, price*qty, DATE_ADD(date_ini, INTERVAL delay_days DAY), CURRENT_TIMESTAMP),
	('Rápido', '17003', '08860', '2021-07-28 05:30:00', 5, 200, 13, price*qty, DATE_ADD(date_ini, INTERVAL delay_days DAY), CURRENT_TIMESTAMP),
	('Exprés', '08840', '25196', '2021-08-02 16:30:00', 1, 500, 45, price*qty, DATE_ADD(date_ini, INTERVAL delay_days DAY), CURRENT_TIMESTAMP),
	('Normal', '08860', '17003', '2021-08-14 14:20:00', 10, 100, 21, price*qty, DATE_ADD(date_ini, INTERVAL delay_days DAY), CURRENT_TIMESTAMP),
	('Exprés', '08840', '17840', '2021-09-08 09:00:00', 1, 500, 18, price*qty, DATE_ADD(date_ini, INTERVAL delay_days DAY), CURRENT_TIMESTAMP),
	('Normal', '25007', '17003', '2021-09-22 07:15:00', 10, 100, 29, price*qty, DATE_ADD(date_ini, INTERVAL delay_days DAY), CURRENT_TIMESTAMP),
	('Rápido', '17003', '08860', '2021-10-14 03:30:00', 5, 200, 4, price*qty, DATE_ADD(date_ini, INTERVAL delay_days DAY), CURRENT_TIMESTAMP),
	('Normal', '25007', '17003', '2021-10-17 09:55:00', 10, 100, 8, price*qty, DATE_ADD(date_ini, INTERVAL delay_days DAY), CURRENT_TIMESTAMP)
;

*/


