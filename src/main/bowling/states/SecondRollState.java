package bowling.states;

import bowling.State;

public class SecondRollState extends State {
	public SecondRollState(StateTransition transition) {
		super(transition);
	}

	protected Event event(boolean allPins) {
		if(allPins) return Event.SPARE;
		return Event.OPEN;		
	}
}