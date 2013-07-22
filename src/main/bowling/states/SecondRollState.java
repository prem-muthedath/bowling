package bowling.states;

import bowling.Play;
import bowling.State;

public class SecondRollState extends State {
	protected State transition(Play play, boolean allPins) {
		if(allPins) return Transition.SPARE.next(this, play);
		return Transition.OPEN.next(this, play);
	}

	protected void exit(Play play) {
		advance(play);
	}
}