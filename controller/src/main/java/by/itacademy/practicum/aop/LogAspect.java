package by.itacademy.practicum.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class LogAspect {

    @Pointcut("execution(public * by.itacademy.practicum.service.*Service.findAll(..))")
    public void anyServiceFindAllMethod() {
    }

    @Pointcut("execution(public * by.itacademy.practicum.service.*Service.create(..))")
    public void anyServiceCreateMethod() {
    }

    @Pointcut("execution(public * by.itacademy.practicum.controller.*Controller.findAll(..))")
    public void anyControllerFindAllMethod() {
    }

    @Pointcut("execution(public * by.itacademy.practicum.controller.*Controller.create(..))")
    public void anyControllerCreateMethod() {
    }

    @Pointcut("execution(public * by.itacademy.practicum.mapper.*Mapper.toEntity(..))")
    public void anyMapperToEntityMethod() {
    }

    @Pointcut("execution(public * by.itacademy.practicum.mapper.*Mapper.toDto(..))")
    public void anyMapperToDtoMethod() {
    }

    @Before(value = "anyServiceFindAllMethod()")
    public void checkServiceFindAllMethod(JoinPoint joinPoint) {
        log.info("Invoke findAll() method in {} with params: {}", joinPoint.getTarget(), joinPoint.getArgs());
    }

    @Before(value = "anyServiceCreateMethod()")
    public void checkServiceCreateMethod(JoinPoint joinPoint) {
        log.info("Invoke create() method in {} with params: {}", joinPoint.getTarget(), joinPoint.getArgs());
    }

    @Before(value = "anyControllerFindAllMethod()")
    public void checkControllerFindAllMethod(JoinPoint joinPoint) {
        log.info("Invoke findAll() method in {} with params: {}", joinPoint.getTarget(), joinPoint.getArgs());
    }

    @Before(value = "anyControllerCreateMethod()")
    public void checkControllerCreateMethod(JoinPoint joinPoint) {
        log.info("Invoke create() method in {} with params: {}", joinPoint.getTarget(), joinPoint.getArgs());
    }

    @Before(value = "anyMapperToEntityMethod()")
    public void checkMapperToEntityMethod(JoinPoint joinPoint) {
        log.info("Invoke toEntity() method in {} with params: {}", joinPoint.getTarget(), joinPoint.getArgs());
    }

    @Before(value = "anyMapperToDtoMethod()")
    public void checkMapperToDtoMethod(JoinPoint joinPoint) {
        log.info("Invoke toDto() method in {} with params: {}", joinPoint.getTarget(), joinPoint.getArgs());
    }

    @AfterReturning(value = "anyServiceFindAllMethod() && target(service)", returning = "result", argNames = "result,service")
    public void addServiceLoggingAfterReturningFindAllMethod(Object result, Object service) {
        log.info("After findAll() method in class {}, return {}", service, result);
    }

    @AfterReturning(value = "anyServiceCreateMethod() && target(service)", returning = "result", argNames = "result,service")
    public void addServiceLoggingAfterReturningCreateMethod(Object result, Object service) {
        log.info("After create() method in class {}, return {}", service, result);
    }

  @AfterReturning(value = "anyControllerFindAllMethod() && target(controller)", returning = "result", argNames = "result,controller")
    public void addControllerLoggingAfterReturningFindAllMethod(Object result, Object controller) {
        log.info("After findAll() method in class {}, return {}", controller, result);
    }

    @AfterReturning(value = "anyControllerCreateMethod() && target(controller)", returning = "result", argNames = "result,controller")
    public void addControllerLoggingAfterReturningCreateMethod(Object result, Object controller) {
        log.info("After create() method in class {}, return {}", controller, result);
    }

    @AfterReturning(value = "anyMapperToEntityMethod() && target(mapper)", returning = "result", argNames = "result,mapper")
    public void addMapperLoggingAfterReturningToEntityMethod(Object result, Object mapper) {
        log.info("After toEntity() method in class {}, return {}", mapper, result);
    }

    @AfterReturning(value = "anyMapperToDtoMethod() && target(mapper)", returning = "result", argNames = "result,mapper")
    public void addMapperLoggingAfterReturningToDtoMethod(Object result, Object mapper) {
        log.info("After toDto() method in class {}, return {}", mapper, result);
    }

}
