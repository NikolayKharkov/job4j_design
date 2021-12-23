create table bodies (
    id serial primary key,
    name varchar(255)
);

create table engines(
    id serial primary key,
    name varchar(255)
);

create table transmissions(
    id serial primary key,
    name varchar(255)
);

create table cars(
    id serial primary key,
    name varchar(255),
	body_id int references bodies(id),
	engine_id int references engines(id),
	transmission_id int references transmissions(id)
);

insert into bodies(name)
values('Седан');
insert into bodies(name)
values('Универсал');
insert into bodies(name)
values('Хэтчбек');

insert into engines(name)
values('Бензиновый  двигатель');
insert into engines(name)
values('Дизельные  двигатель');
insert into engines(name)
values('Электро двигатель');

insert into transmissions(name)
values('Механическая коробка');
insert into transmissions(name)
values('Автоматическая коробка');
insert into transmissions(name)
values('Роботизированная коробка');

insert into cars(name, body_id, engine_id, transmission_id)
values('Машина 1', 1, 2, 2);
insert into cars(name, body_id, engine_id, transmission_id)
values('Машина 2', 2, 2, 2);
insert into cars(name, body_id, engine_id, transmission_id)
values('Машина 3', 1, 2, 2);
insert into cars(name, body_id, engine_id, transmission_id)
values('Машина 4', 1, 1, 1);
insert into cars(name, body_id, engine_id, transmission_id)
values('Машина 5', 2, 1, 1);

select c.name, b.name, e.name, t.name
from cars c
join bodies b on b.id = c.body_id
join engines e on e.id = c.engine_id
join transmissions t on t.id = c.transmission_id;

select b.name
from bodies b
left join cars c on c.body_id = b.id
where c.id is null;

select e.name
from engines e
left join cars c on c.engine_id = e.id
where c.id is null;
 
select t.name
from transmissions t
left join cars c on c.body_id = t.id
where c.id is null;

create view cars_info
    as select c.name as car_name,
              b.name as body_name,
              e.name as engine_name,
              t.name as transmission_name
	   from cars c
	   join bodies b on b.id = c.body_id
       join engines e on e.id = c.engine_id
	   join transmissions t on t.id = c.transmission_id
	   where b.id = 3
	         and e.id = 1
	         and t.id = 2
	         and lower(c.name) like '%2%';
	   

select * from cars_info;










