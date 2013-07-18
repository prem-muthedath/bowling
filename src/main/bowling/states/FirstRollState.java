package bowling.states;

import bowling.Frame;
import bowling.State;

public class FirstRollState extends State {
	protected State transition(Frame frame, boolean allPins) {
		if(allPins) return Transition.STRIKE.next(this, frame);
		return Transition.FIRST_ROLL.next(this, frame);
	}
}