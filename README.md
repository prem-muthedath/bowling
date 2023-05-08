Bowling
=======

Bowling Game designed as a state machine.

Uncle Bob's code from XP Bowling episode is considered a good OO design of a 
bowling game. But one problem I saw with Unlce Bob's code was that one object 
was both aggregating frame scores as well as scoring each frame.

I therefore, on my own, cooked up and tried many other designs, and I eventually 
found the design using the state pattern as the only satisfactory one.

With this design, Bowling just aggregates frame scores, and the logic for scoring a frame is distributed
between Frame and its states (Ball objects here).

The design is also quite robust: (a) it does not score incomplete frames; and 
(b) it checks for invalid pin counts, frame scores, as well as frame counts.

The design is largely based on what I learned about OO from:

- Kent Beck's Implementation Patterns
- Kent Beck's Test-Driven Development
- Object Calisthenics by Jeff Bay in Thoughtworks Anthology
- Law of Demeter
- Dependency Injection
- "Tell, don't ask" principle by Dave Thomas & Andy Hunt
- Fred George's presentation at Agile India 2013 in Bangalore


HOW TO RUN THE TESTS FROM A TERMINAL:

1. `cd` to bowling directory -- the top directory containing this README file.
2. If a `bin` directory does not exist, create an empty `bin` directory at the 
   same level as this README file. this is needed for compilation in step 3.
3. Type the following command to compile:

     ````
     javac -d bin -sourcepath src/main:src/tests  src/tests/bowling/Tests.java

4. Press enter.
5. Type the following command to run the tests:

     ````
     java -classpath bin bowling.Tests

6. Press enter.
7. You will see the Expected & Actual scores and PASS/FAIL status for each test.

