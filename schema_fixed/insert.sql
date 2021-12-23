insert into role_right(right_name)
values('Права пользователя');

insert into role(role_name, right_id)
values('Пользователь', 3);

insert into users(user_name , role_id)
values('Пользователь_1', 4);

insert into statuses_items(status_name)
values('Открыт');
insert into statuses_items(status_name)
values('Закрыт');
insert into statuses_items(status_name)
values('Заблокирован');

insert into categories_items(category_name)
values('Техника');
insert into categories_items(category_name)
values('Все для кухни');
insert into categories_items(category_name)
values('Все для спальни');

insert into items(user_id, item_stattus, item_category)
values(4, 4, 4);

insert into comments(item_id, comment )
values(3, 'Просто комментарий, который не имеет смыла');

insert into attachs(item_id, attach)
values(3, 'photo.png');




