package bowling.states;

import bowling.State;

public class ScoredState extends State {
	public ScoredState(StateTransition transition) {
		super(transition);
	}

	protected int pins(int pins) {
		return 0;
	}

	protected Event event(boolean allPins) {
		return Event.SCORED;		
	}

	public int score(int pinfall) {
		return pinfall;
	}
}