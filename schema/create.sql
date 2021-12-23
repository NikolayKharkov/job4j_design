create table role_right(
	id serial primary key,
	right_name varchar(255)
);

create table role(
	id serial primary key,
	role_name varchar(255),	
	right_id int references role_right(id)
);

create table users(
	id serial primary key,
	user_name varchar(255),
	role_id int references role(id)
);

create table statuses_items(
	id serial primary key,
	status_name varchar(255)
);

create table categories_items(
	id serial primary key,
	category_name varchar(255)
);

create table items(
	id serial primary key,
	user_id int references users(id),
	item_stattus int references statuses_items(id),
	item_category int references categories_items(id)
);

create table comments(
	id serial primary key,
	item_id int references items(id),
	comment text
);

create table attachs(
	id serial primary key,
	item_id int references items(id),
	attach varchar(255)
);




