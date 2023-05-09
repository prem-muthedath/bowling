package bowling.core;

import bowling.states.BallFactory;

/**
 * this object "configures" a bowling game, meaning it does all the work to 
 * create a valid Bowling instance.
 *
 * author: Prem Muthedath
 * */
class Configuration {
  /* create a new Bowling instance. */
  Bowling newGame() {
    return new Bowling(frames());
  }

  /* create all frames in the bowling game. */
  private Frame[] frames() {
    Frame[] frames=new Frame[Bowling.FRAMES];
    for(int i=0; i < frames.length; i++) {
      Ball first=new BallFactory().firstBall();
      frames[i]=new Frame(first);
    }
    return frames;
  }
}
