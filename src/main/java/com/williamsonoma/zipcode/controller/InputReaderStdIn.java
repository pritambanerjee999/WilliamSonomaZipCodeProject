package com.williamsonoma.zipcode.controller;

/**
* The InputReaderFromStdIn class reads the input text from the user input
* and then calls the stdInReader method
* @author  Pritam Banerjee
* @version 1.0
* @since   06/05/2017 
*/

import java.util.List;

import com.williamsonoma.zipcode.model.ZipCodeRange;

public class InputReaderStdIn {

    public List<ZipCodeRange> stdInReader(String zipCodeText) {
        InputTextReaderHelper itrh = new InputTextReaderHelper();
        return itrh.stdInReader(zipCodeText);
    }

}
