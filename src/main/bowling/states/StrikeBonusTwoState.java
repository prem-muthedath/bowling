package bowling.states;

import bowling.FrameContext;
import bowling.State;

public class StrikeBonusTwoState extends State {
	protected State transition(FrameContext context, boolean allPins) {
		return Transition.STRIKE_BONUS_TWO.next(this, context);
	}
}