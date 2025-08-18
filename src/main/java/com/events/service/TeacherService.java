package com.events.service;

import com.events.entities.Teacher;
import com.events.repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {
    private final TeacherRepository teacherRepository;

    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public List<Teacher> list() {
        return teacherRepository.findAll();
    }

    public Teacher create(String name, String bio, String avatar_url) {
        Teacher teacher = new Teacher(name, bio, avatar_url);
        return teacherRepository.save(teacher);
    }
}
