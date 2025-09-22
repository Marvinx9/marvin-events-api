package com.events.mapper;

import com.events.dto.ChallengeOutputDto;
import com.events.entities.Challenge;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ChallengeMapper {
    ChallengeOutputDto paraDto(Challenge challenge);
}
