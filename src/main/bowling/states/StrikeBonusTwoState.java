package bowling.states;

import bowling.Transition;
import bowling.State;

public class StrikeBonusTwoState extends State {
	public StrikeBonusTwoState(Transition transition) {
		super(transition);
	}

	protected Transition.Event event(boolean allPins) {
		return Transition.Event.STRIKE_BONUS_TWO;		
	}
}