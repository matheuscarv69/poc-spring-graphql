create table pocgraphql.client
(
    id    bigserial    not null,
    name  varchar(100) not null,
    email varchar(100) not null,

    primary key (id)
)