USE world;
SELECT id as id, Name AS Name, CountryCode AS CountryCode, Population AS Population, Count(name) AS Counts_city 
FROM city 
GROUP BY CountryCode
ORDER BY id;