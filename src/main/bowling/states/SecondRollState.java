package bowling.states;

import bowling.Bowling;
import bowling.State;

public class SecondRollState extends State {
	public SecondRollState(Bowling game) {
		super(game);
	}

	public State next(boolean allPins) {
		exit();
		return transition(allPins);
	}

	private void exit() {
		advance();
	}

	private State transition(boolean allPins) {
		if(allPins) return Transition.SPARE.next(this, game());
		return Transition.OPEN.next(this, game());		
	}
}