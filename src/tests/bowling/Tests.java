package bowling;

import bowling.core.Bowling;
import bowling.core.FrameCount;

/**
 * `Tests` class has all unit tests for the bowling game.
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
    tests.testUnplayedGame();
    tests.testPerfectGame();
    tests.testHeartBreak();
    tests.testTenthFrameSpare();
    tests.testNinthFrameSpare();
    tests.testTenthFrameStrike();
    tests.testNinthFrameSrike();
    tests.testTwoThrowsNoMark();
    tests.testFourThrowsNoMark();
    tests.testSimpleSpare();
    tests.testSimpleFrameAfterSpare();
    tests.testSimpleStrike();
    tests.testTenthFrameSpareAndStrike();
    tests.testSampleGame();
    tests.testAllDucks();
    tests.testFrameLimit();
    tests.testUnfinishedSpare();
    tests.testUnfinishedStrike();
    tests.testUnfinishedOpen();
    tests.testZeroStrikeBonus();
    tests.testZeroSpareBonus();
    tests.testValidFrameCount();
    tests.testZeroFrameCount();
    tests.testGT10FrameCount();
    tests.testNegativeFrameCount();
    tests.testNegativePinsAtStart();
    tests.testNegativePinsLater();
    tests.testMoreThanTenPins();
    tests.testInvalidRoll();
    tests.testInvalidRollAfterSpare();
    tests.testInvalidRollAfterStrike();
    tests.testGT10PinsAfterSpare();
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

  private void testUnplayedGame() {
    Bowling game = bowling();
    printScore("testUnplayedGame", 0, game.score());
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
    game.roll(pinCount(1)); // spare 9 + 1 = 10
    game.roll(pinCount(1));
    printScore("testTenthFrameSpare", 270, game.score());
  }

  private void testNinthFrameSpare() {
    Bowling game = bowling();
    for (int i=0; i<16; i++)
      game.roll(pinCount(0));
    game.roll(pinCount(9));
    game.roll(pinCount(1)); // spare, 9 + 1 = 10
    game.roll(pinCount(6));
    game.roll(pinCount(3));
    printScore("testNinthFrameSpare", 25, game.score());
  }

  private void testTenthFrameStrike() {
    // https://programmingpraxis.com/2009/08/11/uncle-bobs-bowling-game-kata/
    // 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 10,1,2 (A strike in the 10th frame should = 13)
    Bowling game = bowling();
    for (int i=0; i<18; i++)
      game.roll(pinCount(0));
    game.roll(pinCount(10));
    game.roll(pinCount(1));
    game.roll(pinCount(2));
    printScore("testTenthFrameStrike", 13, game.score());
  }

  private void testNinthFrameSrike() {
    // https://programmingpraxis.com/2009/08/11/uncle-bobs-bowling-game-kata/
    // 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 10, 1,1 (A strike in the 9th frame should = 14)
    Bowling game = bowling();
    for (int i=0; i<16; i++)
      game.roll(pinCount(0));
    game.roll(pinCount(10));
    game.roll(pinCount(1));
    game.roll(pinCount(1));
    printScore("testNinthFrameSrike", 14, game.score());
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
    printScore("testFourThrowsNoMark - FRAMES: 1", 9, game.score(frameCount(1)));
    printScore("testFourThrowsNoMark - FRAMES: 2", 18, game.score(frameCount(2)));
  }

  public void testSimpleSpare() {
    Bowling game=bowling();
    game.roll(pinCount(3));
    game.roll(pinCount(7));
    game.roll(pinCount(3));
    printScore("testSimpleSpare - GAME", 13, game.score());
    printScore("testSimpleSpare - FRAMES: 1", 13, game.score(frameCount(1)));
  }

  public void testSimpleFrameAfterSpare() {
    Bowling game=bowling();
    game.roll(pinCount(3));
    game.roll(pinCount(7));
    game.roll(pinCount(3));
    game.roll(pinCount(2));
    printScore("testSimpleFrameAfterSpare - GAME", 18, game.score());
    printScore("testSimpleFrameAfterSpare - FRAMES: 1", 13, game.score(frameCount(1)));
    printScore("testSimpleFrameAfterSpare - FRAMES: 2", 18, game.score(frameCount(2)));
  }

  public void testSimpleStrike()  {
    Bowling game=bowling();
    game.roll(pinCount(10));
    game.roll(pinCount(3));
    game.roll(pinCount(6));
    printScore("testSimpleStrike - GAME", 28, game.score());
    printScore("testSimpleStrike - FRAMES: 1", 19, game.score(frameCount(1)));
  }

  public void testTenthFrameSpareAndStrike()  {
    Bowling game=bowling();
    for (int i=0; i<9; i++) {
      game.roll(pinCount(0));
      game.roll(pinCount(0));
    }
    game.roll(pinCount(2));
    game.roll(pinCount(8)); // 10th frame spare
    game.roll(pinCount(10)); // Strike in last position of array.
    printScore("testTenthFrameSpareAndStrike", 20, game.score());
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
    printScore("testSampleGame -- GAME", 133, game.score());
    printScore("testSampleGame - FRAMES: 200", 133, game.score(frameCount(200)));
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
    printScore("testUnfinishedSpare -- GAME", 3, game.score());
    printScore("testUnfinishedSpare - FRAMES: 2", 3, game.score(frameCount(2)));
  }

  public void testUnfinishedStrike()  {
    Bowling game=bowling();
    game.roll(pinCount(10));
    game.roll(pinCount(5));
    printScore("testUnfinishedStrike - GAME", 0, game.score());
    printScore("testUnfinishedStrike - FRAMES: 1", 0, game.score(frameCount(1)));
  }

  public void testUnfinishedOpen()  {
    Bowling game=bowling();
    game.roll(pinCount(2));
    game.roll(pinCount(1));
    game.roll(pinCount(3));
    printScore("testUnfinishedOpen -- GAME", 3, game.score());
    printScore("testUnfinishedOpen - FRAMES: 2", 3, game.score(frameCount(2)));
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

  public void testValidFrameCount()  {
    Bowling game=bowling();
    game.roll(pinCount(2));
    game.roll(pinCount(1));
    game.roll(pinCount(3));
    game.roll(pinCount(6));
    printScore("testValidFrameCount - GAME", 12, game.score());
    printScore("testValidFrameCount - FRAMES: 1", 3, game.score(frameCount(1)));
  }

  public void testZeroFrameCount()  {
    Bowling game=bowling();
    game.roll(pinCount(6));
    game.roll(pinCount(3));
    game.roll(pinCount(1));
    game.roll(pinCount(4));
    printScore("testZeroFrameCount - GAME", 14, game.score());
    printScore("testZeroFrameCount - FRAMES: 0", 0, game.score(frameCount(0)));
  }

  private void testGT10FrameCount() {
    Bowling game=bowling();
    for (int i=0; i<20; i++) {
      game.roll(pinCount(2));
    }
    printScore("testGT10FrameCount - GAME", 200, game.score());
    printScore("testGT10FrameCount - FRAMES: 100", 200, game.score(frameCount(100)));
  }

  public void testNegativeFrameCount()  {
    Bowling game=bowling();
    game.roll(pinCount(4));
    game.roll(pinCount(1));
    game.roll(pinCount(3));
    game.roll(pinCount(6));
    printScore("testNegativeFrameCount - GAME", 14, game.score());
    printScore("testNegativeFrameCount - FRAMES: -3", 0, game.score(frameCount(-3)));
  }

  public void testNegativePinsAtStart()  {
    // this method is expected to throw an exception which is then caught.
    Bowling game=bowling();
    try {
        game.roll(pinCount(-2));  // negative pins right at the start
        game.roll(pinCount(5));
        game.roll(pinCount(3));
        System.out.println("0: "+game.score(frameCount(200)));
    } catch(Exception e) {
        printScore("testNegativePinsAtStart: EXCEPTION THROWN", 0, game.score());
        printScore("testNegativePinsAtStart - FRAMES: 1 : ERR", 0, game.score(frameCount(1)));
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
        printScore("testNegativePinsLater - FRAMES: 2 : ERR", 7, game.score(frameCount(2)));
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
        game.roll(pinCount(1));
        game.roll(pinCount(3));
        printScore("testMoreThanTenPins: NO EXCEPTION THROWN", 0, game.score());
    } catch(Exception e) {
        printScore("testMoreThanTenPins: EXCEPTION THROWN", 16, game.score());
        printScore("testMoreThanTenPins - FRAMES: 3 : ERR", 16, game.score(frameCount(3)));
    }
  }

  public void testInvalidRoll()  {
    // this method is expected to throw an exception which is then caught.
    Bowling game=bowling();
    try {
        game.roll(pinCount(1));
        game.roll(pinCount(5));
        game.roll(pinCount(6));
        game.roll(pinCount(7)); // 6 + 7 = 13 > 10, can NOT happen!
        game.roll(pinCount(3));
        game.roll(pinCount(4));
        printScore("testInvalidRoll: NO EXCEPTION THROWN", -10, game.score());
    } catch(Exception e) {
        printScore("testInvalidRoll: EXCEPTION THROWN", 6, game.score());
        printScore("testInvalidRoll - FRAMES: 2 : ERR", 6, game.score(frameCount(2)));
    }
  }

  public void testInvalidRollAfterSpare()  {
    // this method is expected to throw an exception which is then caught.
    Bowling game=bowling();
    try {
        game.roll(pinCount(4));
        game.roll(pinCount(6)); // spare: 4 + 6 = 10
        game.roll(pinCount(5));
        game.roll(pinCount(6)); // can NOT happen, b'coz 5 + 6 = 11 > 10
        game.roll(pinCount(7));
        game.roll(pinCount(1));
        game.roll(pinCount(10));
        printScore("testInvalidRollAfterSpare: NO EXCEPTION THROWN", 0, game.score());
    } catch(Exception e) {
        printScore("testInvalidRollAfterSpare: EXCEPTION THROWN", 15, game.score());
    }
  }

  public void testInvalidRollAfterStrike() {
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
        printScore("testInvalidRollAfterStrike: NO EXCEPTION THROWN", 0, game.score());
    } catch(Exception e) {
        printScore("testInvalidRollAfterStrike: EXCEPTION THROWN", 120, game.score());
    }
  }

  public void testGT10PinsAfterSpare()  {
    // this method is expected to throw an exception which is then caught.
    Bowling game=bowling();
    try {
        game.roll(pinCount(2));
        game.roll(pinCount(6));
        game.roll(pinCount(4));
        game.roll(pinCount(6));  // spare: 4 + 6 = 10
        game.roll(pinCount(15)); // > 10 pins after spare
        game.roll(pinCount(6));
        game.roll(pinCount(7));
        game.roll(pinCount(1));
        game.roll(pinCount(10));
        printScore("testGT10PinsAfterSpare: NO EXCEPTION THROWN", -10, game.score());
    } catch(Exception e) {
        printScore("testGT10PinsAfterSpare: EXCEPTION THROWN", 8, game.score());
    }
  }

  public void testGT10PinsAfterStrike() {
    // this method is expected to throw an exception which is then caught.
    Bowling game=bowling();
    try {
        game.roll(pinCount(2));
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
        game.roll(pinCount(19));  // 19 > 10
        printScore("testGT10PinsAfterStrike: NO EXCEPTION THROWN", 0, game.score());
    } catch(Exception e) {
        printScore("testGT10PinsAfterStrike: EXCEPTION THROWN", 121, game.score());
    }
  }
}
