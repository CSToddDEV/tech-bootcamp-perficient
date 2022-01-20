product
USE BIGOLBEARDS;
DROP TABLE IF EXISTS BRAND;
CREATE TABLE BRAND (
BrandID int auto_increment primary key unique,
BrandName varchar(255) unique not null,
BrandSite varchar(255) unique,
Phone varchar(16) unique,
TopSeller int
);
DROP TABLE IF EXISTS PRODUCT;
CREATE TABLE PRODUCT (
ProductID int primary key auto_increment unique,
BrandID int not null,
ProductName varchar(255),
ProductType varchar(255) not null,
Price float(5, 2) not null,
Sold int,
Rating float(2,1) DEFAULT 0.00,
RecentReview mediumtext,
foreign key (BrandID) references BRAND(BrandID)
);
ALTER TABLE BRAND
ADD FOREIGN KEY (TopSeller) 
REFERENCES PRODUCT(ProductID); 
DROP TABLE IF EXISTS REVIEW;
CREATE TABLE REVIEW (
ReviewID int primary key auto_increment unique,
Rating int not null,
ReviewDate date not null,
Review mediumtext,
ProductID int not null,
foreign key (ProductID) references PRODUCT(ProductID)
);

