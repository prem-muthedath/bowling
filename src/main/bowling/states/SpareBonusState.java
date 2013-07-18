package bowling.states;

import bowling.Frame;
import bowling.State;

public class SpareBonusState extends State {
	protected State transition(Frame frame, boolean allPins) {
		return Transition.SPARE_BONUS.next(this, frame);
	}
}