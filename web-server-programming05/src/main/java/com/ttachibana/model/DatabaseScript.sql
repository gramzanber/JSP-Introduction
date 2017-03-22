-- Clearing the table for fresh script run
drop table customer;

-- Creating table for holding customer information
Create Table CUSTOMER (
CUSTOMER_ID INT NOT NULL AUTO_INCREMENT,
LNAME VARCHAR(20), 
FNAME VARCHAR(20), 
PASSWORD VARCHAR(20), 
EMAIL VARCHAR(50),
PHONE VARCHAR(20),
HOMETOWN VARCHAR(30), 
GENDER VARCHAR(6), 
LANGUAGES VARCHAR(80), 
PRIMARY KEY (CUSTOMER_ID)
);

-- Inserting three test values in the customer table
insert into customer (LNAME,FNAME,PASSWORD,EMAIL,PHONE,HOMETOWN,GENDER,LANGUAGES) values ('McKinnion','Micah','Password','mmckinnion@uco.edu','405-456-3456','Edmond','Male','[C++, Java, C#]');
insert into customer (LNAME,FNAME,PASSWORD,EMAIL,PHONE,HOMETOWN,GENDER,LANGUAGES) values ('Chang','Maggie','Password','pchang@uco.edu','405-678-5678','Taipei','Female','[Java]');
insert into customer (LNAME,FNAME,PASSWORD,EMAIL,PHONE,HOMETOWN,GENDER,LANGUAGES) values ('Bilby','Adam','Password','abilby@uco.edu','405-678-2953','Norman','Male','[C++, Pascal]');
insert into customer (LNAME,FNAME,PASSWORD,EMAIL,PHONE,HOMETOWN,GENDER,LANGUAGES) values ('Sopp','Samuel','Password','ssop@uco.edu','405-833-3478','Edmond','Male','[Java, C#]');

select * from customer;