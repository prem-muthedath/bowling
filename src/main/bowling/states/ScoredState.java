package bowling.states;

import bowling.FrameContext;
import bowling.State;

public class ScoredState extends State {
	public void count(FrameContext context, int pins) {
		super.count(context, 0);
	}

	protected State transition(FrameContext context, boolean allPins) {
		return Transition.SCORED.next(this, context);			
	}

	public int score(int pinfall) {
		return pinfall;
	}
}