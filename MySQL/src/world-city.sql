USE world;
SELECT name, district FROM city;
SELECT * FROM city WHERE CountryCode ='RUS' ORDER BY name ASC;
SELECT * FROM city WHERE CountryCode IN ('GRC', 'ESP', 'PRT') ORDER BY name DESC;
SELECT *  FROM city WHERE Population >= 300000 AND Population <= 500000;
SELECT *  FROM city WHERE name LIKE 'a%';
SELECT *  FROM city WHERE name LIKE '%a%';