create schema events;

create table events.teacher (
	id serial primary key,
	name varchar(100) not null,
	bio text,
	avatar_url text
);