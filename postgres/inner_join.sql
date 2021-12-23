create table campaigns (
    id serial primary key,
    name varchar(100),
    country varchar(50)
);

create table aircrafts (
    id serial primary key,
    campaign_id int references campaigns(id),
    name varchar(100),
    pax_capacity int,
	far_trunk boolean
);

insert into campaigns(name, country)
values ('AirBus','France');

insert into campaigns(name, country)
values ('Boeing','USA');

insert into aircrafts(campaign_id, name, pax_capacity, far_trunk)
values (1, 'A320', 189, false);

insert into aircrafts(campaign_id, name, pax_capacity, far_trunk)
values (1, 'A321', 252, false);

insert into aircrafts(campaign_id, name, pax_capacity, far_trunk)
values (1, 'A381', 450, true);

insert into aircrafts(campaign_id, name, pax_capacity, far_trunk)
values (2, 'B737', 180, false);

insert into aircrafts(campaign_id, name, pax_capacity, far_trunk)
values (2, 'B787', 530, true);

select cp.name as Компания,
       cp.country as Страна,
	   air.name as Модель,
	   air.pax_capacity as Вместительность,
	   air.far_trunk as Дальний
from campaigns as cp
join aircrafts as air on cp.id = air.campaign_id;

select cp.name as Компания,
       cp.country as Страна,
	   air.name as Модель,
	   air.pax_capacity as Вместительность,
	   air.far_trunk as Дальний
from campaigns as cp
join aircrafts as air on cp.id = air.campaign_id and air.far_trunk is false;

select cp.name as Компания,
       cp.country as Страна,
	   air.name as Модель,
	   air.pax_capacity as Вместительность,
	   air.far_trunk as Дальний
from campaigns as cp
join aircrafts as air on cp.id = air.campaign_id 
where cp.country = 'USA';

select cp.name as Компания,
       cp.country as Страна,
	   air.name as Модель,
	   air.pax_capacity as Вместительность,
	   air.far_trunk as Дальний
from campaigns as cp
join aircrafts as air on cp.id = air.campaign_id and air.pax_capacity >= 200;






