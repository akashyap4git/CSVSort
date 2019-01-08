package com.hm.csv.sort.client;

import com.hm.csv.reader.LoadCsvAndSetup;
import com.hm.csv.sort.service.SortCsvService;

public class CustomCsvFileSorting {

    private static String CSV_INPUT_FILE_PATH;
    private static String CSV_SORTING_DEF_FILE_PATH;
    private static int columnToSortOn;
    private static int sortOrderDefColumn;


    public static void main(String[] args) {
        if(args.length <= 0 || args.length > 4) {
            throw new IllegalArgumentException("Please provide valid input parameter");
        }
        CSV_INPUT_FILE_PATH = args[0];
        columnToSortOn = Integer.parseInt(args[1]);
        CSV_SORTING_DEF_FILE_PATH = args[2];
        sortOrderDefColumn = Integer.parseInt(args[3]);

        try {
            LoadCsvAndSetup.setup(CSV_INPUT_FILE_PATH, CSV_SORTING_DEF_FILE_PATH);
            //LoadCsvAndSetup.displayCsvArray(LoadCsvAndSetup.getDataOfFileToBeSorted(), "fileToBeSorted");
            //LoadCsvAndSetup.displayCsvArray(LoadCsvAndSetup.getDataOfSortOrderDefFile(), "sortOrderDefFile");

            SortCsvService sortCsvService = new SortCsvService();
            sortCsvService.applySorting(columnToSortOn, sortOrderDefColumn);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
