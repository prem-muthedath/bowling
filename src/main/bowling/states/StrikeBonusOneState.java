package bowling.states;

import bowling.RollContext;
import bowling.State;

public class StrikeBonusOneState extends State {
	protected State transition(RollContext context, boolean allPins) {
		return Transition.STRIKE_BONUS_ONE.next(this, context);
	}

	public void enter(RollContext context) {
		advance(context);
	}
}