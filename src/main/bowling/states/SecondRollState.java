package bowling.states;

import bowling.RollContext;
import bowling.State;

public class SecondRollState extends State {
	protected State transition(RollContext context, boolean allPins) {
		if(allPins) return Transition.SPARE.next(this, context);
		return Transition.OPEN.next(this, context);
	}

	protected void exit(RollContext context) {
		advance(context);
	}
}