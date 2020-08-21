create schema public;

comment on schema public is 'standard public schema';

alter schema public owner to postgres;

create table if not exists book
(
  id uuid not null
    constraint book_pk
      primary key,
  name varchar(255) not null,
  created timestamp default now() not null,
  description varchar(255),
  available boolean default false not null
);

alter table book owner to postgres;

create unique index if not exists book_id_uindex
  on book (id);

create unique index if not exists book_name_uindex
  on book (name);

create table if not exists school
(
  id uuid not null
    constraint school_pk
      primary key,
  name varchar(255) not null,
  open boolean default true not null
);

alter table school owner to postgres;

create unique index if not exists school_id_uindex
  on school (id);

create unique index if not exists school_name_uindex
  on school (name);

create table if not exists library
(
  id uuid not null
    constraint library_pk
      primary key,
  school uuid not null
    constraint fk_library_school
      references school,
  name varchar(255) not null,
  open boolean default true not null
);

alter table library owner to postgres;

create unique index if not exists library_id_uindex
  on library (id);

create unique index if not exists library_name_uindex
  on library (name);

create table if not exists director
(
  id uuid not null
    constraint principal_pk
      primary key,
  first_name varchar(255) not null,
  library uuid not null
    constraint fk_principal_library
      references library,
  birth_date timestamp not null
);

alter table director owner to postgres;

create unique index if not exists principal_id_uindex
  on director (id);

create unique index if not exists principal_name_uindex
  on director (first_name);

create table if not exists shopuser
(
  id uuid not null
    constraint user_pk
      primary key,
  login varchar(255) not null,
  password varchar(255) not null,
  first_name varchar(255) not null,
  role varchar(255) not null
);

alter table shopuser owner to postgres;

create unique index if not exists user_id_uindex
  on shopuser (id);

create unique index if not exists user_login_uindex
  on shopuser (login);