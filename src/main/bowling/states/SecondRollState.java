package bowling.states;

import bowling.Transition;
import bowling.State;

public class SecondRollState extends State {
	public SecondRollState(Transition transition) {
		super(transition);
	}

	protected Transition.Event event(boolean allPins) {
		if(allPins) return Transition.Event.SPARE;
		return Transition.Event.OPEN;		
	}
}