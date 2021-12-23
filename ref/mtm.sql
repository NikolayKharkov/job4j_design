 create table company(
     id serial primary key,
     name varchar(255)
 );
 
 create table offices(
     id serial primary key,
     address varchar(255)
 );
 
 create table company_offices(
     id serial primary key,
     company_id int references company(id),
     office_id int references offices(id)
 );