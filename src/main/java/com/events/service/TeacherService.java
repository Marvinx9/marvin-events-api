package com.events.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.events.entities.Teacher;
import com.events.repository.TeacherRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TeacherService {
    private final TeacherRepository teacherRepository;

    public List<Teacher> list() {
        return teacherRepository.findAll();
    }

    public Teacher create(String name, String bio, String avatar_url) {
        Teacher teacher = new Teacher(name, bio, avatar_url);
        return teacherRepository.save(teacher);
    }
}
