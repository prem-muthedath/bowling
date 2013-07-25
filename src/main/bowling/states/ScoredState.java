package bowling.states;

import bowling.Transition;
import bowling.State;

public class ScoredState extends State {
	public ScoredState(Transition transition) {
		super(transition);
	}

	protected int pins(int pins) {
		return 0;
	}

	protected Transition.Event event(boolean allPins) {
		return Transition.Event.SCORED;		
	}

	public int score(int pinfall) {
		return pinfall;
	}
}