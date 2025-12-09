package com.scorpio.config;

import java.util.function.Supplier;

import jakarta.inject.Singleton;

import com.scorpio.model.Category;
import com.scorpio.service.ReadFileService;

import io.micronaut.context.annotation.Factory;
import io.micronaut.core.util.SupplierUtil;

@Factory
public class CategoryFactory {

    @Singleton
    public Supplier<Category> rootCategorySupplier(final ReadFileService readFileService) {
        return SupplierUtil.memoized(readFileService::loadTreeFromResourceFile);
    }
}
