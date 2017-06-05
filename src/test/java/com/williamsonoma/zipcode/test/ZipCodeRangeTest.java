package com.williamsonoma.zipcode.test;

/**
* The ZipCodeRangeTest class performs the unit tests 
* @author  Pritam Banerjee
* @version 1.0
* @since   06/05/2017 
*/


import static org.junit.Assert.*;

import org.junit.Test;

import com.williamsonoma.zipcode.controller.ZipCodeApplicationController;

public class ZipCodeRangeTest {

    //test data
    private static String zipCodeRangeOneRangeOnly = "[97006,97010]";
    private static String zipCodeRangeOneRangeOnlyExpectedOutput = "[97006,97010]";
    private static String zipCodeRangeMultipleRangesOne = "[94133,94133] [94200,94299] [94600,94699]";
    private static String zipCodeRangeMultipleRangesOneExpectedOutput = "[94133,94133] [94200,94299] [94600,94699]";
    private static String zipCodeRangeMultipleRangesTwo = "[94133,94133] [94200,94299] [94226,94399]";
    private static String zipCodeRangeMultipleRangesTwoExpectedOutput = "[94133,94133] [94200,94399]";

    
    /* Test for One Range only */
    @Test
    public void testZipCodeRangeWithOneZipCodeRange() {
        ZipCodeApplicationController zcac = new ZipCodeApplicationController();
        String zipCodeRangeOneRangeOnlyOutput = zcac.textInputController(zipCodeRangeOneRangeOnly);
        zipCodeRangeOneRangeOnlyOutput = zipCodeRangeOneRangeOnlyOutput.trim();
        assertTrue(zipCodeRangeOneRangeOnlyExpectedOutput.equals(zipCodeRangeOneRangeOnlyOutput));
    }
    
    
    /* Test for no overlap range*/
    @Test
    public void ZipCodeRangeTestWithNoOverlap(){
        ZipCodeApplicationController zcac = new ZipCodeApplicationController();
        String outputTestFour = zcac.textInputController(zipCodeRangeMultipleRangesTwo);
        outputTestFour = outputTestFour.trim();
        assertTrue(zipCodeRangeMultipleRangesTwoExpectedOutput.equals(outputTestFour));
    }
   
    /*Test for range with overlap*/
    @Test
    public void ZipCodeRangeTestWithOverlap(){
        ZipCodeApplicationController zcac = new ZipCodeApplicationController();        
        String outputTestThree = zcac.textInputController(zipCodeRangeMultipleRangesOne);
        outputTestThree = outputTestThree.trim();
        assertTrue(zipCodeRangeMultipleRangesOneExpectedOutput.equals(outputTestThree));
    }
    
    
}
