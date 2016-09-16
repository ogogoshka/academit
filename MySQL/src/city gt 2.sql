USE world;
SELECT id as id, name as name, CountryCode AS code, Population AS Population, count(name) AS counts_city 
FROM city 
GROUP BY CountryCode
HAVING count(name)>=2
ORDER BY counts_city;