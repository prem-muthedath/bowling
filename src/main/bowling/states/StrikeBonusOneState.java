package bowling.states;

import bowling.Play;
import bowling.State;

public class StrikeBonusOneState extends State {
	public StrikeBonusOneState(Play play) {
		super(play);
	}

	public State next(boolean allPins) {
		return Transition.STRIKE_BONUS_ONE.next(this, play());
	}

	public void enter() {
		advance();
	}
}