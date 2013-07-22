package bowling.states;

import bowling.Play;
import bowling.State;

public class FirstRollState extends State {
	protected State transition(Play play, boolean allPins) {
		if(allPins) return Transition.STRIKE.next(this, play);
		return Transition.FIRST_ROLL.next(this, play);
	}
}