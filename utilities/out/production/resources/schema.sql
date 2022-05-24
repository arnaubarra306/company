SET AUTOCOMMIT=1;
DROP DATABASE IF EXISTS company;
CREATE DATABASE company;
USE company;


CREATE TABLE IF NOT EXISTS company.Department (
 deptNo  INT (2) UNSIGNED,
 name     VARCHAR(14) NOT NULL UNIQUE,
 Location      VARCHAR(14),
 PRIMARY KEY (deptNo)
 ) ;


CREATE TABLE IF NOT EXISTS company.Worker (
 compNO    INT (4) UNSIGNED,
 surname    VARCHAR (10) NOT NULL,
 dept       VARCHAR (10),
 boss       INT (4) UNSIGNED,
 date		DATE,
 salary    INT UNSIGNED,
 comission  INT UNSIGNED,
 deptNo   INT (2) UNSIGNED NOT NULL,
 PRIMARY KEY (compNO),
 INDEX IDX_company_deptNo (deptNo),
 FOREIGN KEY (deptNo) REFERENCES company.Department(deptNo)
 );


CREATE TABLE IF NOT EXISTS company.Customer (
 CustomerCode          INT(6) UNSIGNED PRIMARY KEY,
 name                VARCHAR (45) NOT NULL,
 adress              VARCHAR (40) NOT NULL,
 );


CREATE TABLE IF NOT EXISTS company.Product (
 ProductNum     INT (6) UNSIGNED PRIMARY KEY,
 description  VARCHAR (30) NOT NULL  UNIQUE
 );


CREATE INDEX Worker_Surname ON company.Worker (surname);
CREATE INDEX Customer_Name ON company.Customer (name);
