package com.events.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.events.dto.LessonInputDto;
import com.events.entities.Challenge;
import com.events.entities.Lesson;
import com.events.entities.Teacher;
import com.events.exception.BadRequest;
import com.events.repository.ChallengeRepository;
import com.events.repository.LessonRepository;
import com.events.repository.TeacherRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LessonService {
    private final LessonRepository lessonRepository;
    private final TeacherRepository teacherRepository;
    private final ChallengeRepository challengeRepository;

    public List<Lesson> list() {
        return lessonRepository.findAll();
    }

    public Lesson create(LessonInputDto lessonInputDto) {
        Teacher teacher = teacherRepository.findById(lessonInputDto.getTeacher_id()).orElseThrow(() -> new BadRequest("Teacher not found with id " + lessonInputDto.getTeacher_id()));
        Challenge challenge = challengeRepository.findById(lessonInputDto.getChallenge_id()).orElseThrow(() -> new BadRequest("Challenge not found with id " + lessonInputDto.getChallenge_id()));
        
        Lesson lesson = new Lesson();
        lesson.setTitle(lessonInputDto.getTitle());
        lesson.setSlug(lessonInputDto.getSlug());
        lesson.setDescription(lessonInputDto.getDescription());
        lesson.setVideoId(lessonInputDto.getVideo_id());
        lesson.setAvailableAt(lessonInputDto.getAvailable_at());
        lesson.setLessonType(lessonInputDto.getLesson_type());
        lesson.setTeacher(teacher);
        lesson.setChallenge(challenge);

        return lessonRepository.save(lesson);
    }
}
