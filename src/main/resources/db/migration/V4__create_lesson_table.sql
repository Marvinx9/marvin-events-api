create type ENUM_LESSON as ENUM('RECORD', 'LIVE');

create table events.lesson (
	id serial primary key,
	title varchar(100) not null,
	slug varchar(100),
	description text,
	video_id text,
	available_at timestamptz,
	challenge_id integer,
	teacher_id integer,
	lesson_type ENUM_LESSON,
	foreign key (challenge_id) references challenge(id) on delete cascade,
	foreign key (teacher_id) references teacher(id) on delete cascade
);