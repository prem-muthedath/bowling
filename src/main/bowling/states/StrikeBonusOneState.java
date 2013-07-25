package bowling.states;

import bowling.State;

public class StrikeBonusOneState extends State {
	public StrikeBonusOneState(StateTransition transition) {
		super(transition);
	}

	protected Event event(boolean allPins) {
		return Event.STRIKE_BONUS_ONE;		
	}
}