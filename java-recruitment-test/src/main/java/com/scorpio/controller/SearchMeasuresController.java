package com.scorpio.controller;

import lombok.RequiredArgsConstructor;

import java.util.List;

import jakarta.annotation.Nullable;

import com.scorpio.model.DataType;
import com.scorpio.service.SearchMeasuresService;

import io.micronaut.core.util.StringUtils;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.QueryValue;
import io.micronaut.http.annotation.Status;

@Controller("measures")
@RequiredArgsConstructor
public class SearchMeasuresController {

    private final SearchMeasuresService searchMeasuresService;

    @Get("/search")
    @Status(HttpStatus.OK)
    public HttpResponse<List<String>> searchMeasureByName(@Nullable @QueryValue final String name,
                                                          @Nullable @QueryValue final DataType datatype,
                                                          @Nullable @QueryValue final Long id) {
        if (StringUtils.isNotEmpty(name)) {
            return HttpResponse.ok(searchMeasuresService.searchMeasureByName(name));
        } else if (datatype != null) {
            return HttpResponse.ok(searchMeasuresService.searchMeasureByDatatype(datatype));
        } else if (id != null) {
            return HttpResponse.ok(searchMeasuresService.searchMeasureById(id));
        } else {
            return HttpResponse.badRequest();
        }
    }
}
