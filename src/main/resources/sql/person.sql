create table person(
                       id int primary key generated by default as identity ,
                       name varchar(100) not null ,
                       age int check ( age < 100 )
);

insert into person(name, age) VALUES ('Tom',35);
insert into person(name, age) VALUES ('Bob',52);
insert into person(name, age) VALUES ('Katy',14);