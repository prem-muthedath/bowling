package bowling.states;

import bowling.Play;
import bowling.State;

public class SpareBonusState extends State {
	protected State transition(Play play, boolean allPins) {
		return Transition.SPARE_BONUS.next(this, play);
	}
}