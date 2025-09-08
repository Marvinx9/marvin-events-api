package com.events.mapper;

import com.events.dto.LessonOutputDto;
import com.events.entities.Lesson;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.events.dto.LessonInputDto;

@Mapper(componentModel = "spring")
public interface LessonMapper {
    @Mapping(target = "video_id", source = "videoId")
    @Mapping(target = "available_at", source = "availableAt")
    @Mapping(target = "challenge_id", source = "challenge.id")
    @Mapping(target = "teacher_id", source = "teacher.id")
    @Mapping(target = "lesson_type", source = "lessonType")
    LessonOutputDto paraDto(Lesson lesson);

    @Mapping(target = "videoId", source = "video_id")
    @Mapping(target = "availableAt", source = "available_at")
    @Mapping(target = "challenge", source = "challenge_id")
    @Mapping(target = "teacher", source = "teacher_id")
    @Mapping(target = "lessonType", source = "lesson_type")
    Lesson paraEntidade(LessonInputDto lessonInputDto);
}
