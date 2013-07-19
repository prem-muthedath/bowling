package bowling.states;

import bowling.FrameContext;
import bowling.State;

public class SecondRollState extends State {
	protected State transition(FrameContext context, boolean allPins) {
		if(allPins) return Transition.SPARE.next(this, context);
		return Transition.OPEN.next(this, context);
	}

	protected void exit(FrameContext context) {
		advance(context);
	}
}