package bowling.states;

import bowling.State;

public class SpareBonusState extends State {
	public SpareBonusState(StateTransition transition) {
		super(transition);
	}

	protected Event event(boolean allPins) {
		return Event.SPARE_BONUS;		
	}
}