package com.events.entities;

import java.time.Instant;

import com.events.enums.LessonType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
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

    @JoinColumn(name = "challenge_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_lesson_challenge"))
    @ManyToOne(fetch = FetchType.LAZY)
    private Long challengeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_lesson_teacher"))
    private Long teacherId;

    @Enumerated(EnumType.STRING)
    @Column(name = "lesson_type", columnDefinition = "ENUM_LESSON")
    private LessonType lessonType;
}
