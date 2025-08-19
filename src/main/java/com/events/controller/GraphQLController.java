package com.events.controller;

import com.events.entities.Teacher;
import com.events.service.TeacherService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class GraphQLController {
    private final TeacherService teacherService;

    public GraphQLController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @QueryMapping
    public List<Teacher> listTeacher() {
        return teacherService.list();
    }

    @MutationMapping
    public Teacher createUser(@Argument String name, @Argument String bio, @Argument String avatar_url) {
        return teacherService.create(name, bio, avatar_url);
    }
}
