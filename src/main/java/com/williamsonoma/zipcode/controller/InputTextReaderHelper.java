package com.williamsonoma.zipcode.controller;

/**
* The InputTextReaderHelper class reads the input, parses it 
* and creates the ZipCodeRangeArray
* @author  Pritam Banerjee
* @version 1.0
* @since   06/05/2017 
*/

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.williamsonoma.zipcode.model.ZipCodeRange;
import com.williamsonoma.zipcode.view.ViewHandler;

public class InputTextReaderHelper {

    public List<ZipCodeRange> stdInReader(String zipCodeText) {
        
        ViewHandler vh = new ViewHandler();
        ZipCodeRange zcr;
        List<ZipCodeRange> zipCodeList = new ArrayList<>();
        Pattern p = Pattern.compile("\\[(.*?)\\]");
        Matcher m = p.matcher(zipCodeText);

        while(m.find()) {
            zcr = new ZipCodeRange();
            String range = m.group(1);
            String rangeArr[] = range.split(",");
            Integer min = Integer.parseInt(rangeArr[0]);
            Integer max = Integer.parseInt(rangeArr[1]);
            if( min > 99999 || min <10000){
                vh.errorMessageDisplay("Invalid Input");
            }else{
                zcr.setMin(min);
            }
            
            if( max > 99999 || max <10000){
                vh.errorMessageDisplay("Invalid Input");
            }else{
                zcr.setMax(max);
            }
      
            zipCodeList.add(zcr);
        }
        
        for (int i = 0; i < zipCodeList.size(); i++) {
            System.out.println(zipCodeList.get(i));
        }
        
        if(zipCodeList.size() == 0){
            vh.errorMessageDisplay("Invalid Input");
        }
        
        return zipCodeList;
    }
}
