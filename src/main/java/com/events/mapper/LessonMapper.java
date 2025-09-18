package com.events.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.events.dto.LessonInputDto;
import com.events.dto.LessonOutputDto;
import com.events.entities.Lesson;

@Mapper(componentModel = "spring")
public interface LessonMapper {
    @Mapping(target = "video_id", source = "videoId")
    @Mapping(target = "available_at", source = "availableAt")
    @Mapping(target = "challenge_id", source = "challengeId")
    @Mapping(target = "teacher_id", source = "teacherId")
    @Mapping(target = "lesson_type", source = "lessonType")
    LessonOutputDto paraDto(Lesson teacher);
    
    @Mapping(target= "id", ignore= true)
    @Mapping(target = "videoId", source = "video_id")
    @Mapping(target = "availableAt", source = "available_at")
    @Mapping(target = "challengeId", source = "challenge_id")
    @Mapping(target = "teacherId", source = "teacher_id")
    @Mapping(target = "lessonType", source = "lesson_type")
    Lesson paraEntidade(LessonInputDto lessonInputDto);
}
