package by.itacademy.practicum.configuration;

import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.testcontainers.containers.MySQLContainer;

public class MySqlExtension implements BeforeAllCallback {

    private MySQLContainer<?> container;

    @Override
    public void beforeAll(ExtensionContext extensionContext) throws Exception {
        container = new MySQLContainer<>("mysql");
        container.start();
        System.setProperty("spring.datasource.url", container.getJdbcUrl());
    }

}
