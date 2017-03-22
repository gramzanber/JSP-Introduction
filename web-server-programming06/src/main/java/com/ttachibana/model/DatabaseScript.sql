drop table Bookdatabase;

Create Table Bookdatabase (
BOOK_ID INT NOT NULL AUTO_INCREMENT,
TITLE VARCHAR(20), 
AUTHOR VARCHAR(20), 
PUBLICATION_YEAR INT, 
PRICE DOUBLE, 
PRIMARY KEY (BOOK_ID)
);

insert into Bookdatabase (TITLE, AUTHOR, PUBLICATION_YEAR, PRICE)
    VALUES ("Planet of Peace", "Eoria", 2007, 14.99);
insert into Bookdatabase (TITLE, AUTHOR, PUBLICATION_YEAR, PRICE)
    VALUES ("Planet at War", "Mir", 2009, 15.99);
insert into Bookdatabase (TITLE, AUTHOR, PUBLICATION_YEAR, PRICE)
    VALUES ("Sea of Death", "Frelia", 2012, 16.99);
insert into Bookdatabase (TITLE, AUTHOR, PUBLICATION_YEAR, PRICE)
    VALUES ("The Three Towers", "Tyria", 2013, 17.99);
insert into Bookdatabase (TITLE, AUTHOR, PUBLICATION_YEAR, PRICE)
    VALUES ("Ar Ciel - Ec Tisia", "Ar Ru", 2016, 19.99);

select * from Bookdatabase;
