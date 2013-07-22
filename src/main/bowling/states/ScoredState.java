package bowling.states;

import bowling.Play;
import bowling.State;

public class ScoredState extends State {
	public ScoredState(Play play) {
		super(play);
	}

	protected int pins(int pins) {
		return 0;
	}

	public State next(boolean allPins) {
		return Transition.SCORED.next(this, play());			
	}

	public int score(int pinfall) {
		return pinfall;
	}
}