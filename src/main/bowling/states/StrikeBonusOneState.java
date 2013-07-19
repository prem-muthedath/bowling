package bowling.states;

import bowling.FrameContext;
import bowling.State;

public class StrikeBonusOneState extends State {
	protected State transition(FrameContext context, boolean allPins) {
		return Transition.STRIKE_BONUS_ONE.next(this, context);
	}

	public void enter(FrameContext context) {
		advance(context);
	}
}