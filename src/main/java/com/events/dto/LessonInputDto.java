package com.events.dto;

import java.time.Instant;

import com.events.enums.LessonType;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class LessonInputDto {
    @NotNull
    @NotBlank
    private String title;

    @NotNull
    @NotBlank
    private String slug;

    private String description;

    private Long video_id;

    private Instant available_at;

    private Long challenge_id;

    @NotNull
    private Long teacher_id;

    private LessonType lesson_type;
}
