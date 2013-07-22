package bowling.states;

import bowling.Play;
import bowling.State;

public class StrikeBonusTwoState extends State {
	public StrikeBonusTwoState(Play play) {
		super(play);
	}

	public State next(boolean allPins) {
		return Transition.STRIKE_BONUS_TWO.next(this, play());
	}
}