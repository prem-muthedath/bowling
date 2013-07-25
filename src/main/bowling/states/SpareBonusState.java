package bowling.states;

import bowling.Transition;
import bowling.State;

public class SpareBonusState extends State {
	public SpareBonusState(Transition transition) {
		super(transition);
	}

	protected Transition.Event event(boolean allPins) {
		return Transition.Event.SPARE_BONUS;		
	}
}