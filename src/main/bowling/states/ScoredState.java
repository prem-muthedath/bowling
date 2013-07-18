package bowling.states;

import bowling.Frame;
import bowling.State;

public class ScoredState extends State {
	public void count(Frame frame, int pins) {}

	protected State transition(Frame frame, boolean allPins) {
		return Transition.SCORED.next(this, frame);			
	}

	public int score(int pinfall) {
		return pinfall;
	}
}