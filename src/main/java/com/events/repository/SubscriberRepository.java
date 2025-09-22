package com.events.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.events.entities.Subscriber;

public interface SubscriberRepository extends JpaRepository<Subscriber, Long> {
}
