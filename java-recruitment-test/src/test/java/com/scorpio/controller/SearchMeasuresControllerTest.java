package com.scorpio.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.greaterThan;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import io.micronaut.http.HttpStatus;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import io.restassured.specification.RequestSpecification;

@MicronautTest
class SearchMeasuresControllerTest {

    @Nested
    class should_return_BAD_REQUEST {

        @Test
        void when_missingQueryParameters(RequestSpecification spec) {
            // given

            // when
            spec
                    .when().get("/measures/search")

                    // then
                    .then().statusCode(HttpStatus.BAD_REQUEST.getCode())
            ;
        }

        @Test
        void when_NameParameterIsEmpty(RequestSpecification spec) {
            // given

            // when
            spec
                    .when().get("/measures/search?word=")

                    // then
                    .then().statusCode(HttpStatus.BAD_REQUEST.getCode())
            ;
        }

        @Test
        void when_NameParameterIsBlank(RequestSpecification spec) {
            // given

            // when
            spec
                    .when().get("/measures/search?word=%20")

                    // then
                    .then().statusCode(HttpStatus.BAD_REQUEST.getCode())
            ;
        }

        @Test
        void when_DatatypeParameterIsIncorrect(RequestSpecification spec) {
            // given

            // when
            spec
                    .when().get("/measures/search?datatype=Integre")

                    // then
                    .then().statusCode(HttpStatus.BAD_REQUEST.getCode())
            ;
        }

        @Test
        void when_IdParameterIsIncorrect(RequestSpecification spec) {
            // given

            // when
            spec
                    .when().get("/measures/search?id=A")

                    // then
                    .then().statusCode(HttpStatus.BAD_REQUEST.getCode())
            ;
        }
    }

    @Nested
    class should_return_OK {
        @Test
        void when_searchingByName(RequestSpecification spec) {
            // given

            // when
            spec
                    .when().get("/measures/search?name=Heating")

                    // then
                    .then().statusCode(HttpStatus.OK.getCode())
                    .body("size()", greaterThan(0))
            ;
        }

        @Test
        void when_searchingByDatatype(RequestSpecification spec) {
            // given

            // when
            spec
                    .when().get("/measures/search?datatype=Integer")

                    // then
                    .then().statusCode(HttpStatus.OK.getCode())
                    .body("size()", greaterThan(0))
            ;
        }

        @Test
        void when_searchingById(RequestSpecification spec) {
            // given

            // when
            spec
                    .when().get("/measures/search?id=6287015995768832")

                    // then
                    .then().statusCode(HttpStatus.OK.getCode())
                    .body("size()", greaterThan(0))
            ;
        }

        @Test
        void with_emptyList_when_noMatchingResults(RequestSpecification spec) {
            // given

            // when
            spec
                    .when().get("/measures/search?name=nonexistentmeasure12345")

                    // then
                    .then().statusCode(HttpStatus.OK.getCode())
                    .body("size()", is(0))
            ;
        }
    }

}
