package by.itacademy.practicum.repository;

import by.itacademy.practicum.annotation.IT;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

@IT
@RequiredArgsConstructor
public class RoleRepositoryTest {

    private final RoleRepository roleRepository;
    private final String[] roles = {"Administrator", "Customer User", "Sale User", "Secure API User"};

    @Test
    void whenFindByNameExpectPresentOptional() {
        for (String role : roles) {
            assertTrue(roleRepository.findByName(role).isPresent());
        }
    }
}
