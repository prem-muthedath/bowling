package bowling.states;

import bowling.RollContext;
import bowling.State;

public class SpareBonusState extends State {
	protected State transition(RollContext context, boolean allPins) {
		return Transition.SPARE_BONUS.next(this, context);
	}
}