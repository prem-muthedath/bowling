package bowling.states;

import bowling.State;

public class StrikeBonusTwoState extends State {
	public StrikeBonusTwoState(StateTransition transition) {
		super(transition);
	}

	protected Event event(boolean allPins) {
		return Event.STRIKE_BONUS_TWO;		
	}
}