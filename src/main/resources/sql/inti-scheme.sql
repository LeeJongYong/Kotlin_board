create table if not exists user
(
    id          varchar(16) primary key,
    username    varchar(100),
    email       varchar(100),
    password    varchar(100),
    cret_dt     DATETIME,
    mdfy_dt     DATETIME,
    index idx_id (id),
);