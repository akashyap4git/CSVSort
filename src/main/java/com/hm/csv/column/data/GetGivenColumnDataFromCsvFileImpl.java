package com.hm.csv.column.data;

import com.hm.csv.reader.LoadCsvAndSetup;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class GetGivenColumnDataFromCsvFileImpl implements GetGivenColumnDataFromCsvFile {

    public List<String> getDataOfGivenColumnFromFileToBeSorted(int column) {
        return getDataOfGivenColumn(LoadCsvAndSetup.getDataOfFileToBeSorted(), column);
    }

    public List<String> getDataOfGivenColumnFromSortOrderDefFile(int column) {
        return getDataOfGivenColumn(LoadCsvAndSetup.getDataOfSortOrderDefFile(), column);
    }

    public void verifyValidColumnInput(int columnToSortOn, int sortOrderDefColumn) throws IllegalArgumentException {
        if(!(columnToSortOn < LoadCsvAndSetup.getDataOfFileToBeSorted().get(0).length)) {
            throw new IllegalArgumentException("Please provide valid input of column to be sorted");
        }
        if(!(sortOrderDefColumn < LoadCsvAndSetup.getDataOfSortOrderDefFile().get(0).length)) {
            throw new IllegalArgumentException("Please provide valid input of column of sort order def file");
        }
    }

    private List<String> getDataOfGivenColumn(List<String[]> allDataOfCsvFile, int column) {
        List<String> allDataOfGivenColumn = new LinkedList<String>();
        Iterator<String[]> rowCol = allDataOfCsvFile.iterator();
        while(rowCol.hasNext()) {
            String[] row = rowCol.next();
            for(int col = 0; col < row.length; col++) {
                if(column == col) {
                    allDataOfGivenColumn.add(row[column]);
                    break;
                }
            }
        }
        return allDataOfGivenColumn;
    }
}
