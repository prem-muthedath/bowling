Bowling
=======

Bowling Game designed as a state machine.  

I refactored Uncle Bob's code from the XP Bowling episode.  One problem I saw with Unlce Bob's code was that 
one object was both aggregating frame scores as well as scoring each frame. 

I tried many designs, but I found the design using the state pattern as the only satisfactory one.

With this design, Bowling just aggregates frame scores, and the logic for scoring a frame is distributed
between Frame and its states (Ball objects here).

This design is also based on what I learned about OO from:

- Kent Beck's Implementation Patterns
- Kent Beck's Test-Driven Development
- Object Calisthenics by Jeff Bay in Thoughtworks Anthology
- Law of Demeter
- Dependency Injection
- "Tell, don't ask" principle by Dave Thomas & Andy Hunt
- Fred George's presentation at Agile India 2013 in Bangalore


HOW TO RUN THE TESTS FROM A TERMINAL:

1. cd to bowling directory -- the top directory of the app containing this README file.
2. Type the following command to compile: 

		javac -d bin -sourcepath src/main:src/tests  src/tests/bowling/Tests.java

3. Press enter.
4. Type the following command to run the tests:
	
 		java -classpath bin bowling.Tests

5. Press enter.
6. You should see the following output: Expected and Actual values for each test.
	