package bowling.states;

import bowling.Play;
import bowling.State;

public class SpareBonusState extends State {
	public SpareBonusState(Play play) {
		super(play);
	}

	public State next(boolean allPins) {
		return Transition.SPARE_BONUS.next(this, play());
	}
}