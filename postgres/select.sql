create table fauna (
    id serial primary key,
    name text,
    avg_age int,
    discovery_date date
);

insert into fauna(name, avg_age, discovery_date)
values ('Walking fish', 50000, '1896-05-01');

insert into fauna(name, avg_age, discovery_date)
values ('Flying elephant', 15789, '1678-12-01');

insert into fauna(name, avg_age, discovery_date)
values ('Dragons', 5687446, null);

insert into fauna(name, avg_age, discovery_date)
values ('Unicorn', 10443, '2021-12-23');


select * from fauna
where name like '%fish%';

select * from fauna
where avg_age >= 10000 and avg_age <= 21000;

select * from fauna
where discovery_date is null;

select * from fauna
where EXTRACT(YEAR FROM discovery_date) < 1950;





