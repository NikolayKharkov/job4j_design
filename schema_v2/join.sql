create table departments (
    id serial primary key,
    name varchar(255)
);

create table emploers(
    id serial primary key,
    name varchar(255),
    department_id int references departments(id)
);

insert into departments(name)
values('Южный департамент');
insert into departments(name)
values('Северный департамент');
insert into departments(name)
values('Западный департамент');
insert into departments(name)
values('Восточный департамент');

insert into emploers(name, department_id)
values('Сотрудник 1', 1);
insert into emploers(name, department_id)
values('Сотрудник 2', 1);
insert into emploers(name, department_id)
values('Сотрудник 3', 2);
insert into emploers(name, department_id)
values('Сотрудник 4', 2);
insert into emploers(name, department_id)
values('Сотрудник 5', 2);
insert into emploers(name, department_id)
values('Сотрудник 6', 3);
insert into emploers(name, department_id)
values('Сотрудник 7', 3);
insert into emploers(name, department_id)
values('Сотрудник 8', 3);
insert into emploers(name, department_id)
values('Сотрудник 9', 3);


select *
from departments d
left join emploers e on e.department_id = d.id;

select *
from departments d
right join emploers e on e.department_id = d.id;

select *
from departments d
full join emploers e on e.department_id = d.id;

select *
from departments
cross join emploers;

select d.name
from departments d
left join emploers e on e.department_id = d.id
where e.id is null;

select d.name, e.name
from departments d
left join emploers e on e.department_id = d.id;

select d.name, e.name
from emploers e
right join departments d on d.id = e.department_id;

create table teens(
	id serial primary key,
	name varchar(60),
	gender varchar(1) check (gender in ('M','F'))
);


insert into teens(name, gender)
values ('Мальчик 1', 'M');
insert into teens(name, gender)
values ('Мальчик 2', 'M');
insert into teens(name, gender)
values ('Девочка 1', 'F');
insert into teens(name, gender)
values ('Девочка 2', 'F');
insert into teens(name, gender)
values ('Девочка 3', 'F');

select * 
from teens t1
cross join teens t2
where t1.gender != t2.gender;





 








