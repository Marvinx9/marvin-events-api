package com.events.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.events.dto.SubscriberInputDto;
import com.events.dto.SubscriberOutputDto;
import com.events.entities.Subscriber;

@Mapper(componentModel = "spring")
public interface SubscriberMapper {
    SubscriberOutputDto paraDto(Subscriber subscriber);

    @Mapping(target= "id", ignore= true)
    Subscriber paraEntidade(SubscriberInputDto subscriberInputDto);
}
