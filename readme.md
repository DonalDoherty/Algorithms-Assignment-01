Algorithms Assignment 0
Donal Doherty
04.11.16

This program reads in a list of 10,000 terms into an ArrayList, using the abstract data type "Term"

This program contains three functions.
1. To get the weight of a Term
2. To get the best match for a prefix
3. To get a list of k matches for a prefix

User input is required for all functions, and all methods are using a Brute Force approach.

-Testing-
For the purposes of this assignment I have written two JUnit test cases.
BruteTest tests the three methods as outlined in the interface.
Each method also has an invalid test, which checks if the validation I have put in place works.
TermListTest simply checks that the list was built correctly and that the correct amount of terms have been added.

-Known Bugs/Issues-
-No exception handling in driver
-Quick AutoComplete not implemented
-List is not sorted

