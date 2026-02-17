****************
* Project 1 - Deterministic Finite Automata
* CS 361 002
* 2/16/2026
* Leo Haener-Pope, Lucas Coltrin
**************** 


OVERVIEW:


This is a Java project that represents a Definite Finite Automata. In DFA.java, there are functions that let users define the elements of the 5-tuple of a DFA, and also see if a given string is acceptable in DFA. The program is ran with the test file DFATest.java.




INCLUDED FILES:
 * test/dfa/DFATest.java - source and test file
 * fa/State.java - source file
 * fa/FAInterface.java - source file
 * fa/dfa/DFAInterface.java - source file
 * fa/dfa/DFA.java - Implementation of Java DFA
 * fa/dfa/DFAState.java - Extended State to be used in DFA
 * README - this file




COMPILING AND RUNNING:
The project is ran by the tester DFATest.java
As stated by the assignment, use these commands to compile and run the test in Onyx:

`javac -cp .:/usr/share/java/junit.jar ./test/dfa/DFATest.java`

`java -cp .:/usr/share/java/junit.jar:/usr/share/java/hamcrest/hamcrest.jar
org.junit.runner.JUnitCore test.dfa.DFATest`


 Console output will give the results after the program finishes.




PROGRAM DESIGN AND IMPORTANT CONCEPTS:

This function uses the DFA.java to handle most of the load of defining what a Definite Finite Automata is. It contains all five of the 5-tuples variables stored in it and handles those within the file. The DFAState.java only uses super to extend State.java, and it overrides the Java equals method in order to check if the names of the DFAStates that are being compared are equal (it also overrides the hashCode function, but it doesn't do anything as Java wants you to override the hashCode function when overriding equals).

Most of the variables are stored and played around with how you would most likely think they would. Transitions are stored as a HashMap inside of a HashMap, with Map<InState, Map<AlphabetCharacter, OutState>>. Ultimately, the DFA functions were filled out to satisfy the given directions in DFAInterface.java and FAInterface.java. There is a also a toString function that prints out the 5-tuple according to how the DFATest.java wanted the output to look like.


TESTING:

We tested the program with the given tester program. You are able to run the tests on Onyx, but VSCode also lets you use their Java Projects testing functionality to run each test as well. Ultimately, it was pretty easy to test the program, as VSCode lets you debug each test as well, so if there was anything that went wrong, it was easy to pinpoint what was happening within the code. This program can mostly handle bad input, as the functions follow the definitions defined in the given interfaces, which seem to be focused on handling bad input pretty well. The toString function may need to be worked on though to make this program 100% bad input proof, because there may be some funky looking output if certain parts of the DFA aren't defined by the user before the toString() is called.



DISCUSSION:
 
 There were not really that many issues that came up when programming. The hardest part of this project was probably deciding which implementation of the Java Map and Set to use. We ended up using LinkedHashSet and HashMap for our variables. At first, we used HashSet, but then we realized that the toString function needed to know the order in which things were added, according to the DFATest.java file.
 
 This project was not too challenging, as DFAs are a decently simple concept by themselves, with very specific rules about them that make them easily definable in Java. One error that happened was that in the check to see if a given string matched a DFA, the final state check was placed before the current state update happened, which created some problems with the tester. Fortunately, the bug was pinpointed pretty fast. Ultimately, this project was a very fun and interesting challenge.
 
EXTRA CREDIT:


N/A


SOURCES:

Java Docs for Maps and Sets Documentation: https://docs.oracle.com/en/java/
Java Overriding Equals Function: https://www.geeksforgeeks.org/java/override-equalsobject-hashcode-method/