create table pocgraphql.product
(
    id    bigserial    not null,
    name  varchar(100) not null,
    value float        not null,

    primary key (id)
)