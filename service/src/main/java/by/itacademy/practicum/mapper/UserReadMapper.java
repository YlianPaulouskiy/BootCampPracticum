package by.itacademy.practicum.mapper;

import by.itacademy.practicum.dto.UserReadDto;
import by.itacademy.practicum.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserReadMapper {

    @Mapping(target = "fio", expression = "java(String.join(\" \", user.getLastName(), user.getName(), user.getMidName()))")
    @Mapping(target = "role", expression = "java(user.getRole().getName())")
    UserReadDto toDto(User user);

}
