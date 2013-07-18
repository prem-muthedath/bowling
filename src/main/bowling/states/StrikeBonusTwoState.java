package bowling.states;

import bowling.Frame;
import bowling.State;

public class StrikeBonusTwoState extends State {
	protected State transition(Frame frame, boolean allPins) {
		return Transition.STRIKE_BONUS_TWO.next(this, frame);
	}
}