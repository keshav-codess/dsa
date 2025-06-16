# Write your MySQL query statement below
delete p from person p where p.id not in ( select min_id from ( select min(id) as min_id from Person group by email) as min_id);