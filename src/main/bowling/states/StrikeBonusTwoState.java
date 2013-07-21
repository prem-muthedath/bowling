package bowling.states;

import bowling.AdvancingFrame;
import bowling.State;

public class StrikeBonusTwoState extends State {
	protected State transition(AdvancingFrame frame, boolean allPins) {
		return Transition.STRIKE_BONUS_TWO.next(this, frame);
	}
}