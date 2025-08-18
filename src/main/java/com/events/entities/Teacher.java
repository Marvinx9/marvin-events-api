package com.events.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "teacher")
@Data
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "bio")
    private String bio;

    @Column(name = "avatar_url")
    private String avatarUrl;

    public Teacher(String name, String bio, String avatarUrl) {
        this.name = name;
        this.bio = bio;
        this.avatarUrl = avatarUrl;
    }
}
