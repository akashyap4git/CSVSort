package com.hm.csv.sort.service;

import com.hm.csv.reader.LoadCsvAndSetup;
import com.hm.csv.column.data.GetGivenColumnDataFromCsvFile;
import com.hm.csv.column.data.GetGivenColumnDataFromCsvFileImpl;

import java.util.*;

public class SortCsvService {

    List<String[]> originalResult = new LinkedList<String[]>();
    List<String[]> sortedResult = new LinkedList<String[]>();

    public void applySorting(int columnToSortOn, int sortOrderDefColumn) {
        GetGivenColumnDataFromCsvFile columnData = new GetGivenColumnDataFromCsvFileImpl();
        columnData.verifyValidColumnInput(columnToSortOn, sortOrderDefColumn);
        checkNumberAndThenSortData(columnData.getDataOfGivenColumnFromFileToBeSorted(columnToSortOn), columnData.getDataOfGivenColumnFromSortOrderDefFile(sortOrderDefColumn));
    }

    private void checkNumberAndThenSortData(List<String> dataColumnFromFileToBeSorted, List<String> dataColumnFromSortOrderDefFile) {

        for(int colSortOrder = 0; colSortOrder < dataColumnFromSortOrderDefFile.size(); colSortOrder++) {
            for(int colToBeSorted = 0; colToBeSorted < dataColumnFromFileToBeSorted.size(); colToBeSorted++) {
                if(dataColumnFromSortOrderDefFile.get(colSortOrder).equals(dataColumnFromFileToBeSorted.get(colToBeSorted))) {
                    processSorting(colToBeSorted);
                    dataColumnFromFileToBeSorted.remove(colToBeSorted);
                    break;
                }
            }
        }
        mergeTheResult();
        LoadCsvAndSetup.displayCsvArray(sortedResult, "fileToBeSorted");
    }

    private void mergeTheResult() {
        sortedResult.addAll(originalResult);
    }

    private void processSorting(int colToBeSorted) {
        originalResult = LoadCsvAndSetup.getDataOfFileToBeSorted();
        sortedResult.add(originalResult.get(colToBeSorted));
        originalResult.remove(colToBeSorted);
    }
}
