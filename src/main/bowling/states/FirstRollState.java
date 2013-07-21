package bowling.states;

import bowling.AdvancingFrame;
import bowling.State;

public class FirstRollState extends State {
	protected State transition(AdvancingFrame frame, boolean allPins) {
		if(allPins) return Transition.STRIKE.next(this, frame);
		return Transition.FIRST_ROLL.next(this, frame);
	}
}