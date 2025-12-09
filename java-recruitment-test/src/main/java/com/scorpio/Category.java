package com.scorpio;

import java.util.List;

public interface Category<CategoryT extends Category<CategoryT, MeasureT>, MeasureT extends Measure> {
    List<CategoryT> getCategories();
    List<MeasureT> getMeasures();
    String getName();
}
