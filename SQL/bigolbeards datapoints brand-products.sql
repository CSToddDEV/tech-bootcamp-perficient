INSERT INTO BRAND (BrandName, BrandSite)
VALUES ("Honest Amish", "www.honestamish.com");
INSERT INTO BRAND (BrandName, BrandSite, Phone)
VALUES ("Viking Revolution", "www.vikingrevolution.com", "(425)358-9236");
INSERT INTO BRAND (BrandName, BrandSite)
VALUES ("Crown Shaving Co.", "www.crownshavingco.com");
INSERT INTO BRAND (BrandName, BrandSite)
VALUES ("Clubman", "www.clubmanonline.com");
INSERT INTO PRODUCT (BrandID, ProductName, ProductType, Price)
VALUES ((SELECT BrandID FROM BRAND WHERE BrandName = "Honest Amish"), "PURE", "Beard Balm", 12.87);
INSERT INTO PRODUCT (BrandID, ProductName, ProductType, Price)
VALUES ((SELECT BrandID FROM BRAND WHERE BrandName = "Honest Amish"), "Heavy Duty", "Beard Balm", 13.77);
INSERT INTO PRODUCT (BrandID, ProductName, ProductType, Price)
VALUES ((SELECT BrandID FROM BRAND WHERE BrandName = "Honest Amish"), "SLICK", "Beard Wax", 11.77);
INSERT INTO PRODUCT (BrandID, ProductName, ProductType, Price)
VALUES ((SELECT BrandID FROM BRAND WHERE BrandName = "Honest Amish"), "EXTRA Grit", "Beard Wax", 12.27);
INSERT INTO PRODUCT (BrandID, ProductName, ProductType, Price)
VALUES ((SELECT BrandID FROM BRAND WHERE BrandName = "Honest Amish"), "ORIGINAL", "Beard Wax", 12.77);
INSERT INTO PRODUCT (BrandID, ProductName, ProductType, Price)
VALUES ((SELECT BrandID FROM BRAND WHERE BrandName = "Honest Amish"), "Classic", "Beard Oil", 13.87);
INSERT INTO PRODUCT (BrandID, ProductName, ProductType, Price)
VALUES ((SELECT BrandID FROM BRAND WHERE BrandName = "Honest Amish"), "Premium", "Beard Oil", 19.77);
INSERT INTO PRODUCT (BrandID, ProductName, ProductType, Price)
VALUES ((SELECT BrandID FROM BRAND WHERE BrandName = "Honest Amish"), "PURE", "Beard Oil", 13.57);
INSERT INTO PRODUCT (BrandID, ProductName, ProductType, Price)
VALUES ((SELECT BrandID FROM BRAND WHERE BrandName = "Viking Revolution"), "CITRUS", "Beard Balm", 8.88);
INSERT INTO PRODUCT (BrandID, ProductName, ProductType, Price)
VALUES ((SELECT BrandID FROM BRAND WHERE BrandName = "Viking Revolution"), "BAY RUM", "Beard Balm", 8.88);
INSERT INTO PRODUCT (BrandID, ProductName, ProductType, Price)
VALUES ((SELECT BrandID FROM BRAND WHERE BrandName = "Viking Revolution"), "CEDAR AND PINE", "Beard Balm", 8.88);
INSERT INTO PRODUCT (BrandID, ProductName, ProductType, Price)
VALUES ((SELECT BrandID FROM BRAND WHERE BrandName = "Viking Revolution"), "CITRUS", "Mustache Wax", 8.88);
INSERT INTO PRODUCT (BrandID, ProductName, ProductType, Price)
VALUES ((SELECT BrandID FROM BRAND WHERE BrandName = "Viking Revolution"), "SANDALWOOD", "Mustache Wax", 8.88);
INSERT INTO PRODUCT (BrandID, ProductName, ProductType, Price)
VALUES ((SELECT BrandID FROM BRAND WHERE BrandName = "Viking Revolution"), "BAY RUM", "Beard Oil", 8.99);
INSERT INTO PRODUCT (BrandID, ProductName, ProductType, Price)
VALUES ((SELECT BrandID FROM BRAND WHERE BrandName = "Viking Revolution"), "CEDAR AND PINE", "Beard Oil", 8.99);
INSERT INTO PRODUCT (BrandID, ProductName, ProductType, Price)
VALUES ((SELECT BrandID FROM BRAND WHERE BrandName = "Viking Revolution"), "CLARY SAGE", "Beard Oil", 8.99);
INSERT INTO PRODUCT (BrandID, ProductName, ProductType, Price)
VALUES ((SELECT BrandID FROM BRAND WHERE BrandName = "Crown Shaving Co."), "Classic", "Beard Balm", 13.99);
INSERT INTO PRODUCT (BrandID, ProductName, ProductType, Price)
VALUES ((SELECT BrandID FROM BRAND WHERE BrandName = "Clubman"), "3 in 1", "Beard Balm", 16.95);
INSERT INTO PRODUCT (BrandID, ProductName, ProductType, Price)
VALUES ((SELECT BrandID FROM BRAND WHERE BrandName = "Clubman"), "Styling", "Beard Wax", 8.95);
INSERT INTO PRODUCT (BrandID, ProductName, ProductType, Price)
VALUES ((SELECT BrandID FROM BRAND WHERE BrandName = "Clubman"), "Classic", "Beard Oil", 8.95);
INSERT INTO PRODUCT (BrandID, ProductName, ProductType, Price)
VALUES ((SELECT BrandID FROM BRAND WHERE BrandName = "Clubman"), "Neutral", "Mustache Wax", 4.95);
INSERT INTO PRODUCT (BrandID, ProductName, ProductType, Price)
VALUES ((SELECT BrandID FROM BRAND WHERE BrandName = "Clubman"), "Black", "Mustache Wax", 4.95);
INSERT INTO PRODUCT (BrandID, ProductName, ProductType, Price)
VALUES ((SELECT BrandID FROM BRAND WHERE BrandName = "Clubman"), "Chestnut", "Mustache Wax", 4.95);
INSERT INTO PRODUCT (BrandID, ProductName, ProductType, Price)
VALUES ((SELECT BrandID FROM BRAND WHERE BrandName = "Clubman"), "Brownreview", "Mustache Wax", 4.95);