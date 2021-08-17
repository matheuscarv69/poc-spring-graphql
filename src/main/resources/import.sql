create table public.client
(
    id    bigserial primary key,
    email varchar(255) null,
    name  varchar(255) null
);

create table public.product
(
    id    bigserial primary key,
    name  varchar(255) null,
    value float        not null
);

create table public.purchase
(
    id         bigserial primary key,
    date       timestamp    null,
    quantity   int          null,
    status     varchar(255) null,
    client_id  bigint       null,
    product_id bigint       null,
    constraint FK_PURCHASE_PRODUCT foreign key (product_id) references public.product (id),
    constraint FK_PURCHASE_CLIENT foreign key (client_id) references public.client (id)
);

INSERT INTO public.client (email, name)
VALUES ('a@a.com', 'Cliente A');
INSERT INTO public.client (email, name)
VALUES ('b@b.com', 'Cliente B');
INSERT INTO public.client (email, name)
VALUES ('c@c.com', 'Cliente C');

INSERT INTO public.product (name, value)
VALUES ('Boné', 25);
INSERT INTO public.product (name, value)
VALUES ('Bola', 120);
INSERT INTO public.product (name, value)
VALUES ('Bermuda', 60);
INSERT INTO public.product (name, value)
VALUES ('Camiseta', 80);
INSERT INTO public.product (name, value)
VALUES ('Chuteira', 130);