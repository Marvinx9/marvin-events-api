package com.events.dto;

import java.time.Instant;

import com.events.enums.LessonType;

import lombok.Data;

@Data
public class LessonOutputDto {
    private Long id;
    private String title;
    private String slug;
    private String description;
    private String video_id;
    private Instant available_at;
    private Long challenge_id;
    private Long teacher_id;
    private LessonType lesson_type;
}
