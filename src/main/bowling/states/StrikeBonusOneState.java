package bowling.states;

import bowling.Transition;
import bowling.State;

public class StrikeBonusOneState extends State {
	public StrikeBonusOneState(Transition transition) {
		super(transition);
	}

	protected Transition.Event event(boolean allPins) {
		return Transition.Event.STRIKE_BONUS_ONE;		
	}
}