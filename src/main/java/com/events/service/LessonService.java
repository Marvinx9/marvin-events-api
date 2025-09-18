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

    public List<LessonOutputDto> list() {
        return lessonRepository.findAll().stream().map(lessonMapper::paraDto).toList();
    }

     public LessonOutputDto find(Long id) {
        Lesson lesson = lessonRepository.findById(id).orElseThrow(() -> new NotFound("Lesson not found, id: " + id));
        return lessonMapper.paraDto(lesson);
    }

    public LessonOutputDto create(LessonInputDto lessonInputDto) {
        Lesson lesson = lessonRepository.save(lessonMapper.paraEntidade(lessonInputDto));
        return lessonMapper.paraDto(lesson);
    }
}
