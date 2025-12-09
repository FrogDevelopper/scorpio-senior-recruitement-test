package com.scorpio.service;

import static org.assertj.core.api.Assertions.assertThat;

import jakarta.inject.Inject;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.scorpio.model.DataType;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;

@MicronautTest
class SearchMeasuresServiceTest {

    @Inject
    private SearchMeasuresService searchMeasuresService;

    @Nested
    class ByName {

        @Test
        void should_return_empty_when_noMatching() {
            // given

            // when
            final var results = searchMeasuresService.searchMeasureByName("Heater");

            // then
            assertThat(results).isEmpty();
        }

        @Test
        void should_return_paths_when_matching() {
            // given

            // when
            final var results = searchMeasuresService.searchMeasureByName("Heat");

            // then
            assertThat(results)
                    .hasSize(3)
                    .contains("categories[0].categories[0].measures[0]")
                    .contains("categories[1].categories[0].measures[0]")
                    .contains("categories[1].categories[0].measures[1]")
            ;
        }
    }

    @Nested
    class ByDataType {

        @Test
        void should_return_empty_when_noMatching() {
            // given

            // when
            final var results = searchMeasuresService.searchMeasureByDatatype(DataType.STRING);

            // then
            assertThat(results).isEmpty();
        }

        @Test
        void should_return_paths_when_matching() {
            // given

            // when
            final var results = searchMeasuresService.searchMeasureByDatatype(DataType.BOOLEAN);

            // then
            assertThat(results)
                    .hasSize(2)
                    .contains("categories[0].categories[1].measures[0]")
                    .contains("categories[1].categories[1].categories[0].measures[0]")
            ;
        }
    }


    @Nested
    class ById {

        @Test
        void should_return_empty_when_noMatching() {
            // given

            // when
            final var results = searchMeasuresService.searchMeasureById(123456L);

            // then
            assertThat(results).isEmpty();
        }

        @Test
        void should_return_paths_when_matching() {
            // given

            // when
            final var results = searchMeasuresService.searchMeasureById(6627611130200064L);

            // then
            assertThat(results)
                    .hasSize(1)
                    .contains("categories[1].categories[2].measures[0]")
            ;
        }
    }

}
