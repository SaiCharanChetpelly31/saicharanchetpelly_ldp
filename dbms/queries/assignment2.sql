#assignment2 solutions
#solution1 - Find out the number of documentaries with deleted scenes.
select count(*)
from sakila.film as f
JOIN sakila.film_category as fc ON fc.film_id = f.film_id
JOIN sakila.category as c ON c.category_id = fc.category_id
where c.name='Documentary' AND f.special_features LIKE '%Deleted Scenes%';

#solution2- Find out the number of sci-fi movies rented by the store managed by Jon Stephens.
select count(*) as num_rented_movies
from sakila.category as c
JOIN sakila.film_category as fc ON fc.category_id = c.category_id
JOIN sakila.film as f ON f.film_id = fc.film_id
JOIN sakila.inventory as i ON i.film_id = f.film_id
JOIN sakila.rental AS r ON r.inventory_id = i.inventory_id
JOIN sakila.store as s ON s.store_id = i.store_id
JOIN sakila.staff as s1 ON s1.store_id = s.store_id
where c.name = 'Sci-Fi' AND s1.first_name = 'Jon' AND s1.last_name = 'Stephens';

-- select count(f.title) as num
-- from sakila.rental right
-- join sakila.inventory i on r.inventory_id = i.inventory_id
-- join sakila.film f on i.film_id = f.film_id
-- join sakila.film_category fc on f.film_id = fc.film_id
-- join sakila.category c on fc.category_id = c.category_id
-- join sakila.staff s on r.staff_id = s.staff_id
-- join sakila.store sto on sto.store_id = sto.store_id
-- where c.name = 'Sci-Fi' and s.first_name = 'Jon' and s.last_name = 'Stephens';


#solution3 -  Find out the total sales from Animation movies.
select sum(p.amount) as total_sales
from sakila.category as c
JOIN sakila.film_category as fc ON fc.category_id = c.category_id
JOIN sakila.film as f ON f.film_id = fc.film_id
JOIN sakila.inventory as i ON i.film_id = f.film_id
JOIN sakila.rental as r ON r.inventory_id = i.inventory_id
JOIN sakila.payment as p ON p.rental_id = r.rental_id
where c.name = 'Animation';

#solution4 - Find out the top 3 rented category of movies by “PATRICIA JOHNSON”.
select c1.name,COUNT(*) AS rentals_count
from sakila.customer as c
JOIN sakila.rental as r ON r.customer_id = c.customer_id
JOIN sakila.inventory as i ON i.inventory_id = r.inventory_id
JOIN sakila.film as f ON f.film_id = i.film_id
JOIN sakila.film_category as fc ON fc.film_id = f.film_id
JOIN sakila.category as c1 ON fc.category_id = c1.category_id
where c.first_name = 'PATRICIA' AND c.last_name = 'JOHNSON'
group by c1.name
ORDER BY rentals_count DESC;

#solution5 -  Find out the number of R rated movies rented by “SUSAN WILSON”.
select count(*) as no_of_R_rated_movies
from sakila.customer as c
JOIN sakila.rental as r ON r.customer_id = c.customer_id
JOIN sakila.inventory as i ON i.inventory_id = r.inventory_id
JOIN sakila.film as f ON f.film_id = i.film_id
where c.first_name='SUSAN' AND c.last_name = 'WILSON' AND f.rating = 'R';

