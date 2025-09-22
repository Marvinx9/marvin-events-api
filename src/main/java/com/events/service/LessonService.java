package com.events.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.events.dto.LessonInputDto;
import com.events.dto.LessonOutputDto;
import com.events.entities.Lesson;
import com.events.exception.NotFound;
import com.events.mapper.LessonMapper;
import com.events.repository.LessonRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LessonService {
    private final LessonRepository lessonRepository;
    private final LessonMapper lessonMapper;

    public List<Lesson> list() {
        return lessonRepository.findAll();
    }

     public Lesson find(Long id) {
        return lessonRepository.findById(id).orElseThrow(() -> new NotFound("Lesson not found, id: " + id));
    }

    public Lesson findBySlug(String slug) {
        return lessonRepository.findBySlug(slug).orElseThrow(() -> new NotFound("Lesson not found, slug: " + slug));
    }

    public LessonOutputDto create(LessonInputDto lessonInputDto) {
        Lesson lesson = lessonRepository.save(lessonMapper.paraEntidade(lessonInputDto));
        return lessonMapper.paraDto(lesson);
    }
}
