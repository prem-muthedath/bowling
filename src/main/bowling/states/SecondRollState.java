package bowling.states;

import bowling.Play;
import bowling.State;

public class SecondRollState extends State {
	public SecondRollState(Play play) {
		super(play);
	}

	public State next(boolean allPins) {
		exit();
		return transition(allPins);
	}

	private void exit() {
		advance();
	}

	private State transition(boolean allPins) {
		if(allPins) return Transition.SPARE.next(this, play());
		return Transition.OPEN.next(this, play());		
	}
}