package com.events.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.events.dto.TeacherInputDto;
import com.events.dto.TeacherOutputDto;
import com.events.entities.Teacher;

@Mapper(componentModel = "spring")
public interface TeacherMapper {
    @Mapping(target = "avatar_url", source = "avatarUrl")
    TeacherOutputDto paraDto(Teacher teacher);

    @Mapping(target= "id", ignore= true)
    @Mapping(target= "avatarUrl", source= "avatar_url")
    Teacher paraEntidade(TeacherInputDto teacherInputDto);
}
