package com.events.config;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.events.entities.Challenge;
import com.events.entities.Lesson;
import com.events.entities.Teacher;
import com.events.repository.ChallengeRepository;
import com.events.repository.TeacherRepository;

import lombok.AllArgsConstructor;

@Configuration
@Profile("test")
@AllArgsConstructor
public class TestConfig implements CommandLineRunner {
    private final TeacherRepository teacherRepository;
    private final ChallengeRepository challengeRepository;

    @Override
    public void run(String... args) throws Exception {
        Teacher t1 = new Teacher("Martin Lens", "history teacher, graduated from the University of Canada", "https://avatars.githubusercontent.com/u/132841689?v=4");
        Teacher t2 = new Teacher("Louis Andrew", "Phd in applied physics and winner of the international mathematics prize", "https://avatars.githubusercontent.com/u/26119052?v=4");
        teacherRepository.saveAll(Arrays.asList(t1, t2));

        Challenge c1 = new Challenge("http://challenge-test");
        Challenge c2 = new Challenge("http://challenge-usua-test");
        challengeRepository.saveAll(Arrays.asList(c1, c2));

        Lesson l1 = new Lesson("Opening class", "class 1", )
    }
}
