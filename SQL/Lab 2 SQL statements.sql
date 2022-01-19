SELECT BrandName FROM Brand;
SELECT product.ProductName, review.ProductID, review.Review
FROM product
INNER JOIN review
on product.ProductID = review.ProductID
WHERE review.Rating = 5;
INSERT INTO BRAND (BrandName, BrandSite)
VALUES ("NOT A BRAND", "www.cat-stuff.com");
SELECT * FROM Brand
WHERE BrandName = "NOT A BRAND";
UPDATE BRAND
SET BrandName = "STILL NOT A BRAND"
WHERE BrandName = "NOT A BRAND";
SELECT * FROM Brand
WHERE BrandName = "STILL NOT A BRAND";
DELETE FROM BRAND
WHERE BrandName = "STILL NOT A BRAND";