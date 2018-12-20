package com.hm.csv.column.data;

import java.util.List;

public interface GetGivenColumnDataFromCsvFile {

    public List<String> getDataOfGivenColumnFromFileToBeSorted(int column);

    public List<String> getDataOfGivenColumnFromSortOrderDefFile(int column);

    public void verifyValidColumnInput(int columnToSortOn, int sortOrderDefColumn) throws IllegalArgumentException;
}
