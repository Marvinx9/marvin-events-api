package com.events.service;

import com.events.dto.TeacherOutputDto;
import com.events.entities.Teacher;
import com.events.exception.NotFound;
import com.events.mapper.TeacherMapper;
import com.events.repository.TeacherRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TeacherService {
    private final TeacherRepository teacherRepository;
    private final TeacherMapper teacherMapper;

    public List<TeacherOutputDto> list() {
        return teacherRepository.findAll().stream().map(teacherMapper::paraDto).toList();
    }

    public TeacherOutputDto find(Long id) {
        Teacher teacher = teacherRepository.findById(id).orElseThrow(() -> new NotFound("Teacher not found, id: " + id));
        return teacherMapper.paraDto(teacher);
    }

    public TeacherOutputDto create(String name, String bio, String avatar_url) {
        Teacher teacher = teacherRepository.save(new Teacher(name, bio, avatar_url));
        return teacherMapper.paraDto(teacher);
    }
}
