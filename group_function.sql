create table devices(
    id serial primary key,
    name varchar(255),
    price float
);

create table people(
    id serial primary key,
    name varchar(255)
);

create table devices_people(
    id serial primary key,
    device_id int references devices(id),
    people_id int references people(id)
);

insert into devices(name, price)
values('LapTop', 7500);
insert into devices(name, price)
values('SmartPhone', 4000);
insert into devices(name, price)
values('GameConsole', 6000);

insert into people(name) 
values('Katya');
insert into people(name) 
values('Anna');
insert into people(name) 
values('Misha');

insert into devices_people(device_id, people_id)
values(2, 1);
insert into devices_people(device_id, people_id)
values(1, 2);
insert into devices_people(device_id, people_id)
values(2, 2);
insert into devices_people(device_id, people_id)
values(2, 3);
insert into devices_people(device_id, people_id)
values(3, 3);

select round(avg(d.price)::numeric,2)
from devices d;

select p.name, round(avg(d.price)::numeric,2)
from devices_people dp
join people p on p.id = dp.people_id
join devices d on d.id = dp.device_id
group by p.id;

select p.name, round(avg(d.price)::numeric,2)
from devices_people dp
join people p on p.id = dp.people_id
join devices d on d.id = dp.device_id
group by p.id
having round(avg(d.price)::numeric,2) > 5000;







