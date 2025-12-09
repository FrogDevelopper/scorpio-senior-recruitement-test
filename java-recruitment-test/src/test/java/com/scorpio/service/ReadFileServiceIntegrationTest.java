package com.scorpio.service;

import static org.assertj.core.api.Assertions.assertThat;

import jakarta.inject.Inject;

import org.junit.jupiter.api.Test;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;

@MicronautTest
class ReadFileServiceIntegrationTest {

    @Inject
    private ReadFileService readFileService;

    @Test
    void should_createRootCategoryFromResourceFile() {
        // given

        // when
        final var category = readFileService.loadTreeFromResourceFile();

        // then
        assertThat(category).isNotNull();
        assertThat(category.id()).isEqualTo(5630742793027584L);
        assertThat(category.name()).isEqualTo("root");
        assertThat(category.categories()).hasSize(2);
        assertThat(category.measures()).isEmpty();
    }
}
