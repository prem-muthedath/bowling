package bowling.states;

import bowling.core.Ball;

/**
 * `BallFactory` class makes instances of all Ball subclasses. since Ball 
 * objects form Frame states, this class can also be seen as the object that 
 * knows how to make instances of all possible Frame states in the bowling game.
 *
 * NOTE: many or most methods below use anonymous class definitions to avoid 
 * defining a long list of subclasses that require separate files.
 *
 * for bowling game scoring, see https://bowl.com/keeping-score
 * bowling terminology, see https://en.wikipedia.org/wiki/Glossary_of_bowling
 *
 * NOTE: 'mark' in bowling terminology means strike or spare.
 *
 * author: Prem Muthedath
 * */
public class BallFactory {
  /* returns the first or initial Frame state, where the Frame is awaiting it's 
   * 1st ball to be physically rolled in it.
   */
  public Ball firstBall() {
    return new RolledBall(new Ball() {
      public Ball markSuccessor() {    // next state if 1st ball is a strike
        return new BallFactory().firstStrikeBonusBall();
      }

      public Ball nonMarkSuccessor() { // next state if 1st ball is a non-strike 
        return new BallFactory().secondBall();
      }
    });
  }

  /* returns the second ball Frame state, where the Frame is awaiting it's 2nd 
   * ball to be physically rolled in it.
   */
  Ball secondBall() {
    return new RolledBall(new Ball() {
      public Ball markSuccessor() {    // next state if 2nd ball results in a spare 
        return new BallFactory().spareBonusBall();
      }

      public Ball nonMarkSuccessor() { // next state if 2nd ball results in a non-spare
        return new BallFactory().scoredBall();
      }
    });
  }

  /* returns Frame state where Frame is awaiting it's 1st strike bonus ball. */
  Ball firstStrikeBonusBall() {
    return new Ball() {
      public Ball nonMarkSuccessor() {  // next state after 1st strike bonus ball
        return new BallFactory().secondStrikeBonusBall();
      }
    };
  }

  /* returns Frame state where Frame is awaiting it's 2nd strike bonus ball. */
  Ball secondStrikeBonusBall() {
    return new Ball() {
      public Ball nonMarkSuccessor() {  // next state after 2nd strike bonus ball
        return new BallFactory().scoredBall();
      }
    };
  }

  /* returns Frame state where Frame is awaiting its spare bonus ball. */
  Ball spareBonusBall() {
    return new Ball() {
      public Ball nonMarkSuccessor() {  // next state after spare bonus ball
        return new BallFactory().scoredBall();
      }
    };
  }

  /* returns state of a fully-scored Frame. */
  Ball scoredBall() {
    return new ScoredBall();
  }
}
