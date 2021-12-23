create table type(
    id serial primary key,
    name varchar(255)
);

create table product(
    id serial primary key,
    name varchar(255),
    type_id int references type(id),
	expired_date date,
	price int
);

insert into type(name)
values('Сыр');
insert into type(name)
values('Мясо');
insert into type(name)
values('Фрукт');

insert into product(name, type_id, expired_date, price)
values('Унылый фермер', 1, '2021-06-03', 135);
insert into product(name, type_id, expired_date, price)
values('Lamber', 1, '2022-01-15', 210);
insert into product(name, type_id, expired_date, price)
values('Новгородский молочник', 1, '2021-12-23', 167);

insert into product(name, type_id, expired_date, price)
values('Мраморная говядина', 2, '2022-03-21', 560);
insert into product(name, type_id, expired_date, price)
values('Свина', 2, '2022-04-01', 340);
insert into product(name, type_id, expired_date, price)
values('Фарш говяжий', 2, '2022-07-15', 220);

insert into product(name, type_id, expired_date, price)
values('Яблоко', 3, '2022-01-28', 44);
insert into product(name, type_id, expired_date, price)
values('Апельсин', 3, '2022-02-10', 56);
insert into product(name, type_id, expired_date, price)
values('Банан', 3, '2022-01-07', 27);
insert into product(name, type_id, expired_date, price)
values('Фруктовое ассорти. Мороженное', 3, '2022-06-07', 150);


select p.name, p.price, p.expired_date
from type t 
join product p on p.type_id = t.id
where lower(t.name) = 'сыр';

select p.name, p.price, p.expired_date
from product p
where lower(p.name) like '%мороженное%';

select p.name, p.price, p.expired_date
from product p
where p.expired_date <= current_date;

select p.name, p.price, p.expired_date
from product p
where p.price in (select max(price) from product);

select t.name, count(p.id)
from product p
join type t on t.id = p.type_id
group by t.id;

select p.name, p.price, p.expired_date
from type t 
join product p on p.type_id = t.id and lower(t.name) in ('сыр', 'молоко');

select t.name, count(p.id)
from product p
join type t on t.id = p.type_id
group by t.id
having count(p.id) < 10;

select t.name, p.name
from type t 
join product p on p.type_id = t.id;



 








