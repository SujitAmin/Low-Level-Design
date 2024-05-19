CREATE TABLE users (
                        id BIGINT PRIMARY KEY,
                        birthDate TIMESTAMP,
                        name VARCHAR(255)
);

insert into users (id, birthDate, name) values(10001, CURRENT_TIMESTAMP, 'AB');
insert into users (id, birthDate, name) values(10002, CURRENT_TIMESTAMP, 'Jill');
insert into users (id, birthDate, name) values(10003, CURRENT_TIMESTAMP, 'Jam');