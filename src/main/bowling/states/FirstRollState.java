package bowling.states;

import bowling.FrameContext;
import bowling.State;

public class FirstRollState extends State {
	protected State transition(FrameContext context, boolean allPins) {
		if(allPins) return Transition.STRIKE.next(this, context);
		return Transition.FIRST_ROLL.next(this, context);
	}
}