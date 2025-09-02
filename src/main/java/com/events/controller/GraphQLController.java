package com.events.controller;

import com.events.dto.LessonOutputDto;
import com.events.dto.TeacherOutputDto;
import com.events.service.LessonService;
import com.events.service.TeacherService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

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
    public List<LessonOutputDto> listLesson() {
        return lessonService.list();
    }

    @QueryMapping
    public TeacherOutputDto findTeacher(@Argument Long id) {
        return teacherService.find(id);
    }

    @MutationMapping
    public TeacherOutputDto createTeacher(@Argument String name, @Argument String bio, @Argument String avatar_url) {
        return teacherService.create(name, bio, avatar_url);
    }
}
