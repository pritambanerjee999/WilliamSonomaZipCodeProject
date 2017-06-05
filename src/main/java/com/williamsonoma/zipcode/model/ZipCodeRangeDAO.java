package com.williamsonoma.zipcode.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
* The ZipCodeRangeDAO class provides different methods to access the ZipCodeRange
* @author  Pritam Banerjee
* @version 1.0
* @since   06/05/2017 
*/

public class ZipCodeRangeDAO {

    public List<ZipCodeRange> getMergedZipCodeArray(List<ZipCodeRange> zipCodeRangeArr) {

        List<ZipCodeRange> zipCodeRangeMergedArr = new ArrayList<>();
        
        if(zipCodeRangeArr.size() <= 1){
            return zipCodeRangeArr;
        }

        Collections.sort(zipCodeRangeArr);

        ZipCodeRangeDAO zcrDAO = new ZipCodeRangeDAO();

        for (int i = 0; i < zipCodeRangeArr.size() ; i++) {
            if(i < zipCodeRangeArr.size() -1){
                zipCodeRangeMergedArr.add(zcrDAO.compareAndCombine(zipCodeRangeArr.get(i), zipCodeRangeArr.get(i + 1)));
            }else{
                ZipCodeRange zcrMerged = zipCodeRangeMergedArr.get(zipCodeRangeMergedArr.size()-1);
                ZipCodeRange zcr = zipCodeRangeArr.get(i);

                if(zcr.getMax()>zcrMerged.getMax()){
                    zipCodeRangeMergedArr.add(zcr);
                }
            }
        }

        for (int i = 0; i < zipCodeRangeMergedArr.size(); i++) {
            System.out.println(zipCodeRangeMergedArr.get(i));
        }

        return zipCodeRangeMergedArr;
    }

    public ZipCodeRange compareAndCombine(ZipCodeRange z1, ZipCodeRange z2) {

        ZipCodeRange z3 = new ZipCodeRange();
        z3.setMax(10000);
        z3.setMin(10000);

        if ((z2.getMin() >= z1.getMin()) && (z2.getMin() <= z1.getMax())) {
            z3.setMin(z1.getMin());

            if ((z2.getMax() <= z1.getMax())) {
                z3.setMax(z1.getMax());
            } else {
                z3.setMax(z2.getMax());
            }
        } else {
            z3 = z1;
        }
        return z3;
    }

}
