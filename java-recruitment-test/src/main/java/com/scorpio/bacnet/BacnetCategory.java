package com.scorpio.bacnet;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.scorpio.Category;
import com.scorpio.DataType;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/***
 * This class represents a category into a plc data tree
 */
@Slf4j
@Data
@NoArgsConstructor
public class BacnetCategory implements Category<BacnetCategory, BacnetMeasure> {
    private long id;

    private String name;

    @JsonProperty("categories")
    private List<BacnetCategory> categories;

    @JsonProperty("measures")
    private List<BacnetMeasure> measures;
}
