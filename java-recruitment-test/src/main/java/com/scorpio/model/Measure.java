package com.scorpio.model;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable.Deserializable
public record Measure(
        long id,
        String name,
        DataType dataType) {
}
