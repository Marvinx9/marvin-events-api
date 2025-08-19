create table events.subscriber (
	id serial primary key,
	name varchar(100) not null,
	email varchar(100) not null
);