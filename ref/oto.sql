 create table company(
     id serial primary key,
     name varchar(255)
 );
 
create table patents(
    id serial primary key,
    name varchar(255),
    id_company int references company(id) unique
);