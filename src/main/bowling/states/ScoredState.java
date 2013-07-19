package bowling.states;

import bowling.RollContext;
import bowling.State;

public class ScoredState extends State {
	public void count(RollContext context, int pins) {
		super.count(context, 0);
	}

	protected State transition(RollContext context, boolean allPins) {
		return Transition.SCORED.next(this, context);			
	}

	public int score(int pinfall) {
		return pinfall;
	}
}