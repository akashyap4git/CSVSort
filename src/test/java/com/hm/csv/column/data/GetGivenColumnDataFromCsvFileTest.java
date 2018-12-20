package com.hm.csv.column.data;

import com.hm.csv.reader.LoadCsvAndSetup;
import org.junit.Before;
import org.junit.Test;

public class GetGivenColumnDataFromCsvFileTest {

    private static String CSV_INPUT_FILE_PATH = "C:\\ITLogistics\\src\\main\\resources\\csv\\product.csv";
    private static String CSV_SORTING_DEF_FILE_PATH = "C:\\ITLogistics\\src\\main\\resources\\csv\\sortingdef.csv";

    @Before
    public void setup() {
        LoadCsvAndSetup.setup(CSV_INPUT_FILE_PATH, CSV_SORTING_DEF_FILE_PATH);
    }

    // Test cases should be written for all functionality, proving only one for an example
    @Test(expected = IllegalArgumentException.class)
    public void testVerifyValidColumnInput() {
        GetGivenColumnDataFromCsvFileImpl columnData = new GetGivenColumnDataFromCsvFileImpl();
        int columnToSortOn = 10;
        int sortOrderDefColumn = 10;
        columnData.verifyValidColumnInput(columnToSortOn, sortOrderDefColumn);
    }
}
