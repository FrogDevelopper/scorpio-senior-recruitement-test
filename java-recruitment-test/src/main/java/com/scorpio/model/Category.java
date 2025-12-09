package com.scorpio.model;

import java.util.List;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable.Deserializable
public record Category(
        long id,
        String name,
        List<Category> categories,
        List<Measure> measures) {
}
