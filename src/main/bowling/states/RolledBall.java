package bowling.states;

import bowling.core.Ball;

/* represents the state of a Frame that is waiting to receive the current ball 
 * roll in the bowling game; i.e., the state of a frame that is waiting for the 
 * current ball in the bowling game to be physically rolled in it. a Frame 
 * starts off in the `RolledBall` state, waiting for it's 1st roll.
 *
 * design:
 * in the bowling game, a frame usually gets 2 ball rolls -- the first and the 
 * second. in both these situations, the frame is waiting for the current ball 
 * in the bowling game to be physically rolled in it. to model both these 2 
 * rolls, the `RolledBall`, a subclass of `Ball`, takes a `Ball` in it's 
 * constructor, and uses this parameter to vary behavior for 1st & 2nd rolls.  
 * by this design, `RolledBall` class is able to factor the common code (see  
 * `rolled()` method below) for 1st and 2nd rolls in a Frame, while also 
 * accommodating variations.
 *
 * see `BallFactory` in bowling.states package on `RolledBall` creation.
 *
 * for bowling game scoring, see https://bowl.com/keeping-score
 * bowling terminology, see https://en.wikipedia.org/wiki/Glossary_of_bowling
 *
 * author: Prem Muthedath
 *
 * */

class RolledBall extends Ball {
  private Ball ball;

  // `BallFactory` class in bowling.states package makes `RolledBall` instances.
  RolledBall(Ball ball) {
    this.ball=ball;
  }

  // was the current ball physically rolled in RolledBall's associated Frame?
  // yes, `true` for both 1st & 2nd balls rolled in a Frame.
  protected boolean rolled() {
    return true;
  }

  // delegates to it's `Ball` object to find the next state.
  // 'mark' in bowling terminology means strike or spare.
  public Ball markSuccessor() {
    return this.ball.markSuccessor();
  }

  // delegates to it's `Ball` object to find the next state.
  // 'mark' in bowling terminology means strike or spare.
  public Ball nonMarkSuccessor() {
    return this.ball.nonMarkSuccessor();
  }
}
