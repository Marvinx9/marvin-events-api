package com.events.entities;

import java.time.Instant;

import com.events.enums.LessonType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private Instant availableAt;

    @Column(name = "challenge_id")
    private Long challengeId;

    @Column(name = "teacher_id")
    private Long teacherId;

    @Enumerated(EnumType.STRING)
    @Column(name = "lesson_type", columnDefinition = "ENUM_LESSON")
    private LessonType lessonType;

    public Lesson( String title, String slug, String description, String videoId, Instant availableAt, Long teacherId, Long challengeId, LessonType lessonType) {
        this.availableAt = availableAt;
        this.challengeId = challengeId;
        this.description = description;
        this.lessonType = lessonType;
        this.slug = slug;
        this.teacherId = teacherId;
        this.title = title;
        this.videoId = videoId;
    }


}
