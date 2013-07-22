package bowling.states;

import bowling.Play;
import bowling.State;

public class StrikeBonusTwoState extends State {
	protected State transition(Play play, boolean allPins) {
		return Transition.STRIKE_BONUS_TWO.next(this, play);
	}
}