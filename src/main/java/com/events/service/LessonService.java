package com.events.service;

import com.events.dto.LessonOutputDto;
import com.events.mapper.LessonMapper;
import com.events.repository.LessonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LessonService {
    private final LessonRepository lessonRepository;
    private final LessonMapper lessonMapper;

    public List<LessonOutputDto> list() {
        return lessonRepository.findAll().stream().map(lessonMapper::paraDto).toList();
    }
}
