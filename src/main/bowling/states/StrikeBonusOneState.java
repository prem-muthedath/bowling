package bowling.states;

import bowling.AdvancingFrame;
import bowling.State;

public class StrikeBonusOneState extends State {
	protected State transition(AdvancingFrame frame, boolean allPins) {
		return Transition.STRIKE_BONUS_ONE.next(this, frame);
	}

	public void enter(AdvancingFrame frame) {
		advance(frame);
	}
}