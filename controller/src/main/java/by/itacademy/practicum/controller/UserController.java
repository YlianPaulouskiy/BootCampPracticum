package by.itacademy.practicum.controller;

import by.itacademy.practicum.dto.UserCreateDto;
import by.itacademy.practicum.dto.UserReadDto;
import by.itacademy.practicum.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<UserReadDto> findAll(@RequestParam(value = "page", defaultValue = "0") Integer page) {
        return userService.findAll(page);
    }

    @PostMapping
    public UserReadDto create(@RequestBody UserCreateDto createDto) {
        return userService.create(createDto).orElseThrow();
    }

}
