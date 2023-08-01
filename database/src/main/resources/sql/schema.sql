# USE practicum;

DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS roles;

CREATE TABLE roles
(
    id   bigint PRIMARY KEY AUTO_INCREMENT,
    role varchar(128) NOT NULL UNIQUE
);

CREATE TABLE users
(
    id        bigint PRIMARY KEY AUTO_INCREMENT,
    name      varchar(20) NOT NULL,
    last_name varchar(40) NOT NULL,
    mid_name varchar(40) NOT NULL,
    email     varchar(50) NOT NULL UNIQUE,
    role_id   int NOT NULL REFERENCES roles (id) ON UPDATE CASCADE ON DELETE CASCADE
);
