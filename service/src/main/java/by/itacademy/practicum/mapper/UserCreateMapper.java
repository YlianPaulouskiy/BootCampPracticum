package by.itacademy.practicum.mapper;

import by.itacademy.practicum.dto.UserCreateDto;
import by.itacademy.practicum.entity.User;
import by.itacademy.practicum.mapper.exception.RoleNotExistsException;
import by.itacademy.practicum.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserCreateMapper {

    private final RoleRepository roleRepository;

    public User toEntity(UserCreateDto userDto) {
        if (userDto == null) {
            return null;
        }

        var user = User.builder();
        user.name(userDto.getName());
        user.lastName(userDto.getLastName());
        user.midName(userDto.getMidName());
        user.email(userDto.getEmail());
        user.role(roleRepository.findByName(userDto.getRole())
                .orElseThrow(() -> new RoleNotExistsException("Role " + userDto.getRole() + " not exists.")));

        return user.build();
    }

}
