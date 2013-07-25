package bowling.states;

import bowling.Transition;
import bowling.State;

public class FirstRollState extends State {
	public FirstRollState(Transition transition) {
		super(transition);
	}

	protected Transition.Event event(boolean allPins) {
		if(allPins) return Transition.Event.STRIKE;
		return Transition.Event.FIRST_ROLL;		
	}
}