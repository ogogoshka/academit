USE world;
SELECT id as id, CountryCode AS code, Population AS Population, AVG(Population) AS Averages
FROM city 
GROUP BY CountryCode
ORDER BY Averages;