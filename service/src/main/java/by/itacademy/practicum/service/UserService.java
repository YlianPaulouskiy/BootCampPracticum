package by.itacademy.practicum.service;

import by.itacademy.practicum.dto.UserCreateDto;
import by.itacademy.practicum.dto.UserReadDto;
import by.itacademy.practicum.mapper.UserCreateMapper;
import by.itacademy.practicum.mapper.UserReadMapper;
import by.itacademy.practicum.repository.UserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Validated
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserReadMapper userReadMapper;
    private final UserCreateMapper userCreateMapper;

    @Transactional(readOnly = true)
    public List<UserReadDto> findAll(Integer page) {
        return userRepository.findAll(PageRequest.of(page, 10, Sort.by("email")))
                .stream()
                .map(userReadMapper::toDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public Optional<UserReadDto> create(@Valid UserCreateDto userCreateDto) {
        return Optional.ofNullable(userReadMapper.toDto(
                userRepository.save(userCreateMapper.toEntity(userCreateDto))));
    }

}
