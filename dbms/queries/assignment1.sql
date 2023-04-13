# Find out the PG-13 rated comedy movies. DO NOT use the film_list table.
select *
from sakila.film as f
where f.rating = 'PG-13';

#category_id if it is comedy
select category_id
from sakila.category
where name = 'Comedy';

#filmid of film that are comeedy
select film_id
from sakila.film_category
where category_id = (
	select category_id
	from sakila.category
	where name = 'Comedy'
);

#solution 1
select rating,title
from sakila.film as f
where rating = 'PG-13' and film_id IN (
	select film_id
	from sakila.film_category
	where category_id = (
		select category_id
		from sakila.category
		where name = 'Comedy'
	)
);

#solution2 - Find out the top 3 rented horror movies.
select title,rental_rate
from sakila.film
where film_id IN (
	select film_id
	from sakila.film_category
	where category_id IN (
		select category_id
		from sakila.category
		where name = 'Horror'
	)
)
order by rental_rate desc
limit 3;

#solution3 -  Find out the list of customers from India who have rented sports movies.
select c.customer_id, c.first_name, c.last_name
from sakila.customer c
JOIN sakila.rental r ON c.customer_id = r.customer_id
JOIN sakila.inventory i ON r.inventory_id = i.inventory_id
JOIN sakila.film f ON f.film_id = i.film_id
JOIN sakila.film_category fc ON fc.film_id = f.film_id
JOIN sakila.category c2 ON c2.category_id = fc.category_id
JOIN sakila.address a ON a.address_id = c.address_id
JOIN sakila.city c3 ON c3.city_id = a.city_id
JOIN sakila.country c4 ON c4.country_id = c3.country_id
where c4.country = 'India' AND c2.name = 'Sports'
ORDER BY c.first_name,c.last_name;

#solution4 - Find out the list of customers from Canada who have rented “NICK WAHLBERG” movies.
select c.customer_id, c.first_name, c.last_name,concat(a.first_name,' ',a.last_name) as movie_name
from sakila.customer as c
JOIN sakila.rental as r ON r.customer_id = c.customer_id
JOIN sakila.inventory as i ON i.inventory_id = r.inventory_id
JOIN sakila.film as f ON f.film_id = i.film_id
JOIN sakila.film_actor as fa ON fa.film_id = f.film_id
JOIN sakila.actor as a ON a.actor_id = fa.actor_id
JOIN sakila.address as a1 ON a1.address_id = c.address_id
JOIN sakila.city as c1 ON c1.city_id = a1.city_id
JOIN sakila.country as c2 ON c2.country_id = c1.country_id
where c2.country = 'Canada' AND a.first_name = 'NICK' AND a.last_name = 'WAHLBERG';

#solution5 -  Find out the number of movies in which “SEAN WILLIAMS” acted.
select count(*) as no_of_movies
from sakila.actor as a
JOIN sakila.film_actor as fa ON fa.actor_id = a.actor_id
JOIN sakila.film as f ON f.film_id = fa.film_id
where a.first_name= 'SEAN' AND a.last_name = 'WILLIAMS';


