package com.events.entities;

import java.time.Instant;

import com.events.enums.LessonType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name= "challenge_id")
    private Challenge challenge;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name= "teacher_id")
    private Teacher teacher;

    @Enumerated(EnumType.STRING)
    @Column(name = "lesson_type")
    private LessonType lessonType;

    public Lesson( String title, String slug, String description, String videoId, Instant availableAt, Teacher teacher, Challenge challenge, LessonType lessonType) {
        this.availableAt = availableAt;
        this.challenge = challenge;
        this.description = description;
        this.lessonType = lessonType;
        this.slug = slug;
        this.teacher = teacher;
        this.title = title;
        this.videoId = videoId;
    }


}
