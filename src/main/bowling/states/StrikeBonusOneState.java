package bowling.states;

import bowling.Play;
import bowling.State;

public class StrikeBonusOneState extends State {
	protected State transition(Play play, boolean allPins) {
		return Transition.STRIKE_BONUS_ONE.next(this, play);
	}

	public void enter(Play play) {
		advance(play);
	}
}