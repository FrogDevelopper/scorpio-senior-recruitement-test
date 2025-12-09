package com.scorpio.opcua;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.scorpio.DataType;
import com.scorpio.Measure;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *  This class represents a measure into a plc data tree
 */
@Data
@NoArgsConstructor
public class OpcUaMeasure implements Measure {
    private long id;

    @JsonProperty("objectName")
    private String name;

    private DataType dataType;
}
