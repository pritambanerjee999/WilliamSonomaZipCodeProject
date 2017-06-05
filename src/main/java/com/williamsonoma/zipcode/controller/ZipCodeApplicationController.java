package com.williamsonoma.zipcode.controller;

/**
* The ZipCodeApplicationController class acts as the controller
* It calls the correct methods to format the input for the DAO
* @author  Pritam Banerjee
* @version 1.0
* @since   06/05/2017 
*/

import java.util.ArrayList;
import java.util.List;

import com.williamsonoma.zipcode.model.ZipCodeRange;
import com.williamsonoma.zipcode.model.ZipCodeRangeDAO;

public class ZipCodeApplicationController {

    private List<ZipCodeRange> zipCodeRangeList = new ArrayList<>();
    private List<ZipCodeRange> mergedList = new ArrayList<>();

    public String fileInputController(String filePath) {
        InputReaderFromFile fileReader = new InputReaderFromFile();
        zipCodeRangeList = fileReader.fileReader(filePath);
        return getMergedListString();
    }

    public String textInputController(String zipCodeRangeText) {
        InputReaderStdIn stdInInputReader = new InputReaderStdIn();
        zipCodeRangeList = stdInInputReader.stdInReader(zipCodeRangeText);
        return getMergedListString();
        
    }

    private String getMergedListString() {
        ZipCodeRangeDAO zcrDAO = new ZipCodeRangeDAO();
        String result = "";
        mergedList = zcrDAO.getMergedZipCodeArray(zipCodeRangeList);
        
        for (int i = 0; i <  mergedList.size(); i++) {
            result = result + " " +  mergedList.get(i);
        }
        return result;
    }

}
