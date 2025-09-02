package com.events.dto;

import com.events.entities.Challenge;
import com.events.entities.Teacher;
import com.events.enums.LessonType;

import java.time.ZonedDateTime;

public class LessonOutputDto {
    private Long id;
    private String title;
    private String slug;
    private String description;
    private String video_id;
    private ZonedDateTime available_at;
    private Challenge challenge;
    private Teacher teacher;
    private LessonType lesson_type;
}
