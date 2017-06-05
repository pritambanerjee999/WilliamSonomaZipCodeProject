package com.williamsonoma.zipcode.controller;

/**
* The InputReaderFromFile class reads the input file from the user input
* @author  Pritam Banerjee
* @version 1.0
* @since   06/05/2017 
*/

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


import com.williamsonoma.zipcode.model.ZipCodeRange;
import com.williamsonoma.zipcode.view.ViewHandler;

public class InputReaderFromFile {

    private ViewHandler vh = new ViewHandler();

    public List<ZipCodeRange> fileReader(String fileName) {

        List<ZipCodeRange> zipCodeList = new ArrayList<>();

        try {
            List<String> lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
            InputTextReaderHelper itrh = new InputTextReaderHelper();
            zipCodeList = itrh.stdInReader(lines.get(0));
            System.out.println(lines.get(0));
        } catch (IOException e) {
            e.printStackTrace();
            vh.errorMessageDisplay("Error: Something went terribly wrong while trying to read the input file." 
                    + "\n Please make sure that the file path is correct");
        }

        return zipCodeList;
    }

}
