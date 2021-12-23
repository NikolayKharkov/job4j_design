 create table company(
     id serial primary key,
     name varchar(255),
	 country_id int references country(id)
 );
 
create table country(
    id serial primary key,
    name varchar(255)
);