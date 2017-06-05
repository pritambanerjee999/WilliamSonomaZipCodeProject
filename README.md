PROBLEM STATEMENT:

Sometimes items cannot be shipped to certain zip codes, and the rules for these restrictions are stored as a series of ranges of 5 digit codes. For example if the ranges are:

[94133,94133] [94200,94299] [94600,94699]

Then the item can be shipped to zip code 94199, 94300, and 65532, but cannot be shipped to 94133, 94650, 94230, 94600, or 94299.

Any item might be restricted based on multiple sets of these ranges obtained from multiple sources.

PROBLEM
Given a collection of 5-digit ZIP code ranges (each range includes both their upper and lower bounds), provide an algorithm that produces the minimum number of ranges required to represent the same restrictions as the input.

NOTES
- The ranges above are just examples, your implementation should work for any set of arbitrary ranges
- Ranges may be provided in arbitrary order
- Ranges may or may not overlap
- Your solution will be evaluated on the correctness and the approach taken, and adherence to coding standards and best practices

EXAMPLES:
If the input = [94133,94133] [94200,94299] [94600,94699]
Then the output should be = [94133,94133] [94200,94299] [94600,94699]

If the input = [94133,94133] [94200,94299] [94226,94399] 
Then the output should be = [94133,94133] [94200,94399]

Evaluation Guidelines:
Your work will be evaluated against the following criteria:
- Successful implementation
- Efficiency of the implementation
- Design choices and overall code organization
- Code quality and best practices


User Guide:

1. Run the ApplicationStarter.java
2. Should popup a window asking for Input. 
   i. Enter 1 for file input
   ii.Enter 2 for text input
   
   The right input format: [94133,94133] [94200,94299] [94600,94699]
   
3. It should display you the result i.e. the merged range array

Design and Implementation:

1. Used MVC design Pattern where the Application starter starts the view, and then ZipCodeApplicationController acts as the controller and ZipCodeRange as the model.
2. Chose to sort using Collections.sort over TreeMap because sorting is required only once.
3. JUnit Test Cases are implemented in ZipCodeRangeTest.java
