package ru.starkov.first_practice;

import org.junit.jupiter.api.*;
import org.testcontainers.containers.PostgreSQLContainer;

class CreateBooksTableTest {
    private static PostgreSQLContainer<?> postgreSQLContainer = new PostgreSQLContainer<>(
            "postgres:15-alpine"
    );

    @BeforeAll
    void setUp() {
        postgreSQLContainer.start();
    }

    @AfterAll
    void tearDown() {
        postgreSQLContainer.stop();
    }

    @Test
    void  asd() {

    }
}