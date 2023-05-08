package bowling.core;

/* represents a Bowling game, it's starting point.
 * Bowling object aggregates frame scores to report game score.
 *
 * has API for recording pins for a roll as well as for reporting game score.
 * clients simulate the game by calling exposed APIs to add pins & report score.
 *
 * for bowling game scoring, see https://bowl.com/keeping-score
 * bowling terminology, see https://en.wikipedia.org/wiki/Glossary_of_bowling
 *
 * author: Prem Muthedath
 * */
 public class Bowling {
  public static final int FRAMES=10;  // max no of frames in the game
  static final int PINS=10;           // # of pins to knock out for each frame.

  private Frame[] frames;             // array of frames

  // constructor with package visibility.
  // package visibility limits creation of invalid Bowling objects, because 
  // objects outside the package can not -- and should not -- create a Bowling 
  // instance. instead, clients should call the class method to get an instance.
  Bowling(Frame[] frames) {
    this.frames=java.util.Arrays.copyOfRange(frames, 0, Bowling.FRAMES);
  }

  // create a valid Bowling instance.
  // clients should call this class method to get a Bowling instance.
  // in haskell parlance, this class method is known as a "smart" constructor.
  public static Bowling newGame() {
    return new Configuration().newGame();
  }

  // record/score a ball roll event in a bowling game.
  //
  // when a ball roll event occurs in the game, Bowling informs its Frame 
  // objects about the event, so that they may record/score the roll. in this 
  // function, Bowling informs its Frame objects about the ball roll by spinning 
  // through it's Frame objects and invoking the corresponding API in those 
  // objects to record/score the roll. each call's return value is monitored, 
  // and looping continues through the Frame objects until one of the calls 
  // returns true, at which point the loop is exited. a `true` value returned by 
  // a Frame object identifies itself as the "current" frame where the ball roll 
  // physically occurred (the frame's state object detects this event).  All 
  // other Frame objects will return false. each called Frame will either 
  // record/score the ball roll or ignore it altogether depending on its state.
  //
  // so, in summary, unlike other designs, we do not here explicitly keep track 
  // of a "current" frame. instead, the "current" frame has the responsibility 
  // to identify itself. whenever a ball roll happens, Bowling informs all 
  // frames in active play, which includes the "current" frame where the current 
  // ball in the game was physically rolled as well as all preceeding frames.  
  // each called frame, based on its state, has the responsibility to either 
  // record/score the roll or ignore it altogether.
  //
  // this method can throw a runtime exception in case of a "bad" roll.
  public void roll(int pins)  {
    for (Frame each : this.frames) {
      if (each.roll(pins)) return;
    }
  }

  // compute current game score.
  // Note: game score totals scores of all frames, but frames that are still 
  // being scored will report their score as 0, even though their actual pin 
  // count may be > 0. these frames do so simply because their final scores are 
  // not yet determined. because of this behavior, the game score reported here 
  // actually only reflects the total of all fully-scored frames' scores.
  public int score() {
    return score(this.frames.length);
  }

  // compute total score for specified number of frames, starting from first.
  // Note: frames numbered 0 - 9; score computed only for frames that are fully 
  // scored. for example, if you call score(FrameCount(4)), then score will 
  // aggregate scores of frames numbered 0 - 3 (i.e., the first 4 frames) that 
  // have been fully scored. if say frame numbered 3 is still being scored, 
  // while frames 0 - 2 have been fully scored, then frame 3 will return a score 
  // of 0 (even if it's pin count may be > 0), because it's final score is not 
  // yet determined, so score will only reflect the total of frames 0-2 scores.
  public int score(FrameCount count) {
    return count.score(this);
  }

  // compute total score for specified number of frames.
  int score(int frameCount) {
    int score=0;
    for (int i=0; i < frameCount; i++)
        score+=this.frames[i].score();
    return score;
  }
}
