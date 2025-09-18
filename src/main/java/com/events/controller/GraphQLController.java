package com.events.controller;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.events.dto.LessonInputDto;
import com.events.dto.LessonOutputDto;
import com.events.dto.TeacherInputDto;
import com.events.dto.TeacherOutputDto;
import com.events.service.LessonService;
import com.events.service.TeacherService;

@Controller
public class GraphQLController {
    private final TeacherService teacherService;
    private final LessonService lessonService;

    public GraphQLController(TeacherService teacherService, LessonService lessonService) {
        this.teacherService = teacherService;
        this.lessonService = lessonService;
    }

    @QueryMapping
    public List<TeacherOutputDto> listTeacher() {
        return teacherService.list();
    }

    @QueryMapping
    public TeacherOutputDto findTeacher(@Argument Long id) {
        return teacherService.find(id);
    }

    @MutationMapping
    public TeacherOutputDto createTeacher(@Argument("teacher") TeacherInputDto teacherInputDto) {
        return teacherService.create(teacherInputDto);
    }

    @QueryMapping
    public List<LessonOutputDto> listLesson() {
        return lessonService.list();
    }

    @QueryMapping
    public LessonOutputDto findLesson(@Argument Long id) {
        return lessonService.find(id);
    }

    @MutationMapping
    public LessonOutputDto createLesson(@Argument("lesson") LessonInputDto lessonInputDto) {
        return lessonService.create(lessonInputDto);
    }
}
