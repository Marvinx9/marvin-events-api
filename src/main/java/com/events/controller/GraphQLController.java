package com.events.controller;

import java.util.List;

import jakarta.validation.Valid;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.events.dto.LessonInputDto;
import com.events.dto.LessonOutputDto;
import com.events.dto.SubscriberInputDto;
import com.events.dto.SubscriberOutputDto;
import com.events.dto.TeacherInputDto;
import com.events.dto.TeacherOutputDto;
import com.events.entities.Lesson;
import com.events.service.LessonService;
import com.events.service.SubscriberService;
import com.events.service.TeacherService;

@Controller
public class GraphQLController {
    private final TeacherService teacherService;
    private final LessonService lessonService;
    private final SubscriberService subscriberService;

    public GraphQLController(TeacherService teacherService, LessonService lessonService, SubscriberService subscriberService) {
        this.teacherService = teacherService;
        this.lessonService = lessonService;
        this.subscriberService = subscriberService;
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
    public List<Lesson> listLesson() {
        return lessonService.list();
    }

    @QueryMapping
    public Lesson findLesson(@Argument Long id) {
        return lessonService.find(id);
    }

    @QueryMapping
    public Lesson findLessonBySlug(@Argument String slug) {
        return lessonService.findBySlug(slug);
    }

    @MutationMapping
    public LessonOutputDto createLesson(@Argument("lesson") LessonInputDto lessonInputDto) {
        return lessonService.create(lessonInputDto);
    }

    @MutationMapping
    public SubscriberOutputDto createSubscriber(@Argument("subscriber") @Valid SubscriberInputDto subscriberInputDto) {
        return subscriberService.create(subscriberInputDto);
    }
}
