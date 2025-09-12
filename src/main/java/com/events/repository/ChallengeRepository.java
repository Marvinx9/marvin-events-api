package com.events.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.events.entities.Challenge;

public interface ChallengeRepository extends JpaRepository<Challenge, Long> {
}
