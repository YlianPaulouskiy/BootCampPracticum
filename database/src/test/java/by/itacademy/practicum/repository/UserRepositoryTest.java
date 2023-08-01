package by.itacademy.practicum.repository;

import by.itacademy.practicum.annotation.IT;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.PageRequest;

import static org.assertj.core.api.Assertions.assertThat;

@IT
@RequiredArgsConstructor
public class UserRepositoryTest {

    private final UserRepository userRepository;
    private static final Integer PAGE_SIZE = 10;

    @Test
    void whenFindAllByPageableExpect10UsersAtFirstPageAnd3AtLast() {
        var users = userRepository.findAll(PageRequest.of(0,PAGE_SIZE));
        assertThat(users).hasSize(PAGE_SIZE);
        users = userRepository.findAll(PageRequest.of(1,PAGE_SIZE));
        assertThat(users).hasSize(3);
    }

}
