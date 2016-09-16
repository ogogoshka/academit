USE world;
SELECT id, name, district FROM city;
SELECT * FROM city where Code ='RUS';
SELECT * FROM city WHERE CountryCode = 'GRC' OR CountryCode = 'ESP' OR CountryCode = 'PRT' ORDER BY name DESC
SELECT *  FROM city WHERE Population >= 300000 AND Population <= 500000;
SELECT *  FROM city WHERE name LIKE 'a%';
SELECT *  FROM city WHERE name LIKE '%a%';