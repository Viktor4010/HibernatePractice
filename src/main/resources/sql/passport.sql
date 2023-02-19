create table Passport(
                         person_id int primary key references Person(id) on delete cascade,
                         passport_number int not null
)