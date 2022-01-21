USE bigolbeards;
INSERT INTO BRAND (brand_name, brand_site)
VALUES ("Honest Amish", "www.honestamish.com");
INSERT INTO BRAND (brand_name, brand_site, phone)
VALUES ("Viking Revolution", "www.vikingrevolution.com", "(425)358-9236");
INSERT INTO BRAND (brand_name, brand_site)
VALUES ("Crown Shaving Co.", "www.crownshavingco.com");
INSERT INTO BRAND (brand_name, brand_site)
VALUES ("Clubman", "www.clubmanonline.com");
INSERT INTO PRODUCT (brand_id, product_name, product_type, price)
VALUES ((SELECT id FROM BRAND WHERE brand_name = "Honest Amish"), "PURE", "Beard Balm", 12.87);
INSERT INTO PRODUCT (brand_id, product_name, product_type, price)
VALUES ((SELECT id FROM BRAND WHERE brand_name = "Honest Amish"), "Heavy Duty", "Beard Balm", 13.77);
INSERT INTO PRODUCT (brand_id, product_name, product_type, price)
VALUES ((SELECT id FROM BRAND WHERE brand_name = "Honest Amish"), "SLICK", "Beard Wax", 11.77);
INSERT INTO PRODUCT (brand_id, product_name, product_type, price)
VALUES ((SELECT id FROM BRAND WHERE brand_name = "Honest Amish"), "EXTRA Grit", "Beard Wax", 12.27);
INSERT INTO PRODUCT (brand_id, product_name, product_type, price)
VALUES ((SELECT id FROM BRAND WHERE brand_name = "Honest Amish"), "ORIGINAL", "Beard Wax", 12.77);
INSERT INTO PRODUCT (brand_id, product_name, product_type, price)
VALUES ((SELECT id FROM BRAND WHERE brand_name = "Honest Amish"), "Classic", "Beard Oil", 13.87);
INSERT INTO PRODUCT (brand_id, product_name, product_type, price)
VALUES ((SELECT id FROM BRAND WHERE brand_name = "Honest Amish"), "Premium", "Beard Oil", 19.77);
INSERT INTO PRODUCT (brand_id, product_name, product_type, price)
VALUES ((SELECT id FROM BRAND WHERE brand_name = "Honest Amish"), "PURE", "Beard Oil", 13.57);
INSERT INTO PRODUCT (brand_id, product_name, product_type, price)
VALUES ((SELECT id FROM BRAND WHERE brand_name = "Viking Revolution"), "CITRUS", "Beard Balm", 8.88);
INSERT INTO PRODUCT (brand_id, product_name, product_type, price)
VALUES ((SELECT id FROM BRAND WHERE brand_name = "Viking Revolution"), "BAY RUM", "Beard Balm", 8.88);
INSERT INTO PRODUCT (brand_id, product_name, product_type, price)
VALUES ((SELECT id FROM BRAND WHERE brand_name = "Viking Revolution"), "CEDAR AND PINE", "Beard Balm", 8.88);
INSERT INTO PRODUCT (brand_id, product_name, product_type, price)
VALUES ((SELECT id FROM BRAND WHERE brand_name = "Viking Revolution"), "CITRUS", "Mustache Wax", 8.88);
INSERT INTO PRODUCT (brand_id, product_name, product_type, price)
VALUES ((SELECT id FROM BRAND WHERE brand_name = "Viking Revolution"), "SANDALWOOD", "Mustache Wax", 8.88);
INSERT INTO PRODUCT (brand_id, product_name, product_type, price)
VALUES ((SELECT id FROM BRAND WHERE brand_name = "Viking Revolution"), "BAY RUM", "Beard Oil", 8.99);
INSERT INTO PRODUCT (brand_id, product_name, product_type, price)
VALUES ((SELECT id FROM BRAND WHERE brand_name = "Viking Revolution"), "CEDAR AND PINE", "Beard Oil", 8.99);
INSERT INTO PRODUCT (brand_id, product_name, product_type, price)
VALUES ((SELECT id FROM BRAND WHERE brand_name = "Viking Revolution"), "CLARY SAGE", "Beard Oil", 8.99);
INSERT INTO PRODUCT (brand_id, product_name, product_type, price)
VALUES ((SELECT id FROM BRAND WHERE brand_name = "Crown Shaving Co."), "Classic", "Beard Balm", 13.99);
INSERT INTO PRODUCT (brand_id, product_name, product_type, price)
VALUES ((SELECT id FROM BRAND WHERE brand_name = "Clubman"), "3 in 1", "Beard Balm", 16.95);
INSERT INTO PRODUCT (brand_id, product_name, product_type, price)
VALUES ((SELECT id FROM BRAND WHERE brand_name = "Clubman"), "Styling", "Beard Wax", 8.95);
INSERT INTO PRODUCT (brand_id, product_name, product_type, price)
VALUES ((SELECT id FROM BRAND WHERE brand_name = "Clubman"), "Classic", "Beard Oil", 8.95);
INSERT INTO PRODUCT (brand_id, product_name, product_type, price)
VALUES ((SELECT id FROM BRAND WHERE brand_name = "Clubman"), "Neutral", "Mustache Wax", 4.95);
INSERT INTO PRODUCT (brand_id, product_name, product_type, price)
VALUES ((SELECT id FROM BRAND WHERE brand_name = "Clubman"), "Black", "Mustache Wax", 4.95);
INSERT INTO PRODUCT (brand_id, product_name, product_type, price)
VALUES ((SELECT id FROM BRAND WHERE brand_name = "Clubman"), "Chestnut", "Mustache Wax", 4.95);
INSERT INTO PRODUCT (brand_id, product_name, product_type, price)
VALUES ((SELECT id FROM BRAND WHERE brand_name = "Clubman"), "Brownreview", "Mustache Wax", 4.95);
INSERT INTO REVIEW (Rating, ReviewDate, Review, ProductID)
VALUES (2, '2022-01-01', "Terrible Beard Balm, the only thing PURE about it is my PUTE LOATHING for putting it in my beard!", 1);
INSERT INTO REVIEW (Rating, ReviewDate, Review, ProductID)
VALUES (5, '2022-01-03', "A PURE Joy", 1);
INSERT INTO REVIEW (Rating, ReviewDate, Review, ProductID)
VALUES (4, '2021-01-03', "My Beard Drives a Lifted Ford Truck, this is the only blam that keeps it in place", 2);
INSERT INTO REVIEW (Rating, ReviewDate, Review, ProductID)
VALUES (3, '2021-06-03', "It says it's heavy, but I had not trouble lifting the container of Beard Balm.", 2);
INSERT INTO REVIEW (Rating, ReviewDate, Review, ProductID)
VALUES (5, '2021-04-03', "When I finally could hold on to the container, this Balm was great!", 3);
INSERT INTO REVIEW (Rating, ReviewDate, Review, ProductID)
VALUES (5, '2021-07-07', "Makes it so people can go tubing on your beard.", 3);
INSERT INTO REVIEW (Rating, ReviewDate, Review, ProductID)
VALUES (2, '2021-02-11', "I was uncomfortable with how hardcore this Balm was", 4);
INSERT INTO REVIEW (Rating, ReviewDate, Review, ProductID)
VALUES (4, '2021-08-12', "I wore this one time and people kept asking me for an authograph, they though I was Bruce Willis.", 4);
INSERT INTO REVIEW (Rating, ReviewDate, Review, ProductID)
VALUES (2, '2021-02-11', "I was uncomfortable with how hardcore this Balm was", 4);
INSERT INTO REVIEW (Rating, ReviewDate, Review, ProductID)
VALUES (4, '2021-08-22', "Like a Red Roses on Valnetines, classic.", 5);
INSERT INTO REVIEW (Rating, ReviewDate, Review, ProductID)
VALUES (4, '2021-05-20', "If it ain't broken, don't fix it.", 5);
INSERT INTO REVIEW (Rating, ReviewDate, Review, ProductID)
VALUES (5, '2021-02-21', "Best Oil Out There", 6);
INSERT INTO REVIEW (Rating, ReviewDate, Review, ProductID)
VALUES (5, '2021-09-21', "I replaced the oil in my car with this and it now drives 2x as fast", 6);
INSERT INTO REVIEW (Rating, ReviewDate, Review, ProductID)
VALUES (2, '2021-01-11', "Only thing Premium is the Price", 7);
INSERT INTO REVIEW (Rating, ReviewDate, Review, ProductID)
VALUES (3, '2021-08-18', "It smells like microwaved butterscotches", 7);
INSERT INTO REVIEW (Rating, ReviewDate, Review, ProductID)
VALUES (1, '2021-01-10', "PUREly dissapointing", 8);
INSERT INTO REVIEW (Rating, ReviewDate, Review, ProductID)
VALUES (4, '2021-01-14', "My cat likes it, it makes him PURRRRRRRRRRRRRE", 8);
INSERT INTO REVIEW (Rating, ReviewDate, Review, ProductID)
VALUES (4, '2021-04-14', "Like Sunday Morning Mimosas!", 9);
INSERT INTO REVIEW (Rating, ReviewDate, Review, ProductID)
VALUES (5, '2021-05-14', "Also protects from Scurvy", 9);
INSERT INTO REVIEW (Rating, ReviewDate, Review, ProductID)
VALUES (2, '2021-04-12', "No actual rum inside this, be warned", 10);
INSERT INTO REVIEW (Rating, ReviewDate, Review, ProductID)
VALUES (3, '2021-04-12', "I got this for my boyfriend and the first day he wore it he got attacked by seagulls.", 10);
INSERT INTO REVIEW (Rating, ReviewDate, Review, ProductID)
VALUES (4, '2021-04-02', "There are directions on how to actually Chop Down Trees on the label", 11);
INSERT INTO REVIEW (Rating, ReviewDate, Review, ProductID)
VALUES (3, '2021-03-02', "I stole this from a lumberjack when he wasn't looking", 11);
INSERT INTO REVIEW (Rating, ReviewDate, Review, ProductID)
VALUES (4, '2021-01-02', "My mustache smells like I just finished eating an Oro blanco Grapefruit, rind and all", 12);
INSERT INTO REVIEW (Rating, ReviewDate, Review, ProductID)
VALUES (5, '2021-11-02', "Lemon curd with notes of lemon, and a slight after smell of lemon grass.", 12);
INSERT INTO REVIEW (Rating, ReviewDate, Review, ProductID)
VALUES (2, '2021-11-12', "NOT ACTUALLY SANDALS", 13);
INSERT INTO REVIEW (Rating, ReviewDate, Review, ProductID)
VALUES (4, '2021-11-01', "Makes you smell 50 percent fancier.", 13);
INSERT INTO REVIEW (Rating, ReviewDate, Review, ProductID)
VALUES (4, '2021-11-13', "Flammable.", 14);
INSERT INTO REVIEW (Rating, ReviewDate, Review, ProductID)
VALUES (2, '2021-12-13', "Yo.  This tastes real bad.  I don't know why they don't put a do not drink warning on it.", 14);
INSERT INTO REVIEW (Rating, ReviewDate, Review, ProductID)
VALUES (5, '2021-10-10', "If I could give this a higher rating, I would.  I like Trees.", 15);
INSERT INTO REVIEW (Rating, ReviewDate, Review, ProductID)
VALUES (4, '2021-01-13', "I would swim in a pool of this.", 15);
INSERT INTO REVIEW (Rating, ReviewDate, Review, ProductID)
VALUES (3, '2021-09-01', "Definitely something.  I think.", 16);
INSERT INTO REVIEW (Rating, ReviewDate, Review, ProductID)
VALUES (5, '2021-01-02', "Refilled my magic 8-Ball with this, it now is 20% more accurate", 16);
INSERT INTO REVIEW (Rating, ReviewDate, Review, ProductID)
VALUES (5, '2021-01-05', "This takes the crown.  I am smell so fancy.", 17);
INSERT INTO REVIEW (Rating, ReviewDate, Review, ProductID)
VALUES (5, '2021-03-03', "I left my partner for this Balm.", 17);
INSERT INTO REVIEW (Rating, ReviewDate, Review, ProductID)
VALUES (2, '2021-09-05', "Too much going on.  Do one thing and do it well.", 18);
INSERT INTO REVIEW (Rating, ReviewDate, Review, ProductID)
VALUES (3, '2021-03-08', "I wouldn't wear this to the club.", 18);
INSERT INTO REVIEW (Rating, ReviewDate, Review, ProductID)
VALUES (5, '2021-02-22', "I have SO MUCH SYLE NOW.  I don't know what to do with it, help!", 19);
INSERT INTO REVIEW (Rating, ReviewDate, Review, ProductID)
VALUES (4, '2021-03-23', "This Balm dresed my beard up in a 3 piece suit and a tie.  It was a good look, but now all my beard does is talk about import cards and the S&P500.", 19);
INSERT INTO REVIEW (Rating, ReviewDate, Review, ProductID)
VALUES (5, '2021-12-02', "As Classy as it is Classic.", 20);
INSERT INTO REVIEW (Rating, ReviewDate, Review, ProductID)
VALUES (3, '2021-11-12', "With the price tag this beard oil should be called classist.", 20);
INSERT INTO REVIEW (Rating, ReviewDate, Review, ProductID)
VALUES (4, '2021-11-14', "Like Switzerland, this wax is Neutral.", 21);
INSERT INTO REVIEW (Rating, ReviewDate, Review, ProductID)
VALUES (5, '2021-09-14', "This wax holds tighter than me holding on to my receding hairline.", 21);
INSERT INTO REVIEW (Rating, ReviewDate, Review, ProductID)
VALUES (3, '2021-02-14', "I have very mixed feelings on this wax.  I think I will blog about it", 22);
INSERT INTO REVIEW (Rating, ReviewDate, Review, ProductID)
VALUES (5, '2021-05-15', "This wax saved my kitten who got stuck in a tree.", 22);
INSERT INTO REVIEW (Rating, ReviewDate, Review, ProductID)
VALUES (4, '2021-01-11', "Tried to use this in a Chestnut Pie, 10/10 would do again.", 23);
INSERT INTO REVIEW (Rating, ReviewDate, Review, ProductID)
VALUES (5, '2021-07-17', "This is the only mustache wax my racehorse will use", 23);
INSERT INTO REVIEW (Rating, ReviewDate, Review, ProductID)
VALUES (5, '2021-06-16', "YES!", 24);
INSERT INTO REVIEW (Rating, ReviewDate, Review, ProductID)
VALUES (3, '2021-06-17', "MAYBE!", 24);