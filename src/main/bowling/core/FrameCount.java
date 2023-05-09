package bowling.core;

/**
 * FrameCount, as its name implies, encapsulates a count of frames.
 * FrameCount knows how to ensure a valid frame count.
 *
 * this tiny class is an excellent example of how you can create a small object 
 * that uses its data to do just 1 thing: in this case, ensuring a valid count.
 *
 * author: Prem Muthedath
 */

public class FrameCount {
  private int count;

  public FrameCount(int count) {
    this.count=count; // count of frames
  }

  /* compute aggregate score for a valid number of frames.
   *
   * note that score is computed for a valid frame count. for example, if you 
   * had instantiated this object with an invalid frame count of 100, score 
   * would not be computed for 100 frames but for Bowling.FRAMES, the total # of 
   * frames in a bowling game.
   *
   * likewise, if you had created this object with an invalid frame count of 
   * -20, score would be computed not for -20 but for a valid frame count of 0.
   */
  public int score(Bowling game) {
    return game.score(validCount());
  }

  /* compute a valid frame count.
   * # of frames >= 0 and <= total # of frames allowed in a bowling game.
   */
  private int validCount() {
    return  this.count < 1   ?   0  :  Math.min(this.count, Bowling.FRAMES);
  }
}
