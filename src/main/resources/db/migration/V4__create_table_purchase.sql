create table pocgraphql.purchase
(
    id         bigserial   not null,
    quantity   bigint      not null,
    createdAt  timestamp   not null,
    status     varchar(20) not null,
    client_id  bigint      not null,
    product_id bigint      not null,

    primary key (id),
    foreign key (client_id) references pocgraphql.client (id),
    foreign key (product_id) references pocgraphql.product (id)
)