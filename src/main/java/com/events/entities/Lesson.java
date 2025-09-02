package com.events.entities;

import com.events.enums.LessonType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Entity
@NoArgsConstructor
@Table(name = "lesson", schema = "events")
@Data
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "slug")
    private String slug;

    @Column(name = "description")
    private String description;

    @Column(name = "video_id")
    private String videoId;

    @Column(name = "available_at")
    private ZonedDateTime availableAt;

    @JoinColumn(name = "challenge_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_lesson_challenge"))
    @ManyToOne(fetch = FetchType.LAZY)
    private Challenge challenge;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_lesson_teacher"))
    private Teacher teacher;

    @Enumerated(EnumType.STRING)
    @Column(name = "lesson_type", columnDefinition = "ENUM_LESSON")
    private LessonType lessonType;
}
