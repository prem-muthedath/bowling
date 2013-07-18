package bowling.states;

import bowling.Frame;
import bowling.State;

public class SecondRollState extends State {
	protected State transition(Frame frame, boolean allPins) {
		if(allPins) return Transition.SPARE.next(this, frame);
		return Transition.OPEN.next(this, frame);
	}

	protected void exit(Frame frame) {
		advance(frame);
	}
}