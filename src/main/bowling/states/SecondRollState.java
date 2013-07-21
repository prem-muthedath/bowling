package bowling.states;

import bowling.AdvancingFrame;
import bowling.State;

public class SecondRollState extends State {
	protected State transition(AdvancingFrame frame, boolean allPins) {
		if(allPins) return Transition.SPARE.next(this, frame);
		return Transition.OPEN.next(this, frame);
	}

	protected void exit(AdvancingFrame frame) {
		advance(frame);
	}
}