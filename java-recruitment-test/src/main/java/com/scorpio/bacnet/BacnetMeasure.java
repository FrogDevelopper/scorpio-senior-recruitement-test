package com.scorpio.bacnet;

import com.scorpio.DataType;
import com.scorpio.Measure;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *  This class represents a measure into a plc data tree
 */
@Data
@NoArgsConstructor
public class BacnetMeasure implements Measure {
    private long id;

    private String name;

    private DataType dataType;
}
