create table category
(
    id         bigserial primary key,
    title      varchar(255),
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp,
    deleted_at timestamp
);

insert into category (id, title)
values (1, 'Drinks'),
       (2, 'Food');

create table product
(
    id          bigserial primary key,
    title       varchar(255),
    price       int,
    category_id bigserial,
    created_at  timestamp default current_timestamp,
    updated_at  timestamp default current_timestamp,
    deleted_at  timestamp
);

insert into product (category_id, title, price)
values (1, 'Tea', 80),
       (1, 'Coffee', 100),
       (1, 'Water', 50),
       (2, 'Meat', 280),
       (2, 'Fish', 300),
       (2, 'Cheese', 250),
       (1, 'Juice', 180),
       (2, 'Bananas', 100),
       (2, 'Carrot', 50),
       (2, 'Onion', 60);

create table users
(
    id       bigserial,
    login    varchar(30) not null,
    password varchar(80) not null,
    email    varchar(50) unique,
    role_id  int,
    primary key (id)
);

create table roles
(
    id   serial,
    name varchar(50) not null,
    primary key (id)
);

CREATE TABLE users_roles
(
    user_id bigint not null,
    role_id int    not null,
    primary key (user_id, role_id),
    foreign key (user_id) references users (id),
    foreign key (role_id) references roles (id)
);

insert into roles (name)
values ('ROLE_USER'),
       ('ROLE_ADMIN');

insert into users (id, login, password, email, role_id)
values (1, 'user1', '$2y$12$KoBlGqSO5Efaci1TW4m3rOxQOtgz8A5XhWz8Jcnby5XkV7ENOJQTC', 'user1@gmail.com', 1),
       (2, 'user2', '$2y$12$KoBlGqSO5Efaci1TW4m3rOxQOtgz8A5XhWz8Jcnby5XkV7ENOJQTC', 'user2@gmail.com', 1),
       (3, 'user3', '$2y$12$KoBlGqSO5Efaci1TW4m3rOxQOtgz8A5XhWz8Jcnby5XkV7ENOJQTC', 'user3@gmail.com', 1)
;

insert into users_roles (user_id, role_id)
values (1, 1),
       (1, 2),
       (2, 1),
       (3, 1);
