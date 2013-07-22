package bowling.states;

import bowling.Play;
import bowling.State;

public class FirstRollState extends State {
	public FirstRollState(Play play) {
		super(play);
	}

	public State next(boolean allPins) {
		if(allPins) return Transition.STRIKE.next(this, play());
		return Transition.FIRST_ROLL.next(this, play());
	}
}