package bowling.core;

import java.util.ArrayList;
import java.util.List;

/* this class models a frame in the bowling game.
 *
 * the Frame object records its 'pins', just as a bowling game frame would.
 *
 * the Frame object here is modeled as a state machine that undergoes state 
 * transitions in response to applicable "current" ball-roll events iin the 
 * bowling game. the unique "Ball" object within a Frame represents the current 
 * Frame state. typically, a Frame starts off in the 'first ball' state, where 
 * it is awaiting the first ball to be rolled in it. after its first ball roll 
 * (not same as the first ball roll in the game, unless it is the first Frame), 
 * the Frame may transition to other states, such as 'second ball' state, 'first 
 * strike bonus ball', etc. typical current Frame states, for example, include 
 * 'first ball', 'second ball', 'first strike bonus ball', 'spare bonus ball', 
 * 'scored ball', etc. `BallFactory` class in bowling.states package creates 
 * instances of all possible Frame states.
 *
 * the Frame object, working with its state, the Ball object, computes its own 
 * score, which is Frame's primary responsibility. depending on the Frame 
 * object's state, the reported score (to clients), however, may differ from the 
 * calculated one. for example, when a Frame is in a state of being scored, the 
 * reported score will be 0 even though the calculated one may be > 0. this is 
 * so because Frame scores reported are final scores, and reporting a final 
 * score for a Frame whose final score is still being determined is meaningless!  
 * in such cases, reporting 0 for Frame score is the only practical solution.
 *
 * the Frame object updates its score (i.e, its collection of pin counts) 
 * whenever an "applicable" ball roll event in the bowling game affects its 
 * state, meaning the Frame undergoes a state transition. an "applicable" ball 
 * roll event implies either an actual physical ball roll in the frame or a 
 * bonus ball, in case of strike and spare, rolled in the following frames.  
 * typically, whenever the Frame is notified of a ball roll (i.e., the current 
 * roll), Frame's current state (the `Ball`) will dictate if the current roll 
 * needs to be scored or ignored. if it decides YES, then the Frame will update 
 * its collection of pin counts, and then based on its new score, the current 
 * state will transition to the next state. if, on the other hand, the current 
 * state decides NO, then there will be no change of state as well as score.
 *
 * for bowling game scoring, see https://bowl.com/keeping-score
 * bowling terminology, see https://en.wikipedia.org/wiki/Glossary_of_bowling
 *
 * author: Prem Muthedath
 * */
 public class Frame {
  private List<Integer> pins; // list of pin counts, each slot corresponds to a roll
  private Ball ball;          // current state

  // constructor with package visibility.
  // package visibility limits creation of invalid Frame objects, because 
  // objects outside the package can not -- and need not -- create a Frame.
  Frame(Ball first) {
    this.ball=first;                    // first ball state
    this.pins=new ArrayList<Integer>(); // stores pin counts from applicable rolls
  }

  // this function represents a message to the Frame object about the no of pins 
  // felled in a single ball-roll event (i.e., the current roll) that has 
  // occurred in the bowling game. all frames in active play, which includes the 
  // frame where the current ball in the game was physically rolled as well as 
  // all the preceeding frames, receive this message. if the current roll has 
  // physically happened in a specific Frame instance (Frame instance's state 
  // determines this), then this function in that instance will return true; 
  // otherwise not. depending on Frame state as well as roll validity, this call 
  // will either trigger score & state changes or will be completely ignored.
  boolean roll(int pins) {
    // we first go ahead and blindly add these pin counts from this current roll 
    // for now. but this decision's correctness depends on the state of the 
    // frame as well as the validity of the pin counts in this current roll. for 
    // example, if you had 5 pins from the previous roll and this current roll 
    // has 6 pins, you will then end up with 5 + 6 = 11 pins for the Frame, 
    // which, obviously, is an invalid situation, because the total number of 
    // pins for two consecutive rolls in an "open" frame can not exceed 10, the 
    // max number of pins available for knockout in a frame. likewise, if the 
    // frame is already in a scored state, then you can not add anymore pins to 
    // it. in these situations we'll have to rollback the pins added.
    this.pins.add(Integer.valueOf(pins));

    // as mentioned earlier, the current state of the Frame, the Ball object, 
    // decides if the Frame should include pin counts from the current roll, 
    // which is why the code here calls `ball.transition(this)`. if the state 
    // decides YES, then it will invoke the `transition()` method in Frame, 
    // which will lead to acceptance of pin counts from the current roll as well 
    // as a transition to a new state based on the new score of Frame. if, on 
    // the other hand, the state decides NO, it (i.e., the Ball object) will 
    // call `ignoreCurrentRollt()` method in Frame, which will discard pins we 
    // had earlier included from current roll, and state will remain unchanged.
    return this.ball.transition(this);
  }

  // do a state transition if everything is just fine; else throw an exception. 
  void transition() {
    // first, validate added pins from current roll BEFORE a change of state!!
    //
    // this is needed because (a) if the current roll is invalid, then a change 
    // of state is meaningless; (b) if you change the state (say, to 
    // `ScoredBall`) when the current roll is invalid, then even if you throw an 
    // exception later, you would still report an invalid score (because the 
    // `ScoredBall` state that you had mistakenly transitioned to will 
    // incorrectly report the frame's actual score, whereas the earlier states 
    // the frame was in would have rightly reported 0 as the frame score) if you 
    // happen to catch that exception and invoke score on the object. thumb 
    // rule: validate the current roll BEFORE the state change.
    //
    // NOTE:
    // it is important to call `validate()` here inside this `transition()` 
    // function, and not earlier from elsewhere, because the current `Ball` 
    // object (the Frame state) decides whether we will ever need to execute 
    // this function at all. for example, if the current `Ball` is a 
    // `ScoredBall`, then that Ball will never call this function, so we won't 
    // be doing (or needing) any validation at all.  this is because a 
    // `ScoredBall` indicates a frame that has already been scored BEFORE the 
    // current roll, so there is no need to transition the state anymore, and 
    // these newly added pins from the current roll are irrelevant and will be 
    // discarded, so doing any validation on these newly added pin counts that 
    // will anyway be thrown away is meaningless and irrelevant.
    this.validate();
    this.ball=this.nextBall();
  }

  // discard the most recently added pins.
  public void ignoreCurrentRoll() {
    if (this.pins.size() == 0) return;
    this.pins.remove(this.pins.size() - 1);
  }

  // report frame's score. the actual value reported depends on Frame's state.
  int score() {
    return this.ball.score(this.computeScore());
  }

  // compute current score
  private int computeScore() {
    int tot = 0;
    for (int i = 0; i < this.pins.size(); i++) {
      tot = tot + this.pins.get(i).intValue();
    }
    return tot;
  }

  // compute score before current roll.
  private int computePrevScore() {
    if (this.pins.size() == 0) return 0;
    return this.computeScore() - this.pins.get(this.pins.size() - 1);
  }

  // check if the current count of pins is valid. if not, throw an exception.
  private void validate() {
    int sum = this.computeScore();
    if (sum >= this.minimum() && sum <= this.maximum()) return;
    this.ignoreCurrentRoll();
    // we pass `sum` because it retains the bad pins even after rollback.
    throw new RuntimeException(this.errMessage(sum));
  }

  // compute minimum value for current score.
  private int minimum() {
    return Math.max(0, this.computePrevScore());
  }

  // compute maximum value for current score.
  private int maximum() {
    // given the previous Frame score, can we compute the upper bound for 
    // Frame's score for the current roll? and can we use this computed upper 
    // bound to validate the current Frame score?
    //
    // my formula below for max value of a frame's current score provides one 
    // good, handy way to check if the current score we are seeing for a frame 
    // is valid or not. the formula involves a clever strategy that exploits int 
    // division truncation to compute max score. by the way, my formula is not 
    // special to the object model here; it applies to bowling game in general.
    //
    // basically, the max score for a frame is 30 (3 strikes in a row). but 
    // before getting to that high mark, we can see integral jumps of 10, 
    // starting from 10: 10, 20, 30, and these form the upper limits for rolls 
    // 1, 2, 3 for a frame. so for example, if you're in frame x, receiving its 
    // first ball roll, then its max score can at most be 10; given a 10 in the 
    // first roll, on the second ball roll, it's total can at most be 20, and so 
    // on. finally, it's final max score can not exceed 30.
    //
    // to explain further, suppose you are in frame x, and its 1st roll has a 
    // score of 5, is this an OK value not exceeding its allowed maximum?  let's 
    // see -- plugging in 10 for Bowling.PINS in the equation, we get:
    //    Math.min(3* 10, 10*(1 + 0/10))   | here 0 is score before 1st roll
    //    = Math.min(3 * 10, 10 * (1 + 0)) | 0 / 10 = 0
    //    = Math.min (3 * 10, 10 * 1)
    //    = Math.min (30, 10)
    //    = 10
    // since 5 < 10, the maximum value, we are doing good in this roll.  had we 
    // had a value of say 20 for the 1st roll, instead of 5, we would 
    // immediately know that 20 is wrong because it exceeds the max value of 10.
    //
    // likewise, if the 2nd roll in frame x yields 3, we now have a total score 
    // of 8 (= 5 + 3) for frame x after 2 rolls.  is that a good value?  well, 
    // we plugin in the previous value of 5 into the equation to get:
    //    = Math.min (30, 10*(1 + 5/10))  | here 5 is score from 1st roll
    //    = Math.min (30, 10 * (1 + 0))   | 5 / 10 truncates to 0
    //    = Math.min (30, 10)
    //    = 10
    // since 8, our total score for frame x after 2 rolls, is < the max value of 
    // 10, we are good! had we noticed a 6 in the 2nd roll instead, we would 
    // have had a total score of 11 (= 5 + 6), which is > 10, the allowed 
    // maximum for an "open" frame, so we would know that something is amiss.
    //
    // another case: suppose we get a 10 on the 1st roll in frame x.  how are we 
    // doing there?
    //    = Math.min(3 * 10, 10 * (1 + 0/10))  | here 0 = score before 1st roll
    //    = Math.min(3 * 10, 10 * (1 + 0))     | 0 / 10 = 0
    //    = Math.min(30, 10 * 1)
    //    = Math.min (30, 10)
    //    = 10
    // the 10 (total) == 10 (max), so we're good.  next we get another 6 for 
    // frame x as a bonus, which gives a total of 10 + 6 = 16.  how about that?
    //    = Math.min(3 * 10, 10 * (1 + 10/10)) | 10 from 1st roll
    //    = Math.min(30 + 10 * (1 + 1))        | here 10 / 10 = 1
    //    = Math.min(30 + 10 * 2)
    //    = Math.min (30, 20)
    //    = 20
    // so our total score of 16 (= 10 + 6) < 20 (the max value), so we're good!
    //
    // suppose we get 3 on another bonus roll, which makes our total 19.
    //    = Math.min(3 * 10, 10 * (1 + 16 / 10))  | here 16 = total of 2 rolls
    //    = Math.min(30, 10 * (1 + 1))            | 16 /10 truncates to 1
    //    = Math.min(30, 10 * 2)
    //    = Math.min(30, 20)
    //    = 20
    // our total of 19 (= 10 + 6 + 3) is < 20 (the max value), so we're good!
    //
    // what if we had got a 10, instead of 3, in that third roll?  well, then 
    // our score would have have been 10 + 6 + 10 = 26 > 20 (the max allowed), 
    // so this case is not allowed. this makes sense if you think about it: the 
    // max number of pins in 2 consecutive rolls in an "open" frame can not 
    // exceed 10, because we only have 10 pins, so getting 6 in one roll and 10 
    // in another, giving a total of 6 + 10 = 16 pins, is impossible!
    //
    // NOTE: one very important thing to note about my formula: the max value 
    // calculated varies based on the total value from previous rolls.
    //
    // for example, in our last example, if we had got a 10, instead of 6, in 
    // the 2nd roll, we would have had a total of 20 (= 10 + 10) after 2 rolls, 
    // which, as we have just seen, is just fine, because we are equal to 20, 
    // the max allowed after 2 rolls. moving on, our total would be 10 + 
    // 10 + 10 = 30 if we get another 10 in the 3rd roll.
    //
    // is that an OK value, this 30 points, given that we've just seen that 
    // getting 6 and 10 in 2nd and 3rd rolls, respectively, giving a total of 
    // 26 (= 10 + 6 + 10), exceeds the max value of 20 in that case?
    //    = Math.min(3 * 10, 10 * (1 + 20 / 10))  | 20 = total of prev 2 rolls
    //    = Math.min(30, 10 * (1 + 2))            | 20 / 10 = 2
    //    = Math.min(30, 10 * 3)
    //    = Math.min(30, 30)
    //    = 30
    //
    // surprisingly, if we get 10, 10, 10 in a row, the max value becomes 30, 
    // instead of the 20 we saw with 10, 6, 3. so, yeah, the max value changed 
    // this time because our count for first 2 rolls now is 20 (= 10 + 10), 
    // instead of 16 (= 10 + 6), & that makes our current score of 30 just fine!
    //
    // in this last example, we allowed 3 throws because we had a strike in the 
    // first throw. you may be wondering that frame x can theoretically go on 
    // accepting any number of rolls as long as its score is below the max 
    // limit, which surely doesn't occur in a real bowling game, so what limits 
    // the number of rolls per frame? of course this formula here can not do 
    // that job. in this design, the state, the Ball object, does that work.
    return Math.min(3*Bowling.PINS, Bowling.PINS*(1+(this.minimum()/Bowling.PINS)));
  }

  // error message for bad current score caused by the "bad" current roll.
  private String errMessage(int count) {
    return "INVALID CURRENT ROLL => FRAME: " + this +
      ", EXPECTED PIN COUNT RANGE (AFTER ROLL): "
      + minimum() + " - " + maximum() + " BUT FOUND: " + count + ".";
  }

  // get the next state, represented by a Ball object, to transition to.
  // 'mark' means 'strike' or 'spare' in bowling terminlogy.
  // notice how we just compute if the score is a mark here, and then delegate 
  // the actual state computation to Ball? this is the essence of good OOP.
  private Ball nextBall() {
    boolean mark = this.computeScore() == Bowling.PINS;
    return this.ball.next(mark);
  }
}
