package com.events.mapper;

import com.events.dto.LessonOutputDto;
import com.events.entities.Lesson;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LessonMapper {
    @Mapping(target = "video_id", source = "videoId")
    @Mapping(target = "available_at", source = "availableAt")
    @Mapping(target = "challenge_id", source = "challengeId")
    @Mapping(target = "teacher_id", source = "teacherId")
    @Mapping(target = "lesson_type", source = "lessonType")
    LessonOutputDto paraDto(Lesson lesson);
}
