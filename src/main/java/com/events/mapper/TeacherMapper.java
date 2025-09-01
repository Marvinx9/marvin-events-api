package com.events.mapper;

import com.events.dto.TeacherOutputDto;
import com.events.entities.Teacher;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TeacherMapper {
    @Mapping(target = "avatar_url", source = "avatarUrl")
    TeacherOutputDto paraDto(Teacher teacher);
}
