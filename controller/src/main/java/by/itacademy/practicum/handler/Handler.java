package by.itacademy.practicum.handler;

import by.itacademy.practicum.mapper.exception.RoleNotExistsException;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;
import java.time.Instant;
import java.util.Date;

@Slf4j
@RestControllerAdvice
public class Handler {


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public ErrorDetails validationHandle(ConstraintViolationException exception) {
        log.warn("Validation Exception", exception);
        return ErrorDetails.builder().
                timestamp(Date.from(Instant.now())).
                message(exception.getMessage()).
                httpStatus(HttpStatus.BAD_REQUEST).
                details("Incorrect data validation").
                build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(RoleNotExistsException.class)
    public ErrorDetails roleHandle(RoleNotExistsException exception) {
        log.warn("Role not exists exception", exception);
        return ErrorDetails.builder().
                timestamp(Date.from(Instant.now())).
                message(exception.getMessage()).
                httpStatus(HttpStatus.BAD_REQUEST).
                details("Value not found.").
                build();
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ErrorDetails repeatEmailHandle(SQLIntegrityConstraintViolationException exception) {
        log.warn("Repeat entity email exception", exception);
        return ErrorDetails.builder().
                timestamp(Date.from(Instant.now())).
                message(exception.getMessage()).
                httpStatus(HttpStatus.INTERNAL_SERVER_ERROR).
                details("User with this email already exists").
                build();
    }

}
