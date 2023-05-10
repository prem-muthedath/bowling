package bowling.core;

/**
 * `Ball` represents the abstract state of a `Frame` in the bowling game.
 * `subclasses of `Ball` represent concrete `Frame` states in the bowling game.
 *
 * in the bowling game model we've here, a `Ball` object is always associated 
 * with a unique `Frame` -- i.e., a `Frame` always contains a unique `Ball` 
 * object that represents the Frame's current state.  when talking about the 
 * `Frame` associated with a `Ball`, we refer to it as the 'associated Frame.'
 *
 * `Ball` objects manage Frame's state transitions. also, although Frame 
 * computes it's score, it's state decides what score Frame reports to clients.
 *
 * my idea of a ball describing the state of a frame comes from thinking about 
 * an actual bowling game, as well as from seeing a rather crude python design 
 * outline of a bowling game as a state machine somewhere on the Internet. in a 
 * bowling game, a frame at first will be waiting for it's first ball to be 
 * physically rolled in it. you can describe this state as the 'first ball' 
 * state. after the first ball has been rolled in the frame, the frame may now 
 * be waiting for it's second ball to be physically rolled in it, in which case, 
 * its state can be described as 'second ball' state. or if the first ball was a 
 * strike, the frame may now be waiting for it's first strike bonus ball, in 
 * which case the frame's state can be 'first strike bonus ball' state. when a 
 * frame has finally finished scoring, you can describe it's state as 'scored 
 * ball' state, which is frame's final state, because it will no longer be 
 * scoring any more rolls. so, as you can see, in this way, we can use ball to 
 * describe all the states a typical frame will go through in a bowling game!
 *
 * `BallFactory` in bowling.states package makes all subclass instances of Ball.
 *
 * for bowling game scoring, see https://bowl.com/keeping-score
 * bowling terminology, see https://en.wikipedia.org/wiki/Glossary_of_bowling
 *
 * author: Prem Muthedath
 * */

public abstract class Ball {
  /* notifies `Ball` of a current ball roll event in the game.
   * returns true if `Ball`, the current Frame state, is a rolled ball state, 
   * signaling that the current ball was rolled physically in the Frame.
   * default implementation transitions Frame state; subclasses may override.
   */
  protected boolean roll(Frame associatedFrame) {
    associatedFrame.transition();
    return rolled();
  }

  /* is this a rolled ball state?
   * in a rolled ball state, the Frame awaits a physical ball roll in it.
   * default, it returns `false`. subclasses may override this behavior.
   */
  protected boolean rolled() {
    return false;
  }

  /* find the next state to transition to. 'mark' means strike or spare. */
  Ball next(boolean markFrameScore) {
    return markFrameScore ? this.markSuccessor() : this.nonMarkSuccessor();
  }

  /* default implementation for a "mark" Ball's successor (i.e., next state).
   * 'mark' in bowling terminology means strike or spare.
   */
  public Ball markSuccessor() {
    return nonMarkSuccessor();
  }

  /* default implementation for an "open" Ball's successor (i.e., next state).
   * 'mark' in bowling terminology means strike or spare. 'non-mark' = 'open'.
   */
  public Ball nonMarkSuccessor() {
    throw new RuntimeException("Undefined - nonMarkSuccessor()");
  }

  /* default score of Frame instance associated with Ball.
   * Frame delegates to it's state object the responsibility of determining what 
   * score it should report to clients. Frame does this by invoking this method, 
   * passing it's current computed score as argument. Frame object's state then 
   * determines it's actual reported score to clients. unless a Frame has been 
   * fully scored, indicated by it's state, Frame's state will report 0.
   */
  protected int score(int frameScore) {
    return 0;
  }
}
