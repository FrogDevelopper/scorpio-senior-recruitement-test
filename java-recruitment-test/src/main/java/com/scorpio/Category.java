package com.scorpio;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Category {
    private long id;

    private String name;

    private List<Category> categories;

    private List<Measure> measures;
}
