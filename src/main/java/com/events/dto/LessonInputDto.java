package com.events.dto;

import java.time.ZonedDateTime;

import com.events.enums.LessonType;

import lombok.Data;

@Data
public class LessonInputDto {
    private String title;
    private String slug;
    private String description;
    private Long video_id;
    private ZonedDateTime available_at;
    private Long challenge_id;
    private Long teacher_id;
    private LessonType lesson_type;
}
