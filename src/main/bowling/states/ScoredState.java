package bowling.states;

import bowling.Play;
import bowling.State;

public class ScoredState extends State {
	protected int pins(int pins) {
		return 0;
	}

	protected State transition(Play play, boolean allPins) {
		return Transition.SCORED.next(this, play);			
	}

	public int score(int pinfall) {
		return pinfall;
	}
}