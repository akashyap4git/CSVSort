package com.hm.csv.reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class LoadCsvAndSetup {

    private static final String EMPTY_HEADER = "";
    private static final String FILE_TO_BE_SORTED = "fileToBeSorted";

    private static String headerLineOfFileToBeSorted = EMPTY_HEADER;
    private static String headerLineOfSortOrderDefFile = EMPTY_HEADER;

    private static List<String[]> dataOfFileToBeSorted = new LinkedList<String[]>();
    private static List<String[]> dataOfSortOrderDefFile = new LinkedList<String[]>();

    public static void setup(String fileToBeSortedPath, String sortOrderDefFilePath) {
        System.out.println("\n **** Setup List of Array **** ");
        loadFileAndSetupData(fileToBeSortedPath, "fileToBeSorted");
        loadFileAndSetupData(sortOrderDefFilePath, "sortOrderDefFile");
    }

    public static List<String[]> getDataOfFileToBeSorted() {
        return dataOfFileToBeSorted;
    }

    public static List<String[]> getDataOfSortOrderDefFile() {
        return dataOfSortOrderDefFile;
    }

    public static void displayCsvArray(List<String[]> allDataOfCsvFile, String typeOfInput) {
        System.out.println();
        if(FILE_TO_BE_SORTED.equals(typeOfInput)) {
            System.out.println(headerLineOfFileToBeSorted);
        } else {
            System.out.println(headerLineOfSortOrderDefFile);
        }

        for(String[] dataRow : allDataOfCsvFile) {
            for(String dataColumn : dataRow) {
                System.out.print(dataColumn + " ");
            }
            System.out.println();
        }
    }

    private static void loadFileAndSetupData(String filePath, String typeOfInput) {
        String csvLineReader;
        try {
            Scanner csvReader = new Scanner(new BufferedReader(new FileReader(filePath)));
            setupHeaderLine(csvReader, typeOfInput);

            while(csvReader.hasNextLine()) {
                csvLineReader = csvReader.nextLine();
                String[] row = csvLineReader.split(",");
                if(row != null) {
                    setupDataList(row, typeOfInput);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void setupDataList(String[] row, String typeOfInput) {
        if(FILE_TO_BE_SORTED.equals(typeOfInput)) {
            dataOfFileToBeSorted.add(row);
        } else {
            dataOfSortOrderDefFile.add(row);
        }
    }

    private static void setupHeaderLine(Scanner csvReader, String typeOfInput) {
        if(FILE_TO_BE_SORTED.equals(typeOfInput)) {
            headerLineOfFileToBeSorted = csvReader.nextLine();
        } else {
            headerLineOfSortOrderDefFile = csvReader.nextLine();
        }
    }
}
