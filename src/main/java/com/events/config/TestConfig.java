package com.events.config;

// import java.time.Instant;
// import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

// import com.events.entities.Challenge;
// import com.events.entities.Lesson;
// import com.events.entities.Teacher;
// import com.events.enums.LessonType;
// import com.events.repository.ChallengeRepository;
// import com.events.repository.LessonRepository;
// import com.events.repository.TeacherRepository;

import lombok.AllArgsConstructor;

@Configuration
@Profile("test")
@AllArgsConstructor
public class TestConfig implements CommandLineRunner {
    // private final TeacherRepository teacherRepository;
    // private final ChallengeRepository challengeRepository;
    // private final LessonRepository lessonRepository;

    // @Override
    // public void run(String... args) throws Exception {
    //     Teacher t1 = new Teacher("Martin Lens", "history teacher, graduated from the University of Canada", "https://avatars.githubusercontent.com/u/132841689?v=4");
    //     Teacher t2 = new Teacher("Louis Andrew", "Phd in applied physics and winner of the international mathematics prize", "https://avatars.githubusercontent.com/u/26119052?v=4");
    //     teacherRepository.saveAll(Arrays.asList(t1, t2));

    //     Challenge c1 = new Challenge("https://feedview-woad.vercel.app");
    //     Challenge c2 = new Challenge("https://feedview-woad.vercel.app");
    //     challengeRepository.saveAll(Arrays.asList(c1, c2));

    //     Lesson l1 = new Lesson("Opening class", "class 1", "Class for initializer trigger on python advanced", "p_heym7pmEk", Instant.parse("2025-09-21T19:00:07Z"), 1L , 1L, LessonType.LIVE);
    //     Lesson l2 = new Lesson("Python Recognition", "class 2", "Locate faces within an image or video stream. This typically involves using pre-trained models like Haar Cascades or more advanced deep learning models.", "p_heym7pmEk", Instant.parse("2025-09-22T19:00:07Z"), 2L , 1L, LessonType.RECORD);
    //     lessonRepository.saveAll(Arrays.asList(l1, l2));
    // }
}
