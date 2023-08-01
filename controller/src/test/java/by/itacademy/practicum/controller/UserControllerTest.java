package by.itacademy.practicum.controller;

import by.itacademy.practicum.annotation.IT;
import by.itacademy.practicum.dto.UserCreateDto;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectWriter;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.SerializationFeature;

import java.nio.charset.StandardCharsets;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@IT
@AutoConfigureMockMvc
@RequiredArgsConstructor
public class UserControllerTest {

    private final MockMvc mockMvc;
    public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(), StandardCharsets.UTF_8);

    @Test
    void expectSuccessfulWhenFindAll() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users"))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    void expectSuccessfulWhenCreateUser() throws Exception {
        UserCreateDto userCreateDto = UserCreateDto.builder()
                .name("Name")
                .lastName("LastName")
                .midName("MidName")
                .email("email@gmail.com")
                .role("Administrator")
                .build();

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(userCreateDto);

        mockMvc.perform(MockMvcRequestBuilders.post("/users")
                .contentType(APPLICATION_JSON_UTF8)
                .content(requestJson)
        ).andExpect(status().is2xxSuccessful());
    }

    @Test
    void expectBadRequestWhenCreateUserWithException() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(UserCreateDto.builder().build());

        mockMvc.perform(MockMvcRequestBuilders.post("/users")
                .contentType(APPLICATION_JSON_UTF8)
                .content(requestJson)
        ).andExpect(status().is4xxClientError());
    }


}
