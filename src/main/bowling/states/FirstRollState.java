package bowling.states;

import bowling.State;

public class FirstRollState extends State {
	public FirstRollState(StateTransition transition) {
		super(transition);
	}

	protected Event event(boolean allPins) {
		if(allPins) return Event.STRIKE;
		return Event.FIRST_ROLL;		
	}
}