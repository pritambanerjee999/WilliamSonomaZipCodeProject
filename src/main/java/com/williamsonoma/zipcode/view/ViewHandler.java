package com.williamsonoma.zipcode.view;

/**
 * The ViewHandler calls the input handler for file or text depending on the user
 * input
 * @author  Pritam Banerjee
 * @version 1.0
 * @since   06/05/2017 
 */

import javax.swing.JOptionPane;
import com.williamsonoma.zipcode.controller.ZipCodeApplicationController;


public class ViewHandler {
    
    /* This method opens up the welcome screen*/
    public static String welcomeScreen() {

        ZipCodeApplicationController zipCodeController = new ZipCodeApplicationController();
        String result = "";

       
        String input = JOptionPane.showInputDialog(null, "Welcome to Zip Code Range Merger. "
                + "\nPlease Enter : "
                + "\n 1.Read from a file: " 
          + "\n 2.Enter the ZipCodes:", "Input Data", JOptionPane.QUESTION_MESSAGE);

        if ("1".equals(input)) {
            String message = "Please enter the complete file path in format 'C\\your\\path\\test.txt':";
            String filePath = JOptionPane.showInputDialog(null, message, "Input Data", JOptionPane.QUESTION_MESSAGE);
            if ((filePath != null) && (!"".equals(filePath))) {
               result = zipCodeController.fileInputController(filePath);
            }

        } else if ("2".equals(input)) {
            String inputText = JOptionPane.showInputDialog(null, "Enter the zipcode ranges seperated by commas"
                    + "\n Please make sure that zipcodes are 5 digits Integers. Any wrong inputs will be ignored"
                    + "\n Eg: [12345,34567], [56789,78912]:", 
                    "Input Data", JOptionPane.QUESTION_MESSAGE);
            if (inputText != null) {
                System.out.println("Input Text" + inputText);
                result = zipCodeController.textInputController(inputText);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Please enter valid input (Either 1 or 2)", 
                    "Output:", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
        
        showMergeList(result);
        return result;

    }

    public static void showMergeList(String result){
        JOptionPane.showMessageDialog(null, result,"ZipCode Range:",JOptionPane.INFORMATION_MESSAGE);   
    }
    
    /*
     * @Param : Gets the String error message and prints it in the output
     * */
    public void errorMessageDisplay(String error) {
        JOptionPane.showMessageDialog(null, error, "Output:", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
    

}
