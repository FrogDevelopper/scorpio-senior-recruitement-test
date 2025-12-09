package com.scorpio.model;

import lombok.Getter;

import com.fasterxml.jackson.annotation.JsonValue;

import io.micronaut.serde.annotation.Serdeable;

@Getter
@Serdeable.Deserializable
public enum DataType {

    SHORT("Short", Short.class),

    INTEGER("Integer", Integer.class),

    LONG("Long", Long.class),

    FLOAT("Float", Float.class),

    DOUBLE("Double", Double.class),

    BOOLEAN("Boolean", Boolean.class),

    STRING("String", String.class);

    @JsonValue
    private final String value;

    private final Class<?> clazz;

    DataType(String value, Class<?> clazz) {
        this.value = value;
        this.clazz = clazz;
    }

}
