package com.scorpio.service;

import java.util.List;

import com.scorpio.model.DataType;

public interface SearchMeasuresService {

    List<String> searchMeasureByName(String word);

    List<String> searchMeasureByDatatype(DataType datatype);

    List<String> searchMeasureById(long id);
}
