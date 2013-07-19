package bowling.states;

import bowling.RollContext;
import bowling.State;

public class StrikeBonusTwoState extends State {
	protected State transition(RollContext context, boolean allPins) {
		return Transition.STRIKE_BONUS_TWO.next(this, context);
	}
}