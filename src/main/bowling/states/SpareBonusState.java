package bowling.states;

import bowling.FrameContext;
import bowling.State;

public class SpareBonusState extends State {
	protected State transition(FrameContext context, boolean allPins) {
		return Transition.SPARE_BONUS.next(this, context);
	}
}