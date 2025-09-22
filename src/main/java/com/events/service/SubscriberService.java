package com.events.service;

import org.springframework.stereotype.Service;

import com.events.dto.SubscriberInputDto;
import com.events.dto.SubscriberOutputDto;
import com.events.entities.Subscriber;
import com.events.mapper.SubscriberMapper;
import com.events.repository.SubscriberRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SubscriberService {
    private final SubscriberRepository teacherRepository;
    private final SubscriberMapper subscriberMapper;

    public SubscriberOutputDto create(SubscriberInputDto subscriberInputDto) {
        Subscriber subscriber = teacherRepository.save(subscriberMapper.paraEntidade(subscriberInputDto));
        return subscriberMapper.paraDto(subscriber);
    }
}
