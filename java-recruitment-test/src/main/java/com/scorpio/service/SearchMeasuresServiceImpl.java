package com.scorpio.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;

import jakarta.inject.Singleton;

import com.scorpio.model.Category;
import com.scorpio.model.DataType;
import com.scorpio.model.Measure;

import io.micronaut.core.util.CollectionUtils;

@Slf4j
@Singleton
@RequiredArgsConstructor
public class SearchMeasuresServiceImpl implements SearchMeasuresService {

    private final Supplier<Category> rootCategorySupplier;

    @Override
    public List<String> searchMeasureByName(final String word) {
        return searchMeasure(measure -> measure.name().contains(word));
    }

    @Override
    public List<String> searchMeasureByDatatype(final DataType datatype) {
        return searchMeasure(measure -> measure.dataType().equals(datatype));
    }

    @Override
    public List<String> searchMeasureById(final long id) {
        return searchMeasure(measure -> measure.id() == id);
    }

    private List<String> searchMeasure(final Predicate<Measure> predicate) {
        final var root = rootCategorySupplier.get();

        return parseCategories("", root.categories(), predicate);
    }

    private List<String> parseCategories(final String currentPath, final List<Category> categories,
                                         final Predicate<Measure> predicate) {
        final var paths = new ArrayList<String>();
        for (int i = 0; i < categories.size(); i++) {
            var category = categories.get(i);
            final var newPath = currentPath + "categories[" + i + "].";
            if (CollectionUtils.isNotEmpty(category.categories())) {
                paths.addAll(parseCategories(newPath, category.categories(), predicate));
            }

            if (CollectionUtils.isNotEmpty(category.measures())) {
                paths.addAll(parseMeasures(newPath, category.measures(), predicate));
            }
        }

        return paths;
    }

    private List<String> parseMeasures(final String currentPath, final List<Measure> measures,
                                       final Predicate<Measure> predicate) {
        final var paths = new ArrayList<String>();
        for (var i = 0; i < measures.size(); i++) {
            final var measure = measures.get(i);
            if (predicate.test(measure)) {
                paths.add(currentPath + "measures[%s]".formatted(i));
            }
        }

        return paths;
    }
}
