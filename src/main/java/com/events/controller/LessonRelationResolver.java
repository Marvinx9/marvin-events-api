package com.events.controller;

import com.events.dto.ChallengeOutputDto;
import com.events.dto.TeacherOutputDto;
import com.events.entities.Lesson;
import com.events.enums.LessonType;
import com.events.mapper.ChallengeMapper;
import com.events.mapper.TeacherMapper;
import com.events.repository.ChallengeRepository;
import com.events.repository.TeacherRepository;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.time.Instant;

@Controller
@AllArgsConstructor
public class LessonRelationResolver {
    private final TeacherRepository teacherRepository;
    private final ChallengeRepository challengeRepository;
    private final TeacherMapper teacherMapper;
    private final ChallengeMapper challengeMapper;

    @SchemaMapping(typeName = "lesson", field = "teacher")
    public TeacherOutputDto getTeacher(Lesson lesson) {
        return teacherRepository.findById(lesson.getTeacherId()).map(teacherMapper::paraDto).orElse(null);
    }

    @SchemaMapping(typeName = "lesson", field = "challenge")
    public ChallengeOutputDto getChallenge(Lesson lesson) {
        return challengeRepository.findById(lesson.getChallengeId()).map(challengeMapper::paraDto).orElse(null);
    }

    @SchemaMapping(typeName = "lesson", field = "video_id")
    public String getVideoId(Lesson lesson) {
        return lesson.getVideoId();
    }

    @SchemaMapping(typeName = "lesson", field = "available_at")
    public Instant getAvailableAt(Lesson lesson) {
        return lesson.getAvailableAt();
    }

    @SchemaMapping(typeName = "lesson", field = "lesson_type")
    public LessonType getLessonType(Lesson lesson) {
        return lesson.getLessonType();
    }
}
