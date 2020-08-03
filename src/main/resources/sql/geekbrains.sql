create schema public;

comment on schema public is 'standard public schema';

alter schema public owner to postgres;

create table student
(
  id uuid not null
    constraint student_pk
      primary key,
  name varchar(255) not null,
  birth_date timestamp not null,
  graduated boolean default false not null,
  last_name varchar(255),
  birthdate timestamp
);

alter table student owner to postgres;

create unique index student_name_uindex
  on student (name);

create table book
(
  id uuid not null
    constraint book_pk
      primary key,
  name varchar(255) not null,
  created timestamp default now() not null,
  description varchar(255),
  available boolean default false not null,
  student uuid
    constraint fk_book_students
      references student
);

alter table book owner to postgres;

create unique index book_id_uindex
  on book (id);

create unique index book_name_uindex
  on book (name);

create table subject
(
  id uuid not null
    constraint subject_pk
      primary key,
  name varchar(255) not null,
  description varchar
);

alter table subject owner to postgres;

create unique index subject_id_uindex
  on subject (id);

create table student_subject
(
  student uuid not null
    constraint fk_student_subject_student
      references student,
  subject uuid not null
    constraint fk_student_subject_subject
      references subject
);

alter table student_subject owner to postgres;

create unique index index_student_subject
  on student_subject (student, subject);

