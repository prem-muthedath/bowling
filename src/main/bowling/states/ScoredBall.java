package bowling.states;

import bowling.core.Ball;
import bowling.core.Frame;

/**
 * represents the state of a Frame that has been fully scored, meaning the Frame 
 * is no longer in play and therefore not scoring anymore rolls.
 *
 * see `BallFactory` in bowling.states package on `ScoredBall` creation.
 *
 * for bowling game scoring, see https://bowl.com/keeping-score
 * bowling terminology, see https://en.wikipedia.org/wiki/Glossary_of_bowling
 *
 * author: Prem Muthedath
 *
 * */

class ScoredBall extends Ball {
  /* when notified of a current ball roll event in the game, `ScoredBall` state 
   * does not ask it's associated Frame to transition state, because this state 
   * is the final Frame state, and the Frame's score is final as well; instead, 
   * it asks the Frame to ignore the current roll, meaning to ignore or rollback 
   * any pins the Frame has added from the current roll. in this way, 
   * `ScoredBall` ensures no change to Frame's state and score.
   */
  protected boolean roll(Frame associatedFrame) {
    associatedFrame.ignoreCurrentRoll();
    return rolled();  // calls the default `rolled()` in `Ball`.
  }

  /* the `ScoredBall` state reports the `Frame` score as is, without any change, 
   * because the `Frame` is fully scored in this state, and it's score is final.
   */
  protected int score(int frameScore) {
    return frameScore;
  }
}
