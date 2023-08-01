package by.itacademy.practicum.service;

import by.itacademy.practicum.annotation.IT;
import by.itacademy.practicum.dto.UserCreateDto;
import by.itacademy.practicum.dto.UserReadDto;
import by.itacademy.practicum.repository.UserRepository;
import jakarta.validation.ConstraintViolationException;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@IT
@RequiredArgsConstructor
public class UserServiceTest {

    private final UserService userService;
    private final UserRepository userRepository;
    private final static Integer DEFAULT_SIZE = 13;
    private final static Integer CREATED_SIZE = 14;
    private final static String[] SORTING_EMAILS = {"alesia@gmail.com", "alexey@gmail.com", "anna@gmail.com",
            "bogdan@gmail.com", "dmitry@gmail.com", "elena@gmail.com", "irisha@gmail.com", "ivan@gmail.com",
            "katya@gmail.com", "maxik@gmail.com"};
    private UserCreateDto createUser;

    @BeforeEach
    void setUp() {
        createUser = UserCreateDto.builder()
                .lastName("Paulouski")
                .name("Yulyan")
                .midName("Gennadzevich")
                .email("paulouyskiyluan@gmail.com")
                .role("Administrator")
                .build();
    }

    @Test
    void whenFindAllExpect10UsersSortByEmail() {
        var users = userService.findAll(0);
        assertThat(users).hasSize(10);
        assertThat(users.stream().map(UserReadDto::email).collect(Collectors.toList())).containsExactly(SORTING_EMAILS);
    }

    @Test
    void whenCreateExpectCreatedSize() {
        var allUsers = userRepository.findAll();
        assertThat(allUsers).hasSize(DEFAULT_SIZE);
        assertTrue(userService.create(createUser).isPresent());
        assertThat(userRepository.findAll()).hasSize(CREATED_SIZE);
    }

     @Test
    void whenCreateExpectViolationException() {
        var createUser = UserCreateDto.builder().build();
        assertThrows(ConstraintViolationException.class, () -> {
            userService.create(createUser);
        });
    }


}
