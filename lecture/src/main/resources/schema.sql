drop table if exists game cascade;
drop table if exists player cascade;
drop table if exists dealer cascade;
drop table if exists hand cascade;


create table if not exists game
(
    game_id   serial primary key,
    player_id uuid not null,
    dealer_id uuid not null
);

create table if not exists player
(
    player_id uuid primary key
);

create table if not exists dealer
(
    dealer_id uuid primary key
);

create table if not exists hand
(
    hand_id   serial primary key,
    holder_id uuid not null,
    mark      text   not null,
    number    text   not null
);