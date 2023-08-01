package by.itacademy.practicum.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Value;
import lombok.experimental.FieldNameConstants;

@Value
@Builder
@FieldNameConstants
public class UserCreateDto {

    @NotBlank(message = "Name is required")
    @Pattern(regexp = "^[a-zA-Z]*$", message = "The name should consist only of Latin letters")
    @Size(max = 20, message = "The mid name must consist of 20 characters")
    String name;

    @NotBlank(message = "Lastname is required")
    @Pattern(regexp = "^[a-zA-Z]*$", message ="The lastname should consist only of Latin letters")
    @Size(max = 40, message = "The lastname must consist of 40 characters")
    String lastName;

    @NotBlank(message = "Mid name is required")
    @Pattern(regexp = "^[a-zA-Z]*$", message = "The mid name should consist only of Latin letters")
    @Size(max = 40, message = "The mid name must consist of 40 characters")
    String midName;

    @Email(message = "Invalid email pattern")
    @Size(max = 50, message = "The email must consist of 50 characters")
    String email;

    @NotBlank(message = "Role is required")
    String role;

}
