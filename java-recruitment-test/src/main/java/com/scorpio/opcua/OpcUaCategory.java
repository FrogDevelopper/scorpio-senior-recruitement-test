package com.scorpio.opcua;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.scorpio.Category;
import com.scorpio.DataType;
import com.scorpio.bacnet.BacnetMeasure;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Slf4j
@Data
@NoArgsConstructor
public class OpcUaCategory implements Category<OpcUaCategory, OpcUaMeasure> {
    private long id;

    @JsonProperty("objectName")
    private String name;

    @JsonProperty("categories")
    private List<OpcUaCategory> categories;

    @JsonProperty("measures")
    private List<OpcUaMeasure> measures;
}
