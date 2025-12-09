package com.scorpio.service;

import lombok.RequiredArgsConstructor;

import java.io.IOException;

import jakarta.inject.Singleton;

import com.scorpio.model.Category;

import io.micronaut.context.annotation.Value;
import io.micronaut.core.io.Readable;
import io.micronaut.serde.ObjectMapper;

@Singleton
@RequiredArgsConstructor
public class ReadFileService {

    @Value("classpath:bacnetPlcTree.json")
    private final Readable tree;
    private final ObjectMapper objectMapper;

    public Category loadTreeFromResourceFile() {
        try {
            return objectMapper.readValue(tree.asInputStream(), Category.class);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
}
