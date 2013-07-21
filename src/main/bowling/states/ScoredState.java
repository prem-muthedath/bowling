package bowling.states;

import bowling.AdvancingFrame;
import bowling.State;

public class ScoredState extends State {
	public void count(AdvancingFrame frame, int pins) {
		super.count(frame, 0);
	}

	protected State transition(AdvancingFrame frame, boolean allPins) {
		return Transition.SCORED.next(this, frame);			
	}

	public int score(int pinfall) {
		return pinfall;
	}
}