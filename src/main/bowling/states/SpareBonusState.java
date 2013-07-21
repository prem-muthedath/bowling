package bowling.states;

import bowling.AdvancingFrame;
import bowling.State;

public class SpareBonusState extends State {
	protected State transition(AdvancingFrame frame, boolean allPins) {
		return Transition.SPARE_BONUS.next(this, frame);
	}
}