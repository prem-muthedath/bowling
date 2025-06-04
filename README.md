#### Bowling

Bowling game designed as a state machine.

Uncle Bob's code from XP Bowling episode is widely considered a solid 
object-oriented design for a bowling game (see 
`notes/uncle-bob-bowling-game-code.txt`). But I spotted one issue with it: a 
single object was both aggregating frame scores as well as scoring each frame -- 
mixing two distinct responsibilities.

I, therefore, explored several other designs, and I eventually found the design 
using the state pattern as the only satisfactory one.

With this design, `Bowling` just aggregates frame scores, and the logic for 
scoring a frame is distributed between `Frame` and its states -- represented as 
`Ball` objects.

This design accommodates your usual needs: (a) you can score a game in progress 
as well as a completed one; (b) it does not tally incomplete frame scores; and 
(c) it checks for invalid pin counts, frame scores, and frame counts.

The design combines my own ideas about object-oriented programming with 
influences from:

- Kent Beck's Implementation Patterns
- Kent Beck's Test-Driven Development
- Object Calisthenics by Jeff Bay in Thoughtworks Anthology
- Law of Demeter
- Dependency Injection
- "Tell, don't ask" principle by Dave Thomas & Andy Hunt
- Fred George's presentation at Agile India 2013 in Bangalore


##### HOW TO RUN THE TESTS FROM A TERMINAL:

1. `cd` into project root -- the top directory containing this README file.
2. If you do not already have a `bin` directory there, create an empty one.  
   This is needed for compilation in step 3.
3. Type the following command to compile:

     ````
     javac -d bin -sourcepath src/main:src/tests  src/tests/bowling/Tests.java

4. Press enter.
5. Type the following command to run the tests:

     ````
     java -classpath bin bowling.Tests

6. Press enter.
7. You will see Expected & Actual scores and PASS/FAIL status for each test (see 
   `notes/sample-test-results.txt` for a sample test output).

