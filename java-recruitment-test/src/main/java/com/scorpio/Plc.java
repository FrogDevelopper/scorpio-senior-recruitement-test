package com.scorpio;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.scorpio.bacnet.BacnetCategory;
import com.scorpio.bacnet.BacnetMeasure;
import com.scorpio.opcua.OpcUaCategory;
import com.scorpio.opcua.OpcUaMeasure;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@Slf4j
@AllArgsConstructor
public class Plc<MeasureT extends Measure, CategoryT extends Category<CategoryT, MeasureT>> {

    private Class<CategoryT> categoryClazz;

    /**
     * main function of the application
     *
     * @param args
     */
    public static void main(String[] args) throws IOException {

        log.info("--------------- bacnet -----------------");
        Plc<BacnetMeasure, BacnetCategory> plcBacnet = new Plc<>(BacnetCategory.class);
        BacnetCategory bacnetCategory = plcBacnet.loadPlcTree(System.getProperty("user.dir") + "/resources/bacnetPlcTree.json");

        List<String> pieceCounters = plcBacnet.searchByName(bacnetCategory, "Pump rotation", bacnetCategory.getName());
        logPaths(pieceCounters, "Path to Pump rotation {}");

        List<String> booleanMeasurePaths = plcBacnet.searchByDataType(bacnetCategory, DataType.BOOLEAN, bacnetCategory.getName());
        logPaths(booleanMeasurePaths, "Path to boolean {}");


        log.info("--------------- opcUa -----------------");
        Plc<OpcUaMeasure, OpcUaCategory> plcOpcUa = new Plc<>(OpcUaCategory.class);
        OpcUaCategory opcUaCategory = plcOpcUa.loadPlcTree(System.getProperty("user.dir") + "/resources/opcUaPlcTree.json");

        List<String> opcUaPieceCounters = plcOpcUa.searchByName(opcUaCategory, "Ambient-temperature", opcUaCategory.getName());
        logPaths(opcUaPieceCounters, "Path to Ambient-temperature {}");

        List<String> opcUaBooleanMeasurePaths = plcOpcUa.searchByDataType(opcUaCategory, DataType.BOOLEAN, opcUaCategory.getName());
        logPaths(opcUaBooleanMeasurePaths, "Path to boolean {}");
    }

    private static void logPaths(List<String>paths, String logPattern) {
        for (String path : paths) {
            log.info(logPattern, path);
        }
    }

    CategoryT loadPlcTree(String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new java.io.File(filePath), categoryClazz);
    }

    public List<String> searchByName(CategoryT currentCategory, String searchingString, String currentPath) {
        return searchBy(currentCategory, bacnetMeasure -> bacnetMeasure.getName().equals(searchingString), currentPath);
    }

    public List<String> searchByDataType(CategoryT currentCategory, DataType dataType, String currentPath) {
        return searchBy(currentCategory, bacnetMeasure -> bacnetMeasure.getDataType().equals(dataType), currentPath);
    }

    public List<String> searchBy(CategoryT currentCategory, Predicate<MeasureT> predicate, String currentPath) {
        List<String> paths = new ArrayList<>();
        for(MeasureT measure :  currentCategory.getMeasures()){
            if(predicate.test(measure)){
                paths.add(currentPath + "/" + measure.getName());
            }
        }
        for (CategoryT category : currentCategory.getCategories()) {
            paths.addAll(searchBy(category, predicate, currentPath + "/" + category.getName()));
        }
        return paths;
    }
}
