package bowling;

import bowling.core.Bowling;
import bowling.core.FrameCount;

/* `Tests` class has all unit tests for the bowling game.
 *
 * you can run all the tests in one shot by calling the main method in this 
 * class. test results will be printed to the console in an easy-to-read format.
 *
 * author: Prem Muthedath
 * */

public class Tests {
  public static void main(String[] args) {
    Tests tests=new Tests();
    tests.printHeader();
    tests.testPerfectGame();
    tests.testHeartBreak();
    tests.testTenthFrameSpare();
    tests.testTwoThrowsNoMark();
    tests.testFourThrowsNoMark();
    tests.testSimpleSpare();
    tests.testSimpleFrameAfterSpare();
    tests.testSimpleStrike();
    tests.testEndOfArray();
    tests.testSampleGame();
    tests.testAllDucks();
    tests.testFrameLimit();
    tests.testUnfinishedSpare();
    tests.testUnfinishedStrike();
    tests.testUnfinishedOpen();
    tests.testMoreThanAllowedFrames();
    tests.testZeroStrikeBonus();
    tests.testZeroSpareBonus();
    tests.testValidFrame();
    tests.testInvalidFrame();
    tests.testNegativePins();
    tests.testNegativePinsLater();
    tests.testMoreThanTenPins();
    tests.testInvalidRoll();
    tests.testGT10PinsAfterStrike();
  }

  private Bowling bowling() {
    return Bowling.newGame();
  }

  private int pinCount(int pins) {
    return pins;
  }

  private FrameCount frameCount(int id) {
    return new FrameCount(id);
  }

  private void printHeader() {
    System.out.printf("%-40s %-25s  %-25s %-10s \n", "   TEST  ", "EXPECTED SCORE", "ACTUAL SCORE", "STATUS");
  }

  private void printScore(String test, int expected, int actual) {
    System.out.printf("%-45s %-10s %-15s %-10s %-10s %-10s \n",
        test, expected, "", actual, "", status(expected, actual));
  }

  private String status(int expected, int actual) {
    if (expected==actual) return "PASS";
    return "FAIL";
  }

  private void testPerfectGame() {
    Bowling game=bowling();
    for (int i=0; i<12; i++)
      game.roll(pinCount(10));
    printScore("testPerfectGame", 300, game.score());
  }

  private void testHeartBreak()  {
    Bowling game=bowling();
    for (int i=0; i<11; i++)
      game.roll(pinCount(10));
    game.roll(pinCount(9));
    printScore("testHeartBreak", 299, game.score());
  }

  private void testTenthFrameSpare() {
    Bowling game=bowling();
    for (int i=0; i<9; i++)
      game.roll(pinCount(10));
    game.roll(pinCount(9));
    game.roll(pinCount(1));
    game.roll(pinCount(1));
    printScore("testTenthFrameSpare", 270, game.score());
  }

  public void testTwoThrowsNoMark() {
    Bowling game=bowling();
    game.roll(pinCount(5));
    game.roll(pinCount(4));
    printScore("testTwoThrowsNoMark", 9, game.score());
  }

  public void testFourThrowsNoMark() {
    Bowling game=bowling();
    game.roll(pinCount(5));
    game.roll(pinCount(4));
    game.roll(pinCount(7));
    game.roll(pinCount(2));
    printScore("testFourThrowsNoMark - GAME", 18, game.score());
    printScore("testFourThrowsNoMark - FRAME: 1", 9, game.score(frameCount(1)));
    printScore("testFourThrowsNoMark - FRAME: 2", 18, game.score(frameCount(2)));
  }

  public void testSimpleSpare() {
    Bowling game=bowling();
    game.roll(pinCount(3));
    game.roll(pinCount(7));
    game.roll(pinCount(3));
    printScore("testSimpleSpare - FRAME: 1", 13, game.score(frameCount(1)));
  }

  public void testSimpleFrameAfterSpare() {
    Bowling game=bowling();
    game.roll(pinCount(3));
    game.roll(pinCount(7));
    game.roll(pinCount(3));
    game.roll(pinCount(2));
    printScore("testSimpleFrameAfterSpare - FRAME: 1", 13, game.score(frameCount(1)));
    printScore("testSimpleFrameAfterSpare - FRAME: 2", 18, game.score(frameCount(2)));
    printScore("testSimpleFrameAfterSpare - GAME", 18, game.score());
  }

  public void testSimpleStrike()  {
    Bowling game=bowling();
    game.roll(pinCount(10));
    game.roll(pinCount(3));
    game.roll(pinCount(6));
    printScore("testSimpleStrike - FRAME: 1", 19, game.score(frameCount(1)));
    printScore("testSimpleStrike - GAME", 28, game.score());
  }

  public void testEndOfArray()  {
    Bowling game=bowling();
    for (int i=0; i<9; i++) {
      game.roll(pinCount(0));
      game.roll(pinCount(0));
    }
    game.roll(pinCount(2));
    game.roll(pinCount(8)); // 10th frame spare
    game.roll(pinCount(10)); // Strike in last position of array.
    printScore("testEndOfArray", 20, game.score());
  }

  public void testSampleGame()  {
    Bowling game=bowling();
    game.roll(pinCount(1));   // 1
    game.roll(pinCount(4));   // 2
    game.roll(pinCount(4));   // 3
    game.roll(pinCount(5));   // 4
    game.roll(pinCount(6));   // 5
    game.roll(pinCount(4));   // 6
    game.roll(pinCount(5));   // 7
    game.roll(pinCount(5));   // 8
    game.roll(pinCount(10));  // 9
    game.roll(pinCount(0));   // 10
    game.roll(pinCount(1));   // 11
    game.roll(pinCount(7));   // 12
    game.roll(pinCount(3));   // 13
    game.roll(pinCount(6));   // 14
    game.roll(pinCount(4));   // 15
    game.roll(pinCount(10));  // 16
    game.roll(pinCount(2));   // 17
    game.roll(pinCount(8));   // 18
    game.roll(pinCount(6));   // 19
    printScore("testSampleGame", 133, game.score());
  }

  public void testAllDucks()  {
    Bowling game=bowling();
    for (int i=0; i<20; i++) {
      game.roll(pinCount(0));
    }
    printScore("testAllDucks", 0, game.score());
  }

  public void testFrameLimit()  {
    Bowling game=bowling();
    for (int i=0; i<20; i++) {
      game.roll(pinCount(1));
      game.roll(pinCount(1));
    }
    printScore("testFrameLimit", 20, game.score());
  }

  public void testUnfinishedSpare()  {
    Bowling game=bowling();
    game.roll(pinCount(2));
    game.roll(pinCount(1));
    game.roll(pinCount(3));
    game.roll(pinCount(7));
    printScore("testUnfinishedSpare", 3, game.score());
  }

  public void testUnfinishedStrike()  {
    Bowling game=bowling();
    game.roll(pinCount(10));
    game.roll(pinCount(5));
    printScore("testUnfinishedStrike - FRAME: 1", 0, game.score(frameCount(1)));
    printScore("testUnfinishedStrike - GAME", 0, game.score());
  }

  public void testUnfinishedOpen()  {
    Bowling game=bowling();
    game.roll(pinCount(2));
    game.roll(pinCount(1));
    game.roll(pinCount(3));
    printScore("testUnfinishedOpen", 3, game.score());
  }

  public void testMoreThanAllowedFrames()  {
    Bowling game=bowling();
    game.roll(pinCount(2));
    game.roll(pinCount(5));
    game.roll(pinCount(3));
    printScore("testMoreThanAllowedFrames", 7, game.score());
  }

  public void testZeroStrikeBonus()  {
    Bowling game=bowling();
    game.roll(pinCount(10));
    game.roll(pinCount(0));
    game.roll(pinCount(0));
    game.roll(pinCount(5));
    printScore("testZeroStrikeBonus", 10, game.score());
  }

  public void testZeroSpareBonus()  {
    Bowling game=bowling();
    game.roll(pinCount(2));
    game.roll(pinCount(8));
    game.roll(pinCount(0));
    game.roll(pinCount(10));
    game.roll(pinCount(10));
    printScore("testZeroSpareBonus", 30, game.score());
  }

  public void testValidFrame()  {
    Bowling game=bowling();
    game.roll(pinCount(2));
    game.roll(pinCount(1));
    game.roll(pinCount(3));
    game.roll(pinCount(6));
    printScore("testValidFrame - GAME", 12, game.score());
    printScore("testValidFrame - FRAME: 1", 3, game.score(frameCount(1)));
  }

  public void testInvalidFrame()  {
    Bowling game=bowling();
    game.roll(pinCount(4));
    game.roll(pinCount(1));
    game.roll(pinCount(3));
    game.roll(pinCount(6));
    printScore("testInvalidFrame - GAME", 14, game.score());
    printScore("testInvalidFrame - FRAME: -3", 0, game.score(frameCount(-3)));
  }

  public void testNegativePins()  {
    // this method is expected to throw an exception which is then caught.
    Bowling game=bowling();
    try {
        game.roll(pinCount(-2));  // negative pins right at the start
        game.roll(pinCount(5));
        game.roll(pinCount(3));
        System.out.println("7: "+game.score(frameCount(200)));
    } catch(Exception e) {
        printScore("testNegativePins: EXCEPTION THROWN", 0, game.score());
    }
  }

  public void testNegativePinsLater()  {
    Bowling game=bowling();
    try {
        game.roll(pinCount(2));
        game.roll(pinCount(5));
        game.roll(pinCount(3));
        game.roll(pinCount(-1));  // negative pins after a few OK rolls.
        System.out.println("0: "+game.score(frameCount(200)));
    } catch(Exception e) {
        printScore("testNegativePinsLater: EXCEPTION THROWN", 7, game.score());
    }
  }

  public void testMoreThanTenPins()  {
    // this method is expected to throw an exception which is then caught.
    Bowling game=bowling();
    try {
        game.roll(pinCount(2));
        game.roll(pinCount(5));
        game.roll(pinCount(3));
        game.roll(pinCount(6));
        game.roll(pinCount(11)); // 11 > 10
        printScore("testMoreThanTenPins: NO EXCEPTION THROWN", 0, game.score());
    } catch(Exception e) {
        printScore("testMoreThanTenPins: EXCEPTION THROWN", 16, game.score());
    }
  }

  public void testInvalidRoll()  {
    // this method is expected to throw an exception which is then caught.
    Bowling game=bowling();
    try {
        game.roll(pinCount(10));
        game.roll(pinCount(5));
        game.roll(pinCount(6)); // can NOT happen, b'coz 5 + 6 = 11 > 10
        game.roll(pinCount(7));
        game.roll(pinCount(1));
        game.roll(pinCount(10));
        printScore("testInvalidRoll: NO EXCEPTION THROWN", 10, game.score());
    } catch(Exception e) {
        printScore("testInvalidRoll: EXCEPTION THROWN", 0, game.score());
    }
  }

  public void testGT10PinsAfterStrike() {
    // this method is expected to throw an exception which is then caught.
    Bowling game=bowling();
    try {
        game.roll(pinCount(1));
        game.roll(pinCount(4));
        game.roll(pinCount(4));
        game.roll(pinCount(5));
        game.roll(pinCount(6));
        game.roll(pinCount(4));
        game.roll(pinCount(5));
        game.roll(pinCount(5));
        game.roll(pinCount(10));
        game.roll(pinCount(0));
        game.roll(pinCount(1));
        game.roll(pinCount(7));
        game.roll(pinCount(3));
        game.roll(pinCount(6));
        game.roll(pinCount(4));
        game.roll(pinCount(10));
        game.roll(pinCount(10));  // strike
        game.roll(pinCount(3));
        game.roll(pinCount(9)); // 3 + 9 = 12 > 10
        printScore("testGT10PinsAfterStrike: NO EXCEPTION THROWN", 0, game.score());
    } catch(Exception e) {
        printScore("testGT10PinsAfterStrike: EXCEPTION THROWN", 120, game.score());
    }
  }
}
