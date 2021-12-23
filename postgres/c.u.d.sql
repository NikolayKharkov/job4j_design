create table company (
id serial primary key,
v_name varchar(100),
n_capitalization numeric,
b_foreign boolean
);

select * from company;

insert into company(v_name, n_capitalization, b_foreign) 
values ('Google', 100000000, true);

insert into company(v_name, n_capitalization, b_foreign) 
values ('Yandex', 5000000, false);

select * from company;

update company 
set n_capitalization = n_capitalization + 100000;

delete from company;

select * from company;


