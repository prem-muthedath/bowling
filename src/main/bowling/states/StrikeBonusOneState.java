package bowling.states;

import bowling.Frame;
import bowling.State;

public class StrikeBonusOneState extends State {
	protected State transition(Frame frame, boolean allPins) {
		return Transition.STRIKE_BONUS_ONE.next(this, frame);
	}

	public void enter(Frame frame) {
		advance(frame);
	}
}