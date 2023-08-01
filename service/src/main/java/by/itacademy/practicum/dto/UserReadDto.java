package by.itacademy.practicum.dto;

import lombok.Builder;

@Builder
public record UserReadDto(String fio,
                          String email,
                          String role) {
}
